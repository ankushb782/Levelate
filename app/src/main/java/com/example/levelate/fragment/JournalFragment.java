package com.example.levelate.fragment;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.levelate.R;
import com.squareup.timessquare.CalendarPickerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JournalFragment extends Fragment {
    private static final String TAG = JournalFragment.class.getSimpleName();
    private View main;

    public JournalFragment() {
        // Required empty public constructor
    }

    public static JournalFragment newInstance(String param1, String param2) {
        JournalFragment fragment = new JournalFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.frag_jounal, container, false);
        applyInit();

        return main;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void applyInit() {
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);

        CalendarPickerView calendar = (CalendarPickerView) main.findViewById(R.id.calendar_view);
        Date today = new Date();
        calendar.init(today, nextYear.getTime())
                .withSelectedDate(today);
        calendar.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                Log.e(TAG, "Date Selected:" + date);
                SimpleDateFormat formatter = new SimpleDateFormat("dd");
                String dateString = formatter.format(date);
                Log.e(TAG, "Date Selected:" + dateString);

                moveToNext(dateString);

            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });
    }

    private void moveToNext(String dateString) {
        Bundle bundl = new Bundle();
        bundl.putString("day", dateString);
        JournalQuestionFragment journalQuestionFragment = new JournalQuestionFragment();
        journalQuestionFragment.setArguments(bundl);

        assert getFragmentManager() != null;
        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out);
        ft.replace(R.id.fragment_frame, journalQuestionFragment, "NewFragmentTag");
        ft.commitAllowingStateLoss();
        ft.addToBackStack(null);
    }


}




