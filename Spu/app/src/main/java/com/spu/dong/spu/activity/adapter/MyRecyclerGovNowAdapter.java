package com.spu.dong.spu.activity.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
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
import com.spu.dong.spu.activity.activity.WebActivity;
import com.spu.dong.spu.activity.base.Constant;
import com.spu.dong.spu.activity.model.Nows;
import com.spu.dong.spu.activity.viewhoder.MyViewHoderLeftPic;
import com.spu.dong.spu.activity.viewhoder.MyViewHoderTiltleTime;
import com.spu.dong.spu.activity.viewhoder.MyViewHoderTipImage;

import java.util.ArrayList;


public class MyRecyclerGovNowAdapter extends RecyclerView.Adapter {

    private ArrayList<Nows> listTitle;
    private Context mContext;
    public MyRecyclerGovNowAdapter(ArrayList<Nows> listTitle, Context context) {
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
            Nows nows = listTitle.get(position);
            ArrayList<ImageView> imagelist = new ArrayList<>();
            //第一个 添加头
            MyViewHoderTipImage myViewHoder = (MyViewHoderTipImage) holder;
            myViewHoder.tvItemTipTopImage.setScaleType(ImageView.ScaleType.FIT_XY);
            myViewHoder.tvItemTipTopImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.minsheng));
            //myViewHoder.tvItemTipTopImage
            myViewHoder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Log.i("dongdong","点击了大图片，进入webview");
                    Intent intent = new Intent(mContext, WebActivity.class);
                    intent.putExtra("url","https://shimo.im/docs/hrwNorn6slQ2fNsv");
                    mContext.startActivity(intent);
                }
            });

        } else if (holder instanceof MyViewHoderLeftPic) {
            Nows nows = listTitle.get(position);
            //左边图片 右边标题
            final MyViewHoderLeftPic myViewHoder = (MyViewHoderLeftPic) holder;
            //拼接时间和 单位 赋值给时间
            StringBuffer sb = new StringBuffer();
            if(nows.gov.equals("NULL")){
                sb.append(nows.time);
            }else{
                sb.append(nows.gov).append("  ").append(nows.time);
            }

            ImageView imageView4 = new ImageView(mContext);

            Glide.with(mContext)
                    .load(nows.imageurl)
                    .placeholder(R.drawable.nopic) //占位符
                    .error(R.drawable.nopic)       //错误占位符
                    .dontAnimate()//没有任何淡入淡出效果
                    .override(640, 428)//调整图片大小
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)//优先级
                    .into(myViewHoder.ivNewsRecyclerItemImage);
            myViewHoder.ivNewsRecyclerItemImage.setScaleType(ImageView.ScaleType.FIT_XY);

            myViewHoder.tvNewsRecyclerItemTime.setText(sb.toString());
            myViewHoder.tvNewsRecyclerItemTitle.setText(nows.title);
            if(nows.flag){
                myViewHoder.tvNewsRecyclerItemTitle.setTextColor(mContext.getResources().getColor(R.color.grey));
            }else{
                myViewHoder.tvNewsRecyclerItemTitle.setTextColor(mContext.getResources().getColor(R.color.text_black));
            }
            myViewHoder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listTitle.get(position).flag = true;
                    Log.i("dongdong", "recycler点击了" + position);
                    //字体设置为灰色 进入activity
                    myViewHoder.tvNewsRecyclerItemTitle.setTextColor(mContext.getResources().getColor(R.color.grey));
                    Intent intent = new Intent(mContext, PeolpeActivity.class);
                    intent.putExtra("num",position+"");
                    mContext.startActivity(intent);

                }
            });

            if(position == 1 || position == 2){
                //显示置顶按钮
                myViewHoder.tvNewsRecyclerItemTop.setVisibility(View.VISIBLE);
            }else{
                myViewHoder.tvNewsRecyclerItemTop.setVisibility(View.GONE);
            }
            myViewHoder.tvNewsRecyclerItemDegree.setVisibility(View.VISIBLE);


            if(nows.dealflag.equals("已审核")){
                //已审核
                myViewHoder.tvNewsRecyclerItemDegree.setBackground(mContext.getResources().getDrawable(R.drawable.shape_gov_nows_red));
                myViewHoder.tvNewsRecyclerItemDegree.setTextColor(mContext.getResources().getColor(R.color.status_color_red));
                myViewHoder.tvNewsRecyclerItemDegree.setText("已审核");
            }else if(nows.dealflag.equals("已办结")){
                //已办结
                myViewHoder.tvNewsRecyclerItemDegree.setBackground(mContext.getResources().getDrawable(R.drawable.shape_gov_nows_green));
                myViewHoder.tvNewsRecyclerItemDegree.setTextColor(mContext.getResources().getColor(R.color.SeaGreen));
                myViewHoder.tvNewsRecyclerItemDegree.setText("已办结");
            }else{
                //已转办
                myViewHoder.tvNewsRecyclerItemDegree.setBackground(mContext.getResources().getDrawable(R.drawable.shape_gov_nows_blue));
                myViewHoder.tvNewsRecyclerItemDegree.setTextColor(mContext.getResources().getColor(R.color.colorPrimaryDark));
                myViewHoder.tvNewsRecyclerItemDegree.setText("已转办");
            }


        } else {
            Nows nows = listTitle.get(position);
            StringBuffer sb = new StringBuffer();
            if(nows.gov.equals("NULL")){
                sb.append(nows.time);
            }else{
                sb.append(nows.gov).append("  ").append(nows.time);
            }
            final MyViewHoderTiltleTime myViewHoder = (MyViewHoderTiltleTime) holder;
            myViewHoder.ivNewsRecyclerBigpicItemImage.setText(sb.toString());
            myViewHoder.tvNewsRecyclerBigpicItemTitle.setText(nows.title);
            if(nows.flag){
                myViewHoder.tvNewsRecyclerBigpicItemTitle.setTextColor(mContext.getResources().getColor(R.color.grey));
            }else{
                myViewHoder.tvNewsRecyclerBigpicItemTitle.setTextColor(mContext.getResources().getColor(R.color.text_black));
            }
            myViewHoder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listTitle.get(position).flag = true;
                    Log.i("dongdong", "recycler点击了" + position);
                    //字体设置为灰色 进入activity
                    myViewHoder.tvNewsRecyclerBigpicItemTitle.setTextColor(mContext.getResources().getColor(R.color.grey));
                    Intent intent = new Intent(mContext, PeolpeActivity.class);
                    intent.putExtra("num",position+"");
                    mContext.startActivity(intent);
                }
            });
            if(position == 1 || position == 2){
                //显示置顶按钮
                myViewHoder.getTvNewsRecyclerBigpicItemTitleTop.setVisibility(View.VISIBLE);
            }else{
                myViewHoder.getTvNewsRecyclerBigpicItemTitleTop.setVisibility(View.GONE);
            }
            myViewHoder.getTvNewsRecyclerBigpicItemTitleGegree.setVisibility(View.VISIBLE);
            if(nows.dealflag.equals("已审核")){
                //已审核
                myViewHoder.getTvNewsRecyclerBigpicItemTitleGegree.setBackground(mContext.getResources().getDrawable(R.drawable.shape_gov_nows_red));
                myViewHoder.getTvNewsRecyclerBigpicItemTitleGegree.setTextColor(mContext.getResources().getColor(R.color.status_color_red));
                myViewHoder.getTvNewsRecyclerBigpicItemTitleGegree.setText("已审核");
            }else if(nows.dealflag.equals("已办结")){
                //已办结
                myViewHoder.getTvNewsRecyclerBigpicItemTitleGegree.setBackground(mContext.getResources().getDrawable(R.drawable.shape_gov_nows_green));
                myViewHoder.getTvNewsRecyclerBigpicItemTitleGegree.setTextColor(mContext.getResources().getColor(R.color.SeaGreen));
                myViewHoder.getTvNewsRecyclerBigpicItemTitleGegree.setText("已办结");
            }else{
                //已转办
                myViewHoder.getTvNewsRecyclerBigpicItemTitleGegree.setBackground(mContext.getResources().getDrawable(R.drawable.shape_gov_nows_blue));
                myViewHoder.getTvNewsRecyclerBigpicItemTitleGegree.setTextColor(mContext.getResources().getColor(R.color.colorPrimaryDark));
                myViewHoder.getTvNewsRecyclerBigpicItemTitleGegree.setText("已转办");
            }
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
        } else if (!listTitle.get(position).imageurl.equals("NULL")) {
            //有图
            return Constant.ITEM_LEFT_IAMGE_FLAGE;
        } else {
            return Constant.ITEM_BIG_TITLE_TIME;
        }

    }






}
