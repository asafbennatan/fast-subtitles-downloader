package com.asaf.response;

public class User {

    private int allowed_downloads;
    private int allowed_translations;
    private String level;
    private int user_id;
    private boolean ext_installed;
    private boolean vip;

    public int getAllowed_downloads() {
        return allowed_downloads;
    }

    public <T extends User> T setAllowed_downloads(int allowed_downloads) {
        this.allowed_downloads = allowed_downloads;
        return (T) this;
    }

    public int getAllowed_translations() {
        return allowed_translations;
    }

    public <T extends User> T setAllowed_translations(int allowed_translations) {
        this.allowed_translations = allowed_translations;
        return (T) this;
    }

    public String getLevel() {
        return level;
    }

    public <T extends User> T setLevel(String level) {
        this.level = level;
        return (T) this;
    }

    public int getUser_id() {
        return user_id;
    }

    public <T extends User> T setUser_id(int user_id) {
        this.user_id = user_id;
        return (T) this;
    }

    public boolean isExt_installed() {
        return ext_installed;
    }

    public <T extends User> T setExt_installed(boolean ext_installed) {
        this.ext_installed = ext_installed;
        return (T) this;
    }

    public boolean isVip() {
        return vip;
    }

    public <T extends User> T setVip(boolean vip) {
        this.vip = vip;
        return (T) this;
    }
}
