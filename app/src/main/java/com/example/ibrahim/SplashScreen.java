package com.example.ibrahim;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    ImageView logo;
    int SPLASH_TIME_OUT = 3000; // 3 seconds
    TextView tv_appName, tvVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Hide the status bar.
        View doctorView = getWindow().getDecorView();
        doctorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        // Delay the splash screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the main screen
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, SPLASH_TIME_OUT);

        logo = findViewById(R.id.logo);
        tv_appName = findViewById(R.id.tv_appName);
        tvVersion = findViewById(R.id.tv_version);

        // Start Animation
        Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        logo.startAnimation(myAnim);
        tv_appName.startAnimation(myAnim);
        tvVersion.startAnimation(myAnim);

    }
}