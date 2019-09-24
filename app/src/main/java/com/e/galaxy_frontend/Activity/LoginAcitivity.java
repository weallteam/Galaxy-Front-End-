package com.e.galaxy_frontend.Activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.e.galaxy_frontend.API_Connection.API_CALL;
import com.e.galaxy_frontend.API_Interface.Login_Call;
import com.e.galaxy_frontend.API_Interface.SignUp_Call;
import com.e.galaxy_frontend.Model.LoginResponse;
import com.e.galaxy_frontend.Model.User;
import com.e.galaxy_frontend.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginAcitivity extends AppCompatActivity implements View.OnClickListener {
    private EditText username, password;
    private Button btnlogin;
    private Retrofit retrofit;
    private Login_Call login_call;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        username =  findViewById(R.id.login_etUsername);
        password = findViewById(R.id.login_etPassword);
        btnlogin = findViewById(R.id.login_btnlogin);
        btnlogin.setOnClickListener(this);
        retrofit = API_CALL.getAPI_Instance().getRetrofit();
        login_call = retrofit.create(Login_Call.class);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.login_btnlogin){
            if(TextUtils.isEmpty(username.getText())){
                username.setError("Please type username");
                return;
            }
            if(TextUtils.isEmpty(password.getText())){
                password.setError("Please type username");
                return;
            }
            String user =  username.getText().toString();
            String pass = password.getText().toString();
            User userModel  = new User();
            userModel.setUsername(user);
            userModel.setPassword(pass);
            onLogin(userModel);
        }
    }

    private void onLogin(User user) {
        Call<LoginResponse> call = login_call.onLogin(user);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(LoginAcitivity.this, "Successfully logged In", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginAcitivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
}
