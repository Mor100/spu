package com.spu.dong.spu.activity.viewhoder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.spu.dong.spu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyViewHoderQuestionLeft extends RecyclerView.ViewHolder {
    @BindView(R.id.iv_news_recycler_item_image)
    public ImageView tvNewsRecyclerItemImage;//左边的问
    @BindView(R.id.tv_news_recycler_item_title)
     public TextView tvNewsRecyclerItemTitle;//标题
    @BindView(R.id.tv_news_recycler_item_content)
    public TextView ivNewsRecyclerItemContent;//内容
    @BindView(R.id.iv_news_recycler_item_time)
    public TextView getTvNewsRecyclerItemTime;//时间

    public MyViewHoderQuestionLeft(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }
}