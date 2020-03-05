package com.example.xapp.chat;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xapp.R;
import com.example.xapp.base.XFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class XChatListView extends XFragment {
    private Activity activity;
    private View view;

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
        view = inflater.inflate(R.layout.view_chatlist, container, false);
        return view;
    }

    @Override
    public void refresh() {

    }
}
