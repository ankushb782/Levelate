package com.example.levelate.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.levelate.MainActivity;
import com.example.levelate.R;
import com.example.levelate.util.PrefManager;

public class WelcomeActivity extends AppCompatActivity {
    Handler handler;
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        prefManager = new PrefManager(this);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!prefManager.isFirstTimeLaunch()) {
                    launchHomeScreen();
                    finish();
                } else {
                    launchLanguageScreen();
                    finish();
                }
            }
        }, 3000);
    }

    private void launchLanguageScreen() {
        startActivity(new Intent(WelcomeActivity.this, SignInActivity.class));
        finish();
    }

    private void launchHomeScreen() {
        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
        finish();
    }
}
