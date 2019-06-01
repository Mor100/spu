package com.spu.dong.spu.activity.demo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.io.Serializable;

public class MyViewSeriable extends android.support.v7.widget.AppCompatImageView implements Serializable{



    public MyViewSeriable(Context context) {
        super(context);
    }

    public MyViewSeriable(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewSeriable(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
