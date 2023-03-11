package com.asaf;

public class VideoInfo {
    private String name;
    private Integer season;
    private Integer episode;

    public VideoInfo(String name, Integer season, Integer episode) {
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

    public Integer getSeason() {
        return season;
    }

    public VideoInfo setSeason(Integer season) {
        this.season = season;
        return this;
    }

    public Integer getEpisode() {
        return episode;
    }

    public VideoInfo setEpisode(Integer episode) {
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
