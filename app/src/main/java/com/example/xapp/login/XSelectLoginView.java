package com.example.xapp.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xapp.R;

public class XSelectLoginView extends AppCompatActivity {
    private TextView aslvTvRegistered;  //註冊按鈕
    private TextView aslvTvLogin;       //登入按鈕
    private ConstraintLayout aslvClRegisteredBackground; //註冊背景頁面
    private ImageView aslvIvReadRadioImg; //
    private boolean isCheckReadAgree = false;   //判斷是否按了閱讀同意

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_login_view);
        initComponet();//初始化資料
    }

    private void initComponet() {
        aslvTvRegistered = findViewById(R.id.aslvTvRegistered);
        aslvTvLogin = findViewById(R.id.aslvTvLogin);
        aslvClRegisteredBackground = findViewById(R.id.aslvClRegisteredBackground);
        aslvIvReadRadioImg = findViewById(R.id.aslvIvReadRadioImg);
        //設定ONClickListener
        aslvTvRegistered.setOnClickListener(OnClickListener);
        aslvTvLogin.setOnClickListener(OnClickListener);
        aslvIvReadRadioImg.setOnClickListener(OnClickListener);
    }

    //各個按鈕的Click事件
    private View.OnClickListener OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            switch (view.getId()) {
                case R.id.aslvTvRegistered:
//                    intent.setClass(XSelectLoginView.this, XRegisteredView2.class);
//                    startActivity(intent);
                    aslvClRegisteredBackground.setVisibility(View.VISIBLE);
                    break;
                case R.id.aslvTvLogin:

                    break;
                case R.id.aslvIvReadRadioImg:
                    if (isCheckReadAgree) {
                        isCheckReadAgree = false;
                        aslvIvReadRadioImg.setImageResource(R.drawable.tick);
                    } else {
                        isCheckReadAgree = true;
                        aslvIvReadRadioImg.setImageResource(R.drawable.tickf);
                    }
                    break;
            }
        }
    };
}
