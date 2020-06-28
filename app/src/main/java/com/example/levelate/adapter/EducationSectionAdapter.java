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
import com.example.levelate.model.SectionDataModel;

import java.util.ArrayList;

public class EducationSectionAdapter extends RecyclerView.Adapter<EducationSectionAdapter.ItemRowHolder> implements SectionListDataAdapter.SectionItemClick, EducationSectionListAdapter.SectionItemClick {
    private ArrayList<EducationSectionModel> dataList;
    private Context mContext;
    SingleClicked singleClicked;
    public interface SingleClicked{
        void onSingleItemClicked();
    }
    public EducationSectionAdapter(Context context, ArrayList<EducationSectionModel> dataList, SingleClicked singleClicked) {
        this.dataList = dataList;
        this.mContext = context;
        this.singleClicked = singleClicked;
    }

    @Override
    public EducationSectionAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.education_section_list_item, null);
        EducationSectionAdapter.ItemRowHolder mh = new EducationSectionAdapter.ItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(EducationSectionAdapter.ItemRowHolder itemRowHolder, int i) {
        final String sectionName = dataList.get(i).getHeaderTitle();
        ArrayList singleSectionItems = dataList.get(i).getAllItemsInSection();
        itemRowHolder.itemTitle.setText(sectionName);

        EducationSectionListAdapter itemListDataAdapter = new EducationSectionListAdapter(mContext, singleSectionItems,this);
        //itemRowHolder.recycler_view_list.setHasFixedSize(true);
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
        protected TextView itemTitle;
        protected RecyclerView recycler_view_list;

        public ItemRowHolder(View view) {
            super(view);

            this.itemTitle = (TextView) view.findViewById(R.id.itemTitle);
            this.recycler_view_list = (RecyclerView) view.findViewById(R.id.recycler_view_list);
        }

    }

}


