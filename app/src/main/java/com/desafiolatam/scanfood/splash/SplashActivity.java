package com.desafiolatam.scanfood.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.desafiolatam.scanfood.MainActivity;
import com.desafiolatam.scanfood.R;
import com.desafiolatam.scanfood.login.LoginActivity;

public class SplashActivity extends AppCompatActivity implements LoginCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        View view = findViewById(R.id.root);
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        new LoginValidation(this).login();

    }


    @Override
    public void signed() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();


    }

    @Override
    public void signUp() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }
        },1200);



    }
}
