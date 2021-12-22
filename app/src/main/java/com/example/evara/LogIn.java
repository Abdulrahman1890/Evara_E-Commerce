package com.example.evara;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class LogIn extends AppCompatActivity {


    private TextInputEditText password;
    private EditText email;
    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        getSupportActionBar().hide();

        email = findViewById(R.id.login_edt_email);
        password = findViewById(R.id.login_edt_password);
        login = findViewById(R.id.login_btn);


    }
}