package com.spu.dong.spu.activity.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spu.dong.spu.R;
import com.spu.dong.spu.activity.adapter.MyRecyclerMyFocusAdapter;
import com.spu.dong.spu.activity.base.BaseFragment;
import com.spu.dong.spu.activity.model.MyQuestion;
import com.spu.dong.spu.activity.model.MyQuestionFocus;
import com.spu.dong.spu.activity.view.MyItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MyQuestionFragment extends BaseFragment {


    @BindView(R.id.rv_my_focus)
    RecyclerView rvMyFocus;

    @Override
    public int getResourceId() {
        return R.layout.fragment_myquestion;
    }

    @Override
    public void initView() {

        Bundle arguments = getArguments();
        ArrayList<MyQuestionFocus> data = arguments.getParcelableArrayList("data");

        rvMyFocus.setAdapter(new MyRecyclerMyFocusAdapter(data,mActivity));
        rvMyFocus.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        rvMyFocus.addItemDecoration(new MyItemDecoration());
    }

    @Override
    public void loadData() {

    }

    @Override
    public void loadFirstData() {

    }

    @Override
    public void stopLoadData() {

    }
}
