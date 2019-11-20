package com.arandasebastian.fluxit_desafiotecnico.model;

import android.util.Log;
import com.arandasebastian.fluxit_desafiotecnico.utils.ResultListener;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDAO extends UsersRetrofitDAO {

    public static final String BASE_URL = "https://randomuser.me/api/";

    public UserDAO() {
        super(BASE_URL);
    }

    public void getUsers(final ResultListener<List<User>> controllerListener){
        Call<ContainerUsers> call = usersService.getUsersFromAPI();
        call.enqueue(new Callback<ContainerUsers>() {
            @Override
            public void onResponse(Call<ContainerUsers> call, Response<ContainerUsers> response) {
                ContainerUsers containerUsers = response.body();
                controllerListener.finish(containerUsers.getUserList());
            }

            @Override
            public void onFailure(Call<ContainerUsers> call, Throwable t) {
                Log.d("Error","Falló el pedido.");
            }
        });
    }

}
