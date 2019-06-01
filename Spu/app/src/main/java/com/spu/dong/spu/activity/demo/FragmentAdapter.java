package com.spu.dong.spu.activity.demo;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.spu.dong.spu.activity.base.BaseFragment;

import java.util.ArrayList;

public class FragmentAdapter extends FragmentStatePagerAdapter {


    private ArrayList<BaseFragment> allFragment = null;
    private String[] titles = null;
    public FragmentAdapter(ArrayList<BaseFragment> fragments,FragmentManager fm) {
        super(fm);
        if(fragments != null){
            this.allFragment = fragments;
        }
    }

    public FragmentAdapter(ArrayList<BaseFragment> fragments,FragmentManager fm,String[] titls) {
        super(fm);
        if(fragments != null){
            this.allFragment = fragments;
        }
        if(titls != null){
            this.titles = titls;
        }
    }

    @Override
    public BaseFragment getItem(int position) {
        return allFragment.get(position);
    }

    @Override
    public int getCount() {
        return allFragment.size();
    }

    @Nullable
    @Override
    public String getPageTitle(int position) {
        if(titles != null){
            return titles[position];
        }
        return "";
    }

}
