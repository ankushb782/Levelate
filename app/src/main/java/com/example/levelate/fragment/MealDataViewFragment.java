package com.example.levelate.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.levelate.R;

public class MealDataViewFragment extends Fragment {
    private View main;

    public MealDataViewFragment() {
        // Required empty public constructor
    }

    public static MindSetFragment newInstance(String param1, String param2) {
        MindSetFragment fragment = new MindSetFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.frag_view_meal_data, container, false);
        init();
        applyInit();

        return main;
    }

    private void applyInit() {

    }

    private void init() {

    }


}

