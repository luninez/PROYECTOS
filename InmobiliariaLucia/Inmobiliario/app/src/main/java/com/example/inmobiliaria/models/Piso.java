package com.example.inmobiliaria.models;

import java.util.Objects;

public class Piso {

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

    public Piso() { }

    public Piso(String title, String description, double price, int rooms, double size, String categoryId, String address, String zipCode, String city, String province, String loc) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piso piso = (Piso) o;
        return Double.compare(piso.price, price) == 0 &&
                rooms == piso.rooms &&
                Double.compare(piso.size, size) == 0 &&
                Objects.equals(title, piso.title) &&
                Objects.equals(description, piso.description) &&
                Objects.equals(categoryId, piso.categoryId) &&
                Objects.equals(address, piso.address) &&
                Objects.equals(zipCode, piso.zipCode) &&
                Objects.equals(city, piso.city) &&
                Objects.equals(province, piso.province) &&
                Objects.equals(loc, piso.loc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, price, rooms, size, categoryId, address, zipCode, city, province, loc);
    }

    @Override
    public String toString() {
        return "Piso{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", rooms=" + rooms +
                ", size=" + size +
                ", categoryId='" + categoryId + '\'' +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
