package com.arandasebastian.fluxit_desafiotecnico.model.usermodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Location implements Serializable {
    @SerializedName("street")
    private Street street;
    @SerializedName("city")
    private String city;
    @SerializedName("state")
    private String state;
    @SerializedName("country")
    private String country;
    @SerializedName("postcode")
    private String postcode;
    @SerializedName("coordinates")
    private Coordinates coordinates;

    public Location() {
    }

    public Location(Street street, String city, String state, String country, String postcode, Coordinates coordinates) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postcode = postcode;
        this.coordinates = coordinates;
    }

    public Street getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPostcode() {
        return postcode;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
