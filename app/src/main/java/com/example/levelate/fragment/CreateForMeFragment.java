package com.example.levelate.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.levelate.R;

public class CreateForMeFragment extends Fragment implements View.OnClickListener {
    private View main;
    private RelativeLayout rlBuyNow,rlBuyNow1;
    public CreateForMeFragment() {
        // Required empty public constructor
    }

    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.frag_create_meal_for_me, container, false);
        init();
        applyInit();

        return main;
    }

    private void applyInit() {

    }

    private void init() {
        rlBuyNow = main.findViewById(R.id.rlBuyNow);
       // rlBuyNow1 = main.findViewById(R.id.rlBuyNow1);

//        rlBuyNow1.setOnClickListener(this);
        rlBuyNow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.rlBuyNow){
            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.setCustomAnimations(android.R.anim.fade_in,
                    android.R.anim.fade_out);
            ft.replace(R.id.fragment_frame, new CreateForMeQuestionnaireMainFragment(), "NewFragmentTag");
            ft.commitAllowingStateLoss();
            ft.addToBackStack(null);
        }/*if (v.getId()==R.id.rlBuyNow1){
            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.setCustomAnimations(android.R.anim.fade_in,
                    android.R.anim.fade_out);
            ft.replace(R.id.fragment_frame, new CreateForMeQuestionnaireMainFragment(), "NewFragmentTag");
            ft.commitAllowingStateLoss();
            ft.addToBackStack(null);
        }*/
    }
}


