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
import com.e.galaxy_frontend.Model.User;
import com.e.galaxy_frontend.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText username, firtname, lastname, password, email;
    private Button btnsignup;
    private Retrofit retrofit;
    private SignUp_Call signUp_call;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);
        username = findViewById(R.id.signup_etusername);
        password = findViewById(R.id.signup_etpassword);
        firtname = findViewById(R.id.signup_etfname);
        lastname = findViewById(R.id.signup_etlname);
        email = findViewById(R.id.signup_etemail);
        btnsignup =  findViewById(R.id.signup_btnsign);
        btnsignup.setOnClickListener(this);
        retrofit = API_CALL.getAPI_Instance().getRetrofit();
        signUp_call = retrofit.create(SignUp_Call.class);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.signup_btnsign){
            if(TextUtils.isEmpty(username.getText())){
                username.setError("Please type username");
                return;
            }
            if(TextUtils.isEmpty(password.getText())){
                password.setError("Please type username");
                return;
            }
            if(TextUtils.isEmpty(firtname.getText())){
                firtname.setError("Please type username");
                return;
            }
            if(TextUtils.isEmpty(lastname.getText())){
                lastname.setError("Please type username");
                return;
            }
            if(TextUtils.isEmpty(email.getText())){
                email.setError("Please type username");
                return;
            }

            String  user = username.getText().toString(),
                    pass = password.getText().toString(),
                    emai = email.getText().toString(),
                    fname = firtname.getText().toString(),
                    lname = lastname.getText().toString();
            Toast.makeText(this, user, Toast.LENGTH_SHORT).show();
            onSignUp(user,pass,emai,fname,lname);
        }
    }

    private void onSignUp(String user,String pass,String emai,String fname,String lname) {
        User userModel = new User();
        userModel.setUsername(user);
        userModel.setPassword(pass);
        userModel.setFirstname(fname);
        userModel.setLastname(lname);
        userModel.setEmail(emai);
        userModel.setSecurity_question("default");
        userModel.setSecurity_question("default");
        Call<Void> call = signUp_call.onSignUp(userModel);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    Toast.makeText(SignupActivity.this, "User is created", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(SignupActivity.this, "Error in input while created user", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
