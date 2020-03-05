package com.example.xapp.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xapp.R;
import com.example.xapp.home.XStartPlatformView;

public class XSelectLoginView extends AppCompatActivity {
    private TextView aslvTvRegistered;  //註冊按鈕
    private TextView aslvTvLogin;       //登入按鈕
    private ImageView aslvIvMaleRadioButtonImg; //男性按鈕
    private ImageView aslvIvFemaleRadioButtonImg; //性按鈕
    private TextView aslvTvNextButton; //下一步
    private TextView aslvTvNextLoginButton; //登入
    private ImageView aslvIvBackImg; //取消
    private ConstraintLayout aslvClRegisteredBackground; //註冊背景頁面
    private ConstraintLayout aslvClLoginVerificationBackground; //登入與驗証背景頁面
    private ImageView aslvIvReadRadioImg; //
    private boolean isCheckReadAgree = false;   //判斷是否按了閱讀同意
    private String CheckLoginType = ""; //1:註, 2:登入
    private TextView aslvTvLoginButton;

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
        aslvClLoginVerificationBackground = findViewById(R.id.aslvClLoginVerificationBackground);
        aslvIvReadRadioImg = findViewById(R.id.aslvIvReadRadioImg);
        aslvIvMaleRadioButtonImg = findViewById(R.id.aslvIvMaleRadioButtonImg);
        aslvIvFemaleRadioButtonImg = findViewById(R.id.aslvIvFemaleRadioButtonImg);
        aslvTvNextButton = findViewById(R.id.aslvTvNextButton);
        aslvTvNextLoginButton = findViewById(R.id.aslvTvNextLoginButton);
        aslvIvBackImg = findViewById(R.id.aslvIvBackImg);
        aslvTvLoginButton = findViewById(R.id.aslvTvLoginButton);
        //設定ONClickListener
        aslvTvRegistered.setOnClickListener(OnClickListener);
        aslvTvLogin.setOnClickListener(OnClickListener);
        aslvIvReadRadioImg.setOnClickListener(OnClickListener);
        aslvIvMaleRadioButtonImg.setOnClickListener(OnClickListener);
        aslvIvFemaleRadioButtonImg.setOnClickListener(OnClickListener);
        aslvIvBackImg.setOnClickListener(OnClickListener);
        aslvTvNextButton.setOnClickListener(OnClickListener);
        aslvTvNextLoginButton.setOnClickListener(OnClickListener);
        aslvTvLoginButton.setOnClickListener(OnClickListener);
    }

    //各個按鈕的Click事件
    private View.OnClickListener OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            switch (view.getId()) {
                case R.id.aslvTvRegistered:
                    CheckLoginType = "1";
                    aslvClRegisteredBackground.setVisibility(View.VISIBLE);
                    break;
                case R.id.aslvIvBackImg:
                    if ("1".equals(CheckLoginType)) {
                        aslvClLoginVerificationBackground.setVisibility(View.GONE);
                        aslvClRegisteredBackground.setVisibility(View.VISIBLE);
                    } else {
                        aslvClLoginVerificationBackground.setVisibility(View.GONE);
                    }
                    break;
                case R.id.aslvTvLogin:
                case R.id.aslvTvNextLoginButton:
                    aslvClLoginVerificationBackground.setVisibility(View.GONE);
                    aslvClRegisteredBackground.setVisibility(View.GONE);
                    intent.setClass(XSelectLoginView.this, XLoginView.class);
                    startActivity(intent);
                    break;
                case R.id.aslvTvNextButton:
                    aslvClRegisteredBackground.setVisibility(View.GONE);
                    aslvClLoginVerificationBackground.setVisibility(View.VISIBLE);
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
                case R.id.aslvIvMaleRadioButtonImg:
                    aslvIvMaleRadioButtonImg.setBackgroundResource(R.drawable.radio_button_true);
                    aslvIvFemaleRadioButtonImg.setBackgroundResource(R.drawable.radio_button_false);
                    break;
                case R.id.aslvIvFemaleRadioButtonImg:
                    aslvIvMaleRadioButtonImg.setBackgroundResource(R.drawable.radio_button_false);
                    aslvIvFemaleRadioButtonImg.setBackgroundResource(R.drawable.radio_button_true);
                    break;
                case R.id.aslvTvLoginButton:
                    intent.setClass(XSelectLoginView.this, XStartPlatformView.class);
                    startActivity(intent);
                    finish();
                    break;
            }
        }
    };
}
