package com.desafiolatam.scanfood.data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Gabriel on 16-12-2017.
 */

public class Nodes {

    private DatabaseReference root = FirebaseDatabase.getInstance().getReference();

    public DatabaseReference users(){

        return root.child("users");
    }

    public DatabaseReference user(String key){

        return users().child(key);

    }


}
