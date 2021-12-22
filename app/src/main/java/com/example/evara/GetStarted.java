package com.example.evara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GetStarted extends AppCompatActivity {

    Button getStarted;
    TextView signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        getSupportActionBar().hide();

        getStarted = findViewById(R.id.getstarted_btn);
        signIn = findViewById(R.id.getstarted_tv_signin);

        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GetStarted.this,Register.class);
                startActivity(intent);

            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GetStarted.this,LogIn.class);
                startActivity(intent);
            }
        });

    }
}