package com.example.levelate.fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.levelate.R;
import com.example.levelate.adapter.EducationSectionAdapter;
import com.example.levelate.adapter.RecentSectionItemAdapter;
import com.example.levelate.model.EducationSectionModel;
import com.example.levelate.model.EducationSingleItemModel;

import java.util.ArrayList;

public class RecentBlogFragment extends Fragment implements View.OnClickListener,RecentSectionItemAdapter.SingleClicked {
    private View main;
    ArrayList<EducationSectionModel> educationSectionModels;
    private RecyclerView my_recycler_view;

    public RecentBlogFragment() {
        // Required empty public constructor
    }

    public static EducationFragment newInstance(String param1, String param2) {
        EducationFragment fragment = new EducationFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.frag_recent_blog, container, false);
        educationSectionModels = new ArrayList<EducationSectionModel>();
        init();
        applyInit();

        return main;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void applyInit() {
        my_recycler_view.setHasFixedSize(true);
        RecentSectionItemAdapter adapter = new RecentSectionItemAdapter(getActivity(), educationSectionModels, this);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        my_recycler_view.setAdapter(adapter);
        createDummyData();
    }

    public void createDummyData() {
        for (int i = 1; i <= 1; i++) {

            EducationSectionModel dm = new EducationSectionModel();
            dm.setHeaderTitle("");
            ArrayList<EducationSingleItemModel> singleItem = new ArrayList<EducationSingleItemModel>();
            for (int j = 1; j <= 3; j++) {
                singleItem.add(new EducationSingleItemModel("Article- " + j));
            }
            dm.setAllItemsInSection(singleItem);
            educationSectionModels.add(dm);

        }
    }

    private void init() {
        my_recycler_view = (RecyclerView) main.findViewById(R.id.my_recycler_view);
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void onSingleItemClicked() {

    }
}



