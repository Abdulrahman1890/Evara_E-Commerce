package com.example.evara;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
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

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentPosition == dots.length - 1){
                    Intent intent = new Intent(getApplicationContext(),Register.class);
                    startActivity(intent);
                    finish();
                }
                else
                    viewPager.setCurrentItem(currentPosition + 1);
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
                finish();
            }
        });
        addThreeDots(0);
    }
    public void  addThreeDots(int position){
        dots = new TextView[3];
        dotLayout.removeAllViews();
        for (int i = 0;i < dots.length;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.LightGray));

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

            if(currentPosition == dots.length - 1){
                next.setText("finish");
            }else{
                next.setText("next");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}