package com.arandasebastian.fluxit_desafiotecnico.model;

import com.arandasebastian.fluxit_desafiotecnico.model.usermodel.DOB;
import com.arandasebastian.fluxit_desafiotecnico.model.usermodel.Location;
import com.arandasebastian.fluxit_desafiotecnico.model.usermodel.Name;
import com.arandasebastian.fluxit_desafiotecnico.model.usermodel.Pictures;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class User implements Serializable {
    @SerializedName("name")
    private Name name;
    @SerializedName("picture")
    private Pictures pictures;
    @SerializedName("gender")
    private String gender;
    @SerializedName("email")
    private String email;
    @SerializedName("phone")
    private String phone;
    @SerializedName("cell")
    private String cell;
    @SerializedName("dob")
    private DOB dob;
    @SerializedName("location")
    private Location location;

    public User() {
    }

    public User(Name name, Pictures pictures, String gender, String email, String phone, String cell, DOB dob, Location location) {
        this.name = name;
        this.pictures = pictures;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.cell = cell;
        this.dob = dob;
        this.location = location;
    }

    public Name getName() {
        return name;
    }

    public Pictures getPictures() {
        return pictures;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCell() {
        return cell;
    }

    public DOB getDob() {
        return dob;
    }

    public Location getLocation() {
        return location;
    }
}
