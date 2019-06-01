package com.spu.dong.spu.activity.kai.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.spu.dong.spu.R;


public class ItemViewVertical extends RelativeLayout {
    private ImageView iv_icon;
    private TextView tv_title;

    public ItemViewVertical(Context context) {
        super(context);
    }

    public ItemViewVertical(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.item_view_vertical,this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        iv_icon = (ImageView) findViewById(R.id.iv_icon);
        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.ItemViewVertical);
        tv_title.setText(array.getString(R.styleable.ItemViewVertical_title_text_vertical));
        iv_icon.setImageDrawable(array.getDrawable(R.styleable.ItemViewVertical_icon_vertical));
        array.recycle();
    }
}
