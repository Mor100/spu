package com.spu.dong.spu.activity.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.spu.dong.spu.R;
import com.spu.dong.spu.activity.activity.WebActivity;
import com.spu.dong.spu.activity.base.Constant;
import com.spu.dong.spu.activity.model.News;
import com.spu.dong.spu.activity.viewhoder.MyViewHoderLeftPic;
import com.spu.dong.spu.activity.viewhoder.MyViewHoderTiltleTime;
import com.spu.dong.spu.activity.viewhoder.MyViewHoderTipImage;

import java.util.ArrayList;


public class MyRecyclerGovPowerContorlAdapter extends RecyclerView.Adapter {
    private ArrayList<News> listTitle;
    private Context mContext;
    public MyRecyclerGovPowerContorlAdapter(ArrayList<News> listTitle, Context context) {
        this.listTitle = listTitle;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == Constant.ITEM_HEAD_VIEWPAGER_FLAG) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_tip_off_iamge_title, parent, false);
            MyViewHoderTipImage myViewHoder = new MyViewHoderTipImage(inflate);
            return myViewHoder;
        }else if(viewType == Constant.ITEM_BIG_TITLE_TIME){
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_news_bottom_title_time, parent, false);
            MyViewHoderTiltleTime myViewHoder = new MyViewHoderTiltleTime(inflate);
            return myViewHoder;

        } else {

            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_news_leftpic, parent, false);
            MyViewHoderLeftPic myViewHoder = new MyViewHoderLeftPic(inflate);
            return myViewHoder;
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof MyViewHoderTipImage) {
            ArrayList<ImageView> imagelist = new ArrayList<>();
            //第一个 添加头
            MyViewHoderTipImage myViewHoder = (MyViewHoderTipImage) holder;
            //myViewHoder.tvItemTipTopImage
            myViewHoder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    News news = listTitle.get(position);
                    Intent intent = new Intent(mContext, WebActivity.class);
                    intent.putExtra("url",news.contenturl);
                    mContext.startActivity(intent);
                }
            });
        } else if(holder instanceof MyViewHoderLeftPic){
            //左边图片 右边标题
            final MyViewHoderLeftPic myViewHoder = (MyViewHoderLeftPic) holder;
            News news = listTitle.get(position);
            myViewHoder.tvNewsRecyclerItemTime.setText(news.time);
            myViewHoder.tvNewsRecyclerItemTitle.setText(news.title);
            if(news.flag){
                myViewHoder.tvNewsRecyclerItemTitle.setTextColor(mContext.getResources().getColor(R.color.grey));
            }else{
                myViewHoder.tvNewsRecyclerItemTitle.setTextColor(mContext.getResources().getColor(R.color.text_black));
            }
            myViewHoder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listTitle.get(position).flag = true;
                    Log.i("dongdong", "recycler点击了" + position);
                    myViewHoder.tvNewsRecyclerItemTitle.setTextColor(mContext.getResources().getColor(R.color.grey));
                    News news = listTitle.get(position);
                    Intent intent = new Intent(mContext, WebActivity.class);
                    intent.putExtra("url",news.contenturl);
                    mContext.startActivity(intent);
                }
            });


        }else{
            final MyViewHoderTiltleTime myViewHolder = (MyViewHoderTiltleTime) holder;
            News news = listTitle.get(position);
            myViewHolder.ivNewsRecyclerBigpicItemImage.setText(news.time);
            myViewHolder.tvNewsRecyclerBigpicItemTitle.setText(news.title);
            if(news.flag){
                myViewHolder.tvNewsRecyclerBigpicItemTitle.setTextColor(mContext.getResources().getColor(R.color.grey));
            }else{
                myViewHolder.tvNewsRecyclerBigpicItemTitle.setTextColor(mContext.getResources().getColor(R.color.text_black));
            }
            myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listTitle.get(position).flag = true;
                    Log.i("dongdong", "recycler点击了" + position);
                    myViewHolder.tvNewsRecyclerBigpicItemTitle.setTextColor(mContext.getResources().getColor(R.color.grey));
                    News news = listTitle.get(position);
                    Intent intent = new Intent(mContext, WebActivity.class);
                    intent.putExtra("url",news.contenturl);
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
        }else if(!listTitle.get(position).imageurl.equals("NULL")){
            return Constant.ITEM_LEFT_IAMGE_FLAGE;
        }else{
            return Constant.ITEM_BIG_TITLE_TIME;
        }

    }






}
