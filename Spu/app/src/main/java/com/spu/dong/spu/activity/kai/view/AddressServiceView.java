package com.spu.dong.spu.activity.kai.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.spu.dong.spu.R;


public class AddressServiceView extends RelativeLayout {
    private TextView tvAdress;

    public AddressServiceView(Context context) {
        super(context);
    }

    public AddressServiceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.address_service_view,this);
        tvAdress = (TextView) findViewById(R.id.tv_address);
        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.AddressServiceView);
        tvAdress.setText(array.getString(R.styleable.AddressServiceView_address_text));
        array.recycle();
    }
}
