package com.spu.dong.spu.activity.activity;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Toast;

import com.chaychan.library.BottomBarLayout;
import com.spu.dong.spu.R;
import com.spu.dong.spu.activity.base.BaseFragment;
import com.spu.dong.spu.activity.cache.LocationCache;
import com.spu.dong.spu.activity.demo.FragmentAdapter;
import com.spu.dong.spu.activity.demo.MyDemoSecondFragment;
import com.spu.dong.spu.activity.demo.MyDemoThridFragment;
import com.spu.dong.spu.activity.demo.MyDemofifthFragment;
import com.spu.dong.spu.activity.demo.MyDemofouthFragment;
import com.spu.dong.spu.activity.flyn.Eyes;
import com.spu.dong.spu.activity.fragment.NewsFragment;
import com.spu.dong.spu.activity.fragment.TipOffFragment;
import com.spu.dong.spu.activity.model.News;
import com.spu.dong.spu.activity.utils.UIUtils;
import com.spu.dong.spu.activity.view.NoScrollViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.rv_main)
    NoScrollViewPager rvMain;
    @BindView(R.id.bbl_main)
    BottomBarLayout bblMain;
    private int[] mStatusColors = new int[]{
            R.color.colorRedDeep,
            R.color.status_color_grey,
    };
    private long mPreTime;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ArrayList<News> list = LocationCache.getLocationCache().getList();
        NewsFragment newsFragment = new NewsFragment();
        MyDemofouthFragment myDemofouthFragment = new MyDemofouthFragment();
        MyDemoSecondFragment myDemoSecondFragment = new MyDemoSecondFragment();
        TipOffFragment myDemoThridFragment = new TipOffFragment();
        MyDemofifthFragment myDemofifthFragment = new MyDemofifthFragment();
        ArrayList<BaseFragment> fragments = new ArrayList<>();
        fragments.add(newsFragment);//新闻页
        fragments.add(myDemoSecondFragment);//政务

        fragments.add(myDemofouthFragment);//服务
        fragments.add(myDemoThridFragment);//爆料页
        fragments.add(myDemofifthFragment);//我的
        FragmentAdapter fragmentAdapter = new FragmentAdapter(fragments, getSupportFragmentManager());

        rvMain.setAdapter(fragmentAdapter);
        rvMain.setOffscreenPageLimit(fragments.size());

        bblMain.setViewPager(rvMain);
        Eyes.setStatusBarColor(MainActivity.this, UIUtils.getColor(mStatusColors[0]));

//        //1.创建
//        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 3);
//        //2.修改属性值
//        valueAnimator.setDuration(3*1000);
//        valueAnimator.setRepeatMode(Animation.RESTART);
//        valueAnimator.setRepeatCount(Animation.INFINITE);
//        //3.设置监听
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                    //
//                int animatedValue = (int) valueAnimator.getAnimatedValue();
//
//                view.setProperty(animatedValue);//4将改变后的值赋给对象的属性值，下面会详细说明
//                view.requestlayout;//5刷新视图，即重新绘制，从而实现动画效果
//            }
//        });
//        valueAnimator.start();//6开始
    }


        @Override
        public void onBackPressed() {
            //如果是主页面
            if (System.currentTimeMillis() - mPreTime > 2000) {// 两次点击间隔大于2秒
//                UIUtils.showToast("再按一次，退出应用");
                Toast.makeText(this,"再按一次，退出应用",Toast.LENGTH_SHORT).show();
                mPreTime = System.currentTimeMillis();
                return;
            }
            super.onBackPressed();// finish()
    }


}
