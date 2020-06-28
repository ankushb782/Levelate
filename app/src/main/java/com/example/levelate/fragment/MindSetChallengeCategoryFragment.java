package com.example.levelate.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.levelate.R;
import com.example.levelate.adapter.GymChallengeCategoryAdapter;
import com.example.levelate.model.GymCategoryModel;

import java.util.ArrayList;

public class MindSetChallengeCategoryFragment extends Fragment implements GymChallengeCategoryAdapter.ItemClicked, View.OnClickListener {
    private View main;
    ArrayList<GymCategoryModel> gymCategoryModelArrayList;
    private RecyclerView my_recycler_view;
    private GymChallengeCategoryAdapter gymChallengeCategoryAdapter;
    private RelativeLayout rlChallenges1,rlChallenges2,rlChallenges3,rlChallenges4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.mindset_challenge_category, container, false);
        gymCategoryModelArrayList = new ArrayList<GymCategoryModel>();

        init();
        applyInit();

        return main;
    }

    private void applyInit() {
        my_recycler_view.setHasFixedSize(true);
        gymChallengeCategoryAdapter = new GymChallengeCategoryAdapter(getActivity(), gymCategoryModelArrayList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        my_recycler_view.setLayoutManager(mLayoutManager);
        my_recycler_view.setAdapter(gymChallengeCategoryAdapter);

        createDummyData();
    }

    private void createDummyData() {
        for (int i = 1; i <= 4; i++) {
            GymCategoryModel dm = new GymCategoryModel();
            dm.headerTitle = "Challenges-" + i;
            dm.isClicked = false;
            gymCategoryModelArrayList.add(dm);
        }
    }

    private void init() {
        my_recycler_view = main.findViewById(R.id.my_recycler_view);
        rlChallenges1 = main.findViewById(R.id.rlChallenges1);
        rlChallenges2 = main.findViewById(R.id.rlChallenges2);
        rlChallenges3 = main.findViewById(R.id.rlChallenges3);
        rlChallenges4 = main.findViewById(R.id.rlChallenges4);

        rlChallenges1.setOnClickListener(this);
        rlChallenges2.setOnClickListener(this);
        rlChallenges3.setOnClickListener(this);
        rlChallenges4.setOnClickListener(this);

    }



    @Override
    public void onItemClicked(CharSequence pos) {
        Toast.makeText(getActivity(), pos, Toast.LENGTH_LONG).show();
//        final FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.setCustomAnimations(android.R.anim.fade_in,
//                android.R.anim.fade_out);
//        ft.replace(R.id.fragment_frame, new HomeBasedChallengeStartFragment(), "NewFragmentTag");
//        ft.commitAllowingStateLoss();
//        ft.addToBackStack(null);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.rlChallenges1){
            Bundle bundl = new Bundle();
            bundl.putString("category", "Task-1");

            WeeklyMidsetStartFragment dv = new WeeklyMidsetStartFragment();
            dv.setArguments(bundl);
            replaceFragment(dv);

        }if (v.getId()==R.id.rlChallenges2){
            Bundle bundl = new Bundle();
            bundl.putString("category", "Task-2");

            WeeklyMidsetStartFragment dv = new WeeklyMidsetStartFragment();
            dv.setArguments(bundl);
            replaceFragment(dv);

        }if (v.getId()==R.id.rlChallenges3){
            Bundle bundl = new Bundle();
            bundl.putString("category", "Task-3");

            WeeklyMidsetStartFragment dv = new WeeklyMidsetStartFragment();
            dv.setArguments(bundl);
            replaceFragment(dv);

        }if (v.getId()==R.id.rlChallenges4){
            Bundle bundl = new Bundle();
            bundl.putString("category", "Challenge-4");

            WeeklyMidsetStartFragment dv = new WeeklyMidsetStartFragment();
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


