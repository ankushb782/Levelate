package com.example.levelate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.levelate.R;
import com.example.levelate.model.WeeklySectionModel;

import java.util.ArrayList;

public class WeeklyDataAdapter extends RecyclerView.Adapter<WeeklyDataAdapter.ItemRowHolder> implements WeeklySingleListDataAdapter.SectionItemClick {
    private ArrayList<WeeklySectionModel> weeklySectionModels;
    private Context mContext;

    SingleClicked singleClicked;

    @Override
    public void onSectionClicked(CharSequence po) {
        singleClicked.onSingleItemClicked(po);

    }

    public interface SingleClicked {
        void onSingleItemClicked(CharSequence pos);
    }

    public WeeklyDataAdapter(Context context, ArrayList<WeeklySectionModel> weeklySectionModels, SingleClicked singleClicked) {
        this.weeklySectionModels = weeklySectionModels;
        this.mContext = context;
        this.singleClicked = singleClicked;
    }

    @Override
    public WeeklyDataAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.weekly_list_item, null);
        WeeklyDataAdapter.ItemRowHolder mh = new WeeklyDataAdapter.ItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(WeeklyDataAdapter.ItemRowHolder itemRowHolder, int i) {
        final String sectionName = weeklySectionModels.get(i).getHeaderTitle();
        ArrayList singleSectionItems = weeklySectionModels.get(i).getAllItemsInSection();
        itemRowHolder.itemTitle.setText(sectionName);

        WeeklySingleListDataAdapter itemListDataAdapter = new WeeklySingleListDataAdapter(mContext, singleSectionItems, this);
      //  itemRowHolder.recycler_view_list.setHasFixedSize(true);
        GridLayoutManager manager = new GridLayoutManager(mContext, 4, GridLayoutManager.VERTICAL, false);
        itemRowHolder.recycler_view_list.setLayoutManager(manager);
        itemRowHolder.recycler_view_list.setAdapter(itemListDataAdapter);


    }

    @Override
    public int getItemCount() {
        return (null != weeklySectionModels ? weeklySectionModels.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView itemTitle;
        protected RecyclerView recycler_view_list;

        public ItemRowHolder(View view) {
            super(view);

            this.itemTitle = (TextView) view.findViewById(R.id.itemTitle);
            this.recycler_view_list = (RecyclerView) view.findViewById(R.id.recycler_view_list);
        }

    }

}


