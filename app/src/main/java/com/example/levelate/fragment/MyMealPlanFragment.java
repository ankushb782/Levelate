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

public class MyMealPlanFragment extends Fragment implements View.OnClickListener {
    private View main;
    private LinearLayout myOwnMealPlan, llCreateForMe;

    public MyMealPlanFragment() {
        // Required empty public constructor
    }

    public static MyMealPlanFragment newInstance(String param1, String param2) {
        MyMealPlanFragment fragment = new MyMealPlanFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.frag_my_meal_plan, container, false);
        init();
        applyInit();

        return main;
    }

    private void applyInit() {

    }

    private void init() {
        myOwnMealPlan = main.findViewById(R.id.myOwnMealPlan);
        llCreateForMe = main.findViewById(R.id.llCreateForMe);
        myOwnMealPlan.setOnClickListener(this);
        llCreateForMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.myOwnMealPlan) {
            assert getFragmentManager() != null;
            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.setCustomAnimations(android.R.anim.fade_in,
                    android.R.anim.fade_out);
            ft.replace(R.id.fragment_frame, new OwnMealPlanFragment(), "NewFragmentTag");
            ft.commitAllowingStateLoss();
            ft.addToBackStack(null);
        }
        if (v.getId() == R.id.llCreateForMe) {
            assert getFragmentManager() != null;
            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.setCustomAnimations(android.R.anim.fade_in,
                    android.R.anim.fade_out);
            ft.replace(R.id.fragment_frame, new CreateForMeFragment(), "NewFragmentTag");
            ft.commitAllowingStateLoss();
            ft.addToBackStack(null);
//            startActivity(new Intent(getActivity(), CreateForMeActivity.class));
        }
    }
}

