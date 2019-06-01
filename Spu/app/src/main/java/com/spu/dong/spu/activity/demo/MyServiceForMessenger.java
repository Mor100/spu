package com.spu.dong.spu.activity.demo;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.spu.dong.spu.activity.aidl.Book;
import com.spu.dong.spu.activity.aidl.IBookManager;
import com.spu.dong.spu.activity.base.Constant;

import java.util.ArrayList;
import java.util.List;

public class MyServiceForMessenger extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        serviceList = new ArrayList<>();
        Log.i("dongdong","创建了");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("dongdong","绑定了");
        return stub.getBinder();
    }

    private List<Book> serviceList;
  public class MyMessenger extends Handler{
      @Override
      public void handleMessage(Message msg) {
          switch(msg.what){

              case Constant.MSG_FROM_CLIENT:
                  String msg1 = msg.getData().getString("msg");
                  Log.i("dongdong",msg1);
                  Messenger replyTo = msg.replyTo;
                  Message obtain = Message.obtain(null, Constant.MSG_FROM_CLIENT);
                  Bundle bundle = new Bundle();
                  bundle.putString("delay","收到了，但是回复你好麻烦");
                  obtain.setData(bundle);
                  try {
                      replyTo.send(obtain);
                  } catch (RemoteException e) {
                      e.printStackTrace();
                  }
                  break;

              default:
                  super.handleMessage(msg);
          }

      }
  }
    Messenger stub = new Messenger(new MyMessenger());
}
