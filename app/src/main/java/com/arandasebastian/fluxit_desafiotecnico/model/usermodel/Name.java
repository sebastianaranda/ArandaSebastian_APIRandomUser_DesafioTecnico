package com.arandasebastian.fluxit_desafiotecnico.model.usermodel;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Name implements Serializable {
    @SerializedName("title")
    private String titleName;
    @SerializedName("first")
    private String firstName;
    @SerializedName("last")
    private String lastName;

    public Name() {
    }

    public Name(String titleName, String firstName, String lastName) {
        this.titleName = titleName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
