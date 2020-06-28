package com.example.levelate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.levelate.R;
import com.example.levelate.model.LeaderboardModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.MyItemViewHolder> {
    private Context mContext;
    private ArrayList<LeaderboardModel> leaderboardModels;

    public LeaderboardAdapter(Context mContext, ArrayList<LeaderboardModel> leaderboardModels) {
        this.mContext = mContext;
        this.leaderboardModels = leaderboardModels;
    }


    @NonNull
    @Override
    public MyItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboard_item, null);
        return new LeaderboardAdapter.MyItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyItemViewHolder holder, int position) {
        LeaderboardModel leaderboardModel = leaderboardModels.get(position);
        holder.ivImage.setImageResource(leaderboardModel.imageResource);
        holder.ivRank.setImageResource(leaderboardModel.rankImage);
        holder.tvName.setText(leaderboardModel.name);
        holder.tvPoint.setText(leaderboardModel.point+"");
    }

    @Override
    public int getItemCount() {
        return leaderboardModels.size();
    }

    public class MyItemViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView ivImage, ivRank;
        private TextView tvName, tvPoint;

        public MyItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);
            ivRank = itemView.findViewById(R.id.ivRank);

            tvName = itemView.findViewById(R.id.tvName);
            tvPoint = itemView.findViewById(R.id.tvPoint);


        }
    }
}

