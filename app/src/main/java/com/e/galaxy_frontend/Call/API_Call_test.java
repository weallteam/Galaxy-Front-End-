package com.e.galaxy_frontend.Call;

import com.e.galaxy_frontend.API_Connection.API_CALL;
import com.e.galaxy_frontend.API_Interface.Login_Call;
import com.e.galaxy_frontend.Model.User;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class API_Call_test {
    private Retrofit retrofit;
    private Login_Call login_call;
    private User user;
    public API_Call_test() {
     retrofit = API_CALL.getAPI_Instance().getRetrofit();
     login_call = retrofit.create(Login_Call.class);
    }

    public String getMessage(){
        String message = "Hello World";
        Call<User> call = login_call.getData();
        try {
            Response<User> response = call.execute();
            message = response.body().getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }
}
