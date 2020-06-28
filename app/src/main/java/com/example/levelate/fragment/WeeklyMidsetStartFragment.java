package com.example.levelate.fragment;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.levelate.R;
import com.example.levelate.model.WeeklySectionModel;
import com.example.levelate.util.DonutProgress;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class WeeklyMidsetStartFragment extends Fragment {
    private View main;
    ArrayList<WeeklySectionModel> weeklySectionModels;
    private RecyclerView my_recycler_view;
    private TextView tvHeading;
    private CountDownTimer countDownTimer;
    private final long startTime = 10 * 1000;
    private final long interval = 1 * 1000;
    private AppCompatButton btnSubmit;
    private ProgressBar progressBarCircle;
    private long timeCountInMilliSeconds = 1 * 60000;
    private RelativeLayout rlProgress;
    private TextView textViewTime;
    private enum TimerStatus {
        STARTED,
        STOPPED
    }

    private TimerStatus timerStatus = TimerStatus.STOPPED;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.frag_week_mindset_start, container, false);
        init();
        applyInit();

        return main;
    }

    private void applyInit() {

    }

    /**
     * method to initialize the values for count down timer
     */
    private void setTimerValues() {
        int time = 1;
        // assigning values after converting to milliseconds
        timeCountInMilliSeconds = time * 60 * 1000;
    }

    private void setProgressBarValues() {
        progressBarCircle.setMax((int) timeCountInMilliSeconds / 1000);
        progressBarCircle.setProgress((int) timeCountInMilliSeconds / 1000);
    }

    private void startCountDownTimer() {

        countDownTimer = new CountDownTimer(timeCountInMilliSeconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textViewTime.setText(hmsTimeFormatter(millisUntilFinished));
                progressBarCircle.setProgress((int) (millisUntilFinished / 1000));

            }

            @Override
            public void onFinish() {
                textViewTime.setText(hmsTimeFormatter(timeCountInMilliSeconds));
                setProgressBarValues();
                btnSubmit.setVisibility(View.VISIBLE);
                rlProgress.setVisibility(View.GONE);
                timerStatus = TimerStatus.STOPPED;
                replaceFragment();
            }

        }.start();
        countDownTimer.start();
    }
    private String hmsTimeFormatter(long milliSeconds) {

        String hms = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(milliSeconds),
                TimeUnit.MILLISECONDS.toMinutes(milliSeconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliSeconds)),
                TimeUnit.MILLISECONDS.toSeconds(milliSeconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliSeconds)));

        return hms;


    }
    private void init() {
        tvHeading = main.findViewById(R.id.tvHeading);
        btnSubmit = main.findViewById(R.id.btnSubmit);
        textViewTime = main.findViewById(R.id.textViewTime);
        rlProgress = main.findViewById(R.id.rlProgress);

        progressBarCircle = (ProgressBar) main.findViewById(R.id.progressBarCircle);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTimerValues();
                setProgressBarValues();
                btnSubmit.setVisibility(View.GONE);
                rlProgress.setVisibility(View.VISIBLE);
                timerStatus = TimerStatus.STARTED;
                startCountDownTimer();
            }
        });

    }
    private void replaceFragment(){
        assert getFragmentManager() != null;
        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out);
        ft.replace(R.id.fragment_frame, new MindSetChallengeTimeFragment(), "NewFragmentTag");
        ft.commitAllowingStateLoss();
        ft.addToBackStack(null);
    }


}

