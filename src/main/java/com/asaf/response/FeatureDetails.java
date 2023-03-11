package com.asaf.response;

public class FeatureDetails {
    /**
     * {
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
     *                 }
     */

    private int feature_id;
    private String feature_type;
    private int year;
    private String title;
    private String movie_name;
    private int imdb_id;
    private int tmdb_id;
    private int season_number;
    private int episode_number;
    private int parent_imdb_id;
    private String parent_title;
    private int parent_tmdb_id;
    private int parent_feature_id;

    public int getFeature_id() {
        return feature_id;
    }

    public <T extends FeatureDetails> T setFeature_id(int feature_id) {
        this.feature_id = feature_id;
        return (T) this;
    }

    public String getFeature_type() {
        return feature_type;
    }

    public <T extends FeatureDetails> T setFeature_type(String feature_type) {
        this.feature_type = feature_type;
        return (T) this;
    }

    public int getYear() {
        return year;
    }

    public <T extends FeatureDetails> T setYear(int year) {
        this.year = year;
        return (T) this;
    }

    public String getTitle() {
        return title;
    }

    public <T extends FeatureDetails> T setTitle(String title) {
        this.title = title;
        return (T) this;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public <T extends FeatureDetails> T setMovie_name(String movie_name) {
        this.movie_name = movie_name;
        return (T) this;
    }

    public int getImdb_id() {
        return imdb_id;
    }

    public <T extends FeatureDetails> T setImdb_id(int imdb_id) {
        this.imdb_id = imdb_id;
        return (T) this;
    }

    public int getTmdb_id() {
        return tmdb_id;
    }

    public <T extends FeatureDetails> T setTmdb_id(int tmdb_id) {
        this.tmdb_id = tmdb_id;
        return (T) this;
    }

    public int getSeason_number() {
        return season_number;
    }

    public <T extends FeatureDetails> T setSeason_number(int season_number) {
        this.season_number = season_number;
        return (T) this;
    }

    public int getEpisode_number() {
        return episode_number;
    }

    public <T extends FeatureDetails> T setEpisode_number(int episode_number) {
        this.episode_number = episode_number;
        return (T) this;
    }

    public int getParent_imdb_id() {
        return parent_imdb_id;
    }

    public <T extends FeatureDetails> T setParent_imdb_id(int parent_imdb_id) {
        this.parent_imdb_id = parent_imdb_id;
        return (T) this;
    }

    public String getParent_title() {
        return parent_title;
    }

    public <T extends FeatureDetails> T setParent_title(String parent_title) {
        this.parent_title = parent_title;
        return (T) this;
    }

    public int getParent_tmdb_id() {
        return parent_tmdb_id;
    }

    public <T extends FeatureDetails> T setParent_tmdb_id(int parent_tmdb_id) {
        this.parent_tmdb_id = parent_tmdb_id;
        return (T) this;
    }

    public int getParent_feature_id() {
        return parent_feature_id;
    }

    public <T extends FeatureDetails> T setParent_feature_id(int parent_feature_id) {
        this.parent_feature_id = parent_feature_id;
        return (T) this;
    }
}
