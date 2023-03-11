package com.asaf;

import com.asaf.requests.DownloadLinkRequest;
import com.asaf.requests.LoginRequest;
import com.asaf.response.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@ShellComponent
public class DownloadSubtitlesCommand {

    private static final Logger logger = LoggerFactory.getLogger(DownloadSubtitlesCommand.class);

    @ShellMethod(value = "download subtitles", key = "download")
    public void download(@ShellOption(value = "-n", help = "search subtitles by name first") boolean byName,
                         @ShellOption(value = "-i", help = "input file or directory") File file,
                         @ShellOption(value = "-l", help = "language") String[] langs,
                         @ShellOption(value = "-f", help = "force download") boolean force,
                         @ShellOption(value = "-r", help = "recursive") boolean recursive,
                         @ShellOption(value = "-m", help = "minimum score", defaultValue = "0") int minScore,
                         @ShellOption(value = "-t", help = "token") String token,
                         @ShellOption(value = "-u", help = "username") String username,
                         @ShellOption(value = "-p", help = "password") String password,
                         @ShellOption(value = "--title", help = "title", defaultValue = ShellOption.NULL) String title,
                         @ShellOption(value = "--season", help = "season", defaultValue = ShellOption.NULL) Integer season,
                         @ShellOption(value = "--episode", help = "episode", defaultValue = ShellOption.NULL) Integer episode) {

        logger.info("searching subtitles for " + file + " with languages " + Arrays.toString(langs) + " and min score " + minScore);


        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri("https://api.opensubtitles.com/api/v1")
                .additionalInterceptors(new TokenInterceptor(token))
                .build();

        //login
        ResponseEntity<LoginResponse> response = restTemplate.postForEntity("/login", new LoginRequest(username, password), LoginResponse.class);
        if (response.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
            logger.error("invalid username or password");
            return;
        }
        if (!response.getStatusCode().is2xxSuccessful()) {
            logger.error("failed to login");
            return;
        }
        if (response.getBody() == null || response.getBody().getToken() == null) {
            logger.error("failed to login");
            return;
        }
        String userToken = response.getBody().getToken();

        List<File> videos = getVideoFiles(file, recursive);
        for (File video : videos) {
            File sub = getSub(video);
            if (!force && sub.exists()) {
                logger.info(sub + " already exists");
                continue;
            }


            Subtitle info = getSubtitle(byName, langs, minScore, restTemplate, video, title, season, episode).or(() -> getSubtitle(!byName, langs, minScore, restTemplate, video, title, season, episode)).orElse(null);


            if (info == null) {
                logger.error("could not get subtitles for " + video.getName() + ",  no subtitles found");
                continue;
            }
            QueryType usedForSearch = info.getQueryType();
            int numberOfSubs = info.getTotalResults();

            logger.info("Selected Subtitles for " + video + " " + usedForSearch + ",selected: " + info + " had " + numberOfSubs + " option" + (numberOfSubs > 1 ? "s" : ""));
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setBearerAuth(userToken);
            ResponseEntity<DownloadLink> downloadLinkResponseEntity = restTemplate.postForEntity("/download", new HttpEntity<>(new DownloadLinkRequest(info.getAttributes().getFiles()[0].getFile_id()), httpHeaders), DownloadLink.class);
            if (!downloadLinkResponseEntity.getStatusCode().is2xxSuccessful()) {
                logger.error("could not get subtitles for " + video.getName() + ", " + usedForSearch + " error while getting download link");
                continue;
            }
            if (downloadLinkResponseEntity.getBody() == null || downloadLinkResponseEntity.getBody().getLink() == null) {
                logger.error("could not get subtitles for " + video.getName() + ", " + usedForSearch + " error while getting download link");
                continue;
            }
            String link = downloadLinkResponseEntity.getBody().getLink();
            File downloadedSub = restTemplate.execute(link, HttpMethod.GET, null, clientHttpResponse -> {
                StreamUtils.copy(clientHttpResponse.getBody(), new FileOutputStream(sub));
                return sub;
            });


        }


    }

    private static Optional<Subtitle> getSubtitle(boolean byName, String[] langs, int minScore, RestTemplate restTemplate, File video, String titleHint, Integer seasonHint, Integer episodeHint) {
        try {
            ResponseEntity<SearchResponse<Subtitle>> response = searchSubtitles(byName, langs, restTemplate, video, titleHint, seasonHint, episodeHint);
            if (!response.getStatusCode().is2xxSuccessful()) {
                logger.error("Error searching subtitles for " + video.getName());
                return Optional.empty();
            }
            if (response.getBody() == null | response.getBody().getData() == null || response.getBody().getData().isEmpty()) {
                logger.error("Error searching subtitles for " + video.getName());
                return Optional.empty();
            }

            SearchResponse<Subtitle> body = response.getBody();
            List<Subtitle> subtitles = body.getData();
            return subtitles.parallelStream().filter(f -> f.getAttributes().getRatings() >= minScore && f.getAttributes().getFiles() != null && f.getAttributes().getFiles().length > 0).sorted(Comparator.comparingInt((Subtitle o) -> getLangRating(o.getAttributes().getLanguage(), langs)).thenComparing(Comparator.comparingDouble((Subtitle f) -> f.getAttributes().getRatings()).reversed())).findFirst().map(f -> f.setQueryType(byName ? QueryType.NAME : QueryType.HASH).setTotalResults(body.getTotal_count()));
        } catch (IOException e) {
            logger.error("Error searching subtitles for " + video.getName(), e);
            return Optional.empty();
        }
    }

    private static ResponseEntity<SearchResponse<Subtitle>> searchSubtitles(boolean byName, String[] langs, RestTemplate restTemplate, File video, String titleHint, Integer seasonHint, Integer episodeHint) throws IOException {
        return byName ? searchSubtitlesByName(langs, restTemplate, video, titleHint, seasonHint, episodeHint) :
                searchSubtitlesByHash(langs, restTemplate, video);
    }

    private static ResponseEntity<SearchResponse<Subtitle>> searchSubtitlesByHash(String[] langs, RestTemplate restTemplate, File video) throws IOException {
        String md5Hash = MD5Encoder.encode(FileUtils.readFileToByteArray(video));
        return restTemplate.exchange("/subtitles?moviehash_match={moviehash_match}&languages={languages}&order_by={order_by}&order_direction={order_direction}", HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        }, md5Hash, String.join(",", langs), "ratings", "desc");
    }

    private static ResponseEntity<SearchResponse<Subtitle>> searchSubtitlesByName(String[] langs, RestTemplate restTemplate, File video, String titleHint, Integer seasonHint, Integer episodeHint) throws IOException {
        VideoInfo videoInfo = parseVideoInfo(restTemplate, video.getName(), titleHint, seasonHint, episodeHint);
        if (videoInfo == null) {
            throw new IOException("could not parse video info for " + video.getName());
        }
        return restTemplate.exchange("/subtitles?query={query}&season_number={season_number}&episode_number={episode_number}&languages={languages}&order_by={order_by}&order_direction={order_direction}", HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        }, videoInfo.getName(), videoInfo.getSeason(), videoInfo.getEpisode(), String.join(",", langs), "ratings", "desc");
    }

    private static File getSub(File file1) {

        return new File(file1.getParent(), FilenameUtils.getBaseName(file1.getName()) + ".srt");
    }

    private static List<File> getVideoFiles(File file, boolean recursive) {
        //lists all video files in the directory recursively , if file is not directory returns the file itself
        if (file.isDirectory()) {
            return new ArrayList<>(FileUtils.listFiles(file, new String[]{"mkv", "mp4", "avi"}, recursive));
        }
        return Collections.singletonList(file);
    }


    private static VideoInfo parseVideoInfo(RestTemplate restTemplate, String fileName, String titleHint, Integer seasonHint, Integer episodeHint) {
        if (titleHint != null && seasonHint != null && episodeHint != null) {
            return new VideoInfo(titleHint, seasonHint, episodeHint);
        }
        ResponseEntity<GussItResponse> forEntity = restTemplate.getForEntity("/utilities/guessit?filename={filename}", GussItResponse.class, fileName);
        if (!forEntity.getStatusCode().is2xxSuccessful()) {
            return null;
        }
        GussItResponse body = forEntity.getBody();
        if (body == null) {
            return null;
        }
        String title = Optional.ofNullable(titleHint).or(() -> Optional.ofNullable(body.getTitle()).stream().flatMap(Arrays::stream).findFirst()).orElse(null);
        Integer season = Optional.ofNullable(seasonHint).or(() -> Optional.ofNullable(body.getSeason()).stream().flatMap(f -> Arrays.stream(f).boxed()).findFirst()).orElse(null);
        Integer episode = Optional.ofNullable(episodeHint).or(() -> Optional.ofNullable(body.getEpisode()).stream().flatMap(f -> Arrays.stream(f).boxed()).findFirst()).orElse(null);
        return new VideoInfo(title, season, episode);


    }


    private static int getLangRating(String language, String[] subLangs) {
        for (int i = 0; i < subLangs.length; i++) {
            if (language.toLowerCase().startsWith(subLangs[i])) {
                return i;
            }
        }
        return Integer.MAX_VALUE;

    }

}
