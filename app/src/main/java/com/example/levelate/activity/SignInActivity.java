package com.example.levelate.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.levelate.MainActivity;
import com.example.levelate.R;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    private String TAG = SignInActivity.class.getSimpleName();
    private TextView tvSignUp;
    private AppCompatButton btnSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mContext = SignInActivity.this;

        init();
        applyInit();
    }

    private void applyInit() {

    }

    private void init() {
        tvSignUp = findViewById(R.id.tvSignUp);
        btnSubmit = findViewById(R.id.btnSubmit);

        tvSignUp.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.tvSignUp){
            startActivity(new Intent(mContext,SignUpActivity.class));
           // finish();
        }if (v.getId()==R.id.btnSubmit){
            startActivity(new Intent(mContext, MainActivity.class));
            finish();
        }
    }
}
