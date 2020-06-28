package com.example.levelate.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.levelate.R;
import com.example.levelate.listener.MyInterface;

public class OwnMealCategoryFragment extends Fragment implements View.OnClickListener {
    private View main;
    private AppCompatButton btnBreastFastView,btnLunchView,btnDinnerView;

    public OwnMealCategoryFragment() {
        // Required empty public constructor
    }

    public static OwnMealCategoryFragment newInstance(String param1, String param2) {
        OwnMealCategoryFragment fragment = new OwnMealCategoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    MyInterface myInterface;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.frag_own_meal_with_category, container, false);
        init();
        applyInit();

        return main;
    }

    private void applyInit() {

    }


    private void init() {
        btnBreastFastView = main.findViewById(R.id.btnDinnerView);
    //    btnLunchView = main.findViewById(R.id.btnLunchView);
    //    btnDinnerView = main.findViewById(R.id.btnDinnerView);

        btnBreastFastView.setOnClickListener(this);
     //   btnLunchView.setOnClickListener(this);
     //   btnDinnerView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnDinnerView){
            Bundle bundl = new Bundle();
            bundl.putString("category", "Breakfast");

            OwnMealViewAllFragment dv = new OwnMealViewAllFragment();
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

