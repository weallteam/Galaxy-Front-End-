package com.e.galaxy_frontend.API_Interface;

import com.e.galaxy_frontend.Model.LoginResponse;
import com.e.galaxy_frontend.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Login_Call {

    @POST("/user/login")
    Call<LoginResponse> onLogin(@Body User user);
}
