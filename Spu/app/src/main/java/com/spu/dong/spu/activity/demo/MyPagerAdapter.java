package com.spu.dong.spu.activity.demo;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import com.spu.dong.spu.activity.activity.WebActivity;
import com.spu.dong.spu.activity.adapter.PagerAdaptetCallback;
import com.spu.dong.spu.activity.model.News;

import java.util.ArrayList;


public class MyPagerAdapter extends PagerAdapter {


    private PagerAdaptetCallback callback;
    private ArrayList<ImageView> list;
    private ArrayList<News> listTitle;
    private Context context;
    public MyPagerAdapter(Context context, ArrayList<ImageView> list, ArrayList<News> listTitle, PagerAdaptetCallback callback){
        this.list = list;
        this.listTitle = listTitle;
        this.callback = callback;
        this.context = context;
    }
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }
    public int getCountTrue(){

        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;

    }

    int myposition =0 ;
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

      myposition = position%list.size();
        ImageView imageView = list.get(myposition);
        ViewGroup parent = (ViewGroup) imageView.getParent();
        if(parent != null){
            parent.removeView(imageView);
        }
        container.addView(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("dongdong","viewpager点击了"+position);

                int size = listTitle.size();
                int num = size - 10;
                if(size >=14){
                    num = 4;
                }
                if(size <10){
                    num = 0;
                }
                News news = listTitle.get(position%4);
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("url",news.contenturl);
                context.startActivity(intent);

            }
        });


        return imageView;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        int myposition = position % list.size();
        ViewParent parent = container.getParent();
        if(parent != null){
            container.removeView(list.get(myposition));
        }
    }


}


