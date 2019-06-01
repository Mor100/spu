package com.spu.dong.spu.activity.viewhoder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.spu.dong.spu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyViewHoderTiltleTime extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_news_recycler_bigpic_item_title)
   public  TextView tvNewsRecyclerBigpicItemTitle;
    @BindView(R.id.iv_news_recycler_bigpic_item_image)
    public TextView ivNewsRecyclerBigpicItemImage;
    @BindView(R.id.tv_news_recycler_bigpic_item_title_top)
    public TextView getTvNewsRecyclerBigpicItemTitleTop;
    @BindView(R.id.tv_news_recycler_bigpic_item_title_degree)
    public  TextView getTvNewsRecyclerBigpicItemTitleGegree;

    public MyViewHoderTiltleTime(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }

}