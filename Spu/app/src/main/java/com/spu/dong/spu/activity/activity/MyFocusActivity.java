package com.spu.dong.spu.activity.activity;

import android.app.FragmentManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.androidkun.xtablayout.XTabLayout;
import com.spu.dong.spu.R;
import com.spu.dong.spu.activity.base.BaseFragment;
import com.spu.dong.spu.activity.base.Constant;
import com.spu.dong.spu.activity.cache.LocationCache;
import com.spu.dong.spu.activity.demo.FragmentActivityAdapter;
import com.spu.dong.spu.activity.fragment.MyQuestionFragment;
import com.spu.dong.spu.activity.fragment.MyQuestionLeftFragment;
import com.spu.dong.spu.activity.model.MyQuestion;
import com.spu.dong.spu.activity.model.MyQuestionFocus;
import com.spu.dong.spu.activity.utils.DataUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyFocusActivity extends FragmentActivity {


    @BindView(R.id.ctb_news_tab)
    XTabLayout ctbNewsTab;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.vp_my_focus)
    ViewPager vpMyFocus;
    @OnClick(R.id.iv_back)
    public void back(){
        finish();
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_focus);
        ButterKnife.bind(this);
        ArrayList<BaseFragment> baseFragments = new ArrayList<>();
        ArrayList<MyQuestion> myQuestionList = LocationCache.getLocationCache().getMyQuestionList();
        myQuestionList.clear();

        ArrayList<MyQuestionFocus> questionListFocus = LocationCache.getLocationCache().getQuestionListFocus();
        questionListFocus.clear();

        //查询数据库 转内存对象 设置给fragment
        Cursor query = getContentResolver().query(Uri.parse("content://com.spu.dong.spu.ContentProviderDemo/myask"), new String[]{"_id", "title", "ask", "image"}, null, null, null);
        while(query.moveToNext()){

            String title = query.getString(query.getColumnIndex("title"));
            String ask = query.getString(query.getColumnIndex("ask"));
            String image = query.getString(query.getColumnIndex("image"));
            myQuestionList.add(new MyQuestion(title,ask,image));

        }

        Cursor query2 = getContentResolver().query(Uri.parse("content://com.spu.dong.spu.ContentProviderDemo/urlcontent"), new String[]{"_id", "title", "content", "contenturl","answer","gov","flag","imagetrueurl"}, null, null, null);
        while(query2.moveToNext()){

            String title = query2.getString(query2.getColumnIndex("title"));
            String content = query2.getString(query2.getColumnIndex("content"));
            String contenturl = query2.getString(query2.getColumnIndex("contenturl"));
            String answer = query2.getString(query2.getColumnIndex("answer"));
            String gov = query2.getString(query2.getColumnIndex("gov"));
            String flag = query2.getString(query2.getColumnIndex("flag"));
            String imagetrueurl = query2.getString(query2.getColumnIndex("imagetrueurl"));
            questionListFocus.add(new MyQuestionFocus(title,content,contenturl,answer,gov,flag,imagetrueurl));

        }

        MyQuestionFragment myQuestionFragment = new MyQuestionFragment();
        Bundle bundl = new Bundle();
        bundl.putParcelableArrayList("data",questionListFocus);
        myQuestionFragment.setArguments(bundl);

        MyQuestionLeftFragment myQuestionLeftFragment = new MyQuestionLeftFragment();
        Bundle bundleleft = new Bundle();
        bundleleft.putParcelableArrayList("data",myQuestionList);
        myQuestionLeftFragment.setArguments(bundleleft);

        baseFragments.add(myQuestionLeftFragment);
        baseFragments.add(myQuestionFragment);
        FragmentActivityAdapter fragmentAdapter = new FragmentActivityAdapter(baseFragments,getSupportFragmentManager(), Constant.MY_FOCUS);
        vpMyFocus.setAdapter(fragmentAdapter);
        vpMyFocus.setOffscreenPageLimit(baseFragments.size());

        //设置view
        ctbNewsTab.setupWithViewPager(vpMyFocus);
        //ctbNewsTab.setTabPaddingLeftAndRight(5,5);
        ctbNewsTab.setSelectedTabIndicatorHeight(0);//隐藏Indicator


    }
}
