package com.spu.dong.spu.activity.demo;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RadioButton;

import com.spu.dong.spu.R;
import com.spu.dong.spu.activity.model.Point;

public class MyView extends View {

    private float RADUS = 200;//半径
    private MyView view;
    private Paint paint;
    private Point point;
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if(point == null){
            //
            point = new Point(100.0f,100.0f);
            paint = new Paint();
            paint.setColor(Color.BLUE);
            canvas.drawCircle(RADUS,RADUS, RADUS,paint);

            ValueAnimator valueAnimator = ValueAnimator.ofObject(new MyEvaluator(), new Point(100f, 100f), new Point(700f, 700f));
            valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
            valueAnimator.setDuration(3*1000);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {

                     point = (Point) valueAnimator.getAnimatedValue();
                     invalidate();
                }
            });
            valueAnimator.start();
        }else{
            //重新绘制
            canvas.drawCircle(point.getX(),point.getY(), RADUS,paint);
        }
        super.onDraw(canvas);
    }
}
