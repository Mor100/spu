package com.spu.dong.spu.activity.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.androidkun.xtablayout.XTabLayout;
import com.spu.dong.spu.R;
import com.spu.dong.spu.activity.base.BaseFragment;
import com.spu.dong.spu.activity.base.Constant;
import com.spu.dong.spu.activity.cache.LocationCache;
import com.spu.dong.spu.activity.demo.FragmentAdapter;
import com.spu.dong.spu.activity.demo.NewsListFragment;

import java.util.ArrayList;

import butterknife.BindView;

public class TipOffFragment extends BaseFragment {

    @BindView(R.id.ctb_news_tab)
    XTabLayout ctbNewsTab;
    @BindView(R.id.vp_news)
    ViewPager vpNews;

    @Override
    public int getResourceId() {
        return R.layout.fragment_tip_off;
    }

    @Override
    public void initView() {
        ArrayList<BaseFragment> baseFragments = new ArrayList<>();


        TipOffListFragment tipOffListNewsFragment = new TipOffListFragment();//宁夏新闻
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("data",LocationCache.getLocationCache().getTipList());
        tipOffListNewsFragment.setArguments(bundle);

        TipOffListFragment tipOffListLifeFragment = new TipOffListFragment();//生活服务
        Bundle bundle2 = new Bundle();
        bundle2.putParcelableArrayList("data",LocationCache.getLocationCache().getTopLife());
        tipOffListLifeFragment.setArguments(bundle2);

        baseFragments.add(tipOffListNewsFragment);
        baseFragments.add(tipOffListLifeFragment);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(baseFragments, getChildFragmentManager(), Constant.TIP_OFF_TITLES);
        vpNews.setAdapter(fragmentAdapter);
        vpNews.setOffscreenPageLimit(baseFragments.size());

        //设置view
        ctbNewsTab.setupWithViewPager(vpNews);
        //ctbNewsTab.setTabPaddingLeftAndRight(5,5);
        ctbNewsTab.setSelectedTabIndicatorHeight(0);//隐藏Indicator


    }

    @Override
    public void loadData() {
        Log.i("dongdong", "第一页" + "加载数据");
    }


    @Override
    public void loadFirstData() {
        Log.i("dongdong", "第一页" + "加载第一次数据");
    }

    @Override
    public void stopLoadData() {
        Log.i("dongdong", "第一页" + "停止加载第一次数据");
    }

}
