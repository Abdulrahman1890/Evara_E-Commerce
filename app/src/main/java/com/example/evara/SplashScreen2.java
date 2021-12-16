package com.example.evara;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SplashScreen2 extends AppCompatActivity {
    SliderAdapter sliderAdapter;
    ViewPager viewPager;
    TextView[] dots;
    LinearLayout dotLayout;
    Button next , skip;
    int currentPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);
        getSupportActionBar().hide();

        viewPager = findViewById(R.id.sp2_viewpager);
        dotLayout = findViewById(R.id.sp2_dot_layout);
        next = findViewById(R.id.sp2_next);
        skip = findViewById(R.id.sp2_skip);

        sliderAdapter = new SliderAdapter(getApplicationContext());
        viewPager.setAdapter(sliderAdapter);
        viewPager.addOnPageChangeListener(viewListener);
        addThreeDots(0);
    }
    public void  addThreeDots(int position){
        dots = new TextView[3];
        dotLayout.removeAllViews();
        for (int i = 0;i < dots.length;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(android.R.color.darker_gray));

            dotLayout.addView(dots[i]);
        }
        if(dots.length > 0)
            dots[position].setTextColor(getResources().getColor(R.color.white));
    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addThreeDots(position);
            currentPosition = position;

            if(currentPosition == dots.length){
                next.setText("FINISH");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}