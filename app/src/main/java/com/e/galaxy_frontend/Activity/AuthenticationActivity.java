package com.e.galaxy_frontend.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.e.galaxy_frontend.R;



public class AuthenticationActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnlog, btnsign;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlog = findViewById(R.id.btngotologin);
        btnsign = findViewById(R.id.btngotosignup);
        btnlog.setOnClickListener(this);
        btnsign.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btngotologin){
            startActivity( new Intent(AuthenticationActivity.this,LoginAcitivity.class));
        }else if(v.getId() == R.id.btngotosignup){
            startActivity( new Intent(AuthenticationActivity.this,SignupActivity.class));
        }
    }
}
