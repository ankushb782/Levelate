package com.example.levelate.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.levelate.R;

public class JournalQuestionSecondFragment extends Fragment implements View.OnClickListener {
    private View main;
    private AppCompatButton btnNext;
    private String day;
    private TextView tvDay;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.frag_journal_question_second,container,false);
        if (getArguments()!=null){
            Bundle bundle=getArguments();
            assert bundle != null;
            day = bundle.getString("day");

        }
        init();
        applyInit();

        return main;
    }

    private void applyInit() {
        tvDay.setText("Day"+" "+day+" / 30");
    }

    private void init() {
        btnNext = main.findViewById(R.id.btnNext);
        tvDay = main.findViewById(R.id.tvDay);

        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnNext){
            assert getFragmentManager() != null;
            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.setCustomAnimations(android.R.anim.fade_in,
                    android.R.anim.fade_out);
            ft.replace(R.id.fragment_frame, new JournalQuestionViewFragment(), "NewFragmentTag");
            ft.commitAllowingStateLoss();
            ft.addToBackStack(null);
        }
    }
}
