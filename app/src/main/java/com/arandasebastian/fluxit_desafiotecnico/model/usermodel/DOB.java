package com.arandasebastian.fluxit_desafiotecnico.model.usermodel;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class DOB implements Serializable {
    @SerializedName("age")
    private Integer age;

    public DOB() {
    }

    public DOB(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }
}
