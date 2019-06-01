package com.spu.dong.spu.activity.kai.fragment;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.spu.dong.spu.R;

public class SatisfactionFragment extends Fragment {
    private ImageView ivSatisfaction;
    private RotateAnimation animator;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_satisfaction,container,false);
        ivSatisfaction = (ImageView) view.findViewById(R.id.iv_satisfaction);
        ivSatisfaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivSatisfaction.setImageResource(R.drawable.audio_load_one);
                animator = new RotateAnimation(0,900,ivSatisfaction.getPivotX(),ivSatisfaction.getPivotY());
                animator.setDuration(3000);
                ivSatisfaction.startAnimation(animator);
                onAnimationListener();
            }
        });

        return view;
    }

    private void onAnimationListener(){
        animator.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ivSatisfaction.setImageResource(R.drawable.nodata);
                Toast.makeText(getContext()," 暂无数据",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
