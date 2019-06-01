package com.spu.dong.spu.activity.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidkun.xtablayout.XTabLayout;
import com.spu.dong.spu.R;
import com.spu.dong.spu.activity.base.BaseFragment;
import com.spu.dong.spu.activity.base.Constant;
import com.spu.dong.spu.activity.cache.LocationCache;
import com.spu.dong.spu.activity.demo.FragmentAdapter;
import com.spu.dong.spu.activity.demo.MyDemoSecondFragment;
import com.spu.dong.spu.activity.demo.NewsListFragment;
import com.spu.dong.spu.activity.model.News;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class NewsFragment extends BaseFragment {

    @BindView(R.id.ctb_news_tab)
    XTabLayout ctbNewsTab;
    @BindView(R.id.vp_news)
    ViewPager vpNews;

    @Override
    public int getResourceId() {
        return R.layout.fragment_news;
    }

    @Override
    public void initView() {

        ArrayList<BaseFragment> baseFragments = new ArrayList<>();
        NewsListFragment newsListFragment1 = new NewsListFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("data",LocationCache.getLocationCache().getList());
        newsListFragment1.setArguments(bundle);
        newsListFragment1.setList(LocationCache.getLocationCache().getList());
        newsListFragment1.setPageNum("");
        baseFragments.add(newsListFragment1);

        NewsListFragment newsListFragment2 = new NewsListFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putParcelableArrayList("data",LocationCache.getLocationCache().getTextList());
        newsListFragment2.setArguments(bundle2);
        newsListFragment2.setList(LocationCache.getLocationCache().getTextList());
        newsListFragment2.setPageNum("");

        baseFragments.add(newsListFragment2);


        NewsListFragment newsListFragment5 = new NewsListFragment();
        Bundle bundle5 = new Bundle();
            bundle5.putParcelableArrayList("data",LocationCache.getLocationCache().getNingList());
        newsListFragment5.setArguments(bundle5);
            newsListFragment5.setList(LocationCache.getLocationCache().getNingList());
            newsListFragment5.setPageNum("");
            baseFragments.add(newsListFragment5);

        FragmentAdapter fragmentAdapter = new FragmentAdapter(baseFragments, getChildFragmentManager(), Constant.NEWS_TITLES);
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
