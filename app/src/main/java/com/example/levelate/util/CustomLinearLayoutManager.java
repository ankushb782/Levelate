package com.example.levelate.util;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class CustomLinearLayoutManager extends LinearLayoutManager {

private Context mContext;
private int spanCount;

public CustomLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
    super(context, orientation, reverseLayout);
    this.mContext = context;
}

@Override
public void measureChild(View child, int widthUsed, int heightUsed) {
/*    RecyclerView.LayoutParams lpTmp = (RecyclerView.LayoutParams) child.getLayoutParams();
    final RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(measureScreenWidth(mContext) / spanCount, lpTmp.height);
    int widthSpec = View.MeasureSpec.makeMeasureSpec(measureScreenWidth(mContext) / spanCount, View.MeasureSpec.EXACTLY);
    int heightSpec = View.MeasureSpec.makeMeasureSpec(lp.height, View.MeasureSpec.EXACTLY);
    child.measure(widthSpec, heightSpec);*/
}
    }