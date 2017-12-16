package com.desafiolatam.scanfood.splash;

import com.desafiolatam.scanfood.data.CurrentUser;

public class LoginValidation {

    private LoginCallback callback;

    public LoginValidation(LoginCallback callback) {
        this.callback = callback;
    }

    public void login(){

        if (new CurrentUser().getCurrentUser() != null){

            callback.signed();


        }else {

            callback.signUp();


        }

    }


}
