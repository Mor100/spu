package com.spu.dong.spu.activity.kai.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.spu.dong.spu.R;


public class CustomButton extends RelativeLayout {
    private TextView tvText;

    public CustomButton(Context context) {
        super(context);
    }

    public CustomButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.button_custom,this);
        tvText = (TextView) findViewById(R.id.tv_text);

        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.CustomButton);
        String text = array.getString(R.styleable.CustomButton_text);
        tvText.setText(text);
        array.recycle();
    }

    public CustomButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
