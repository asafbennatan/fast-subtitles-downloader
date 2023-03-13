package com.asaf.response;

public class SubtitleFile {


    private int file_id;
    private int cd_number;
    private String file_name;

    public int getFile_id() {
        return file_id;
    }

    public <T extends SubtitleFile> T setFile_id(int file_id) {
        this.file_id = file_id;
        return (T) this;
    }

    public int getCd_number() {
        return cd_number;
    }

    public <T extends SubtitleFile> T setCd_number(int cd_number) {
        this.cd_number = cd_number;
        return (T) this;
    }

    public String getFile_name() {
        return file_name;
    }

    public <T extends SubtitleFile> T setFile_name(String file_name) {
        this.file_name = file_name;
        return (T) this;
    }
}
