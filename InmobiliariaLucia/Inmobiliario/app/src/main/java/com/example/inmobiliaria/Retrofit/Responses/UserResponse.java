package com.example.inmobiliaria.Retrofit.Responses;

import com.example.inmobiliaria.models.Property;

import java.util.List;

public class UserResponse {

    private String id;
    private String email;
    private String password;
    private String name;
    private String role;
    private String picture;
    private List<Property> pisosFavoritos;
    private List<Property> pisosAnuncios;

    public UserResponse() { }

    public UserResponse(String id, String email, String password, String name, String role, String picture, List<Property> pisosFavoritos, List<Property> pisosAnuncios) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
        this.picture = picture;
        this.pisosFavoritos = pisosFavoritos;
        this.pisosAnuncios = pisosAnuncios;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<Property> getPisosFavoritos() {
        return pisosFavoritos;
    }

    public void setPisosFavoritos(List<Property> pisosFavoritos) {
        this.pisosFavoritos = pisosFavoritos;
    }

    public List<Property> getPisosAnuncios() {
        return pisosAnuncios;
    }

    public void setPisosAnuncios(List<Property> pisosAnuncios) {
        this.pisosAnuncios = pisosAnuncios;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", picture='" + picture + '\'' +
                ", pisosFavoritos=" + pisosFavoritos +
                ", pisosAnuncios=" + pisosAnuncios +
                '}';
    }
}
