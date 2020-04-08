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

public class XEditEmailView extends DialogFragment {
    private Activity activity;
    private Dialog dialog;
    private TextView SaveChangeEmailBtn;
    private ImageView veeBackImg;
    private ImageView veeIvCloseImg;

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
        dialog.setContentView(R.layout.view_edit_email);
        initComponent();
        initSetOnClick();
        return dialog;
    }

    private void initComponent() {
        SaveChangeEmailBtn = dialog.findViewById(R.id.SaveChangeEmailBtn);
        veeBackImg  = dialog.findViewById(R.id.veeBackImg);
        veeIvCloseImg  = dialog.findViewById(R.id.veeIvCloseImg);
    }

    private void initSetOnClick() {
        SaveChangeEmailBtn.setOnClickListener(OnClick);
        veeBackImg.setOnClickListener(OnClick);
        veeIvCloseImg.setOnClickListener(OnClick);
    }

    private View.OnClickListener OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.veeBackImg:
                case R.id.veeIvCloseImg:
                case R.id.SaveChangeEmailBtn:
                    dialog.dismiss();
                    break;

            }
        }
    };
}
