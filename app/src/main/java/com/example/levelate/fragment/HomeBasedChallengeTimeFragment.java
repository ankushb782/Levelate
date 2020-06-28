package com.example.levelate.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.levelate.R;

public class HomeBasedChallengeTimeFragment extends Fragment implements View.OnClickListener {
    private View main;
    private String category;
    private TextView tvChallenge;
    private AppCompatButton btnBeatTime;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.home_based_beat_challenge, container, false);
        //here is your arguments
        Bundle bundle=getArguments();
        assert bundle != null;
        category = bundle.getString("category");

        init();
        applyInit();

        return main;
    }

    private void applyInit() {
        if (category.equalsIgnoreCase("Challenge-1")){
            tvChallenge.setText("Challenge 1");
        } if (category.equalsIgnoreCase("Challenge-2")){
            tvChallenge.setText("Challenge 2");
        } if (category.equalsIgnoreCase("Challenge-3")){
            tvChallenge.setText("Challenge 3");
        }if (category.equalsIgnoreCase("Challenge-4")){
            tvChallenge.setText("Challenge 4");
        }    }


    private void init() {
        tvChallenge = main.findViewById(R.id.tvChallenge);
        btnBeatTime = main.findViewById(R.id.btnBeatTime);
        btnBeatTime.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnBeatTime){
            Bundle bundl = new Bundle();
            bundl.putString("category", category);

            HomeBasedSubmitChallengeFragment dv = new HomeBasedSubmitChallengeFragment();
            dv.setArguments(bundl);
            replaceFragment(dv);
        }
    }
    private void replaceFragment(Fragment fragment){
        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out);
        ft.replace(R.id.fragment_frame, fragment, "NewFragmentTag");
        ft.commitAllowingStateLoss();
        ft.addToBackStack(null);
    }
}



