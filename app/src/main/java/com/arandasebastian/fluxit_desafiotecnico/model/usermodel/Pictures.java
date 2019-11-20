package com.arandasebastian.fluxit_desafiotecnico.model.usermodel;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Pictures implements Serializable {
    @SerializedName("large")
    private String pictureLarge;
    @SerializedName("medium")
    private String pictureMedium;
    @SerializedName("thumbnail")
    private String thumbnail;

    public Pictures() {
    }

    public Pictures(String pictureLarge, String pictureMedium, String thumbnail) {
        this.pictureLarge = pictureLarge;
        this.pictureMedium = pictureMedium;
        this.thumbnail = thumbnail;
    }

    public String getPictureLarge() {
        return pictureLarge;
    }

}
