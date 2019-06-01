package com.spu.dong.spu.activity.kai.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.spu.dong.spu.R;


public class ItemView extends RelativeLayout {
    private TextView tvTitle;
    private ImageView ivIcon;
    public ItemView(Context context) {
        super(context);
    }

    public ItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.item_view,this);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        ivIcon = (ImageView) findViewById(R.id.iv_icon);

        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.ItemView);
        tvTitle.setText(array.getString(R.styleable.ItemView_title_text));
        ivIcon.setImageDrawable(array.getDrawable(R.styleable.ItemView_icon));
        array.recycle();
    }
}
