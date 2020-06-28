package com.example.levelate.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.levelate.R;
import com.example.levelate.adapter.LeaderboardAdapter;
import com.example.levelate.model.LeaderboardModel;

import java.util.ArrayList;

public class LeaderboardFragment extends Fragment {
    private View main;
    private LeaderboardAdapter leaderboardAdapter;
    private RecyclerView my_recycler_view;
    ArrayList<LeaderboardModel> leaderboardModels;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.frag_leaderboard, container, false);
        leaderboardModels = new ArrayList<>();
        init();
        applyInit();
        return main;
    }

    private void applyInit() {
        createDummyData();
    }

    private void init() {
        my_recycler_view = main.findViewById(R.id.my_recycler_view);
        my_recycler_view.setHasFixedSize(true);

    }

    private void createDummyData() {
        leaderboardModels.clear();
        for (int i = 1; i <= 4; i++) {
            LeaderboardModel dm = new LeaderboardModel();
            dm.imageResource = R.drawable.face2;
            dm.name = "Abc";
            dm.point = 200;
            dm.rankImage = R.drawable.medal1;
            leaderboardModels.add(dm);
        }

        leaderboardAdapter = new LeaderboardAdapter(getActivity(), leaderboardModels);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));
        my_recycler_view.setAdapter(leaderboardAdapter);

    }

}
