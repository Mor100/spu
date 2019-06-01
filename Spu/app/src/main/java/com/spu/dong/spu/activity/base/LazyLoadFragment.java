package com.spu.dong.spu.activity.base;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

//
public abstract  class LazyLoadFragment extends Fragment {


    private boolean isFirstIn = true;
    private boolean isVisiable = false;
    private View viewRoot = null;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(viewRoot == null){
            return;//未初始化完毕。
        }
        //可见 判断是否时第一次进
        if(isVisibleToUser && isFirstIn){
            isFirstIn = false;
            isVisiable = true;
            loadFirstData();
            return;
        }

        if(isVisibleToUser && (!isVisiable)){
            isVisiable = true;
            //不可见转可见
            loadData();
            return;
        }else{
            //可见转可见 不操作。
        }

        //false 状态可见时
        if((!isVisibleToUser) && isVisiable){
            isVisiable = false;
            //可见转不可见
            stopLoadData();
        }


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //主要是防止第一次进来 直接可见
        //防止view未加载完，先调用了上面的
        if(viewRoot == null){
            viewRoot = view;
        }
        boolean userVisibleHint = getUserVisibleHint();
        //是否可见

        if(userVisibleHint && isFirstIn){
            loadFirstData();
            isFirstIn = false;
            isVisiable = true;
        }else if(userVisibleHint &&(!isVisiable)){
            isVisiable = true;
            loadData();
        }
        //false 状态可见时
        if((!userVisibleHint) && isVisiable){
            isVisiable = false;
            //可见转不可见
            stopLoadData();
        }

        super.onViewCreated(view, savedInstanceState);
    }

    //网络加载
    public abstract void loadData();

    public abstract void loadFirstData();

    public abstract void stopLoadData();
    //重置变量

    @Override
    public void onDetach() {
        super.onDetach();

        isFirstIn = true;
        isVisiable = false;
        viewRoot = null;

    }
}
