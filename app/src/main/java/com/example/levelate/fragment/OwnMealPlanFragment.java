package com.example.levelate.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.levelate.R;

public class OwnMealPlanFragment extends Fragment implements View.OnClickListener {
    private View main;
    private ImageView ivAddMeal, ivAddDessert;
    private boolean isAdded;
    private RelativeLayout rlMealContent,rlDesertContent;
    private AppCompatButton btnSubmit;
    public OwnMealPlanFragment() {
        // Required empty public constructor
    }

    public static OwnMealPlanFragment newInstance(String param1, String param2) {
        OwnMealPlanFragment fragment = new OwnMealPlanFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.frag_own_meal_plan, container, false);
        if (getArguments()!=null){
            Bundle bundle=getArguments();
            assert bundle != null;
            isAdded = bundle.getBoolean("isAdded");

        }
        init();
        applyInit();

        return main;
    }

    private void applyInit() {
        if (isAdded){
            rlMealContent.setVisibility(View.VISIBLE);
            rlDesertContent.setVisibility(View.VISIBLE);
            btnSubmit.setText("Update");
        }
    }

    private void init() {
        ivAddMeal = main.findViewById(R.id.ivAddMeal);
        ivAddDessert = main.findViewById(R.id.ivAddDessert);
        rlMealContent = main.findViewById(R.id.rlMealContent);
        btnSubmit = main.findViewById(R.id.btnSubmit);
        rlDesertContent = main.findViewById(R.id.rlDesertContent);

        ivAddMeal.setOnClickListener(this);
        ivAddDessert.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ivAddMeal) {
            assert getFragmentManager() != null;
            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.setCustomAnimations(android.R.anim.fade_in,
                    android.R.anim.fade_out);
            ft.replace(R.id.fragment_frame, new OwnMealCategoryFragment(), "NewFragmentTag");
            ft.commitAllowingStateLoss();
            ft.addToBackStack(null);
        }
        if (v.getId() == R.id.ivAddDessert) {
            assert getFragmentManager() != null;
            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.setCustomAnimations(android.R.anim.fade_in,
                    android.R.anim.fade_out);
            ft.replace(R.id.fragment_frame, new OwnMealCategoryFragment(), "NewFragmentTag");
            ft.commitAllowingStateLoss();
            ft.addToBackStack(null);
        }
    }
}

