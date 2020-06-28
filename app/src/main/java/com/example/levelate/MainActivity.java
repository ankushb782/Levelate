package com.example.levelate;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.levelate.fragment.DashboardFragment;
import com.example.levelate.fragment.MindSetFragment;
import com.example.levelate.fragment.NutritionFragment;
import com.example.levelate.fragment.TrainingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private TextView textCartItemCount;
    int mCartItemCount = 10;
    // index to identify current nav menu item
    public static int navItemIndex = 0;

    // flag to load home fragment when user presses back key
    private boolean shouldLoadHomeFragOnBackPress = true;
    private Handler mHandler;

    // tags used to attach the fragments
    private static final String TAG_NUTRITION = "NUTRITION";
    private static final String TAG_MINDSET = "MINDSET";
    private static final String TAG_TRAINING = "TRAINING";
    private static final String TAG_DASHBOARD = "dashboard";
    public static String CURRENT_TAG = TAG_NUTRITION;
    private FrameLayout fragment_frame;
    // toolbar titles respected to selected nav menu item
    private Context mContext;
    private BottomNavigationView bottom_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        initView(savedInstanceState);

    }

    private void initView(Bundle savedInstanceState) {
        mHandler = new Handler();

        fragment_frame = findViewById(R.id.fragment_frame);

        bottom_navigation = findViewById(R.id.bottom_navigation);
        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        // Navigation view header

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_DASHBOARD;
            loadDashboardFragment();
        }

    }

    private void loadDashboardFragment() {
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = new DashboardFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.fragment_frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }

        // refresh toolbar menu
        invalidateOptionsMenu();
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.fragment_frame, fragment, CURRENT_TAG);
        fragmentTransaction.commitAllowingStateLoss();
        fragmentTransaction.addToBackStack(null);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
           Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.action_nutrition:
                    navItemIndex=1;
                    CURRENT_TAG = TAG_NUTRITION;
                    fragment = new NutritionFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.action_mindset:
                    navItemIndex=2;
                    CURRENT_TAG = TAG_MINDSET;
                    fragment = new MindSetFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.action_training:
                    navItemIndex=3;
                    CURRENT_TAG = TAG_TRAINING;
                    fragment = new TrainingFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };



    @Override
    public void onBackPressed() {
        // This code loads home fragment when back key is pressed
        // when user is in other fragment than home
        if (shouldLoadHomeFragOnBackPress) {
//            // checking if user is on other navigation menu
//            // rather than home
//            if (navItemIndex != 0) {
//                navItemIndex = 0;
//                CURRENT_TAG = TAG_DASHBOARD;
//                loadDashboardFragment();
//
//                return;
//            }
        }


        super.onBackPressed();
    }
}
