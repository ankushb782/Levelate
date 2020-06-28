package com.example.levelate.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.levelate.R;

public class CheckInFragment extends Fragment implements View.OnClickListener {
    private View main;
    private AppCompatButton btnSubmit;
    public CheckInFragment() {
        // Required empty public constructor
    }

    public static CheckInFragment newInstance(String param1, String param2) {
        CheckInFragment fragment = new CheckInFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.frag_check_in, container, false);
        init();
        applyInit();

        return main;
    }

    private void applyInit() {

    }

    private void init() {
        btnSubmit = main.findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnSubmit){
            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.setCustomAnimations(android.R.anim.fade_in,
                    android.R.anim.fade_out);
            ft.replace(R.id.fragment_frame, new CheckInQuestionareFragment(), "NewFragmentTag");
            ft.commitAllowingStateLoss();
            ft.addToBackStack(null);
        }
    }

}

