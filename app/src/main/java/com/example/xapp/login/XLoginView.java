package com.example.xapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.xapp.R;

public class XLoginView extends AppCompatActivity {
    private TextView alvTvLoginButton;
    private TextView alvTvGoRegisteredButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);
        initComponent();
    }

    private void initComponent() {
        alvTvLoginButton = findViewById(R.id.alvTvLoginButton);
        alvTvGoRegisteredButton = findViewById(R.id.alvTvGoRegisteredButton);
        //設定ONClickListener
        alvTvLoginButton.setOnClickListener(OnClickListener);
        alvTvGoRegisteredButton.setOnClickListener(OnClickListener);
    }

    //各個按鈕的Click事件
    private View.OnClickListener OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            switch (view.getId()) {
                case R.id.alvTvLoginButton:
                    intent.setClass(XLoginView.this, XChatroomView.class);
                    startActivity(intent);

                    break;
                case R.id.alvTvGoRegisteredButton:
                    intent.setClass(XLoginView.this, XSelectLoginView.class);
                    startActivity(intent);

                    break;
            }
        }
    };
}
