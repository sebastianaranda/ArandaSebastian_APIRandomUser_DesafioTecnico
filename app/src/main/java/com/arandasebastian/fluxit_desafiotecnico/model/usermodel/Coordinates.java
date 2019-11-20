package com.arandasebastian.fluxit_desafiotecnico.model.usermodel;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Coordinates implements Serializable {
    @SerializedName("latitude")
    private Double latitude;
    @SerializedName("longitude")
    private Double longitude;

    public Coordinates() {
    }

    public Coordinates(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
