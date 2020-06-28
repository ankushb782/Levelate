package com.example.levelate.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.levelate.R;

public class ChallengesFragment extends Fragment implements View.OnClickListener {
    private View main;
    private LinearLayout llGymBased, llHomeBased;

    public ChallengesFragment() {
        // Required empty public constructor
    }

    public static ChallengesFragment newInstance(String param1, String param2) {
        ChallengesFragment fragment = new ChallengesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.frag_challenges, container, false);
        init();
        applyInit();

        return main;
    }

    private void applyInit() {

    }

    private void init() {
        llGymBased = main.findViewById(R.id.llGymBased);
        llHomeBased = main.findViewById(R.id.llHomeBased);
        llGymBased.setOnClickListener(this);
        llHomeBased.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.llGymBased) {
            assert getFragmentManager() != null;
            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.setCustomAnimations(android.R.anim.fade_in,
                    android.R.anim.fade_out);
            ft.replace(R.id.fragment_frame, new GymBasedChallengeCategoryFragment(), "NewFragmentTag");
            ft.commitAllowingStateLoss();
            ft.addToBackStack(null);
        }
        if (v.getId() == R.id.llHomeBased) {
            Bundle bundl = new Bundle();
            bundl.putBoolean("homeChallenge", true);

            HomeBasedChallengeCategoryFragment dv = new HomeBasedChallengeCategoryFragment();
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

