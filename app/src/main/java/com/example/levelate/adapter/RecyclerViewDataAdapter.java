package com.example.levelate.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.levelate.R;
import com.example.levelate.model.SectionDataModel;

import java.util.ArrayList;

public class RecyclerViewDataAdapter extends RecyclerView.Adapter<RecyclerViewDataAdapter.ItemRowHolder> implements SectionListDataAdapter.SectionItemClick {
    private ArrayList<SectionDataModel> dataList;
    private Context mContext;
    SingleClicked singleClicked;
    public interface SingleClicked{
        void onSingleItemClicked();
    }
    public RecyclerViewDataAdapter(Context context, ArrayList<SectionDataModel> dataList,SingleClicked singleClicked) {
        this.dataList = dataList;
        this.mContext = context;
        this.singleClicked = singleClicked;
    }


    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, null);
        ItemRowHolder mh = new ItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(final ItemRowHolder itemRowHolder, int i) {
        final String sectionName = dataList.get(i).getHeaderTitle();
        ArrayList singleSectionItems = dataList.get(i).getAllItemsInSection();
        itemRowHolder.itemTitle.setText(sectionName);
        SectionListDataAdapter itemListDataAdapter = new SectionListDataAdapter(mContext, singleSectionItems,this);
     //   itemRowHolder.recycler_view_list.setHasFixedSize(true);
        itemRowHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        itemRowHolder.recycler_view_list.setAdapter(itemListDataAdapter);

        /*RecyclerView.LayoutParams layoutParams = null;
        if (i == dataList.size() - 1) {
         layoutParams = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);
        } else {
            final int[] width = {itemRowHolder.itemView.getWidth()};
            if (width[0] == 0) {
                final RecyclerView.LayoutParams finalLayoutParams = layoutParams;
                itemRowHolder.itemView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        itemRowHolder.itemView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        width[0] = itemRowHolder.itemView.getWidth();
                        finalLayoutParams.width = (int) (width[0] - 2.13);
                        itemRowHolder.itemView.requestLayout();
                    }
                });

            } else {
                layoutParams.width = (int) (width[0] - 2.13);
                itemRowHolder.itemView.requestLayout();
            }
        }*/

//        Glide.with(mContext)
//                .load(feedItem.getImageURL())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .centerCrop()
//                .error(R.drawable.bg)
//                .into(feedListRowHolder.thumbView);
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

