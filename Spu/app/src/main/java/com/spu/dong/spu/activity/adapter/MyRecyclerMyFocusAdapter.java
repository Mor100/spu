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
import com.spu.dong.spu.activity.activity.PeolpeActivity;
import com.spu.dong.spu.activity.base.Constant;
import com.spu.dong.spu.activity.model.MyQuestionFocus;
import com.spu.dong.spu.activity.viewhoder.MyViewHoderLeftPic;
import com.spu.dong.spu.activity.viewhoder.MyViewHoderTiltleTime;
import com.spu.dong.spu.activity.viewhoder.MyViewHoderTipImage;

import java.util.ArrayList;


public class MyRecyclerMyFocusAdapter extends RecyclerView.Adapter {
    private ArrayList<MyQuestionFocus> listTitle;
    private Context mContext;
    public MyRecyclerMyFocusAdapter(ArrayList<MyQuestionFocus> listTitle, Context context) {
        this.listTitle = listTitle;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_news_bottom_title_time, parent, false);
            MyViewHoderTiltleTime myViewHoderBigPic = new MyViewHoderTiltleTime(inflate);
            return myViewHoderBigPic;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final MyViewHoderTiltleTime myViewHoder = (MyViewHoderTiltleTime) holder;
        myViewHoder.tvNewsRecyclerBigpicItemTitle.setText(listTitle.get(position).title);
        myViewHoder.ivNewsRecyclerBigpicItemImage.setText(listTitle.get(position).content);
        myViewHoder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("dongdong", "recycler点击了" + position);
                //字体设置为灰色 进入activity
                myViewHoder.tvNewsRecyclerBigpicItemTitle.setTextColor(mContext.getResources().getColor(R.color.grey));

                Intent intent = new Intent(mContext, PeolpeActivity.class);
                intent.putExtra("num",position+"");
                intent.putExtra("flag","1");
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTitle.size();
    }

}
