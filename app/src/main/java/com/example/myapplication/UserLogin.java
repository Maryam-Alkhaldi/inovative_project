package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserLogin extends AppCompatActivity {
    Button loginButton;
    Button createAccount;
    EditText email;
    EditText password;
    TextView errorMessage;
    boolean validLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        loginButton = (Button)findViewById(R.id.buttonlogin);
        createAccount = (Button)findViewById(R.id.buttonCreate);

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CreateAccount.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                email   = (EditText)findViewById(R.id.enterEmailAddress);
                password   = (EditText)findViewById(R.id.enterPass);
                validLogin = validateLogin(email.toString(), password.toString());
                if(!validLogin){
                    errorMessage = (TextView)findViewById(R.id.error);
                    errorMessage.setText("The email or password you entered is incorrect!");
                } else{
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    //check data in database and returns true if login is found and false is not
    /*
    * checks if the email and password are in the database
    * @param mail - email entered by user
    * @param pass - password entered by user
    * @retrun true if valid and false if not
     */
    private boolean validateLogin(String mail, String pass){
        boolean valid;
        //if statment checking if email and pass are in the database
        valid = true;
        return valid;
    }
}
