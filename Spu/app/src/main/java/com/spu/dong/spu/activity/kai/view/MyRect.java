package com.spu.dong.spu.activity.kai.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.spu.dong.spu.R;


public class MyRect extends RelativeLayout {
    public MyRect(Context context) {
        super(context);
    }

    public MyRect(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.touxiang_view,this);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MyRect);
        array.recycle();
    }
}
