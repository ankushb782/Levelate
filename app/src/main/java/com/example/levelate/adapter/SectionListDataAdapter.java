package com.example.levelate.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.levelate.R;
import com.example.levelate.fragment.OwnMealCategoryFragment;
import com.example.levelate.model.SingleItemModel;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {
    private ArrayList<SingleItemModel> itemsList;
    private Context mContext;
    SectionItemClick onSectionItemClick;
    interface SectionItemClick{
        void onSectionClicked(CharSequence position);
    }

    public SectionListDataAdapter(Context context, ArrayList<SingleItemModel> itemsList, SectionItemClick sectionItemClick) {
        this.itemsList = itemsList;
        this.mContext = context;
        this.onSectionItemClick = sectionItemClick;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_single_card, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {

        SingleItemModel singleItem = itemsList.get(i);
        holder.tvTitle.setText(singleItem.getName());
      //  holder.itemView.getLayoutParams().width = getScreenWidth(mContext)/2;
        ViewGroup.LayoutParams params = holder.llLinear.getLayoutParams();
        if (params != null) {
            params.width= (int) (getScreenWidth(mContext)/3.3);
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        } else
            params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        holder.llLinear.setLayoutParams(params);
       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }
    public static double getScreenWidth(Context context) {
        WindowManager wm= (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle;

        protected ImageView itemImage;
        protected CardView cardView;
        protected LinearLayout llLinear;


        public SingleItemRowHolder(View view) {
            super(view);

            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            this.itemImage = (ImageView) view.findViewById(R.id.itemImage);
            this.cardView = (CardView) view.findViewById(R.id.cardView);
            this.llLinear = (LinearLayout) view.findViewById(R.id.llLinear);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onSectionItemClick.onSectionClicked(tvTitle.getText());
                    Toast.makeText(v.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();

                }
            });


        }

    }

}

