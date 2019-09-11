package com.e.galaxy_frontend.Activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.e.galaxy_frontend.API_Connection.API_CALL;
import com.e.galaxy_frontend.API_Interface.Login_Call;
import com.e.galaxy_frontend.Call.API_Call;
import com.e.galaxy_frontend.Model.User;
import com.e.galaxy_frontend.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AuthenticationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Toast.makeText(this, "Hell World", Toast.LENGTH_SHORT).show();
        API_Call api = new API_Call();
        Toast.makeText(this, api.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
