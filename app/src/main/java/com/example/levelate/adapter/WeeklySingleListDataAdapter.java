package com.example.levelate.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.levelate.R;
import com.example.levelate.model.SingleItemModel;
import com.example.levelate.model.WeeklySingleModel;

import java.util.ArrayList;

public class WeeklySingleListDataAdapter extends RecyclerView.Adapter<WeeklySingleListDataAdapter.SingleItemRowHolder> {
    private ArrayList<WeeklySingleModel> itemsList;
    private Context mContext;
   SectionItemClick onSectionItemClick;
    interface SectionItemClick{
        void onSectionClicked(CharSequence position);
    }

    public WeeklySingleListDataAdapter(Context context, ArrayList<WeeklySingleModel> itemsList, SectionItemClick sectionItemClick) {
        this.itemsList = itemsList;
        this.mContext = context;
        this.onSectionItemClick = sectionItemClick;
    }

    @Override
    public WeeklySingleListDataAdapter.SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.weekly_list_single_card, null);
        WeeklySingleListDataAdapter.SingleItemRowHolder mh = new WeeklySingleListDataAdapter.SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(final WeeklySingleListDataAdapter.SingleItemRowHolder holder, final int i) {
        final WeeklySingleModel weeklySingleModel = itemsList.get(i);
        holder.tvTitle.setText(weeklySingleModel.getName());

        if(i==0){
            holder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.colorBlack));
            holder.cardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.colorAccent));
        }else{
            holder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.colorButtonTextDisabled));

            holder.cardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.grey));
        }

    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private CardView cardView;
        public SingleItemRowHolder(View view) {
            super(view);
            this.tvTitle = view.findViewById(R.id.tvTitle);
            this.cardView = view.findViewById(R.id.cardView);

            view.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onClick(View v) {
                    onSectionItemClick.onSectionClicked(tvTitle.getText());
                    Toast.makeText(v.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();


                }
            });



        }

    }

}

