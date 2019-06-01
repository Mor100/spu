package com.spu.dong.spu.activity.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.spu.dong.spu.R;
import com.spu.dong.spu.activity.activity.PeolpeActivity;
import com.spu.dong.spu.activity.activity.TipOffActivity;
import com.spu.dong.spu.activity.activity.WebActivity;
import com.spu.dong.spu.activity.base.Constant;
import com.spu.dong.spu.activity.model.TipOffBeans;
import com.spu.dong.spu.activity.viewhoder.MyViewHoderLeftPic;
import com.spu.dong.spu.activity.viewhoder.MyViewHoderTiltleTime;
import com.spu.dong.spu.activity.viewhoder.MyViewHoderTipImage;

import java.util.ArrayList;


public class MyRecyclerTipOffAdapter extends RecyclerView.Adapter {



    private ArrayList<TipOffBeans> listTitle;
    private Context mContext;


    public MyRecyclerTipOffAdapter(ArrayList<TipOffBeans> listTitle, Context context) {
        this.listTitle = listTitle;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == Constant.ITEM_HEAD_VIEWPAGER_FLAG) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_tip_off_iamge_title, parent, false);
            MyViewHoderTipImage myViewHoder = new MyViewHoderTipImage(inflate);
            return myViewHoder;
        } else if (viewType == Constant.ITEM_LEFT_IAMGE_FLAGE) {

            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_news_leftpic, parent, false);
            MyViewHoderLeftPic myViewHoder = new MyViewHoderLeftPic(inflate);
            return myViewHoder;
        } else {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_news_bottom_title_time, parent, false);
            MyViewHoderTiltleTime myViewHoderBigPic = new MyViewHoderTiltleTime(inflate);
            return myViewHoderBigPic;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof MyViewHoderTipImage) {
            ArrayList<ImageView> imagelist = new ArrayList<>();
            //第一个 添加头
            MyViewHoderTipImage myViewHoder = (MyViewHoderTipImage) holder;
            //myViewHoder.tvItemTipTopImage
            final TipOffBeans tipOffBeans = listTitle.get(position);
            Glide.with(mContext)
                    .load(tipOffBeans.imageurl)
                    .placeholder(R.drawable.nopic) //占位符
                    .error(R.drawable.nopic)       //错误占位符
                    .dontAnimate()//没有任何淡入淡出效果
                    .override(640, 428)//调整图片大小
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)//优先级
                    .into(myViewHoder.tvItemTipTopImage);
            myViewHoder.tvItemTipTopImage.setScaleType(ImageView.ScaleType.FIT_XY);
            myViewHoder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("dongdong","点击了大图片，要进打电话页面");
                    Intent intent = new Intent(mContext, TipOffActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("data",tipOffBeans);
                    intent.putExtras(bundle);
                    mContext.startActivity(intent);
                }
            });

        } else if (holder instanceof MyViewHoderLeftPic) {
            //左边图片 右边标题
            final MyViewHoderLeftPic myViewHoder = (MyViewHoderLeftPic) holder;
           final  TipOffBeans tipOffBeans = listTitle.get(position);
            Glide.with(mContext)
                    .load(tipOffBeans.imageurl)
                    .placeholder(R.drawable.nopic) //占位符
                    .error(R.drawable.nopic)       //错误占位符
                    .dontAnimate()//没有任何淡入淡出效果
                    .override(640, 428)//调整图片大小
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)//优先级
                    .into(myViewHoder.ivNewsRecyclerItemImage);
            myViewHoder.ivNewsRecyclerItemImage.setScaleType(ImageView.ScaleType.FIT_XY);
            //浏览量 加时间

            myViewHoder.tvNewsRecyclerItemTime.setText(tipOffBeans.brownum+"浏览   "+tipOffBeans.time);
            if(tipOffBeans.flag){
                myViewHoder.tvNewsRecyclerItemTitle.setTextColor(mContext.getResources().getColor(R.color.grey));
            }else{
                myViewHoder.tvNewsRecyclerItemTitle.setTextColor(mContext.getResources().getColor(R.color.text_black));
            }
            myViewHoder.tvNewsRecyclerItemTitle.setText(tipOffBeans.title);
            myViewHoder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listTitle.get(position).flag = true;
                    Log.i("dongdong", "recycler点击了" + position);
                    myViewHoder.tvNewsRecyclerItemTitle.setTextColor(mContext.getResources().getColor(R.color.grey));
                    Intent intent = new Intent(mContext, WebActivity.class);
                    intent.putExtra("url",tipOffBeans.contenturl);
                    mContext.startActivity(intent);
                }
            });
        } else {
            final MyViewHoderTiltleTime myViewHoder = (MyViewHoderTiltleTime) holder;
            final TipOffBeans tipOffBeans = listTitle.get(position);
            //时间
            myViewHoder.ivNewsRecyclerBigpicItemImage.setText(tipOffBeans.brownum+"浏览   "+tipOffBeans.time);
            if(tipOffBeans.flag){
                myViewHoder.tvNewsRecyclerBigpicItemTitle.setTextColor(mContext.getResources().getColor(R.color.grey));
            }else{
                myViewHoder.tvNewsRecyclerBigpicItemTitle.setTextColor(mContext.getResources().getColor(R.color.text_black));
            }
            myViewHoder.tvNewsRecyclerBigpicItemTitle.setText(tipOffBeans.title);
            myViewHoder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("dongdong", "recycler点击了" + position);
                    //字体设置为灰色 进入activity
                    listTitle.get(position).flag = true;
                    myViewHoder.tvNewsRecyclerBigpicItemTitle.setTextColor(mContext.getResources().getColor(R.color.grey));

                    Intent intent = new Intent(mContext, WebActivity.class);
                    intent.putExtra("url",tipOffBeans.contenturl);
                    mContext.startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return listTitle.size();

    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return Constant.ITEM_HEAD_VIEWPAGER_FLAG;
        } else if (!TextUtils.isEmpty(listTitle.get(position).imageurl)) {
            return Constant.ITEM_LEFT_IAMGE_FLAGE;
        } else {
            return Constant.ITEM_BIG_TITLE_TIME;
        }

    }






}
