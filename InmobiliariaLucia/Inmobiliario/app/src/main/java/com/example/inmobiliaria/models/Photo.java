package com.example.inmobiliaria.models;

import java.util.Objects;

public class Photo {

    private String id;
    private Property propertyId;
    private String imgurlink;
    private String deletehash;

    public Photo() { }

    public Photo(String id, Property propertyId, String imgurlink, String deletehash) {
        this.id = id;
        this.propertyId = propertyId;
        this.imgurlink = imgurlink;
        this.deletehash = deletehash;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Property getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Property propertyId) {
        this.propertyId = propertyId;
    }

    public String getImgurlink() {
        return imgurlink;
    }

    public void setImgurlink(String imgurlink) {
        this.imgurlink = imgurlink;
    }

    public String getDeletehash() {
        return deletehash;
    }

    public void setDeletehash(String deletehash) {
        this.deletehash = deletehash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Photo)) return false;
        Photo photo = (Photo) o;
        return Objects.equals(id, photo.id) &&
                Objects.equals(propertyId, photo.propertyId) &&
                Objects.equals(imgurlink, photo.imgurlink) &&
                Objects.equals(deletehash, photo.deletehash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, propertyId, imgurlink, deletehash);
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id='" + id + '\'' +
                ", propertyId=" + propertyId +
                ", imgurlink='" + imgurlink + '\'' +
                ", deletehash='" + deletehash + '\'' +
                '}';
    }
}
