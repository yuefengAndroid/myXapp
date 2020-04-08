package com.example.xapp.home;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xapp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class XEditPasswordView extends DialogFragment {
    private Activity activity;
    private Dialog dialog;
    private TextView SaveChangePasswordBtn;
    private ImageView vepBackImg;
    private ImageView vepIvCloseImg;

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
        dialog.setContentView(R.layout.view_edit_password);
        initComponent();
        initSetOnClick();
        return dialog;
    }

    private void initComponent() {
        SaveChangePasswordBtn = dialog.findViewById(R.id.SaveChangePasswordBtn);
        vepBackImg = dialog.findViewById(R.id.vepBackImg);
        vepIvCloseImg = dialog.findViewById(R.id.vepIvCloseImg);
    }

    private void initSetOnClick() {
        SaveChangePasswordBtn.setOnClickListener(OnClick);
        vepBackImg.setOnClickListener(OnClick);
        vepIvCloseImg.setOnClickListener(OnClick);
    }

    private View.OnClickListener OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.vepBackImg:
                case R.id.vepIvCloseImg:
                case R.id.SaveChangePasswordBtn:
                    dialog.dismiss();
                    break;

            }
        }
    };
}
