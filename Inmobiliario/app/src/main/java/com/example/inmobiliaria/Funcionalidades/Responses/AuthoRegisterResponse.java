package com.example.inmobiliaria.Funcionalidades.Responses;

import com.example.inmobiliaria.models.User;

import java.util.Objects;

public class AuthoRegisterResponse {

    private String token;
    private User user;

    public AuthoRegisterResponse() { }

    public AuthoRegisterResponse(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String toker) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "AuthoRegisterResponse{" +
                "toker='" + token + '\'' +
                ", user=" + user +
                '}';
    }
}
