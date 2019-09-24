package com.e.galaxy_frontend.API_Interface;

import com.e.galaxy_frontend.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignUp_Call {
    @POST("/user/signup")
    Call<Void> onSignUp(@Body User user);
}
