package com.spu.dong.spu.activity.viewhoder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.spu.dong.spu.R;
import com.spu.dong.spu.activity.view.AutoPlayViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyViewHoderViewPager extends RecyclerView.ViewHolder {

    @BindView(R.id.tp_firstitem)
    public AutoPlayViewPager textviewpager;
    @BindView(R.id.tv_pv_title)
    public TextView tvVGTitle;
    @BindView(R.id.tv_vp_num)
    public TextView tvVpNum;

    public MyViewHoderViewPager(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }
}
