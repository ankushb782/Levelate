package com.example.levelate.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.levelate.R;

public class NutritionFragment extends Fragment implements View.OnClickListener {
    private View main;
    private CardView cvMacros,cvMyMeal,cvCheckIn,cvRecipe;
    public NutritionFragment() {
        // Required empty public constructor
    }

    public static NutritionFragment newInstance(String param1, String param2) {
        NutritionFragment fragment = new NutritionFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.frag_nutrition, container, false);
        init();
        applyInit();

        return main;
    }

    private void applyInit() {

    }

    private void init() {
        cvMyMeal = main.findViewById(R.id.cvMyMeal);
        cvMacros = main.findViewById(R.id.cvMacros);
        cvCheckIn = main.findViewById(R.id.cvCheckIn);
        cvRecipe = main.findViewById(R.id.cvRecipe);

        cvMyMeal.setOnClickListener(this);
        cvMacros.setOnClickListener(this);
        cvCheckIn.setOnClickListener(this);
        cvRecipe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.cvMacros){
            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.setCustomAnimations(android.R.anim.fade_in,
                    android.R.anim.fade_out);
            ft.replace(R.id.fragment_frame, new MacrosFragment(), "NewFragmentTag");
            ft.commitAllowingStateLoss();
            ft.addToBackStack(null);
        }
        if (v.getId()==R.id.cvMyMeal){
            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.setCustomAnimations(android.R.anim.fade_in,
                    android.R.anim.fade_out);
            ft.replace(R.id.fragment_frame, new MyMealPlanFragment(), "NewFragmentTag");
            ft.commitAllowingStateLoss();
            ft.addToBackStack(null);
        }if (v.getId()==R.id.cvCheckIn){
            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.setCustomAnimations(android.R.anim.fade_in,
                    android.R.anim.fade_out);
            ft.replace(R.id.fragment_frame, new CheckInFragment(), "NewFragmentTag");
            ft.commitAllowingStateLoss();
            ft.addToBackStack(null);
        }if (v.getId()==R.id.cvRecipe){
            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.setCustomAnimations(android.R.anim.fade_in,
                    android.R.anim.fade_out);
            ft.replace(R.id.fragment_frame, new RecipeFragment(), "NewFragmentTag");
            ft.commitAllowingStateLoss();
            ft.addToBackStack(null);
        }
    }

}

