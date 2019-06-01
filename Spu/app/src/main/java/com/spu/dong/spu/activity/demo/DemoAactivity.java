package com.spu.dong.spu.activity.demo;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.spu.dong.spu.R;
import com.spu.dong.spu.activity.aidl.AddBookListener;
import com.spu.dong.spu.activity.aidl.Book;
import com.spu.dong.spu.activity.aidl.IBookManager;

import java.util.List;

public class DemoAactivity extends Activity {

    private IBookManager iBookManager;
    AddBookListener.Stub stub;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_demo_a);
        Button viewById = (Button) findViewById(R.id.btn_a);
        Button viewById2 = (Button) findViewById(R.id.btn_getlist);
        Button viewById3 = (Button) findViewById(R.id.btn_addlist);
        Button viewById4 = (Button) findViewById(R.id.btn_startB);

        stub = new AddBookListener.Stub() {
            @Override
            public void addOneBook(Book book) throws RemoteException {
                //应该发送给子线程去处理。这里简单点。
                Log.i("dongdong","我看下是什么书"+book.bookId+book.bookName);
            }
        };
        viewById4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(DemoAactivity.this,DemoBactivity.class));
                //解除绑定
                try {
                    iBookManager.unRegistAddBookListener(stub);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        viewById2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    List<Book> bookList = iBookManager.getBookList();
                    Log.i("dongodng",bookList.size()+"");
                }catch(Exception t ){
                    Log.i("dongdong","ipc失败");
                }

            }
        });
        viewById3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                     iBookManager.addBook(new Book(11,"好书"));
                }catch(Exception t ){
                    Log.i("dongdong","ipc失败");
                }

            }
        });
        final ServiceConnection serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

                iBookManager = IBookManager.Stub.asInterface(iBinder);

                try {
                    iBookManager.registAddBookListener(stub);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        };
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(DemoAactivity.this,DemoBactivity.class));

                //进程间通信
                Intent intent = new Intent(DemoAactivity.this,MyService.class);
                boolean b = bindService(intent, serviceConnection, Service.BIND_AUTO_CREATE);

                //绑定服务后。注册一下监听


            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("dongdong","AAA启动了一次saveinstance");
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
