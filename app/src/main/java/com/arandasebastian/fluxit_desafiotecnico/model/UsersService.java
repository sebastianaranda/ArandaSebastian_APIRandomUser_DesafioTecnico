package com.arandasebastian.fluxit_desafiotecnico.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsersService {
    @GET("?results=20")
    Call<ContainerUsers> getUsersFromAPI();
}
