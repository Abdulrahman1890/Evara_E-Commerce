package com.example.evara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen1 extends AppCompatActivity {
    Handler handler = new Handler();
    ImageView evara;
    Animation animFade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen1);

        evara = (ImageView)findViewById(R.id.sp1_evara);
        animFade = AnimationUtils.loadAnimation(this, R.anim.evara_faded);
        evara.startAnimation(animFade);

        getSupportActionBar().hide();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen1.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

    }
}