package com.asaf.response;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GussItResponse {
    /**
     * {
     *   "title": [
     *     "The Mindy Project",
     *     "MIXED"
     *   ],
     *   "season": [
     *     1,
     *     2,
     *     3,
     *     4,
     *     5,
     *     6
     *   ],
     *   "screen_size": "1080p",
     *   "video_codec": "H.265",
     *   "audio_channels": "5.1",
     *   "release_group": "5.2-CPT",
     *   "episode": [
     *     1,
     *     2
     *   ],
     *   "container": "mkv",
     *   "mimetype": "video/x-matroska",
     *   "type": "episode"
     * }
     */
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private String[] title;
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private int[] season;
    private String screen_size;
    private String video_codec;
    private String audio_channels;
    private String release_group;
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private int[] episode;
    private String container;
    private String mimetype;
    private String type;


    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public String[] getTitle() {
        return title;
    }

    public <T extends GussItResponse> T setTitle(String[] title) {
        this.title = title;
        return (T) this;
    }

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public int[] getSeason() {
        return season;
    }

    public <T extends GussItResponse> T setSeason(int[] season) {
        this.season = season;
        return (T) this;
    }

    public String getScreen_size() {
        return screen_size;
    }

    public <T extends GussItResponse> T setScreen_size(String screen_size) {
        this.screen_size = screen_size;
        return (T) this;
    }

    public String getVideo_codec() {
        return video_codec;
    }

    public <T extends GussItResponse> T setVideo_codec(String video_codec) {
        this.video_codec = video_codec;
        return (T) this;
    }

    public String getAudio_channels() {
        return audio_channels;
    }

    public <T extends GussItResponse> T setAudio_channels(String audio_channels) {
        this.audio_channels = audio_channels;
        return (T) this;
    }

    public String getRelease_group() {
        return release_group;
    }

    public <T extends GussItResponse> T setRelease_group(String release_group) {
        this.release_group = release_group;
        return (T) this;
    }

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public int[] getEpisode() {
        return episode;
    }

    public <T extends GussItResponse> T setEpisode(int[] episode) {
        this.episode = episode;
        return (T) this;
    }

    public String getContainer() {
        return container;
    }

    public <T extends GussItResponse> T setContainer(String container) {
        this.container = container;
        return (T) this;
    }

    public String getMimetype() {
        return mimetype;
    }

    public <T extends GussItResponse> T setMimetype(String mimetype) {
        this.mimetype = mimetype;
        return (T) this;
    }

    public String getType() {
        return type;
    }

    public <T extends GussItResponse> T setType(String type) {
        this.type = type;
        return (T) this;
    }
}
