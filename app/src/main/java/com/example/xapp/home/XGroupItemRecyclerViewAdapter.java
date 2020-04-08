package com.example.xapp.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.xapp.R;
import com.example.xapp.base.XResponseData;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class XGroupItemRecyclerViewAdapter extends RecyclerView.Adapter<XGroupItemRecyclerViewAdapter.ViewHolder> {
    private ArrayList<XResponseData.GirlGroups> girlGroupsList = new ArrayList<>();
    private Context context;
    private View view;

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView IvGroupFace;
        TextView TvGroupNickname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            IvGroupFace = itemView.findViewById(R.id.IvGroupFace);
            TvGroupNickname = itemView.findViewById(R.id.TvGroupNickname);
        }
    }

    public XGroupItemRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.view_girls_group_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final XResponseData.GirlGroups girlGroups_List = girlGroupsList.get(position);
        if (holder instanceof ViewHolder) {
            final ViewHolder myVieweHolder = holder;
            Glide.with(myVieweHolder.IvGroupFace).load(girlGroups_List.getsFaces())
                    .apply(RequestOptions.bitmapTransform(
                            new MultiTransformation(
                                    new CenterCrop(),
                                    new RoundedCornersTransformation(20, 0, RoundedCornersTransformation.CornerType.ALL)
                            )
                    ))
                    .into(myVieweHolder.IvGroupFace);
            myVieweHolder.TvGroupNickname.setText(girlGroups_List.getgNickname());
        }
    }

    @Override
    public int getItemCount() {
        return girlGroupsList != null ? girlGroupsList.size() : 0;
    }

    //新增資料的方法
    public void add(XResponseData.GirlGroups GirlGroups_List) {
        girlGroupsList.add(GirlGroups_List);
        notifyItemInserted(girlGroupsList != null ? girlGroupsList.size() : 0);
    }

    //清空全部資料方法
    public void removeAll() {
        girlGroupsList = new ArrayList<>();
        notifyDataSetChanged();
    }
}
