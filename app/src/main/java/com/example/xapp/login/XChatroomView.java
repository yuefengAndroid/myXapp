package com.example.xapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.xapp.R;

public class XChatroomView extends AppCompatActivity {
    private TextView acvTvRegisteredBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom_view);
        acvTvRegisteredBtn = findViewById(R.id.acvTvRegisteredBtn);
        acvTvRegisteredBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(XChatroomView.this, XSelectLoginView.class);
                startActivity(intent);
            }
        });


    }
}
