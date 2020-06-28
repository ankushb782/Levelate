package com.example.levelate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.levelate.R;
import com.example.levelate.listener.ViewAllClick;
import com.example.levelate.model.ViewAllModel;

import java.util.List;

public class ViewAllListAdapter extends RecyclerView.Adapter<ViewAllListAdapter.MyViewHolder> {
    private Context mContext;
    private List<ViewAllModel> viewAllModelList;
    public ViewAllClick viewAllClick;

    public ViewAllListAdapter(Context mContext, List<ViewAllModel> viewAllModelList,ViewAllClick viewAllClick) {
        this.mContext = mContext;
        this.viewAllModelList = viewAllModelList;
        this.viewAllClick = viewAllClick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.own_meal_view_all_item, null);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        ViewAllModel viewAllModel = viewAllModelList.get(position);
        holder.cvImage.setImageResource(viewAllModel.getCarImageId());
        holder.btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewAllClick.onViewAllClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return viewAllModelList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView cvImage;
        private AppCompatButton btnView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cvImage = itemView.findViewById(R.id.cvImage);
            btnView = itemView.findViewById(R.id.btnView);

        }
    }
}

