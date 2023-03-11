package com.asaf.response;

import java.util.List;

public class SearchResponse<E extends Data> {
    /**
     * POJO representing this json:
     * {
     * "total_pages": 1,
     * "total_count": 4,
     * "per_page": 60,
     * "page": 1,
     * "data": [
     * {
     * "id": "1652290",
     * "type": "subtitle",
     * "attributes": {
     * "subtitle_id": "1652290",
     * "language": "en",
     * "download_count": 46378,
     * "new_download_count": 109,
     * "hearing_impaired": false,
     * "hd": false,
     * "fps": 23.976,
     * "votes": 0,
     * "ratings": 0.0,
     * "from_trusted": false,
     * "foreign_parts_only": false,
     * "upload_date": "2012-09-27T15:32:08Z",
     * "ai_translated": false,
     * "machine_translated": false,
     * "release": "The.Mindy.Project.S01E01.HDTV.x264-LOL",
     * "comments": "",
     * "legacy_subtitle_id": 4672201,
     * "uploader": {
     * "uploader_id": 3282,
     * "name": "os-auto",
     * "rank": "Application Developers"
     * },
     * "feature_details": {
     * "feature_id": 41899,
     * "feature_type": "Episode",
     * "year": 2012,
     * "title": "Pilot",
     * "movie_name": "The Mindy Project - S01E01  Pilot",
     * "imdb_id": 2157844,
     * "tmdb_id": 895782,
     * "season_number": 1,
     * "episode_number": 1,
     * "parent_imdb_id": 2211129,
     * "parent_title": "The Mindy Project",
     * "parent_tmdb_id": 44857,
     * "parent_feature_id": 12415
     * },
     * "url": "https://www.opensubtitles.com/en/subtitles/legacy/4672201",
     * "related_links": [
     * {
     * "label": "All subtitles for Tv Show The Mindy Project",
     * "url": "https://www.opensubtitles.com/en/features/redirect/12415",
     * "img_url": "https://s9.opensubtitles.com/features/9/9/8/41899.jpg"
     * },
     * {
     * "label": "All subtitles for Episode Pilot",
     * "url": "https://www.opensubtitles.com/en/features/redirect/41899"
     * }
     * ],
     * "files": [
     * {
     * "file_id": 1741133,
     * "cd_number": 1,
     * "file_name": "The Mindy Project - 01x01 - Pilot.LOL.English.HI.C.orig.Addic7ed.com"
     * }
     * ]
     * }
     * },
     * {
     * "id": "1652594",
     * "type": "subtitle",
     * "attributes": {
     * "subtitle_id": "1652594",
     * "language": "en",
     * "download_count": 8196,
     * "new_download_count": 27,
     * "hearing_impaired": false,
     * "hd": true,
     * "fps": 0.0,
     * "votes": 0,
     * "ratings": 0.0,
     * "from_trusted": false,
     * "foreign_parts_only": false,
     * "upload_date": "2013-08-15T15:44:52Z",
     * "ai_translated": false,
     * "machine_translated": false,
     * "release": "The.Mindy.Project.S01E01.720p.HDTV.ReEnc-Max",
     * "comments": "",
     * "legacy_subtitle_id": 5135288,
     * "uploader": {
     * "uploader_id": 3282,
     * "name": "os-auto",
     * "rank": "Application Developers"
     * },
     * "feature_details": {
     * "feature_id": 41899,
     * "feature_type": "Episode",
     * "year": 2012,
     * "title": "Pilot",
     * "movie_name": "The Mindy Project - S01E01  \"The Mindy Project\" Pilot",
     * "imdb_id": 2157844,
     * "tmdb_id": 895782,
     * "season_number": 1,
     * "episode_number": 1,
     * "parent_imdb_id": 2211129,
     * "parent_title": "The Mindy Project",
     * "parent_tmdb_id": 44857,
     * "parent_feature_id": 12415
     * },
     * "url": "https://www.opensubtitles.com/en/subtitles/legacy/5135288",
     * "related_links": [
     * {
     * "label": "All subtitles for Tv Show The Mindy Project",
     * "url": "https://www.opensubtitles.com/en/features/redirect/12415",
     * "img_url": "https://s9.opensubtitles.com/features/9/9/8/41899.jpg"
     * },
     * {
     * "label": "All subtitles for Episode Pilot",
     * "url": "https://www.opensubtitles.com/en/features/redirect/41899"
     * }
     * ],
     * "files": [
     * {
     * "file_id": 1741449,
     * "cd_number": 1,
     * "file_name": "The.Mindy.Project.S01E01.720p.HDTV.ReEnc-Max-eng"
     * }
     * ]
     * }
     * },
     * {
     * "id": "7004816",
     * "type": "subtitle",
     * "attributes": {
     * "subtitle_id": "7004816",
     * "language": "en",
     * "download_count": 78,
     * "new_download_count": 19,
     * "hearing_impaired": true,
     * "hd": false,
     * "fps": 29.97,
     * "votes": 0,
     * "ratings": 0.0,
     * "from_trusted": true,
     * "foreign_parts_only": false,
     * "upload_date": "2022-12-25T22:22:18Z",
     * "ai_translated": false,
     * "machine_translated": false,
     * "release": "Mindy Project S01E01 Pilot.DVDRip.HI.en.UNVSL",
     * "comments": "",
     * "legacy_subtitle_id": 9370192,
     * "uploader": {
     * "uploader_id": 215338,
     * "name": "mrtinkles",
     * "rank": "translator"
     * },
     * "feature_details": {
     * "feature_id": 41899,
     * "feature_type": "Episode",
     * "year": 2012,
     * "title": "Pilot",
     * "movie_name": "The Mindy Project - S01E01  Pilot",
     * "imdb_id": 2157844,
     * "tmdb_id": 895782,
     * "season_number": 1,
     * "episode_number": 1,
     * "parent_imdb_id": 2211129,
     * "parent_title": "The Mindy Project",
     * "parent_tmdb_id": 44857,
     * "parent_feature_id": 12415
     * },
     * "url": "https://www.opensubtitles.com/en/subtitles/legacy/9370192",
     * "related_links": [
     * {
     * "label": "All subtitles for Tv Show The Mindy Project",
     * "url": "https://www.opensubtitles.com/en/features/redirect/12415",
     * "img_url": "https://s9.opensubtitles.com/features/9/9/8/41899.jpg"
     * },
     * {
     * "label": "All subtitles for Episode Pilot",
     * "url": "https://www.opensubtitles.com/en/features/redirect/41899"
     * }
     * ],
     * "files": [
     * {
     * "file_id": 7952279,
     * "cd_number": 1,
     * "file_name": "Mindy Project S01E01 Pilot.DVDRip.HI.en.UNVSL"
     * }
     * ]
     * }
     * },
     * {
     * "id": "7004817",
     * "type": "subtitle",
     * "attributes": {
     * "subtitle_id": "7004817",
     * "language": "en",
     * "download_count": 48,
     * "new_download_count": 100,
     * "hearing_impaired": false,
     * "hd": false,
     * "fps": 29.97,
     * "votes": 0,
     * "ratings": 0.0,
     * "from_trusted": true,
     * "foreign_parts_only": false,
     * "upload_date": "2022-12-25T22:24:14Z",
     * "ai_translated": false,
     * "machine_translated": false,
     * "release": "Mindy Project S01E01 Pilot.DVDRip.NonHI.en.UNVSL",
     * "comments": "",
     * "legacy_subtitle_id": 9370217,
     * "uploader": {
     * "uploader_id": 215338,
     * "name": "mrtinkles",
     * "rank": "translator"
     * },
     * "feature_details": {
     * "feature_id": 41899,
     * "feature_type": "Episode",
     * "year": 2012,
     * "title": "Pilot",
     * "movie_name": "The Mindy Project - S01E01  Pilot",
     * "imdb_id": 2157844,
     * "tmdb_id": 895782,
     * "season_number": 1,
     * "episode_number": 1,
     * "parent_imdb_id": 2211129,
     * "parent_title": "The Mindy Project",
     * "parent_tmdb_id": 44857,
     * "parent_feature_id": 12415
     * },
     * "url": "https://www.opensubtitles.com/en/subtitles/legacy/9370217",
     * "related_links": [
     * {
     * "label": "All subtitles for Tv Show The Mindy Project",
     * "url": "https://www.opensubtitles.com/en/features/redirect/12415",
     * "img_url": "https://s9.opensubtitles.com/features/9/9/8/41899.jpg"
     * },
     * {
     * "label": "All subtitles for Episode Pilot",
     * "url": "https://www.opensubtitles.com/en/features/redirect/41899"
     * }
     * ],
     * "files": [
     * {
     * "file_id": 7952280,
     * "cd_number": 1,
     * "file_name": "Mindy Project S01E01 Pilot.DVDRip.NonHI.en.UNVSL"
     * }
     * ]
     * }
     * }
     * ]
     * }
     */
    private int total_pages;
    private int total_count;
    private int page;
    private int per_page;
    private List<E> data;


    public int getTotal_pages() {
        return total_pages;
    }

    public <T extends SearchResponse> T setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
        return (T) this;
    }

    public int getTotal_count() {
        return total_count;
    }

    public <T extends SearchResponse> T setTotal_count(int total_count) {
        this.total_count = total_count;
        return (T) this;
    }

    public int getPage() {
        return page;
    }

    public <T extends SearchResponse> T setPage(int page) {
        this.page = page;
        return (T) this;
    }

    public int getPer_page() {
        return per_page;
    }

    public <T extends SearchResponse> T setPer_page(int per_page) {
        this.per_page = per_page;
        return (T) this;
    }

    public List<E> getData() {
        return data;
    }

    public <T extends SearchResponse> T setData(List<E> data) {
        this.data = data;
        return (T) this;
    }
}
