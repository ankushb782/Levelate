package com.example.levelate.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.levelate.R;
import com.example.levelate.model.GymCategoryModel;

import java.util.ArrayList;

public class GymChallengeCategoryAdapter extends RecyclerView.Adapter<GymChallengeCategoryAdapter.ItemRowHolder> {
    private ArrayList<GymCategoryModel> gymCategoryModelArrayList;
    private Context mContext;
    ItemClicked itemClicked;
    public interface ItemClicked {
        void onItemClicked(CharSequence pos);
    }

    public GymChallengeCategoryAdapter(Context context, ArrayList<GymCategoryModel> gymCategoryModelArrayList, ItemClicked itemClicked) {
        this.gymCategoryModelArrayList = gymCategoryModelArrayList;
        this.mContext = context;
        this.itemClicked = itemClicked;
    }

    @Override
    public GymChallengeCategoryAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gym_category_list_item, null);
        GymChallengeCategoryAdapter.ItemRowHolder mh = new GymChallengeCategoryAdapter.ItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(final GymChallengeCategoryAdapter.ItemRowHolder itemRowHolder, final int i) {
       GymCategoryModel gymCategoryModel = gymCategoryModelArrayList.get(i);
       itemRowHolder.tvTitle.setText(gymCategoryModel.headerTitle);

       itemRowHolder.ll.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(mContext,i+"",Toast.LENGTH_LONG).show();
               itemClicked.onItemClicked(itemRowHolder.tvTitle.getText());

           }
       });
    }

    @Override
    public int getItemCount() {
        return (null != gymCategoryModelArrayList ? gymCategoryModelArrayList.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvTitle;
        private LinearLayout ll;

        public ItemRowHolder(View view) {
            super(view);
            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            this.ll = (LinearLayout) view.findViewById(R.id.ll);

        }

    }

}



