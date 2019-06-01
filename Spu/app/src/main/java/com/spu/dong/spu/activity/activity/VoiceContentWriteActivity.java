package com.spu.dong.spu.activity.activity;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.spu.dong.spu.R;
import com.spu.dong.spu.activity.cache.LocationCache;
import com.spu.dong.spu.activity.model.MyQuestion;
import com.spu.dong.spu.activity.utils.DataUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class VoiceContentWriteActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView ivUpload;
    private EditText edTitle, edContent;
    private Button btnCommit;
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private View dialogView;
    private TextView tvCamera, tvCancel, tvPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_content_write);

        initView();

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE},1);



    }

    private void initView() {
        ivUpload = (ImageView) findViewById(R.id.iv_image_upload);
        edContent = (EditText) findViewById(R.id.et_content);
        edTitle = (EditText) findViewById(R.id.et_title);
        btnCommit = (Button) findViewById(R.id.btn_commit);
        ivUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(VoiceContentWriteActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){

                    if(ActivityCompat.shouldShowRequestPermissionRationale(VoiceContentWriteActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                        ActivityCompat.requestPermissions(VoiceContentWriteActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                    }else{
                        ActivityCompat.requestPermissions(VoiceContentWriteActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                    }
                }
                if(ContextCompat.checkSelfPermission(VoiceContentWriteActivity.this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){

                    if(ActivityCompat.shouldShowRequestPermissionRationale(VoiceContentWriteActivity.this,Manifest.permission.CAMERA)){
                        ActivityCompat.requestPermissions(VoiceContentWriteActivity.this,new String[]{Manifest.permission.CAMERA},1);
                    }else{
                        ActivityCompat.requestPermissions(VoiceContentWriteActivity.this,new String[]{Manifest.permission.CAMERA},1);
                    }
                }

                builder = new AlertDialog.Builder(VoiceContentWriteActivity.this);
                dialogView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.upload_img_dialog, null);
                builder.setView(dialogView);
                dialog = builder.show();

                initDialogView();

            }
        });
        btnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取数据
                        MyQuestion myQuestion = new MyQuestion("","","");
                        String title = edTitle.getText().toString();
                        myQuestion.title = title;
                        String content = edContent.getText().toString();
                        myQuestion.content = content;

                        if(TextUtils.isEmpty(title)){
                            Toast.makeText(VoiceContentWriteActivity.this,"标题不能未空",Toast.LENGTH_SHORT).show();
                            return;
                        }

                       if(TextUtils.isEmpty(content)){
                            Toast.makeText(VoiceContentWriteActivity.this,"内容不能未空",Toast.LENGTH_SHORT).show();
                            return;
                       }
                        ivUpload.setDrawingCacheEnabled(true);
                        ivUpload.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
                        ivUpload.layout(0, 0, ivUpload.getMeasuredWidth(), ivUpload.getMeasuredHeight());
                        ivUpload.buildDrawingCache();
                        Bitmap bitmap  = Bitmap.createBitmap(ivUpload.getDrawingCache());
                        String s = DataUtils.bitmapToString(bitmap);
                        myQuestion.bitmap = s;
                        // 存到数据库
                        ContentResolver contentResolver = getContentResolver();
                        ContentValues contentValues = new ContentValues();
                        Uri parse = Uri.parse("content://com.spu.dong.spu.ContentProviderDemo/myask");
                        contentValues.put("ask",myQuestion.content);
                        contentValues.put("title",myQuestion.title);
                        contentValues.put("image",myQuestion.bitmap);
                        contentResolver.insert(parse,contentValues);
                        contentValues.clear();
                        ivUpload.setDrawingCacheEnabled(false);
                        ArrayList<MyQuestion> myQuestionList = LocationCache.getLocationCache().getMyQuestionList();
                        myQuestionList.add(myQuestion);
                        edContent.setText("");
                        edTitle.setText("");
                        Toast.makeText(getApplicationContext(), "提交成功", Toast.LENGTH_LONG).show();
                        finish();


            }
        });
    }

    private void initDialogView() {
        tvCamera = (TextView) dialogView.findViewById(R.id.tv_camera);
        tvPicture = (TextView) dialogView.findViewById(R.id.tv_picture);
        tvCancel = (TextView) dialogView.findViewById(R.id.tv_cancel);
        tvCamera.setOnClickListener(this);
        tvPicture.setOnClickListener(this);
        tvCancel.setOnClickListener(this);
    }

    private Handler myHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);


        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable final Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                    ivUpload.setImageBitmap(bitmap);
                }
            case 2:

                if (resultCode == RESULT_OK) {
                   try{
                         Bitmap bitmapFormUri = getBitmapFormUri(VoiceContentWriteActivity.this, data.getData());
                         ivUpload.setImageBitmap(bitmapFormUri);
                    }catch(Exception t){
                        }

                }
                break;
        }
    }
    public static Bitmap getBitmapFormUri(Activity ac, Uri uri) throws FileNotFoundException, IOException {
        InputStream input = ac.getContentResolver().openInputStream(uri);
        BitmapFactory.Options onlyBoundsOptions = new BitmapFactory.Options();
        onlyBoundsOptions.inJustDecodeBounds = true;
        onlyBoundsOptions.inDither = true;//optional
        onlyBoundsOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
        BitmapFactory.decodeStream(input, null, onlyBoundsOptions);
        input.close();
        int originalWidth = onlyBoundsOptions.outWidth;
        int originalHeight = onlyBoundsOptions.outHeight;
        if ((originalWidth == -1) || (originalHeight == -1))
            return null;
        //图片分辨率以480x800为标准
        float hh = 200f;//这里设置高度为800f
        float ww = 150f;//这里设置宽度为480f
        //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1;//be=1表示不缩放
        if (originalWidth > originalHeight && originalWidth > ww) {//如果宽度大的话根据宽度固定大小缩放
            be = (int) (originalWidth / ww);
        } else if (originalWidth < originalHeight && originalHeight > hh) {//如果高度高的话根据宽度固定大小缩放
            be = (int) (originalHeight / hh);
        }
        if (be <= 0)
            be = 1;
        //比例压缩
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inSampleSize = be;//设置缩放比例
        bitmapOptions.inDither = true;//optional
        bitmapOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
        input = ac.getContentResolver().openInputStream(uri);
        Bitmap bitmap = BitmapFactory.decodeStream(input, null, bitmapOptions);
        input.close();
        return compressImage(bitmap);
    }
    public static Bitmap compressImage(Bitmap image) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 50, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        int options = 100;
        while (baos.toByteArray().length / 1024 > 100) {  //循环判断如果压缩后图片是否大于100kb,大于继续压缩
            baos.reset();//重置baos即清空baos
            //第一个参数 ：图片格式 ，第二个参数： 图片质量，100为最高，0为最差  ，第三个参数：保存压缩后的数据的流
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
            options -= 10;//每次都减少10
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片
        return bitmap;

    }

        @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_camera:
                onOpenCamera();
                dialog.dismiss();
                break;
            case R.id.tv_picture:
                onOpenPicture();
                dialog.dismiss();
                break;
            case R.id.tv_cancel:
                dialog.dismiss();
                break;
        }
    }

    private void onOpenPicture() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, 2);
    }

    private void onOpenCamera() {
        if (Build.VERSION.SDK_INT >= 23) {
            int checkPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
            if (checkPermission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 100);
                return;
            } else {
                checkSDCard();
            }
        } else {
            checkSDCard();
        }
    }

    private void checkSDCard() {
        File file = Environment.getExternalStorageDirectory();
        if (file.exists()) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 1);
        } else {
            Toast.makeText(this, "SD卡不存在", Toast.LENGTH_LONG).show();
            return;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 100:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    onOpenCamera();
                } else {
                    Toast.makeText(this, "权限不够", Toast.LENGTH_LONG).show();
                    return;
                }
                break;
        }
    }
}
