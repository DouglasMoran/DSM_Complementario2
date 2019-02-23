package com.example.introduccion.recyclerview.sevenwonders.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Wonders implements Parcelable {

    private int id;
    private String title;
    private String review;
    private String description;
    private String imgCard;
    private String imgDetails;
    private String message;
    private String likes;
    private String country;
    private String address;
    private String schedules;
    private String mail;
    private String phone;
    private String website;

    protected Wonders(Parcel in) {
        id = in.readInt();
        title = in.readString();
        review = in.readString();
        description = in.readString();
        imgCard = in.readString();
        imgDetails = in.readString();
        message = in.readString();
        likes = in.readString();
        country = in.readString();
        address = in.readString();
        schedules = in.readString();
        mail = in.readString();
        phone = in.readString();
        website = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Wonders> CREATOR = new Creator<Wonders>() {
        @Override
        public Wonders createFromParcel(Parcel in) {
            return new Wonders(in);
        }

        @Override
        public Wonders[] newArray(int size) {
            return new Wonders[size];
        }
    };



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgCard() {
        return imgCard;
    }

    public void setImgCard(String imgCard) {
        this.imgCard = imgCard;
    }

    public String getImgDetails() {
        return imgDetails;
    }

    public void setImgDetails(String imgDetails) {
        this.imgDetails = imgDetails;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchedules() {
        return schedules;
    }

    public void setSchedules(String schedules) {
        this.schedules = schedules;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public static Creator<Wonders> getCREATOR() {
        return CREATOR;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(review);
        dest.writeString(description);
        dest.writeString(imgCard);
        dest.writeString(imgDetails);
        dest.writeString(message);
        dest.writeString(likes);
        dest.writeString(country);
        dest.writeString(address);
        dest.writeString(schedules);
        dest.writeString(mail);
        dest.writeString(phone);
        dest.writeString(website);
    }

}
