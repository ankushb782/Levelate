package com.example.levelate.fragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.levelate.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;

public class MacrosFragment extends Fragment implements View.OnClickListener {
    private View main;
    PieChart pieChart;
    ArrayList<Entry> entries;
    ArrayList<String> PieEntryLabels;
    PieDataSet pieDataSet;
    PieData pieData;
    private int[] colors = {Color.rgb(102, 252, 242), Color.rgb(168, 253, 248), Color.rgb(49, 62, 75)};
    private int[] pieColors = {Color.rgb(49, 62, 75), Color.rgb(49, 62, 75), Color.rgb(255, 255, 255)};
    private String[] labelsArray = {"Fat", "Calories", "Protein"};
    private AppCompatButton btnViewMeal, btnCalculate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.frag_macros, container, false);
        init();
        applyInit();
        return main;
    }

    private void applyInit() {


        Typeface typeface = ResourcesCompat.getFont(getActivity(), R.font.mulisemibold);
        entries = new ArrayList<>();
        PieEntryLabels = new ArrayList<String>();
        AddValuesToPIEENTRY();
        AddValuesToPieEntryLabels();

        pieDataSet = new PieDataSet(entries, "");

        pieData = new PieData(PieEntryLabels, pieDataSet);
        pieDataSet.setColors(colors);
        ArrayList<Integer> textclors=new ArrayList<>();
        textclors.add(pieColors[0]);
        textclors.add(pieColors[1]);
        textclors.add(pieColors[2]);
        pieDataSet.setValueTextColors(textclors);
       // pieDataSet.setValueTextColor(Color.rgb(255, 255, 255));
        pieDataSet.setValueTextSize(14f);
        pieDataSet.setSliceSpace(4f);
        pieDataSet.setValueTextSize(16f);
        pieDataSet.setValueTypeface(typeface);
        pieDataSet.setValueFormatter(new PercentFormatter());

        pieChart.setData(pieData);
        pieChart.isHighlightPerTapEnabled();


        pieChart.setDrawCenterText(true);
        pieChart.setDescription("");
        pieChart.setTransparentCircleRadius(0f);
        pieChart.setHoleRadius(1f);

        Legend l = pieChart.getLegend();
        l.setEnabled(false);

        pieChart.setTouchEnabled(true);
//        CustomMarkerView mv = new CustomMarkerView(getActivity(), R.layout.chart_tooltip);
//        pieChart.setMarkerView(mv);
    }

    private void AddValuesToPieEntryLabels() {
        PieEntryLabels.add("Fat");
        PieEntryLabels.add("Protein");
        PieEntryLabels.add("Carbs");

    }

    public void AddValuesToPIEENTRY() {
        entries.add(new BarEntry(30f, 0));
        entries.add(new BarEntry(35f, 1));
        entries.add(new BarEntry(35f, 2));

    }

    private void init() {
        pieChart = main.findViewById(R.id.piechart);
        btnViewMeal = main.findViewById(R.id.btnViewMeal);
        btnCalculate = main.findViewById(R.id.btnCalculate);

        btnViewMeal.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnViewMeal) {
            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.setCustomAnimations(android.R.anim.fade_in,
                    android.R.anim.fade_out);
            ft.replace(R.id.fragment_frame, new MealDataViewFragment(), "NewFragmentTag");
            ft.commitAllowingStateLoss();
            ft.addToBackStack(null);
        }
    }
}

