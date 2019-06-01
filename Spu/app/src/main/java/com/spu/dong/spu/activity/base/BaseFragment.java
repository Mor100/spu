package com.spu.dong.spu.activity.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends LazyLoadFragment{

    //有两个方法的实现 交给子类


    private View rootView;
    public Unbinder unbinder;
    public Activity mActivity;
    public abstract int getResourceId();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;

    }

    // 重用view
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        if(rootView == null){
            View inflate = inflater.inflate(getResourceId(), container, false);
            rootView = inflate;

        }else{
            //防止复加载。
            ViewGroup parent = (ViewGroup)rootView.getParent();
            if(parent != null){
                parent.removeView(rootView);
            }

        }
        unbinder = ButterKnife.bind(this, rootView);
        initView();
        return rootView;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public abstract void initView();

}
