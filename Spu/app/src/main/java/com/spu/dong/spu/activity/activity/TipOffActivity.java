package com.spu.dong.spu.activity.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.TextView;

import com.cazaea.sweetalert.SweetAlertDialog;
import com.spu.dong.spu.R;
import com.spu.dong.spu.activity.flyn.Eyes;
import com.spu.dong.spu.activity.kai.view.ImageViewPlus;
import com.spu.dong.spu.activity.model.TipOffBeans;
import com.spu.dong.spu.activity.utils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TipOffActivity extends AppCompatActivity {

    @BindView(R.id.tb_tip_colcum_detail)
    Toolbar tbTipColcumDetail;
    @BindView(R.id.tv_tipoff_title)
    TextView tvTipoffTitle;
    @BindView(R.id.tv_tipoff_content)
    TextView tvTipoffContent;
    @BindView(R.id.tv_tipoff_phone)
    TextView tvTipoffPhone;
    @BindView(R.id.iv_phone)
    ImageViewPlus ivPhone;
    private TipOffBeans data;

    @OnClick(R.id.iv_phone)
    public void callPhone(){
        request();

    }
    private int[] mStatusColors = new int[]{
            R.color.colorRedDeep,
            R.color.status_color_grey,
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tip_colum_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        data = extras.getParcelable("data");
        initData();
        Eyes.setStatusBarColor(this, UIUtils.getColor(mStatusColors[0]));
    }

    private void initData(){


        tvTipoffTitle.setText(data.title);
        tvTipoffContent.setText(data.content);
        tvTipoffPhone.setText(data.phone);



    }

    private void showDialog(String str,int code){
        final SweetAlertDialog dialog = new SweetAlertDialog(this);
        dialog.setTitleText("提示");
        dialog.setContentText(str);
        dialog.setConfirmText("确定");
        dialog.setCancelText("取消"); //没有取消按钮
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        if(code == 2){
            dialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sweetAlertDialog) {
                    ActivityCompat.requestPermissions(TipOffActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
                    dialog.dismiss();

                }
            });
        }else{
            dialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sweetAlertDialog) {
                    dialog.dismiss();
                    //打电话
                    //有权限
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+data.phone));
                    startActivity(intent);
                }
            });
        }

        dialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    private void request(){
        //请求打电话的权限


        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){

            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CALL_PHONE)){
                showDialog("未授予应用拨号权限\n是否从新授权",2);
            }else{
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
            }
        }else{

            showDialog("是否拨打"+data.phone,1);

        }

    }
}
