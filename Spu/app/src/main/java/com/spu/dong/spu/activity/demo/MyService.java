package com.spu.dong.spu.activity.demo;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.spu.dong.spu.activity.aidl.AddBookListener;
import com.spu.dong.spu.activity.aidl.Book;
import com.spu.dong.spu.activity.aidl.IBookManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        serviceList = new CopyOnWriteArrayList<>();
        addBookList = new RemoteCallbackList<>();
        Log.i("dongdong","创建了");
    }

    private boolean serviceFlage = false;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("dongdong","绑定了");
        serviceFlage = true;
        new Thread(new ServiceWork()).start();
        return stub;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        serviceFlage = false;
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        serviceFlage = false;
    }

    private CopyOnWriteArrayList<Book> serviceList;
    private RemoteCallbackList<AddBookListener> addBookList;
    IBookManager.Stub stub = new IBookManager.Stub(){

        @Override
        public List<Book> getBookList() throws RemoteException {
            return serviceList;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            serviceList.add(book);
        }

        @Override
        public void registAddBookListener(AddBookListener addBookListener) throws RemoteException {
            //有人注册了这个服务，就在服务端保存一下这个listener 添加新书的时候。调用list中的所有addBookListener
            addBookList.register(addBookListener);
        }

        @Override
        public void unRegistAddBookListener(AddBookListener addBookListener) throws RemoteException {
            addBookList.unregister(addBookListener);
        }
    };

    private class ServiceWork implements Runnable{

        @Override
        public void run() {

            try {
                //绑定了
                while (serviceFlage)  {


                Thread.sleep(5*1000);
                Book book = new Book(serviceList.size() + 1, "book#bookid" + (serviceList.size() + 1));
                //加本书
                serviceList.add(book);
                //监听的方法 都调用一下
                    int N = addBookList.beginBroadcast();
                    for (int i = 0;i<N;i++ ){
                        AddBookListener broadcastItem = addBookList.getBroadcastItem(i);
                        broadcastItem.addOneBook(book);
                    }
                    addBookList.finishBroadcast();//finishBroadCast 和 beginBroadcase 配对使用
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
