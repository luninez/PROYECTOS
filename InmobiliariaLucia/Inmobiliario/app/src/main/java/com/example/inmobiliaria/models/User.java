package com.example.inmobiliaria.models;

import java.util.ArrayList;
import java.util.Objects;

public class User {

    private String id;
    private String email;
    private String password;
    private String name;
    private String role;
    private String picture;
    private ArrayList<Property> array_favs;

    public User() { }

    public User(String id, String email, String password, String name, String role, String picture, ArrayList<Property> array_favs) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
        this.picture = picture;
        this.array_favs = array_favs;
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

    public ArrayList<Property> getArray_favs() {
        return array_favs;
    }

    public void setArray_favs(ArrayList<Property> array_favs) {
        this.array_favs = array_favs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                Objects.equals(role, user.role) &&
                Objects.equals(picture, user.picture) &&
                Objects.equals(array_favs, user.array_favs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, name, role, picture, array_favs);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", picture='" + picture + '\'' +
                ", pisos_favs='" + array_favs + '\'' +
                '}';
    }
}
