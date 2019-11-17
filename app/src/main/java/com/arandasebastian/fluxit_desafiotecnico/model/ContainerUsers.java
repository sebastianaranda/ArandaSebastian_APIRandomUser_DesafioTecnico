package com.arandasebastian.fluxit_desafiotecnico.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ContainerUsers {

    @SerializedName("results")
    private List<User> userList;

    public List<User> getUserList(){
        return userList;
    }

}
