package com.example.evara;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    private EditText userName,email,password,confirmPassword;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();

        userName = findViewById(R.id.register_edt_username);
        email = findViewById(R.id.register_edt_email);
        password = findViewById(R.id.register_edt_password);
        confirmPassword = findViewById(R.id.register_edt_confirmpassword);
        register = findViewById(R.id.regist_btn);




    }
}