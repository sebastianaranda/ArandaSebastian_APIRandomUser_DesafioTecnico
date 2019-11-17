package com.arandasebastian.fluxit_desafiotecnico.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UsersRetrofitDAO {

    private Retrofit retrofit;
    protected UsersService usersService;

    public UsersRetrofitDAO(String baseUrl){
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        usersService = retrofit.create(UsersService.class);
    }

}
