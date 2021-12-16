package com.example.evara;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class GetStarted extends AppCompatActivity {
    ImageView slideImg;
    AnimationDrawable animationDrawable;
    Animation animFade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        slideImg = findViewById(R.id.get_started_slide_img);
        animFade = AnimationUtils.loadAnimation(this, R.anim.evara_faded);
        slideImg.startAnimation(animFade);
        animationDrawable = (AnimationDrawable) slideImg.getDrawable();
        animationDrawable.start();

    }
}