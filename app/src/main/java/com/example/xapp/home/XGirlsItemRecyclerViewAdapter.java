package com.example.xapp.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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

public class XGirlsItemRecyclerViewAdapter extends RecyclerView.Adapter<XGirlsItemRecyclerViewAdapter.ViewHolder> {
    private ArrayList<XResponseData.GirlItems> girlItemsList = new ArrayList<>();
    private Context context;
    private View view;

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView GirlsItems;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            GirlsItems = itemView.findViewById(R.id.GirlsItems);
        }
    }

    public XGirlsItemRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.view_girls_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final XResponseData.GirlItems girlItems_List = girlItemsList.get(position);
        if(holder instanceof ViewHolder){
            final ViewHolder myVieweHolder = holder;
            Glide.with(myVieweHolder.GirlsItems).load(girlItems_List.getImgItems())
                    .apply(RequestOptions.bitmapTransform(
                            new MultiTransformation(
                                    new CenterCrop(),
                                    new RoundedCornersTransformation(100, 0, RoundedCornersTransformation.CornerType.ALL)
                            )
                    ))
                    .into(myVieweHolder.GirlsItems);
        }
    }

    @Override
    public int getItemCount() {
        return girlItemsList != null ? girlItemsList.size() : 0;
    }

    //新增資料的方法
    public void add(XResponseData.GirlItems GirlItem_List) {
        girlItemsList.add(GirlItem_List);
        notifyItemInserted(girlItemsList != null ? girlItemsList.size() : 0);
    }

    //清空全部資料方法
    public void removeAll() {
        girlItemsList = new ArrayList<>();
        notifyDataSetChanged();
    }

}
