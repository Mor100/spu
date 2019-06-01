package com.spu.dong.spu.activity.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.androidkun.xtablayout.XTabLayout;
import com.spu.dong.spu.R;
import com.spu.dong.spu.activity.activity.MyFocusActivity;
import com.spu.dong.spu.activity.base.BaseFragment;
import com.spu.dong.spu.activity.base.Constant;
import com.spu.dong.spu.activity.cache.LocationCache;
import com.spu.dong.spu.activity.fragment.GovNowFragment;
import com.spu.dong.spu.activity.fragment.GovPowerControlFragment;
import com.spu.dong.spu.activity.fragment.RankListFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class MyDemoSecondFragment extends BaseFragment {


    @BindView(R.id.ctb_news_tab)
    XTabLayout ctbNewsTab;
    @BindView(R.id.vp_news)
    ViewPager vpNews;
    @BindView(R.id.ll_gov_zheng)
    LinearLayout llGovZheng;
    @BindView(R.id.ll_gov_bu)
    LinearLayout llGovBu;
    @BindView(R.id.rb_gov_zheng)
    RadioButton rbGovZheng;
    @BindView(R.id.rb_gov_bu)
    RadioButton rbGovBu;
    @BindView(R.id.rg_gov)
    RadioGroup rgGov;

    @BindView(R.id.rl_gov_people)
    RelativeLayout rlGovPeople;
    @BindView(R.id.iv_gov_myfocus)
    ImageView ivGovFocus;
    @OnClick(R.id.iv_gov_myfocus)
    public void startMyFocus(){

        startActivity(new Intent(mActivity, MyFocusActivity.class));

    }

    public void showZ() {
        llGovZheng.setVisibility(View.VISIBLE);
        llGovBu.setVisibility(View.GONE);
        ivGovFocus.setVisibility(View.VISIBLE);
    }

    public void showBu() {
        llGovBu.setVisibility(View.VISIBLE);
        llGovZheng.setVisibility(View.GONE);
        ivGovFocus.setVisibility(View.GONE);
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
    public int getResourceId() {
        return R.layout.fragment_gov;
    }


    @Override
    public void loadData() {
        Log.i("dongdong,sedond", "sedond加载数据");
    }

    @Override
    public void loadFirstData() {
        Log.i("dongdong,sedond", "sedond加载第一次数据");
    }

    @Override
    public void stopLoadData() {
        Log.i("dongdong,sedond", "sedond停止加载数据");
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
    public void initView() {
        //初始化数据
        rgGov.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rb_gov_bu) {
                    showBu();
                } else {
                    showZ();
                }
            }
        });
        rbGovZheng.setChecked(true);

        ArrayList<BaseFragment> strings = new ArrayList<>();

        GovNowFragment tipOffListFragment = new GovNowFragment();//最新
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("data",LocationCache.getLocationCache().getNowsList());
        tipOffListFragment.setArguments(bundle);

        GovPowerControlFragment tipOffListFragment2 = new GovPowerControlFragment();//强力督办
        Bundle powerBundle = new Bundle();
        powerBundle.putParcelableArrayList("data", LocationCache.getLocationCache().getPowerList());
        tipOffListFragment2.setArguments(powerBundle);

        RankListFragment rankListFragment = new RankListFragment();//排行
        strings.add(tipOffListFragment);
        strings.add(tipOffListFragment2);
        strings.add(rankListFragment);
        //torbar绑定viewpager viewpager 设置adapter
        vpNews.setAdapter(new FragmentAdapter(strings, getChildFragmentManager(), Constant.GOV_TITLES));
        vpNews.setOffscreenPageLimit(strings.size());//缓存数量
        ctbNewsTab.setupWithViewPager(vpNews);
        ctbNewsTab.setSelectedTabIndicatorHeight(0);
        //setAnimation();
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
