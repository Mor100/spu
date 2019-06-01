package com.spu.dong.spu.activity.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.spu.dong.spu.R;
import com.spu.dong.spu.activity.base.BaseFragment;
import com.spu.dong.spu.activity.kai.fragment.ComprehensiveFragment;
import com.spu.dong.spu.activity.kai.fragment.RecoveryRateFragment;
import com.spu.dong.spu.activity.kai.fragment.SatisfactionFragment;
import com.spu.dong.spu.activity.kai.view.RankingsVoiceItemView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class RankListFragment extends BaseFragment {

    @BindView(R.id.satisfaction)
    RankingsVoiceItemView satisfaction;
    private FragmentManager fragmentManager;
    private TextView tvRecoveryRate;
    private ImageView ivRecoverRate;
    private TextView tvSatisfaction;
    private ImageView ivSatisfaction;
    private TextView tvComprehensiveRank;
    private ImageView ivComprehensiveRank;

    @OnClick(R.id.satisfaction)
    public void fac(){
        satisfaction.setSelected(true);
        tvSatisfaction.setTextColor(Color.RED);

        ivSatisfaction.setImageResource(R.drawable.q2);
        tvRecoveryRate.setTextColor(Color.GRAY);
        ivRecoverRate.setImageResource(R.drawable.q3);
        tvComprehensiveRank.setTextColor(Color.GRAY);
        ivComprehensiveRank.setImageResource(R.drawable.q5);
        recoveryRate.setSelected(false);
        comprehensiveRank.setSelected(false);
        fragmentManager.beginTransaction().replace(R.id.container,new SatisfactionFragment()).commit();
    }
    @BindView(R.id.recovery_rate)
    RankingsVoiceItemView recoveryRate;
    @OnClick(R.id.recovery_rate)
    public void rate(){
        recoveryRate.setSelected(true);
        tvRecoveryRate.setTextColor(Color.RED);
        ivRecoverRate.setImageResource(R.drawable.q4);
        tvSatisfaction.setTextColor(Color.GRAY);
        ivSatisfaction.setImageResource(R.drawable.q1);
        tvComprehensiveRank.setTextColor(Color.GRAY);
        ivComprehensiveRank.setImageResource(R.drawable.q5);
        satisfaction.setSelected(false);
        comprehensiveRank.setSelected(false);
        fragmentManager.beginTransaction().replace(R.id.container,new RecoveryRateFragment()).commit();
    }
    @BindView(R.id.comprehensive_rank)
    RankingsVoiceItemView comprehensiveRank;
    @OnClick(R.id.comprehensive_rank)
    public void rank(){
        comprehensiveRank.setSelected(true);
        tvComprehensiveRank.setTextColor(Color.RED);
        ivComprehensiveRank.setImageResource(R.drawable.q6);
        tvSatisfaction.setTextColor(Color.GRAY);
        ivSatisfaction.setImageResource(R.drawable.q1);
        tvRecoveryRate.setTextColor(Color.GRAY);
        ivRecoverRate.setImageResource(R.drawable.q3);
        recoveryRate.setSelected(false);
        satisfaction.setSelected(false);
        fragmentManager.beginTransaction().replace(R.id.container,new ComprehensiveFragment()).commit();
    }
    @BindView(R.id.liner)
    LinearLayout liner;
    @BindView(R.id.container)
    FrameLayout container;


    @Override
    public int getResourceId() {
        return R.layout.activity_rankings_voice;

    }

    @Override
    public void initView() {
        tvRecoveryRate = (TextView) recoveryRate.findViewById(R.id.tv_rankings_text);
        ivRecoverRate = (ImageView) recoveryRate.findViewById(R.id.iv_rankings_icon);
        tvSatisfaction = (TextView) satisfaction.findViewById(R.id.tv_rankings_text);
        ivSatisfaction = (ImageView) satisfaction.findViewById(R.id.iv_rankings_icon);
        tvComprehensiveRank = (TextView) comprehensiveRank.findViewById(R.id.tv_rankings_text);
        ivComprehensiveRank = (ImageView) comprehensiveRank.findViewById(R.id.iv_rankings_icon);

        satisfaction.setSelected(true);
        recoveryRate.setSelected(false);
        comprehensiveRank.setSelected(false);
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, new SatisfactionFragment()).commit();
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
