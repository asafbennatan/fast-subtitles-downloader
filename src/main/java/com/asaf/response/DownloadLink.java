package com.asaf.response;

public class DownloadLink {
    /**
     * {
     *   "link": "https://www.opensubtitles.com/download/D2C8A7C88D5F7B166D304CBDAF11AB8CE6B6F50B1AC367D9C0F1F9B114C421C8438BF2FAABD862A7335D0D886BD634629C90CA90E5D5962E840081845176BBBFFFB5356D1569C257B682845179660F204C35F3F12CED821C9227B763E8E9CE5A1BAC45E9DC72835644CF7B6C8F2C58B70BF1A69C0C7787C33376289631912D75AAAED32B4662EB0BC4F5DE45A1827158C792A430004DF3125D7DBF43A516BE06370B2360C8066644688B06928F5345E67637BDF4B5777A83B5C1012084976B40C904B61F0B22171F2A3413101033886B586889EB6A5928569A374B060435BF0E5DAD0CAA83FEEF869DB7B64D122C292D3576732635837985CEC72DC96573C2E7FE3B39A0DAD797ED5D43A81A1557E74662379288284B4C71B1B791CF8A31BBBCF78409F5A31EEFE5022FFCE2DCB1EAC2/subfile/The.Mindy.Project.S01E01.720p.HDTV.ReEnc-Max-eng.srt",
     *   "file_name": "The.Mindy.Project.S01E01.720p.HDTV.ReEnc-Max-eng.srt",
     *   "requests": 1,
     *   "remaining": 4,
     *   "message": "Your quota will be renewed in 23 hours and 59 minutes (2023-03-11 22:14:37 UTC) ",
     *   "reset_time": "23 hours and 59 minutes",
     *   "reset_time_utc": "2023-03-11T22:14:37.203Z"
     * }
     */
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
