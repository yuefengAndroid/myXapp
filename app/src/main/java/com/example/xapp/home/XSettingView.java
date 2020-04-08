package com.example.xapp.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.xapp.R;

public class XSettingView extends AppCompatActivity {
    private ImageView vsIvNextImg01;
    private ImageView vsIvCloseImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_view);
        initComponent();
        initSetOnClick();
    }

    private void initComponent() {
        vsIvCloseImg = findViewById(R.id.vsIvCloseImg);
        vsIvNextImg01 = findViewById(R.id.vsIvNextImg01);
    }

    private void initSetOnClick() {
        vsIvCloseImg.setOnClickListener(OnClick);
        vsIvNextImg01.setOnClickListener(OnClick);
    }

    private View.OnClickListener OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.vsIvCloseImg:
                    finish();
                    break;
                case R.id.vsIvNextImg01:
                    XMemberInfoSetView xMemberSetView = new XMemberInfoSetView();
                    FragmentTransaction fragmentTransaction =  getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.add(xMemberSetView, "");
                    fragmentTransaction.commitAllowingStateLoss();
                    break;
            }
        }
    };

}
