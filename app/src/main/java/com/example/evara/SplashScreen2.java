package com.example.evara;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class SplashScreen2 extends AppCompatActivity {
    SliderAdapter sliderAdapter;
    ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);
        viewPager2 = findViewById(R.id.sp2_viewpager);
        getSupportActionBar().hide();
        sliderAdapter = new SliderAdapter(getApplicationContext());
        viewPager2.setAdapter(sliderAdapter);
    }
}