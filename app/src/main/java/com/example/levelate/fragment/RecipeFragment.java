package com.example.levelate.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.levelate.R;
import com.example.levelate.adapter.RecyclerViewDataAdapter;
import com.example.levelate.model.SectionDataModel;
import com.example.levelate.model.SingleItemModel;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;
import java.util.Objects;

public class RecipeFragment extends Fragment implements View.OnClickListener, RecyclerViewDataAdapter.SingleClicked {
    private View main;
    ArrayList<SectionDataModel> allSampleData;
    private RecyclerView my_recycler_view;
    private RelativeLayout myOwnMealPlan;
    private MaterialBetterSpinner materialBetterSpinner;
    public RecipeFragment() {
        // Required empty public constructor
    }

    public static RecipeFragment newInstance(String param1, String param2) {
        RecipeFragment fragment = new RecipeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.frag_recipe, container, false);
        allSampleData = new ArrayList<SectionDataModel>();
        init();
        applyInit();

        return main;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void applyInit() {

       // my_recycler_view.setHasFixedSize(true);
        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(getActivity(), allSampleData,this);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        my_recycler_view.setAdapter(adapter);
        createDummyData();
    }

    public void createDummyData() {
        for (int i = 0; i <= 3; i++) {
            SectionDataModel dm = new SectionDataModel();
            String sec ="";
            if (i==0){
                sec = "Breakfast";
            }if (i==1){
                sec = "Snacks";
            }if (i==2){
                sec = "Lunch";
            }
            dm.setHeaderTitle(sec);
            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
            for (int j = 0; j <= 5; j++) {
                singleItem.add(new SingleItemModel("Title here"));
            }
            dm.setAllItemsInSection(singleItem);
            allSampleData.add(dm);

        }
    }

    private void init() {
        my_recycler_view = (RecyclerView) main.findViewById(R.id.my_recycler_view);
        myOwnMealPlan = (RelativeLayout) main.findViewById(R.id.myOwnMealPlan);

        myOwnMealPlan.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.myOwnMealPlan){
            //Creating the instance of PopupMenu
            Context wrapper = new ContextThemeWrapper(getActivity(), R.style.YOURSTYLE);
            PopupMenu popup = new PopupMenu(wrapper, v);
            //Inflating the Popup using xml file
            popup.getMenuInflater().inflate(R.menu.pop_up_menu, popup.getMenu());
            popup.show();

        }
    }

    @Override
    public void onSingleItemClicked() {
        assert getFragmentManager() != null;
        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out);
        ft.replace(R.id.fragment_frame, new MealDetailFragment(), "NewFragmentTag");
        ft.commitAllowingStateLoss();
        ft.addToBackStack(null);
    }
}

