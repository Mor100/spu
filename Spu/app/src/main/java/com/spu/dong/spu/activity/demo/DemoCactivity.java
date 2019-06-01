package com.spu.dong.spu.activity.demo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.spu.dong.spu.R;

public class DemoCactivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_demo_a);
        Button viewById = (Button) findViewById(R.id.btn_a);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent intent = new Intent("android.intent.action.SEND") ;
//               // intent.setDataAndType(Uri.parse("http"),"image/jpg");
//                intent.setDataAndType(Uri.parse("content:"),"imamge/jpn");
//                ComponentName componentName = intent.resolveActivity(getPackageManager());
                startActivity(new Intent(DemoCactivity.this,DemoBactivity.class));
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("dongdong","ccc启动了一次start");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("dongdong","ccc启动了一次restart");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("dongdong","ccc启动了一次onNewIntent");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("dongdong","ccc启动了一次onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("dongdong","ccc启动了一次onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("dongdong","ccc启动了一次onStop");
    }

}
