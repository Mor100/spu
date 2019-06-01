package com.spu.dong.spu.activity.demo;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.view.ViewPager;
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
import com.spu.dong.spu.activity.adapter.PagerAdaptetCallback;
import com.spu.dong.spu.activity.base.Constant;
import com.spu.dong.spu.activity.model.News;
import com.spu.dong.spu.activity.view.AutoPlayViewPager;
import com.spu.dong.spu.activity.viewhoder.MyViewHoderBigPic;
import com.spu.dong.spu.activity.viewhoder.MyViewHoderLeftPic;
import com.spu.dong.spu.activity.viewhoder.MyViewHoderViewPager;
import java.util.ArrayList;
public class MyRecyclerAdapter extends RecyclerView.Adapter {
    private ArrayList<News> listTitle;
    private Context mContext;

    private AutoPlayViewPager mViewPager;

    public MyRecyclerAdapter(ArrayList<News> listTitle, Context context) {
        this.listTitle = listTitle;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == Constant.ITEM_HEAD_VIEWPAGER_FLAG) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_demo_viewpager, parent, false);
            MyViewHoderViewPager myViewHoder = new MyViewHoderViewPager(inflate);
            mViewPager = myViewHoder.textviewpager;
            Log.i("dongdong", "轮播viewpager赋值成功");
            return myViewHoder;
        } else if (viewType == Constant.ITEM_LEFT_IAMGE_FLAGE) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_news_leftpic, parent, false);
            MyViewHoderLeftPic myViewHoder = new MyViewHoderLeftPic(inflate);
            return myViewHoder;
        } else {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_news_bottom_bigpic, parent, false);
            MyViewHoderBigPic myViewHoderBigPic = new MyViewHoderBigPic(inflate);
            return myViewHoderBigPic;
        }

    }

    private int num = 4 ;
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof MyViewHoderViewPager) {

            int size = listTitle.size();


            ArrayList<ImageView> imagelist = new ArrayList<>();
            //第一个 添加头
            final MyViewHoderViewPager myViewHoder = (MyViewHoderViewPager) holder;

            for (int i = 0;i<num;i++){
                ImageView imageView4 = new ImageView(mContext);

                Glide.with(mContext)
                        .load(listTitle.get(i).imageurl)
                        .placeholder(R.drawable.nopic) //占位符
                        .error(R.drawable.nopic)       //错误占位符
                        .dontAnimate()//没有任何淡入淡出效果
                        .override(640, 428)//调整图片大小
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .priority(Priority.HIGH)//优先级
                        .into(imageView4);
                imageView4.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                imageView4.setScaleType(ImageView.ScaleType.FIT_XY);
                imagelist.add(imageView4);
            }
            MyPagerAdapter myPagerAdapter = new MyPagerAdapter(mContext,imagelist,listTitle, new PagerAdaptetCallback() {
                @Override
                public void onCallbackStart() {
                    myViewHoder.textviewpager.start();
                }

                @Override
                public void onCallbackStop() {
                    myViewHoder.textviewpager.stop();
                }
            });
            myViewHoder.textviewpager.setAdapter(myPagerAdapter);
            mViewPager = myViewHoder.textviewpager;

            myViewHoder.textviewpager.setCurrentItem(myPagerAdapter.getCountTrue() * 100);
            Log.i("dongdong", "轮播viewpager赋值成功");

            //设置title
            myViewHoder.textviewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                @Override
                public void onPageSelected(int position) {
                    //改变了
                    myViewHoder.tvVGTitle.setText(listTitle.get(position % num).title);
                    //修改小圆点
                    myViewHoder.tvVpNum.setText((position % 4) + 1 + "");
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                }
            });
        } else if (holder instanceof MyViewHoderLeftPic) {
            //左边图片 右边标题
            final MyViewHoderLeftPic myViewHoder = (MyViewHoderLeftPic) holder;
            final News news = listTitle.get(position + num-1);
            myViewHoder.tvNewsRecyclerItemTitle.setText(news.title);
            //myViewHoder.tvNewsRecyclerItemTime.setText(news.time);
            myViewHoder.tvNewsRecyclerItemTime.setVisibility(View.GONE);
            Glide.with(mContext)
                    .load(news.imageurl)
                    .placeholder(R.drawable.nopic) //占位符
                    .error(R.drawable.nopic)       //错误占位符
                    .dontAnimate()//没有任何淡入淡出效果
                    .override(640, 428)//调整图片大小
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)//优先级
                    .into(myViewHoder.ivNewsRecyclerItemImage);
            if(news.flag){
                myViewHoder.tvNewsRecyclerItemTitle.setTextColor(mContext.getResources().getColor(R.color.grey));
            }else{
                myViewHoder.tvNewsRecyclerItemTitle.setTextColor(mContext.getResources().getColor(R.color.text_black));
            }
            myViewHoder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listTitle.get(position + num-1).flag = true;
                    Log.i("dongdong", "recycler点击了" + position);
                    myViewHoder.tvNewsRecyclerItemTitle.setTextColor(mContext.getResources().getColor(R.color.grey));

                    Intent intent = new Intent(mContext, WebActivity.class);
                    intent.putExtra("url",news.contenturl);
                    mContext.startActivity(intent);
                }
            });
        } else {
            final MyViewHoderBigPic myViewHoder = (MyViewHoderBigPic) holder;
            final News news = listTitle.get(position + num-1);
            Glide.with(mContext)
                    .load(news.imageurl)
                    .placeholder(R.drawable.nopic) //占位符
                    .error(R.drawable.nopic)       //错误占位符
                    .dontAnimate()//没有任何淡入淡出效果
                    .override(640, 428)//调整图片大小
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)//优先级
                    .into(myViewHoder.ivNewsRecyclerBigpicItemImage);
            myViewHoder.tvNewsRecyclerBigpicItemTitle.setText(news.title);
            if(news.flag){
                myViewHoder.tvNewsRecyclerBigpicItemTitle.setTextColor(mContext.getResources().getColor(R.color.grey));
            }else{
                myViewHoder.tvNewsRecyclerBigpicItemTitle.setTextColor(mContext.getResources().getColor(R.color.text_black));
            }
            myViewHoder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listTitle.get(position + num-1).flag = true;
                    Log.i("dongdong", "recycler点击了" + position);
                    //字体设置为灰色 进入activity
                    myViewHoder.tvNewsRecyclerBigpicItemTitle.setTextColor(mContext.getResources().getColor(R.color.grey));
                    //传入url
                    Intent intent = new Intent(mContext, WebActivity.class);
                    intent.putExtra("url",news.contenturl);
                    mContext.startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {

        int size = listTitle.size();

        return size - 3;
    }

    public void startAdapter() {
        //view pager 开启轮播
        mViewPager.start();
    }

    public void stopAdapter() {
        //停止轮播
        mViewPager.stop();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return Constant.ITEM_HEAD_VIEWPAGER_FLAG;
        } else if (position %5 != 0) {
            return Constant.ITEM_LEFT_IAMGE_FLAGE;
        } else {
            return Constant.ITEM_BOTTOM_IAMGE_FLAGE;
        }

    }






}
