package com.asaf;

public class VideoInfo {
    private String name;
    private String season;
    private String episode;

    public VideoInfo(String name, String season, String episode) {
        this.name = name;
        this.season = season;
        this.episode = episode;
    }

    public String getName() {
        return name;
    }

    public VideoInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getSeason() {
        return season;
    }

    public VideoInfo setSeason(String season) {
        this.season = season;
        return this;
    }

    public String getEpisode() {
        return episode;
    }

    public VideoInfo setEpisode(String episode) {
        this.episode = episode;
        return this;
    }

    @Override
    public String toString() {
        return "VideoInfo{" +
                "name='" + name + '\'' +
                ", season='" + season + '\'' +
                ", episode='" + episode + '\'' +
                '}';
    }
}
