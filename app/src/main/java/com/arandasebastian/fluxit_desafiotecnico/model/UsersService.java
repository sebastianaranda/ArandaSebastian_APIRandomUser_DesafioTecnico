package com.arandasebastian.fluxit_desafiotecnico.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UsersService {

    @GET("?results=20")
    Call<ContainerUsers> getUsersPaginatedFromAPI(@Query("seed") Integer SEED_KEY,@Query("page") Integer PAGE_NUMBER);
}
