package com.spu.dong.spu.activity.viewhoder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.spu.dong.spu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyViewHoderLeftPic extends RecyclerView.ViewHolder {
    @BindView(R.id.iv_news_recycler_item_image)
    public ImageView ivNewsRecyclerItemImage;
    @BindView(R.id.tv_news_recycler_item_title)
   public  TextView tvNewsRecyclerItemTitle;
    @BindView(R.id.iv_news_recycler_item_time)
    public TextView tvNewsRecyclerItemTime;
    @BindView(R.id.iv_news_recycler_item_top)
    public TextView tvNewsRecyclerItemTop;
    @BindView(R.id.iv_news_recycler_item_degree)
    public TextView tvNewsRecyclerItemDegree;

    public MyViewHoderLeftPic(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }
}
