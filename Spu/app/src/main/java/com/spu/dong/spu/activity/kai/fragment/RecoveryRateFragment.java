package com.spu.dong.spu.activity.kai.fragment;

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
import android.widget.TextView;
import android.widget.Toast;

import com.spu.dong.spu.R;

public class RecoveryRateFragment extends Fragment {
    private ImageView ivRecoveryRate;
    private RotateAnimation animation;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recovery_rate,container,false);
        ivRecoveryRate = (ImageView) view.findViewById(R.id.iv_recovery_rate);
        ivRecoveryRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivRecoveryRate.setImageResource(R.drawable.audio_load_one);
                animation = new RotateAnimation(0,900,ivRecoveryRate.getPivotX(),ivRecoveryRate.getPivotY());
                animation.setDuration(3000);
                ivRecoveryRate.startAnimation(animation);
                onAnimationListener();
            }
        });
        return view;
    }

    private void onAnimationListener(){
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ivRecoveryRate.setImageResource(R.drawable.nodata);
                Toast.makeText(getContext(),"暂无数据",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
