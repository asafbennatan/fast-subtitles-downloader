package com.asaf.requests;

public class DownloadLinkRequest {

    private int file_id;

    public DownloadLinkRequest(int file_id) {
        this.file_id = file_id;
    }

    public DownloadLinkRequest() {
    }

    public int getFile_id() {
        return file_id;
    }

    public <T extends DownloadLinkRequest> T setFile_id(int file_id) {
        this.file_id = file_id;
        return (T) this;
    }
}
