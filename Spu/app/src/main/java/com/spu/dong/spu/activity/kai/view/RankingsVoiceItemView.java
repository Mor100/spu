package com.spu.dong.spu.activity.kai.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.spu.dong.spu.R;


public class RankingsVoiceItemView extends RelativeLayout {
    private ImageView ivRankingsIcon;
    private TextView tvRankingsText;

    public RankingsVoiceItemView(Context context) {
        super(context);
    }

    public RankingsVoiceItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.rankings_voice_item_view,this);
        tvRankingsText = (TextView) findViewById(R.id.tv_rankings_text);
        ivRankingsIcon = (ImageView) findViewById(R.id.iv_rankings_icon);
        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.RankingsVoiceItemView);
        tvRankingsText.setText(array.getString(R.styleable.RankingsVoiceItemView_rankings_text));
        ivRankingsIcon.setImageDrawable(array.getDrawable(R.styleable.RankingsVoiceItemView_rankings_icon));

        array.recycle();

    }
}
