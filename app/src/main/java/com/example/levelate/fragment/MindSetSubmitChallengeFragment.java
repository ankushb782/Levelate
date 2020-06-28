package com.example.levelate.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.levelate.R;

public class MindSetSubmitChallengeFragment extends Fragment implements View.OnClickListener {
    private View main;
    private String category="Challenge-1";
    private AppCompatButton btnSubmitTime;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.mindset_submit_challenge,container,false);
        //here is your arguments
        Bundle bundle=getArguments();
        assert bundle != null;
    //    category = bundle.getString("category");

        init();
        applyInit();
        return main;
    }

    private void applyInit() {

    }

    private void init() {
        btnSubmitTime = main.findViewById(R.id.btnSubmitTime);
        btnSubmitTime.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnSubmitTime){
            LeaderboardFragment dv = new LeaderboardFragment();
            replaceFragment(dv);
        }
    }

    private void replaceFragment(LeaderboardFragment fragment) {
        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out);
        ft.replace(R.id.fragment_frame, fragment, "NewFragmentTag");
        ft.commitAllowingStateLoss();
        ft.addToBackStack(null);
    }

}
