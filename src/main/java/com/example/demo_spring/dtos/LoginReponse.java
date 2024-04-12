package com.example.demo_spring.dtos;

public class LoginReponse {
    private String token;

    private long expiresIn;

    public String getToken() {
        return token;
    }

    public LoginReponse setToken(String token) {
        this.token = token;
        return this;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public LoginReponse setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }
}
