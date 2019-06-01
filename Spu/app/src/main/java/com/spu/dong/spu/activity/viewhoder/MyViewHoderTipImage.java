package com.spu.dong.spu.activity.viewhoder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.spu.dong.spu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyViewHoderTipImage extends RecyclerView.ViewHolder {
    @BindView(R.id.iv_item_tip_top_image)
    public ImageView tvItemTipTopImage;
    public MyViewHoderTipImage(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }
}