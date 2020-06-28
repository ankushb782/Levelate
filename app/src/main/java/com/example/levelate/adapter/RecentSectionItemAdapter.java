package com.example.levelate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.levelate.R;
import com.example.levelate.model.EducationSectionModel;

import java.util.ArrayList;

public class RecentSectionItemAdapter extends RecyclerView.Adapter<RecentSectionItemAdapter.ItemRowHolder> implements SectionListDataAdapter.SectionItemClick, EducationSectionListAdapter.SectionItemClick {
    private ArrayList<EducationSectionModel> dataList;
    private Context mContext;
    RecentSectionItemAdapter.SingleClicked singleClicked;
    public interface SingleClicked{
        void onSingleItemClicked();
    }
    public RecentSectionItemAdapter(Context context, ArrayList<EducationSectionModel> dataList, RecentSectionItemAdapter.SingleClicked singleClicked) {
        this.dataList = dataList;
        this.mContext = context;
        this.singleClicked = singleClicked;
    }

    @Override
    public RecentSectionItemAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recent_blog_items, null);
        RecentSectionItemAdapter.ItemRowHolder mh = new RecentSectionItemAdapter.ItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(RecentSectionItemAdapter.ItemRowHolder itemRowHolder, int i) {
        final String sectionName = dataList.get(i).getHeaderTitle();
        ArrayList singleSectionItems = dataList.get(i).getAllItemsInSection();
        EducationSectionListAdapter itemListDataAdapter = new EducationSectionListAdapter(mContext, singleSectionItems,this);
        itemRowHolder.recycler_view_list.setHasFixedSize(true);
        itemRowHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        itemRowHolder.recycler_view_list.setAdapter(itemListDataAdapter);

    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }

    @Override
    public void onSectionClicked(CharSequence position) {
        singleClicked.onSingleItemClicked();

    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected RecyclerView recycler_view_list;

        public ItemRowHolder(View view) {
            super(view);
            this.recycler_view_list = (RecyclerView) view.findViewById(R.id.recycler_view_list);
        }

    }

}



