package com.spu.dong.spu.activity.demo;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.spu.dong.spu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityDemo extends Activity {

//    @BindView(R.id.iv_animation_demo2)
//    ImageView ivAnimationDemo2;
//    @BindView(R.id.iv_animation_demo3)
//    ImageView ivAnimationDemo3;
//
//    @BindView(R.id.iv_animation_demo)
//    ImageView ivAnimaDemo;
//    @BindView(R.id.iv_animation_demo4)
//    ImageView ivAnimationDemo4;

    @BindView(R.id.iv_gov_peple_background1)
    ImageView ivGovPepleBackground1;
    @BindView(R.id.iv_gov_peple_background2)
    ImageView ivGovPepleBackground2;
//    @BindView(R.id.myview_demo)
//    MyView myviewDemo;
    @BindView(R.id.iv_animation_demo)
    ImageView ivAnimationDemo;
    @BindView(R.id.iv_animation_demo3)
    ImageView ivAnimationDemo3;
    @BindView(R.id.iv_animation_demo4)
    ImageView ivAnimationDemo4;
    @BindView(R.id.iv_animation_demo2)
    ImageView ivAnimationDemo2;
    @BindView(R.id.tv_demo_imageview)
    ImageView tvDemoImageview;

    @BindView(R.id.mvoa_demo)
    MyViewObjectAnimator mydemo;
    private AnimationSet animationSet;
    private AnimationSet animationSet2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.animationdemo);
        ButterKnife.bind(this);


        ValueAnimator color = ObjectAnimator.ofObject(mydemo, "color",new MyObjectEvaluator(), "#0000FF", "#FF0000");

        color.setDuration(8*1000);
        color.start();
        //做一个动画 从下向上。然后消失
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, -1f);
        translateAnimation.setDuration(1*1000);
        translateAnimation.setFillAfter(true);
        translateAnimation.setStartOffset(2*1000);



        AlphaAnimation alphaAnimation1 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation1.setDuration(1*1000);
        alphaAnimation1.setFillAfter(true);
        alphaAnimation1.setStartOffset(2*1000);

        ScaleAnimation scaleAnimation1 = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation1.setDuration(1*1000);
        scaleAnimation1.setFillAfter(true);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setFillAfter(true);
       // animationSet.addAnimation(alphaAnimation1);
        //从0-1 扩到整个布局 然后消失

        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(scaleAnimation1);
        animationSet.setInterpolator(new AccelerateDecelerateInterpolator());

        tvDemoImageview.startAnimation(animationSet);
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.demo_alpha);
//
//        animation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                //动画结束后 调用
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });

        //ivAnimaDemo.startAnimation(animation);

        //支付宝咻咻咻。 中间一个图。透明度依次改变。两个圆 放大 透明

//        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.5f);//中间按钮
//        alphaAnimation.setDuration(2*1000);//两秒
//        ivAnimaDemo.startAnimation(alphaAnimation);
//        //两个圆 放大 同时变透明
//
//        final AnimationSet animationSet = new AnimationSet(true);
//        final AnimationSet animationSet2 = new AnimationSet(true);
//
//        AlphaAnimation alphaAnimation1 = new AlphaAnimation(1.0f, 0.0f);
//        alphaAnimation1.setDuration(2*1000);
//        alphaAnimation1.setRepeatCount(Animation.INFINITE);//无限循环
//
//        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
//        alphaAnimation2.setDuration(2*1000);
//       // alphaAnimation2.set
//        //alphaAnimation2.setRepeatMode(Animation.INFINITE);//无限循环
//        alphaAnimation2.setRepeatCount(Animation.INFINITE);
//
//
//        //放大一倍
//        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//        scaleAnimation.setDuration(2*1000);
//        scaleAnimation.setRepeatCount(Animation.INFINITE);
//
//        //放大一倍
//        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//        scaleAnimation2.setDuration(2*1000);
//        scaleAnimation2.setRepeatCount(Animation.INFINITE);
//
//        animationSet.addAnimation(alphaAnimation1);
//        animationSet.addAnimation(scaleAnimation);
//        animationSet.setInterpolator(new LinearInterpolator());
//
//        animationSet2.addAnimation(alphaAnimation2);
//        animationSet2.addAnimation(scaleAnimation2);
//        animationSet2.setInterpolator(new LinearInterpolator());
//
//       ivAnimationDemo2.startAnimation(animationSet);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                ivAnimationDemo3.startAnimation(animationSet2);
//            }
//        },1*1000);
//        AnimationSet animationSet = new AnimationSet(true);
//        final AnimationSet animationSet2 = new AnimationSet(true);
//

        this.animationSet = new AnimationSet(true);
        animationSet2 = new AnimationSet(true);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0.65f, 0.0f);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.65f, 0.0f);
        alphaAnimation.setDuration(2 * 1000);
        alphaAnimation2.setDuration(2 * 1000);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation2.setRepeatCount(Animation.INFINITE);

        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.7f, 1.0f, 1.7f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 1.7f, 1.0f, 1.7f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(2 * 1000);
        scaleAnimation2.setDuration(2 * 1000);
        scaleAnimation.setRepeatCount(Animation.INFINITE);
        scaleAnimation2.setRepeatCount(Animation.INFINITE);

        this.animationSet.addAnimation(alphaAnimation);
        this.animationSet.addAnimation(scaleAnimation);

        animationSet2.addAnimation(alphaAnimation2);
        animationSet2.addAnimation(scaleAnimation2);

        this.animationSet.setInterpolator(new LinearInterpolator());
        animationSet2.setInterpolator(new LinearInterpolator());
        ivGovPepleBackground1.startAnimation(this.animationSet);
        handler.sendEmptyMessageDelayed(111, 1 * 1000);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                ivGovPepleBackground1.startAnimation(animationSet);
//                Log.i("dongdongqidong","延迟两秒启动");
//            }
//        }, 2 * 1000);
//        Log.i("dongdongqidong","应该启动延迟1秒启动");
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                ivGovPepleBackground2.startAnimation(animationSet2);
//                Log.i("dongdongqidong","延迟一秒启动");
//            }
//        }, 1 * 1000);

        ivGovPepleBackground1.startAnimation(this.animationSet);
        ivGovPepleBackground2.startAnimation(animationSet2);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ivGovPepleBackground2.startAnimation(animationSet2);
        }
    };
}
