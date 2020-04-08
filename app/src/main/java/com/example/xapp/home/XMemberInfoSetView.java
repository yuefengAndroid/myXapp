package com.example.xapp.home;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.xapp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class XMemberInfoSetView extends DialogFragment {
    private Activity activity;
    private Dialog dialog;
    private ImageView vmsBackImg;
    private ImageView vmsIvCloseImg;
    private ImageView vsIvNextImgK03;
    private ImageView vsIvNextImgK04;
    private ImageView vsIvNextImgK05;
    private TextView vmsTvFaceCameraBtn;
    private ImageView vmsIvMemberFaceImg;
    private ImageView changeNicknameBtn;

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
        initSetOnClick();
        return dialog;
    }

    private void initSetOnClick() {
        vmsBackImg.setOnClickListener(OnClick);
        vmsIvCloseImg.setOnClickListener(OnClick);
        vsIvNextImgK03.setOnClickListener(OnClick);
        vsIvNextImgK04.setOnClickListener(OnClick);
        vsIvNextImgK05.setOnClickListener(OnClick);
        vmsTvFaceCameraBtn.setOnClickListener(OnClick);
        changeNicknameBtn.setOnClickListener(OnClick);
    }

    private View.OnClickListener OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.vmsIvCloseImg:
                case R.id.vmsBackImg:
                    dialog.dismiss();
                    break;
                case R.id.vsIvNextImgK03:
                    XEditEmailView xEditEmailView = new XEditEmailView();
                    FragmentTransaction fragmentTransaction =  ((FragmentActivity) activity).getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.add(xEditEmailView, "");
                    fragmentTransaction.commitAllowingStateLoss();
                    break;
                case R.id.vsIvNextImgK04:
                    XEditPasswordView xEditPasswordView = new XEditPasswordView();
                    FragmentTransaction fragmentTransaction1 =  ((FragmentActivity) activity).getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.add(xEditPasswordView, "");
                    fragmentTransaction1.commitAllowingStateLoss();
                    break;
                case R.id.vsIvNextImgK05:
                    XEditRecommendCode xEditRecommendCode = new XEditRecommendCode();
                    FragmentTransaction fragmentTransaction2 =  ((FragmentActivity) activity).getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.add(xEditRecommendCode, "");
                    fragmentTransaction2.commitAllowingStateLoss();
                    break;
                case R.id.vmsTvFaceCameraBtn:
                    break;
                case R.id.changeNicknameBtn:
                    break;
            }
        }
    };

    private void initComponent() {
        vmsBackImg = dialog.findViewById(R.id.vmsBackImg);
        vmsIvCloseImg = dialog.findViewById(R.id.vmsIvCloseImg);
        vsIvNextImgK03 = dialog.findViewById(R.id.vsIvNextImgK03);
        vsIvNextImgK04 = dialog.findViewById(R.id.vsIvNextImgK04);
        vsIvNextImgK05 = dialog.findViewById(R.id.vsIvNextImgK05);
        vmsTvFaceCameraBtn  = dialog.findViewById(R.id.vmsTvFaceCameraBtn);
        vmsIvMemberFaceImg  = dialog.findViewById(R.id.vmsIvMemberFaceImg);
        changeNicknameBtn   = dialog.findViewById(R.id.changeNicknameBtn);
        Glide.with(vmsIvMemberFaceImg).load(R.drawable.girls09)
                .apply(RequestOptions.bitmapTransform(
                        new MultiTransformation(
                                new CenterCrop(),
                                new RoundedCornersTransformation(100, 0, RoundedCornersTransformation.CornerType.ALL)
                        )
                ))
                .into(vmsIvMemberFaceImg);
    }
}
