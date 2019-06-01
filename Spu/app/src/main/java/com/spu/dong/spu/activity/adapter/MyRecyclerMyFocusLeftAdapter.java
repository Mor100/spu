package com.spu.dong.spu.activity.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spu.dong.spu.R;
import com.spu.dong.spu.activity.activity.PeolpeActivity;
import com.spu.dong.spu.activity.activity.PeolpeMyQuestionActivity;
import com.spu.dong.spu.activity.model.MyQuestion;
import com.spu.dong.spu.activity.viewhoder.MyViewHoderQuestionLeft;
import com.spu.dong.spu.activity.viewhoder.MyViewHoderTiltleTime;

import java.util.ArrayList;


public class MyRecyclerMyFocusLeftAdapter extends RecyclerView.Adapter {
    private ArrayList<MyQuestion> listTitle;
    private Context mContext;
    public MyRecyclerMyFocusLeftAdapter(ArrayList<MyQuestion> listTitle, Context context) {
        this.listTitle = listTitle;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_myfocus, parent, false);
        MyViewHoderQuestionLeft myViewHoderBigPic = new MyViewHoderQuestionLeft(inflate);
            return myViewHoderBigPic;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            final MyViewHoderQuestionLeft myViewHoder = (MyViewHoderQuestionLeft) holder;

        myViewHoder.tvNewsRecyclerItemTitle.setText(listTitle.get(position).title);
        myViewHoder.ivNewsRecyclerItemContent.setText(listTitle.get(position).content);
            myViewHoder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //字体设置为灰色 进入activity
                    myViewHoder.tvNewsRecyclerItemTitle.setTextColor(mContext.getResources().getColor(R.color.grey));
                    myViewHoder.ivNewsRecyclerItemContent.setTextColor(mContext.getResources().getColor(R.color.grey));
                    Intent intent = new Intent(mContext, PeolpeMyQuestionActivity.class);
                    intent.putExtra("num",position+"");
                    mContext.startActivity(intent);


                }
            });
    }

    @Override
    public int getItemCount() {
        return listTitle.size();
    }

}
