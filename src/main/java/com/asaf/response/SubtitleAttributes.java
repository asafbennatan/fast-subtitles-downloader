package com.asaf.response;

import java.time.OffsetDateTime;

public class SubtitleAttributes {
    /**
     * "subtitle_id": "1652594",
     *                 "language": "en",
     *                 "download_count": 8196,
     *                 "new_download_count": 27,
     *                 "hearing_impaired": false,
     *                 "hd": true,
     *                 "fps": 0.0,
     *                 "votes": 0,
     *                 "ratings": 0.0,
     *                 "from_trusted": false,
     *                 "foreign_parts_only": false,
     *                 "upload_date": "2013-08-15T15:44:52Z",
     *                 "ai_translated": false,
     *                 "machine_translated": false,
     *                 "release": "The.Mindy.Project.S01E01.720p.HDTV.ReEnc-Max",
     *                 "comments": "",
     *                 "legacy_subtitle_id": 5135288,
     *                 "uploader": {
     *                     "uploader_id": 3282,
     *                     "name": "os-auto",
     *                     "rank": "Application Developers"
     *                 },
     *                 "feature_details": {
     *                     "feature_id": 41899,
     *                     "feature_type": "Episode",
     *                     "year": 2012,
     *                     "title": "Pilot",
     *                     "movie_name": "The Mindy Project - S01E01  \"The Mindy Project\" Pilot",
     *                     "imdb_id": 2157844,
     *                     "tmdb_id": 895782,
     *                     "season_number": 1,
     *                     "episode_number": 1,
     *                     "parent_imdb_id": 2211129,
     *                     "parent_title": "The Mindy Project",
     *                     "parent_tmdb_id": 44857,
     *                     "parent_feature_id": 12415
     *                 },
     *                 "url": "https://www.opensubtitles.com/en/subtitles/legacy/5135288",
     *                 "related_links": [
     *                     {
     *                         "label": "All subtitles for Tv Show The Mindy Project",
     *                         "url": "https://www.opensubtitles.com/en/features/redirect/12415",
     *                         "img_url": "https://s9.opensubtitles.com/features/9/9/8/41899.jpg"
     *                     },
     *                     {
     *                         "label": "All subtitles for Episode Pilot",
     *                         "url": "https://www.opensubtitles.com/en/features/redirect/41899"
     *                     }
     *                 ],
     *                 "files": [
     *                     {
     *                         "file_id": 1741449,
     *                         "cd_number": 1,
     *                         "file_name": "The.Mindy.Project.S01E01.720p.HDTV.ReEnc-Max-eng"
     *                     }
     *                 ]
     */

    private String subtitle_id;
    private String language;
    private int download_count;
    private int new_download_count;
    private boolean hearing_impaired;
    private boolean hd;
    private double fps;
    private int votes;
    private double ratings;
    private boolean from_trusted;
    private boolean foreign_parts_only;
    private OffsetDateTime upload_date;
    private boolean ai_translated;
    private boolean machine_translated;
    private String release;
    private String comments;
    private int legacy_subtitle_id;
    private Uploader uploader;
    private FeatureDetails feature_details;
    private String url;
    private RelatedLink[] related_links;
private SubtitleFile[] files;


    public String getSubtitle_id() {
        return subtitle_id;
    }

    public <T extends SubtitleAttributes> T setSubtitle_id(String subtitle_id) {
        this.subtitle_id = subtitle_id;
        return (T) this;
    }

    public String getLanguage() {
        return language;
    }

    public <T extends SubtitleAttributes> T setLanguage(String language) {
        this.language = language;
        return (T) this;
    }

    public int getDownload_count() {
        return download_count;
    }

    public <T extends SubtitleAttributes> T setDownload_count(int download_count) {
        this.download_count = download_count;
        return (T) this;
    }

    public int getNew_download_count() {
        return new_download_count;
    }

    public <T extends SubtitleAttributes> T setNew_download_count(int new_download_count) {
        this.new_download_count = new_download_count;
        return (T) this;
    }

    public boolean isHearing_impaired() {
        return hearing_impaired;
    }

    public <T extends SubtitleAttributes> T setHearing_impaired(boolean hearing_impaired) {
        this.hearing_impaired = hearing_impaired;
        return (T) this;
    }

    public boolean isHd() {
        return hd;
    }

    public <T extends SubtitleAttributes> T setHd(boolean hd) {
        this.hd = hd;
        return (T) this;
    }

    public double getFps() {
        return fps;
    }

    public <T extends SubtitleAttributes> T setFps(double fps) {
        this.fps = fps;
        return (T) this;
    }

    public int getVotes() {
        return votes;
    }

    public <T extends SubtitleAttributes> T setVotes(int votes) {
        this.votes = votes;
        return (T) this;
    }

    public double getRatings() {
        return ratings;
    }

    public <T extends SubtitleAttributes> T setRatings(double ratings) {
        this.ratings = ratings;
        return (T) this;
    }

    public boolean isFrom_trusted() {
        return from_trusted;
    }

    public <T extends SubtitleAttributes> T setFrom_trusted(boolean from_trusted) {
        this.from_trusted = from_trusted;
        return (T) this;
    }

    public boolean isForeign_parts_only() {
        return foreign_parts_only;
    }

    public <T extends SubtitleAttributes> T setForeign_parts_only(boolean foreign_parts_only) {
        this.foreign_parts_only = foreign_parts_only;
        return (T) this;
    }

    public OffsetDateTime getUpload_date() {
        return upload_date;
    }

    public <T extends SubtitleAttributes> T setUpload_date(OffsetDateTime upload_date) {
        this.upload_date = upload_date;
        return (T) this;
    }

    public boolean isAi_translated() {
        return ai_translated;
    }

    public <T extends SubtitleAttributes> T setAi_translated(boolean ai_translated) {
        this.ai_translated = ai_translated;
        return (T) this;
    }

    public boolean isMachine_translated() {
        return machine_translated;
    }

    public <T extends SubtitleAttributes> T setMachine_translated(boolean machine_translated) {
        this.machine_translated = machine_translated;
        return (T) this;
    }

    public String getRelease() {
        return release;
    }

    public <T extends SubtitleAttributes> T setRelease(String release) {
        this.release = release;
        return (T) this;
    }

    public String getComments() {
        return comments;
    }

    public <T extends SubtitleAttributes> T setComments(String comments) {
        this.comments = comments;
        return (T) this;
    }

    public int getLegacy_subtitle_id() {
        return legacy_subtitle_id;
    }

    public <T extends SubtitleAttributes> T setLegacy_subtitle_id(int legacy_subtitle_id) {
        this.legacy_subtitle_id = legacy_subtitle_id;
        return (T) this;
    }

    public Uploader getUploader() {
        return uploader;
    }

    public <T extends SubtitleAttributes> T setUploader(Uploader uploader) {
        this.uploader = uploader;
        return (T) this;
    }

    public FeatureDetails getFeature_details() {
        return feature_details;
    }

    public <T extends SubtitleAttributes> T setFeature_details(FeatureDetails feature_details) {
        this.feature_details = feature_details;
        return (T) this;
    }

    public String getUrl() {
        return url;
    }

    public <T extends SubtitleAttributes> T setUrl(String url) {
        this.url = url;
        return (T) this;
    }

    public RelatedLink[] getRelated_links() {
        return related_links;
    }

    public <T extends SubtitleAttributes> T setRelated_links(RelatedLink[] related_links) {
        this.related_links = related_links;
        return (T) this;
    }

    public SubtitleFile[] getFiles() {
        return files;
    }

    public <T extends SubtitleAttributes> T setFiles(SubtitleFile[] files) {
        this.files = files;
        return (T) this;
    }
}
