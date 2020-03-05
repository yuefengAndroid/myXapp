package com.example.xapp.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.xapp.R;
import com.example.xapp.base.XFragment;
import com.example.xapp.base.XNoScrollViewPager;
import com.example.xapp.chat.XChatListView;
import com.example.xapp.favorite.XFavoriteView;
import com.example.xapp.login.XLoginView;
import com.example.xapp.login.XSelectLoginView;
import com.example.xapp.map.XMapView;
import com.example.xapp.orders.XOrderListView;

import java.util.ArrayList;

public class XStartPlatformView extends AppCompatActivity {
    private XNoScrollViewPager aspvVpAllView;
    private ArrayList<XFragment> pageViewList;
    private TextView aspvTvHomeButton;
    private TextView aspvTvChatButton;
    private TextView aspvTvMapButton;
    private TextView aspvTvOrderButton;
    private TextView aspvTvLoveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_platform_view);
        initComponet();
        setupViewPage();
        initView();
    }

    private void setupViewPage() {
        pageViewList = new ArrayList<>();

        XHomeListView xHomeListView = new XHomeListView();
        pageViewList.add(0, xHomeListView);
        XChatListView xChatListView = new XChatListView();
        pageViewList.add(1, xChatListView);
        XMapView xMapView = new XMapView();
        pageViewList.add(2, xMapView);
        XOrderListView xOrderListView = new XOrderListView();
        pageViewList.add(3, xOrderListView);
        XFavoriteView xFavoriteView = new XFavoriteView();
        pageViewList.add(4, xFavoriteView);
    }

    private void initView() {
        aspvVpAllView.setAdapter(new SelectionPageAdapter(getSupportFragmentManager()));
        aspvVpAllView.setOffscreenPageLimit(5);
        aspvVpAllView.setCurrentItem(0);
    }

    /**
     * 用於首頁的ViewPager
     **/
    private class SelectionPageAdapter extends FragmentPagerAdapter {
        public SelectionPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return pageViewList.get(position);
        }

        @Override
        public int getCount() {
            return pageViewList.size();
        }
    }

    private void initComponet() {
        aspvTvHomeButton = findViewById(R.id.aspvTvHomeButton);
        aspvTvChatButton = findViewById(R.id.aspvTvChatButton);
        aspvTvMapButton = findViewById(R.id.aspvTvMapButton);
        aspvTvOrderButton = findViewById(R.id.aspvTvOrderButton);
        aspvTvLoveButton = findViewById(R.id.aspvTvLoveButton);
        aspvVpAllView = findViewById(R.id.aspvVpAllView);

        //設定ONClickListener
        aspvTvHomeButton.setOnClickListener(OnClickListener);
        aspvTvChatButton.setOnClickListener(OnClickListener);
        aspvTvMapButton.setOnClickListener(OnClickListener);
        aspvTvOrderButton.setOnClickListener(OnClickListener);
        aspvTvLoveButton.setOnClickListener(OnClickListener);
    }

    //各個按鈕的Click事件
    private View.OnClickListener OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.aspvTvHomeButton:
                    aspvVpAllView.setCurrentItem(0);
                    break;
                case R.id.aspvTvChatButton:
                    aspvVpAllView.setCurrentItem(1);
                    break;
                case R.id.aspvTvMapButton:
                    aspvVpAllView.setCurrentItem(2);
                    break;
                case R.id.aspvTvOrderButton:
                    aspvVpAllView.setCurrentItem(3);
                    break;
                case R.id.aspvTvLoveButton:
                    aspvVpAllView.setCurrentItem(4);
                    break;
            }
        }
    };
}
