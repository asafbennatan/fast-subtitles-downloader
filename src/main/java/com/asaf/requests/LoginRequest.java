package com.asaf.requests;

public class LoginRequest {

    private String username;
    private String password;
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public LoginRequest() {
    }

    public String getUsername() {
        return username;
    }

    public <T extends LoginRequest> T setUsername(String username) {
        this.username = username;
        return (T) this;
    }

    public String getPassword() {
        return password;
    }

    public <T extends LoginRequest> T setPassword(String password) {
        this.password = password;
        return (T) this;
    }
}
