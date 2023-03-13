package com.asaf.response;

public class LoginResponse {

    private User user;
    private String base_url;
    private String token;
    private int status;

    public User getUser() {
        return user;
    }

    public <T extends LoginResponse> T setUser(User user) {
        this.user = user;
        return (T) this;
    }

    public String getBase_url() {
        return base_url;
    }

    public <T extends LoginResponse> T setBase_url(String base_url) {
        this.base_url = base_url;
        return (T) this;
    }

    public String getToken() {
        return token;
    }

    public <T extends LoginResponse> T setToken(String token) {
        this.token = token;
        return (T) this;
    }

    public int getStatus() {
        return status;
    }

    public <T extends LoginResponse> T setStatus(int status) {
        this.status = status;
        return (T) this;
    }
}
