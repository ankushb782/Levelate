package com.example.levelate.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.levelate.R;
import com.example.levelate.adapter.WeeklyDataAdapter;
import com.example.levelate.model.WeeklySectionModel;
import com.example.levelate.model.WeeklySingleModel;

import java.util.ArrayList;

public class GymBasedChallengeFragment extends Fragment implements WeeklyDataAdapter.SingleClicked {
    private View main;
    ArrayList<WeeklySectionModel> weeklySectionModels;
    private RecyclerView my_recycler_view;
    private boolean homeChallenge;
    private TextView tvHeading;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.gym_based_challenge, container, false);
        weeklySectionModels = new ArrayList<WeeklySectionModel>();


        init();
        applyInit();

        return main;
    }

    private void applyInit() {
        my_recycler_view.setHasFixedSize(true);
        WeeklyDataAdapter adapter = new WeeklyDataAdapter(getActivity(), weeklySectionModels, this);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        my_recycler_view.setAdapter(adapter);
        createDummyData();
    }

    private void createDummyData() {
        for (int i = 1; i <= 3; i++) {
            WeeklySectionModel dm = new WeeklySectionModel();
            String sec = "";
            if (i == 1) {
                sec = "Week-1";
            }
            if (i == 2) {
                sec = "Week-2";
            }
            if (i == 3) {
                sec = "Week-3";
            }
            dm.setHeaderTitle(sec);
            ArrayList<WeeklySingleModel> weeklySingleModels = new ArrayList<WeeklySingleModel>();
            for (int j = 1; j <= 8; j++) {
                weeklySingleModels.add(new WeeklySingleModel("D-" + j));
            }
            dm.setAllItemsInSection(weeklySingleModels);
            weeklySectionModels.add(dm);
        }
    }

    private void init() {
        my_recycler_view = main.findViewById(R.id.my_recycler_view);
        tvHeading = main.findViewById(R.id.tvHeading);
    }


    @Override
    public void onSingleItemClicked(CharSequence txt) {
        Toast.makeText(getActivity(),txt,Toast.LENGTH_LONG).show();
        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out);
        ft.replace(R.id.fragment_frame, new GymBasedChallengeCategoryFragment(), "NewFragmentTag");
        ft.commitAllowingStateLoss();
        ft.addToBackStack(null);

    }

}


