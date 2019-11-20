package com.arandasebastian.fluxit_desafiotecnico.model.usermodel;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Street implements Serializable {
    @SerializedName("name")
    private String streetName;
    @SerializedName("number")
    private Integer streetNumber;

    public Street() {
    }

    public Street(String streetName, Integer streetNumber) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }
}
