package com.asaf.response;

public class Uploader {
    /**
     * {
     *                     "uploader_id": 3282,
     *                     "name": "os-auto",
     *                     "rank": "Application Developers"
     *                 }
     */
    private int uploader_id;
    private String name;
    private String rank;

    public int getUploader_id() {
        return uploader_id;
    }

    public <T extends Uploader> T setUploader_id(int uploader_id) {
        this.uploader_id = uploader_id;
        return (T) this;
    }

    public String getName() {
        return name;
    }

    public <T extends Uploader> T setName(String name) {
        this.name = name;
        return (T) this;
    }

    public String getRank() {
        return rank;
    }

    public <T extends Uploader> T setRank(String rank) {
        this.rank = rank;
        return (T) this;
    }
}
