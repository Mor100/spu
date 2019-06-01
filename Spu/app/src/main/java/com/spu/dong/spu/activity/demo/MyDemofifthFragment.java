package com.spu.dong.spu.activity.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.spu.dong.spu.R;
import com.spu.dong.spu.activity.base.BaseFragment;
import com.spu.dong.spu.activity.kai.activity.AboutUsActivity;
import com.spu.dong.spu.activity.kai.activity.SuggestionActivity;
import com.spu.dong.spu.activity.kai.view.CustomButton;
import com.spu.dong.spu.activity.kai.view.CustomButton2;
import com.spu.dong.spu.activity.kai.view.CustomButton3;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MyDemofifthFragment extends BaseFragment {


    @BindView(R.id.btn_clear_cache)
    CustomButton btnClearCache;
    @BindView(R.id.btn_suggestion)
    CustomButton2 btnSuggestion;
    @BindView(R.id.btn_about_us)
    CustomButton3 btnAboutUs;


    @OnClick(R.id.btn_clear_cache)
    public void cleanCache(){
        TextView tvCache = (TextView) btnClearCache.findViewById(R.id.tv_cache);
        tvCache.setText("00.00MB");
    }
    @OnClick(R.id.btn_suggestion)
    public void goSuggestion(){
        startActivity(new Intent(mActivity,SuggestionActivity.class));
    }
    @OnClick(R.id.btn_about_us)
    public  void aboutUs(){
        startActivity(new Intent(mActivity,AboutUsActivity.class));
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void loadData() {
        Log.i("dongdong,fift", "fifth加载数据");
    }

    @Override
    public void loadFirstData() {
        Log.i("dongdong,fift", "fifth加载第一次数据");
    }

    @Override
    public void stopLoadData() {
        Log.i("dongdong,fift", "fift停止加载数据");
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
        unbinder.unbind();
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

    @Override
    public int getResourceId() {
        return R.layout.activity_main_kai;
    }

}
