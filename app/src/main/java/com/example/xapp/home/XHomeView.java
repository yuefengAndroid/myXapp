package com.example.xapp.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xapp.MainActivity;
import com.example.xapp.R;
import com.example.xapp.base.XFragment;
import com.example.xapp.base.XResponseData;
import com.example.xapp.chat.XMemberSetViewDialogFragment;
import com.example.xapp.login.XLoginView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class XHomeView extends XFragment {
    private Activity activity;
    private View view;
    private TextView vhTvSettingBtn;
    private ImageView vhIvGirlsBg01;
    private ImageView vhIvGirlsBg02;
    private ImageView vhIvSerachImg;
    private Integer[] mImageGirlsItems;
    private Integer[] mImageGirlsBg;
    private Integer[] mImageGirlsGroups;
    private List<String> GroupsNickname;

    private XGirlsItemRecyclerViewAdapter xGirlsItemRecyclerViewAdapter;
    private XGroupItemRecyclerViewAdapter xGroupItemRecyclerViewAdapter;
    private GridLayoutManager gridLayoutManager;
    private RecyclerView vhRvGirlsItemView;
    private RecyclerView vhRvGirlsGroupView;

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.activity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.view_home, container, false);
        initComponent();
        initSetOnClick();
        initSetImg();
        initSetRecyclerViewAdapter();
        return view;
    }

    private void initSetRecyclerViewAdapter() {
        xGirlsItemRecyclerViewAdapter = new XGirlsItemRecyclerViewAdapter(activity);
        xGroupItemRecyclerViewAdapter = new XGroupItemRecyclerViewAdapter(activity);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        vhRvGirlsItemView.setLayoutManager(layoutManager);
        vhRvGirlsItemView.setAdapter(xGirlsItemRecyclerViewAdapter);

        xGroupItemRecyclerViewAdapter = new XGroupItemRecyclerViewAdapter(activity);
        gridLayoutManager = new GridLayoutManager(activity, 3);
        vhRvGirlsGroupView.setLayoutManager(gridLayoutManager);
        vhRvGirlsGroupView.setNestedScrollingEnabled(false);
        vhRvGirlsGroupView.setItemAnimator(new DefaultItemAnimator());
        vhRvGirlsGroupView.setAdapter(xGroupItemRecyclerViewAdapter);

        xGirlsItemRecyclerViewAdapter.removeAll();
        xGroupItemRecyclerViewAdapter.removeAll();
        for (int i = 0; i < 9; i++) {
            xGirlsItemRecyclerViewAdapter.add(new XResponseData.GirlItems(
                    mImageGirlsItems[i]
            ));
        }
        GroupsNickname = new ArrayList<>();
        GroupsNickname.add("沙莉醬");
        GroupsNickname.add("愛耳沙");
        GroupsNickname.add("美利果");
        GroupsNickname.add("愛神小小");
        GroupsNickname.add("咪咪");
        GroupsNickname.add("小南一夢");
        GroupsNickname.add("Jessica");
        GroupsNickname.add("女神佑佑");
        GroupsNickname.add("天兵二號");
        GroupsNickname.add("小蘿莉");
        GroupsNickname.add("沙沙喔");
        GroupsNickname.add("秀秀女");
        GroupsNickname.add("豪情萬丈");
        GroupsNickname.add("天心");
        for (int k = 0; k < 14; k++) {
            xGroupItemRecyclerViewAdapter.add(new XResponseData.GirlGroups(
                    mImageGirlsGroups[k],
                    GroupsNickname.get(k)
            ));
        }

    }

    private void initSetImg() {
        mImageGirlsItems = new Integer[9];
        for (int i = 0; i < 9; i++) {
            int imageGirlsItems = getResources().getIdentifier("girls0" + (i + 1), "drawable", "com.example.xapp");
            mImageGirlsItems[i] = imageGirlsItems;
        }

        mImageGirlsGroups = new Integer[14];
        for (int j = 0; j < 14; j++) {
            int imageGirlsGroups = 0;
            if (j < 9) {
                imageGirlsGroups = getResources().getIdentifier("gs0" + (j + 1), "drawable", "com.example.xapp");
            } else {
                imageGirlsGroups = getResources().getIdentifier("gs" + (j + 1), "drawable", "com.example.xapp");
            }

            mImageGirlsGroups[j] = imageGirlsGroups;
        }

        mImageGirlsBg = new Integer[2];
        for (int k = 0; k < 2; k++) {
            int imageGirlsBg = getResources().getIdentifier("girls_b" + (k + 1), "drawable", "com.example.xapp");
            mImageGirlsBg[k] = imageGirlsBg;
        }
        vhIvGirlsBg01.setImageResource(mImageGirlsBg[0]);
        vhIvGirlsBg02.setImageResource(mImageGirlsBg[1]);
    }

    private void initComponent() {
        vhTvSettingBtn = view.findViewById(R.id.vhTvSettingBtn);
        vhIvGirlsBg01 = view.findViewById(R.id.vhIvGirlsBg01);
        vhIvGirlsBg02 = view.findViewById(R.id.vhIvGirlsBg02);
        vhIvSerachImg = view.findViewById(R.id.vhIvSerachImg);
        vhRvGirlsItemView = view.findViewById(R.id.vhRvGirlsItemView);
        vhRvGirlsGroupView = view.findViewById(R.id.vhRvGirlsGroupView);

    }

    private void initSetOnClick() {
        vhTvSettingBtn.setOnClickListener(OnClick);
        vhIvSerachImg.setOnClickListener(OnClick);

    }

    private View.OnClickListener OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.vhTvSettingBtn:
                    //跳轉設定頁面
//                    XMemberSetViewDialogFragment xMemberSetViewDialogFragment = new XMemberSetViewDialogFragment();
//                    FragmentTransaction fragmentTransaction = ((FragmentActivity) activity).getSupportFragmentManager().beginTransaction();
//                    fragmentTransaction.add(xMemberSetViewDialogFragment, "");
//                    fragmentTransaction.commitAllowingStateLoss();

                    Intent intent = new Intent();
                    intent.setClass(activity, XSettingView.class);
                    startActivity(intent);
//                    vhIcSettingView.setVisibility(View.VISIBLE);
//                    vhTvViewBackground.setVisibility(View.VISIBLE);
                    break;
                case R.id.vhIvSerachImg:
                    //跳轉搜尋頁面
                    break;
            }
        }
    };


    @Override
    public void refresh() {

    }
}
