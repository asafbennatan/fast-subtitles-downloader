package com.asaf.response;

public class DownloadLink {
    private String link;
    private String file_name;
    private int requests;
    private int remaining;
    private String message;
    private String reset_time;
    private String reset_time_utc;

    public String getLink() {
        return link;
    }

    public <T extends DownloadLink> T setLink(String link) {
        this.link = link;
        return (T) this;
    }

    public String getFile_name() {
        return file_name;
    }

    public <T extends DownloadLink> T setFile_name(String file_name) {
        this.file_name = file_name;
        return (T) this;
    }

    public int getRequests() {
        return requests;
    }

    public <T extends DownloadLink> T setRequests(int requests) {
        this.requests = requests;
        return (T) this;
    }

    public int getRemaining() {
        return remaining;
    }

    public <T extends DownloadLink> T setRemaining(int remaining) {
        this.remaining = remaining;
        return (T) this;
    }

    public String getMessage() {
        return message;
    }

    public <T extends DownloadLink> T setMessage(String message) {
        this.message = message;
        return (T) this;
    }

    public String getReset_time() {
        return reset_time;
    }

    public <T extends DownloadLink> T setReset_time(String reset_time) {
        this.reset_time = reset_time;
        return (T) this;
    }

    public String getReset_time_utc() {
        return reset_time_utc;
    }

    public <T extends DownloadLink> T setReset_time_utc(String reset_time_utc) {
        this.reset_time_utc = reset_time_utc;
        return (T) this;
    }
}
