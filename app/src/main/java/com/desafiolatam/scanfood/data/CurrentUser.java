package com.desafiolatam.scanfood.data;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Gabriel on 10-12-2017.
 */ public class CurrentUser {

    private FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

    public FirebaseUser getCurrentUser() {
        return currentUser;
    }

    public String email() {

        return getCurrentUser().getEmail();

    }

    public String uid(){

        return currentUser.getUid();

    }


}
