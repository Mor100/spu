package com.spu.dong.spu.activity.demo;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spu.dong.spu.R;
import com.spu.dong.spu.activity.base.BaseFragment;

public class MyDemoThridFragment extends BaseFragment {


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getResourceId() {
        return R.layout.fragment_demo_third;
    }


    @Override
    public void loadData() {
        Log.i("dongdong,third","third加载数据");
    }

    @Override
    public void loadFirstData() {
        Log.i("dongdong,third","third加载第一次数据");
    }

    @Override
    public void stopLoadData() {
        Log.i("dongdong,third","third停止加载数据");
    }

    @Override
    public boolean getUserVisibleHint() {

        return super.getUserVisibleHint();
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }




    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void initView() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
