package com.desafiolatam.scanfood.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.desafiolatam.scanfood.R;

/**
 * Created by Gabriel on 16-12-2017.
 */

public class LoginActivity extends AppCompatActivity implements SessionCallback {

    private TextInputLayout mailWrapper, passWrapper;
    private EditText mailEt, passEt;
    private Button button;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mailWrapper = findViewById(R.id.emailTil);
        passWrapper = findViewById(R.id.passwordTil);
        mailEt = findViewById(R.id.emailEt);
        passEt = findViewById(R.id.passwordEt);
        button = findViewById(R.id.signBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mailEt.getText().toString();
                String pass = passEt.getText().toString();
                mailWrapper.setVisibility(View.GONE);
                passWrapper.setVisibility(View.GONE);
                button.setVisibility(View.GONE);


            }
        });
    }

    @Override
    public void requiredField() {

    }

    @Override
    public void mailFormat() {

    }

    @Override
    public void success() {

    }

    @Override
    public void failure() {

    }
}
