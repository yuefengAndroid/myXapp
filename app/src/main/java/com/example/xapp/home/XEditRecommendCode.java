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

public class XEditRecommendCode extends DialogFragment {
    private Activity activity;
    private Dialog dialog;
    private TextView SaveChangeRcCodeBtn;
    private ImageView vercBackImg;
    private ImageView vercIvCloseImg;

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
        dialog.setContentView(R.layout.view_edit_recommmend_code);
        initComponent();
        initSetOnClick();
        return dialog;
    }

    private void initComponent() {
        SaveChangeRcCodeBtn = dialog.findViewById(R.id.SaveChangeRcCodeBtn);
        vercBackImg  = dialog.findViewById(R.id.vercBackImg);
        vercIvCloseImg  = dialog.findViewById(R.id.vercIvCloseImg);
    }

    private void initSetOnClick() {
        SaveChangeRcCodeBtn.setOnClickListener(OnClick);
        vercBackImg.setOnClickListener(OnClick);
        vercIvCloseImg.setOnClickListener(OnClick);
    }

    private View.OnClickListener OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.vercBackImg:
                case R.id.vercIvCloseImg:
                case R.id.SaveChangeRcCodeBtn:
                    dialog.dismiss();
                    break;

            }
        }
    };
}
