package com.example.evara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen1 extends AppCompatActivity {
    Handler handler = new Handler();
    ImageView evara;
    Animation animFade;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen1);

        evara = (ImageView)findViewById(R.id.sp1_evara);
        animFade = AnimationUtils.loadAnimation(this, R.anim.evara_faded);
        evara.startAnimation(animFade);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);


        getSupportActionBar().hide();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(sharedPreferences.getString("token","").equals("")){
                    Intent intent = new Intent(SplashScreen1.this, SplashScreen2.class);
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent = new Intent(getApplicationContext(),NavigateHomeScreen.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name",sharedPreferences.getString("name",""));
                    bundle.putString("email",sharedPreferences.getString("email",""));
                    bundle.putInt("id",sharedPreferences.getInt("id",0));
                    bundle.putString("token",sharedPreferences.getString("token",""));
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }

            }
        },3000);

    }
}