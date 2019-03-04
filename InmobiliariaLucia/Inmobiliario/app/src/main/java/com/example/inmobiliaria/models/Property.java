package com.example.inmobiliaria.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Property {

    private User userId;
    private String title;
    private String description;
    private double price;
    private int rooms;
    private double size;
    private String categoryId;
    private String address;
    private String zipCode;
    private String city;
    private String province;
    private String loc;

    private List<String> favs = new ArrayList<>();
    private List<String> photos = new ArrayList<>();

    public Property() { }

    public Property(String title, String description, double price, int rooms, double size, String categoryId, String address, String zipCode, String city, String province, String loc) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.rooms = rooms;
        this.size = size;
        this.categoryId = categoryId;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.province = province;
        this.loc = loc;
        this.favs = favs;
        this.photos = photos;
    }

    public Property(User userId, String title, String description, double price, int rooms, double size, String categoryId, String address, String zipCode, String city, String province, String loc, List<String> favs, List<String> photos) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.rooms = rooms;
        this.size = size;
        this.categoryId = categoryId;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.province = province;
        this.loc = loc;
        this.favs = favs;
        this.photos = photos;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public List<String> getFavs() {
        return favs;
    }

    public void setFavs(List<String> favs) {
        this.favs = favs;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Property)) return false;
        Property property = (Property) o;
        return Double.compare(property.price, price) == 0 &&
                rooms == property.rooms &&
                Double.compare(property.size, size) == 0 &&
                Objects.equals(userId, property.userId) &&
                Objects.equals(title, property.title) &&
                Objects.equals(description, property.description) &&
                Objects.equals(categoryId, property.categoryId) &&
                Objects.equals(address, property.address) &&
                Objects.equals(zipCode, property.zipCode) &&
                Objects.equals(city, property.city) &&
                Objects.equals(province, property.province) &&
                Objects.equals(loc, property.loc) &&
                Objects.equals(favs, property.favs) &&
                Objects.equals(photos, property.photos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, title, description, price, rooms, size, categoryId, address, zipCode, city, province, loc, favs, photos);
    }

    @Override
    public String toString() {
        return "Property{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", rooms=" + rooms +
                ", size=" + size +
                ", categoryId=" + categoryId +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", loc='" + loc + '\'' +
                ", favs=" + favs +
                ", photos=" + photos +
                '}';
    }
}
