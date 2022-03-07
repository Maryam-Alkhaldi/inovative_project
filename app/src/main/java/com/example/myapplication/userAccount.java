package com.example.myapplication;

import android.widget.EditText;

public class userAccount {
    String email;
    String password;
    String userName;
    String firstName;
    String lastName;
    String dateOfBirth;

    public userAccount(String email, String password, String userName, String firstName, String lastName, String dateOfBirth){
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        addToDatabase();
    }

    private void addToDatabase(){
        //code to add the user information to the database.
    }
}
