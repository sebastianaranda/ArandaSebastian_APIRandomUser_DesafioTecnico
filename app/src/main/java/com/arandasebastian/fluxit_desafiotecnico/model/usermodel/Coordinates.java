package com.arandasebastian.fluxit_desafiotecnico.model.usermodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Coordinates implements Serializable {
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;

    public Coordinates() {
    }

    public Coordinates(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
