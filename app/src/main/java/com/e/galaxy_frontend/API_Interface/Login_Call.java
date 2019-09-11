package com.e.galaxy_frontend.API_Interface;

import com.e.galaxy_frontend.Model.User;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Login_Call {

    @GET("/test")
    Call<User> getData();
}
