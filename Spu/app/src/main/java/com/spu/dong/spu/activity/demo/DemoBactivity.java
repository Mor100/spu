package com.spu.dong.spu.activity.demo;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.spu.dong.spu.R;
import com.spu.dong.spu.activity.aidl.IBookManager;
import com.spu.dong.spu.activity.base.Constant;

public class DemoBactivity extends Activity {

    private Messenger messenger;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_demo_a);
        Button viewById = (Button) findViewById(R.id.btn_a);
        Button viewById2 = (Button) findViewById(R.id.btn_getlist);
        Button viewById3 = (Button) findViewById(R.id.btn_addlist);
        Button viewById4 = (Button) findViewById(R.id.btn_startB);

        viewById2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Message obtain = Message.obtain(null, Constant.MSG_FROM_CLIENT);
                Bundle bundle = new Bundle();
                bundle.putString("msg","这里是dongdongdemo发送的信息，服务端收到了吗");
                obtain.setData(bundle);
                obtain.replyTo = Bmessenger;
                try{
                    messenger.send(obtain);
                }catch(Exception t){

                }

            }
        });
        final ServiceConnection serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                messenger = new Messenger(iBinder);

            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        };
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  startActivity(new Intent(DemoBactivity.this,DemoCactivity.class));

                bindService(new Intent(DemoBactivity.this,MyServiceForMessenger.class),serviceConnection, Service.BIND_AUTO_CREATE);
            }
        });
    }

    private Messenger Bmessenger = new Messenger(new MyMessendClientHandler());
    class MyMessendClientHandler extends Handler{

        @Override
        public void handleMessage(Message msg) {


            switch (msg.what){
                case Constant.MSG_FROM_CLIENT:

                    String delay = msg.getData().getString("delay");
                    Log.i("dongdong",delay);

                    break;
                    default:
                        super.handleMessage(msg);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("dongdong","BBB启动了一次start");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("dongdong","BBB启动了一次restart");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("dongdong","BBB启动了一次onNewIntent");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("dongdong","BBB启动了一次onResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("dongdong","BBB启动了一次onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("dongdong","BBB启动了一次onRestoreInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("dongdong","BBB启动了一次onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("dongdong","BBB启动了一次onStop");
    }

}
