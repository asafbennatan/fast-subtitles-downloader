package com.asaf;

import com.github.wtekiela.opensub4j.api.OpenSubtitlesClient;
import com.github.wtekiela.opensub4j.impl.OpenSubtitlesClientImpl;
import com.github.wtekiela.opensub4j.response.SubtitleFile;
import com.github.wtekiela.opensub4j.response.SubtitleInfo;
import jdk.nashorn.api.scripting.ScriptObjectMirror;
import org.apache.commons.cli.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.xmlrpc.XmlRpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.SimpleLogger;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static final String HELP = "help";
    public static final String BYNAME = "n";
    public static final String INPUT = "i";
    public static final String LANG = "l";
    private static final String FORCE = "f";
    private static final String LOG = "log";
    private static final String RECURSIVE = "r";
    private static final String MIN_SCORE = "m";

    private static Invocable parser;
    private static Logger logger;
    private static String VERSION;
    private static Properties properties=new Properties();


    public static void main(String[] args) throws IOException, XmlRpcException, ScriptException {

        CommandLine line = null;
        Options options = getOptions();

        try {
            line = parseCommandLine(options, args);

        } catch (ParseException e) {
            e.printStackTrace();
            printHelp(options);
            return;

        }
        if (line.hasOption(HELP)) {
            printHelp(options);
            return;
        }
        if (line.hasOption(LOG)) {
            String logName = line.getOptionValue(LOG);
            System.setProperty("org.slf4j.simpleLogger.logFile", logName);
        }
        logger = LoggerFactory.getLogger(Main.class);
        if (!line.hasOption(INPUT)) {
            logger.error("Input is mandatory");
            printHelp(options);
            return;
        }


        File file = new File(line.getOptionValue(INPUT));
        initParser();
        boolean byName = line.hasOption(BYNAME);
        boolean force = line.hasOption(FORCE);
        boolean rec=line.hasOption(RECURSIVE);
        double minScore=Double.parseDouble(line.getOptionValue(MIN_SCORE,"0"));
        properties.load(Main.class.getClassLoader().getResourceAsStream("props.properties"));
        VERSION=properties.getProperty("version","UNKNOWN");

        logger.info("STARTED FAST SUBTITLES DOWNLOADER "+VERSION);

        URL serverUrl = new URL("https", "api.opensubtitles.org", 443, "/xml-rpc");
        OpenSubtitlesClient osClient = new OpenSubtitlesClientImpl(serverUrl);
        String subLang = line.getOptionValue(LANG, "eng");
        String[] subLangs = subLang.split(",");
        String clientLang = "en";

        osClient.login("asafbennatan", "nikoniko", clientLang, "TemporaryUserAgent");
        Collection<File> files;
        if (file.isDirectory()) {
            files=FileUtils.listFiles(file,new FileFileFilter(){
                @Override
                public boolean accept(File file) {
                    try {
                        String mime = Files.probeContentType(file.toPath());
                        return mime != null && mime.contains("video");
                    } catch (IOException e) {
                        return false;
                    }                }
            },new FileFileFilter(){
                @Override
                public boolean accept(File file) {
                    return rec&&file.isDirectory();
                }
            });


        } else {
            List<File> l=new ArrayList<>();
            l.add(file);
            files =l;
        }

        for (File file1 : files) {
            File sub = getSub(file1);
            if (!force && sub.exists()) {
                logger.info(sub + " already exists");
                continue;
            }
            Object usedForSearch = null;
            int numberOfSubs=0;
            SubtitleInfo info = null;
                try {
                    if (byName) {
                        VideoInfo videoInfo = parseVideoInfo(file1.getName());
                        usedForSearch = videoInfo;
                        if (videoInfo != null) {
                            List<SubtitleInfo> subtitles = osClient.searchSubtitles(subLang, videoInfo.getName(), videoInfo.getSeason(), videoInfo.getEpisode());
                            numberOfSubs=subtitles.size();
                            subtitles=subtitles.parallelStream().filter(f->f.getScore() >= minScore).sorted(Comparator.comparingInt((SubtitleInfo o) -> getLangRating(o.getLanguage(),subLangs)).thenComparing(Comparator.comparingDouble(SubtitleInfo::getScore).reversed())).collect(Collectors.toList());
                            info = !subtitles.isEmpty() ? subtitles.get(0) : null;

                        }

                    }
                    if (info == null) {
                        List<SubtitleInfo> subtitles = osClient.searchSubtitles(subLang, file1);
                        numberOfSubs=subtitles.size();
                        subtitles=subtitles.parallelStream().filter(f->f.getScore() >= minScore).sorted(Comparator.comparingInt((SubtitleInfo o) -> getLangRating(o.getLanguage(),subLangs)).thenComparing(Comparator.comparingDouble(SubtitleInfo::getScore).reversed())).collect(Collectors.toList());

                        info = subtitles.isEmpty() ? null : subtitles.get(0);
                        usedForSearch = "Hash";


                    }
                    if (!byName && info == null) {
                        VideoInfo videoInfo = parseVideoInfo(file1.getName());
                        usedForSearch = videoInfo;
                        if (videoInfo != null) {
                            List<SubtitleInfo> subtitles = osClient.searchSubtitles(subLang, videoInfo.getName(), videoInfo.getSeason(), videoInfo.getEpisode());
                            numberOfSubs=subtitles.size();
                            subtitles=subtitles.parallelStream().filter(f->f.getScore() >= minScore).sorted(Comparator.comparingInt((SubtitleInfo o) -> getLangRating(o.getLanguage(),subLangs)).thenComparing(Comparator.comparingDouble(SubtitleInfo::getScore).reversed())).collect(Collectors.toList());
                            info = !subtitles.isEmpty() ? subtitles.get(0) : null;

                        }

                    }


                } catch (XmlRpcException | IOException e) {
                    logger.error("could not get subtitles for " + file1.getName() + ", " + usedForSearch + " failed listing", e);

                }


            if (info != null) {
                    logger.info("Selected Subtitles for " + file1 + " "+usedForSearch+ ",selected: "+info+" had "+numberOfSubs +" option"+(numberOfSubs>1?"s":""));


                List<SubtitleFile> subtitleFiles = null;
                try {
                    long start=System.currentTimeMillis();
                    subtitleFiles = osClient.downloadSubtitles(info.getSubtitleFileId());
                    System.out.println("subtitles downloaded in "+(System.currentTimeMillis()-start) +" millis");
                    if (!subtitleFiles.isEmpty()) {
                        SubtitleFile subtitleFile = subtitleFiles.get(0);
                        FileUtils.writeStringToFile(sub, subtitleFile.getContentAsString(info.getEncoding()), Charset.forName(info.getEncoding()));


                    } else {
                        logger.error("could not get subtitles for " + file1.getName() + ", " + usedForSearch + " empty download file");

                    }
                } catch (XmlRpcException | IOException e) {
                    logger.error("could not get subtitles for " + file1.getName() + ", " + usedForSearch + " error while downloading", e);

                }


            } else {
                logger.error("could not get subtitles for " + file1.getName() + ", " + usedForSearch + " none found");
            }

        }


    }



    private static int getLangRating(String language, String[] subLangs) {
        for (int i = 0; i < subLangs.length; i++) {
            if(language.toLowerCase().startsWith(subLangs[i])){
                return i;
            }
        }
        return Integer.MAX_VALUE;

    }

    private static void initParser() throws IOException, ScriptException {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        String script = IOUtils.toString(Main.class.getClassLoader().getResourceAsStream("parser.js"), Charset.forName("UTF-8"));
        engine.eval(script);

        parser = (Invocable) engine;
    }

    private static void printHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("fast-subtitles-downloader", options);
    }

    private static CommandLine parseCommandLine(Options options, String[] args) throws ParseException {


        CommandLineParser parser = new DefaultParser();
        return parser.parse(options, args);


    }

    private static Options getOptions() {
        return new Options()
                .addOption(HELP, "print this message")
                .addOption(BYNAME, "search by name first")
                .addOption(INPUT, true, "use given file/folder for subtitles download")
                .addOption(LANG, true, "comma delimited list of subtitles langauge for example: heb,eng " +
                        "will download heb if possible and otherwise will fallback to eng")
                .addOption(FORCE, "use for forcing download subtitle even if the file exists")
                .addOption(LOG, true, "use for creating a log file")
                .addOption(RECURSIVE, "use for recursively iterating over directories")
                .addOption(MIN_SCORE,true, "use for removing subtitles under score");



    }

    private static VideoInfo parseVideoInfo(String fileName) {
        try {
            ScriptObjectMirror res = (ScriptObjectMirror) parser.invokeFunction("parse", fileName);
            return new VideoInfo((String) res.get("show"), res.get("season") + "", (Double) res.get("episode") + "");
        } catch (ScriptException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;

     /*   String[] split=fileName.split("\\.");

        String[] episodeSeason=split[2].replaceFirst("e","E").split("E");
        String season = episodeSeason[0].replace("S", "").replace("s","");
        String episode = episodeSeason[1];
        String videoName = split[0] + " " + split[1];
        return new VideoInfo(videoName, season, episode);*/
    }

    private static File getSub(File file1) {

        return new File(file1.getParent(), FilenameUtils.getBaseName(file1.getName()) + ".srt");
    }

}
