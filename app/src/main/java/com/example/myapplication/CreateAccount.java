package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CreateAccount extends AppCompatActivity {
    Button createAccountButton;
    EditText email;
    EditText password;
    EditText userName;
    EditText firstName;
    EditText lastName;
    EditText dateOfBirth;
    TextView errorMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        createAccountButton = (Button)findViewById(R.id.createButton);


        createAccountButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                email   = (EditText)findViewById(R.id.emailAddressInput);
                password   = (EditText)findViewById(R.id.passwordInput);
                userName = (EditText)findViewById(R.id.username);
                firstName = (EditText)findViewById(R.id.firstname);
                lastName = (EditText)findViewById(R.id.lastname);
                dateOfBirth = (EditText)findViewById(R.id.dateInout);
                errorMessage = (TextView)findViewById(R.id.errorCreate);
                if(!validEmail(email.toString())){
                    errorMessage.setText("This email is already used!");
                }
                else if (!validUserName(userName.toString())){
                    errorMessage.setText("This username is taken!");
                }
                else if(!validPass(password.toString())){
                    errorMessage.setText("Your password needs to be at least 8 characters and " +
                            "include an uppercase, lowercase, and a numeric character!");
                }
                else {
                    userAccount user = new userAccount(email.toString(), password.toString(), userName.toString()
                    ,firstName.toString(),lastName.toString(),dateOfBirth.toString());
                    Intent intent = new Intent(getApplicationContext(),UserLogin.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validEmail(String email){
        boolean valid;
        //check if the email is in the database and return true if it isn't.
        valid = true;
        return valid;
    }

    private boolean validUserName(String name){
        boolean valid;
        //check if the name is in the database and return true if it isn't.
        valid = true;
        return valid;
    }

    private boolean validPass(String pass){
        boolean valid;
        int n = pass.length();
        boolean hasLower = false, hasUpper = false,
                hasDigit = false, specialChar = false;
        Set<Character> set = new HashSet<Character>(
                Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'));
        for (char i : pass.toCharArray()) {
            if (Character.isLowerCase(i)){
                hasLower = true;
            } if (Character.isUpperCase(i)){
                hasUpper = true;
            } if (Character.isDigit(i)) {
            hasDigit = true;
            } if (set.contains(i)){
                specialChar = true;
            }
        }
        // Strength of password
        if (hasDigit && hasLower && hasUpper && specialChar && (n >= 8)) { //8 or more
            valid = true;
        } else if ((hasLower || hasUpper || specialChar) && (n >= 6)) { //6 or more
            valid = true;
        } else {
            valid = false;
        }
        return valid;
    }
}