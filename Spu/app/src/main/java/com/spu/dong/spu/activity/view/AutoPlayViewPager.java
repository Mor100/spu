package com.spu.dong.spu.activity.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class AutoPlayViewPager extends ViewPager {

    public AutoPlayViewPager(Context context) {
        super(context);
    }

    public AutoPlayViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i("dongdong","我可见");
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i("dongdong","我不可见");
    }

    /**
     * 播放时间
     */
    private int showTime = 3 * 1000;
    /**
     * 滚动方向
     */
    private Direction direction = Direction.LEFT;
    /**
     * 设置播放时间，默认3秒
     *
     * @param showTimeMillis 毫秒
     */
    public void setShowTime(int showTimeMillis) {
        this.showTime = showTimeMillis; // 本文后期更新，demo中此处有误。
    }

//    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(ev.getAction() == MotionEvent.ACTION_DOWN){
            //这时 按下 停止播放
            Log.i("dongdong","应该停止");
            stop();
        }else if(ev.getAction() == MotionEvent.ACTION_UP){
            //开始播放
            Log.i("dongdong","应该继续");
            start();
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 设置滚动方向，默认向左滚动
     *
     * @param direction 方向
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * 开始
     */
    public void start() {
        stop();
        postDelayed(player, showTime);
        Log.i("dongdonglunbo","开始轮播");
    }

    /**
     * 停止
     */
    public void stop() {
        removeCallbacks(player);
        Log.i("dongdonglunbo","停止轮播");
    }

    /**
     * 播放上一个
     */
    public void previous() {
        if (direction == Direction.RIGHT) {
            play(Direction.LEFT);
        } else if (direction == Direction.LEFT) {
            play(Direction.RIGHT);
        }
    }

    /**
     * 播放下一个
     */
    public void next() {
        play(direction);
    }

    /**
     * 执行播放
     *
     * @param direction 播放方向
     */
    private synchronized void play(Direction direction) {
        PagerAdapter pagerAdapter = getAdapter();
        int count1 = pagerAdapter.getCount();

        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            int currentItem = getCurrentItem();
            switch (direction) {
                case LEFT:
                    currentItem++;
                    if (currentItem > count)
                        currentItem = 0;
                    break;
                case RIGHT:
                    currentItem--;
                    if (currentItem < 0)
                        currentItem = count;
                    break;
            }
            setCurrentItem(currentItem);
        }
        start();
    }


    /**
     * 播放器
     */
    private Runnable player = new Runnable() {
        @Override
        public void run() {
            play(direction);
        }
    };

    public enum Direction {
        /**
         * 向左行动，播放的应该是右边的
         */
        LEFT,
        /**
         * 向右行动，播放的应该是左边的
         */
        RIGHT
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        return super.onTouchEvent(ev);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {
//                if (state == SCROLL_STATE_IDLE)
//                    start();
//                else if (state == SCROLL_STATE_DRAGGING)
//                    stop();
            }
        });
    }
}
