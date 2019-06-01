package com.spu.dong.spu.activity.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MyViewObjectAnimator extends View {

    private Paint paint;

    public MyViewObjectAnimator(Context context) {
        this(context,null);
    }

    public MyViewObjectAnimator(Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);

        paint = new Paint();
    }

    public MyViewObjectAnimator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {


        super(context, attrs, defStyleAttr);
    }

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        //设置颜色
        paint.setColor(Color.parseColor(this.color));
        //调用OnDraw 重新绘图
        invalidate();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(200,200,60,paint);
    }

}
