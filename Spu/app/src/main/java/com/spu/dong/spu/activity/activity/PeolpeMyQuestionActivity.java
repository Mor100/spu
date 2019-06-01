package com.spu.dong.spu.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.spu.dong.spu.R;
import com.spu.dong.spu.activity.cache.LocationCache;
import com.spu.dong.spu.activity.model.MyQuestion;
import com.spu.dong.spu.activity.utils.DataUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PeolpeMyQuestionActivity extends Activity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_author)
    TextView tvAuthor;
    @BindView(R.id.ll_user)
    LinearLayout llUser;
    @BindView(R.id.tv_people_dealflag)
    TextView tvPeopleDealflag;
    @BindView(R.id.tv_people_title)
    TextView tvPeopleTitle;
    @BindView(R.id.tv_people_send)
    TextView tvPeopleSend;
    @BindView(R.id.tv_people_time)
    TextView tvPeopleTime;
    @BindView(R.id.tv_people_content)
    TextView tvPeopleContent;
    @BindView(R.id.iv_people_content_image)
    ImageView ivPeopleContentImage;
    @BindView(R.id.v_line)
    View vLine;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web_view_people2);
        ButterKnife.bind(this);



        Intent intent = getIntent();
        String num = intent.getStringExtra("num");
        MyQuestion data = LocationCache.getLocationCache().getMyQuestionList().get(Integer.valueOf(num));

        Bitmap bitmap = DataUtils.stringToBitmap(data.bitmap);
        ivPeopleContentImage.setImageBitmap(bitmap);
        ivPeopleContentImage.setScaleType(ImageView.ScaleType.FIT_XY);
       tvPeopleTitle.setText(data.title);
       tvPeopleContent.setText(data.content);
//        ivPeopleContentImage.setImageBitmap(myQuestionList.get(0).bitmap);
//        ivPeopleContentImage.setScaleType(ImageView.ScaleType.FIT_XY);


    }

}
