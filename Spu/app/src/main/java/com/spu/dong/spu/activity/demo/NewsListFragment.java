package com.spu.dong.spu.activity.demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spu.dong.spu.R;
import com.spu.dong.spu.activity.base.BaseFragment;
import com.spu.dong.spu.activity.model.News;
import com.spu.dong.spu.activity.utils.BGANormalRefreshViewHolder;
import com.spu.dong.spu.activity.view.MyItemDecoration;
import com.spu.dong.spu.activity.view.TipView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

public class NewsListFragment extends BaseFragment implements BGARefreshLayout.BGARefreshLayoutDelegate {


    @BindView(R.id.rv_newslist)
    RecyclerView rvNewslist;
    @BindView(R.id.bga_news_list)
    BGARefreshLayout bgaNewsList;
    @BindView(R.id.tip_view)
    TipView tipView;
    Unbinder unbinder;
    private String pageNum = "meishezhi";
    private ArrayList<News> data;
    private MyRecyclerAdapter myRecyclerAdapter;


    public NewsListFragment(){

    }
    public void setPageNum(String num) {
        pageNum = num;
    }

   public void  setList(ArrayList<News> data){
       this.data = data;
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
        return R.layout.fragment_demo_newslist;
    }


    @Override
    public void loadData() {
        Log.i("dongdong", pageNum + "加载数据");
////        //开启轮播
////
        new Handler().postDelayed(new Runnable() {
            public void run() {
                //execute the task
                myRecyclerAdapter.startAdapter();
                Log.i("dongdong", "调用一次开始轮播");
            }
        }, 2 * 1000);

    }

    @Override
    public void loadFirstData() {
        Log.i("dongdong", pageNum + "加载第一次数据");
        //viewpager 开启轮播
        new Handler().postDelayed(new Runnable() {
            public void run() {
                //execute the task
                myRecyclerAdapter.startAdapter();
                Log.i("dongdong", "调用一次第一次开始轮播");
            }
        }, 2 * 1000);
    }

    @Override
    public void stopLoadData() {
        Log.i("dongdong", pageNum + "停止加载数据");
        //关闭轮播
        //execute the task
        myRecyclerAdapter.stopAdapter();
        Log.i("dongdong", pageNum + "调用一次停止加载数据");
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

        //设置viewpager

        Bundle arguments = getArguments();
       ArrayList<News> data = arguments.getParcelableArrayList("data");

        myRecyclerAdapter = new MyRecyclerAdapter(data, mActivity);
        //设置adapter
        rvNewslist.setAdapter(myRecyclerAdapter);
        rvNewslist.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        rvNewslist.addItemDecoration(new MyItemDecoration());

        BGANormalRefreshViewHolder bgaNormalRefreshViewHolder = new BGANormalRefreshViewHolder(mActivity, true);
        bgaNewsList.setDelegate(this);
        bgaNewsList.shouldHandleRecyclerViewLoadingMore(rvNewslist);
        bgaNewsList.setRefreshViewHolder(bgaNormalRefreshViewHolder);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    //开始下拉刷新
    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        Log.i("dongdong", "开始刷新");
        //发一个延迟消息
        new Handler().postDelayed(new Runnable() {
            public void run() {
                //execute the task
                tipView.show("暂无更多数据");
                bgaNewsList.endRefreshing();
            }
        }, 2 * 1000);

    }

    //开始底部加载更多
    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        Log.i("dongdong", "开始加载更多");
        //发一个延迟消息
        new Handler().postDelayed(new Runnable() {
            public void run() {
                //execute the task
                tipView.show("暂无更多数据");
                bgaNewsList.endLoadingMore();
            }
        }, 2 * 1000);

        return true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
