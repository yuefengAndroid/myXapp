package com.example.xapp.chat;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.xapp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class XMemberSetViewDialogFragment extends DialogFragment {
    private Activity activity;
    private Dialog dialog;


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

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        dialog = new Dialog(activity, R.style.XDialogFragment);
        dialog.setContentView(R.layout.view_member_setting);
        initComponent();
        return super.onCreateDialog(savedInstanceState);
    }

    private void initComponent() {

    }
}
