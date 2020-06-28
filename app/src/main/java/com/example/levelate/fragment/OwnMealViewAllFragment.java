package com.example.levelate.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.levelate.R;
import com.example.levelate.adapter.ViewAllListAdapter;
import com.example.levelate.listener.ViewAllClick;
import com.example.levelate.model.ViewAllModel;

import java.util.ArrayList;

public class OwnMealViewAllFragment extends Fragment implements View.OnClickListener, ViewAllClick {
    private View main;
    private RecyclerView rvData;
    private ArrayList<ViewAllModel> viewModelArrayList = new ArrayList<>();
    private Context mContext;
    private String category;
    private TextView tvCategory;
    public OwnMealViewAllFragment() {
        // Required empty public constructor
    }

    public static OwnMealViewAllFragment newInstance(String param1, String param2) {
        OwnMealViewAllFragment fragment = new OwnMealViewAllFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.frag_own_meal_view_all, container, false);
        mContext = getActivity();
        //here is your arguments
        Bundle bundle=getArguments();
        assert bundle != null;
        category = bundle.getString("category");
        init();
        applyInit();

        return main;
    }

    private void applyInit() {
        String cat = "Category"+" "+"-"+" "+category;
        tvCategory.setText(cat);
        fetchList();

        ViewAllListAdapter viewAllListAdapter = new ViewAllListAdapter(mContext, viewModelArrayList,this);

//        AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(getActivity(), 500);
//        rvData.setLayoutManager(layoutManager);

        // Create the grid layout manager with 2 columns.
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);
//         Set layout manager.
        rvData.setLayoutManager(manager);
        rvData.setItemAnimator(new DefaultItemAnimator());
        rvData.setAdapter(viewAllListAdapter);
    }

    private void fetchList() {
        viewModelArrayList = new ArrayList<>();
        viewModelArrayList.add(new ViewAllModel(R.drawable.big_thumbnail));
        viewModelArrayList.add(new ViewAllModel(R.drawable.big_thumbnail));
        viewModelArrayList.add(new ViewAllModel(R.drawable.big_thumbnail));
        viewModelArrayList.add(new ViewAllModel(R.drawable.big_thumbnail));
        viewModelArrayList.add(new ViewAllModel(R.drawable.big_thumbnail));
        viewModelArrayList.add(new ViewAllModel(R.drawable.big_thumbnail));
        viewModelArrayList.add(new ViewAllModel(R.drawable.big_thumbnail));
        viewModelArrayList.add(new ViewAllModel(R.drawable.big_thumbnail));
        viewModelArrayList.add(new ViewAllModel(R.drawable.big_thumbnail));
    }

    private void init() {
        rvData = main.findViewById(R.id.rvData);
        tvCategory = main.findViewById(R.id.tvCategory);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onViewAllClick(int position) {
        assert getFragmentManager() != null;
        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out);
        ft.replace(R.id.fragment_frame, new MealDetailFragment(), "NewFragmentTag");
        ft.commitAllowingStateLoss();
        ft.addToBackStack(null);
    }
}

