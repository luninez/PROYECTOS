package com.example.inmobiliaria.Retrofit.Responses;

import com.example.inmobiliaria.models.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class AuthoRegisterResponse {

    @SerializedName("token")
    @Expose
    private String token;

    @SerializedName("user")
    @Expose
    private User user;

    public AuthoRegisterResponse() { }

    /**
     * @param token
     * @param user
     */
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthoRegisterResponse)) return false;
        AuthoRegisterResponse that = (AuthoRegisterResponse) o;
        return Objects.equals(token, that.token) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, user);
    }

    @Override
    public String toString() {
        return "AuthoRegisterResponse{" +
                "toker='" + token + '\'' +
                ", user=" + user +
                '}';
    }
}
