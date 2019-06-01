package com.spu.dong.spu.activity.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.spu.dong.spu.R;
import com.spu.dong.spu.activity.cache.LocationCache;
import com.spu.dong.spu.activity.model.MyQuestionFocus;
import com.spu.dong.spu.activity.model.Nows;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PeolpeActivity extends Activity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_people_dealflag)
    TextView tvPeopleDealflag;
    @BindView(R.id.tv_peolpe_gov)
    TextView tvPeolpeGov;
    @BindView(R.id.tv_people_answer_title_flag)
    TextView tvPeopleAnswerTitleFlag;
    @BindView(R.id.tv_people_answer_title)
    TextView tvPeopleAnswerTitle;
    @BindView(R.id.tv_people_answer_time)
    TextView tvPeopleAnswerTime;
    @BindView(R.id.tv_people_answer_content)
    TextView tvPeopleAnswerContent;
    @BindView(R.id.ll_people_answer)
    LinearLayout llPeopleAnswer;
    @BindView(R.id.v_line)
    View vLine;
    private Nows nows;

    @OnClick(R.id.iv_back)
    public void close() {
        finish();
    }

    @BindView(R.id.tv_author)
    TextView tvAuthor;
    @BindView(R.id.ll_user)
    LinearLayout llUser;
    @BindView(R.id.iv_detail)
    TextView ivDetail;
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
    private   Uri parse = Uri.parse("content://com.spu.dong.spu.ContentProviderDemo/urlcontent");
    ContentValues contentValues = new ContentValues();
    @OnClick(R.id.iv_detail)
    public void showFocus() {

        if(ivDetail.getText().toString().equals("已关注")){

        }else{
            ivDetail.setText("已关注");
            Toast.makeText(this, "已关注", Toast.LENGTH_SHORT).show();
            //存入数据库
            contentValues.put("title",nows.title);//标题
            contentValues.put("content",nows.gov+" "+nows.time);//时间
            contentValues.put("contenturl",nows.ask);//
            contentValues.put("answer",nows.answer);//
            contentValues.put("gov",nows.gov);//
            contentValues.put("flag",nows.dealflag);//
            contentValues.put("imagetrueurl",nows.imageurl);//
            getContentResolver().insert(parse,contentValues);
            contentValues.clear();


        }

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web_view_people);
        ButterKnife.bind(this);


        //设置内容
        Intent intent = getIntent();
        String num = intent.getStringExtra("num");
        String flag = intent.getStringExtra("flag");
        if(TextUtils.isEmpty(flag)){
            nows = LocationCache.getLocationCache().getNowsList().get(Integer.valueOf(num));
        }else{
            //另外一种获取方式
            MyQuestionFocus myQuestionFocus = LocationCache.getLocationCache().getQuestionListFocus().get(Integer.valueOf(num));
            nows = new Nows(myQuestionFocus.title,myQuestionFocus.content,myQuestionFocus.flag,myQuestionFocus.gov,"NULL",myQuestionFocus.contenturl,myQuestionFocus.answer,myQuestionFocus.imagetrueurl);
        }
        //获取nows
        initview(nows);

        //查询 是否已关注
        Cursor query = getContentResolver().query(parse, new String[]{"_id", "title", "content", "contenturl","answer","gov","flag","imagetrueurl"}, null, null, null);
        while(query.moveToNext()){

            String title = query.getString(query.getColumnIndex("title"));

            if(title.equals(nows.title)){
                //匹配
                ivDetail.setText("已关注");
            }
        }

    }

    private void initview(Nows nows) {
        //图片
        if (nows.imageurl.equals("NULL")) {
            ivPeopleContentImage.setVisibility(View.GONE);
        } else {
            Glide.with(this)
                    .load(nows.imageurl)
                    .placeholder(R.drawable.nopic) //占位符
                    .error(R.drawable.nopic)       //错误占位符
                    .dontAnimate()//没有任何淡入淡出效果
                    .override(640, 428)//调整图片大小
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)//优先级
                    .into(ivPeopleContentImage);
            ivPeopleContentImage.setScaleType(ImageView.ScaleType.FIT_XY);
        }

        //问 时间
        tvPeopleTime.setText(nows.time);
        //问 标题
        tvPeopleTitle.setText(nows.title);
        //问 内容
        tvPeopleContent.setText(nows.ask);
        //问 单位
        if (nows.gov.equals("NULL")) {
            tvPeolpeGov.setVisibility(View.GONE);
        } else {
            if (nows.answer.equals("NULL")) {
                StringBuffer sb = new StringBuffer();
                sb.append("已 转办   ").append(nows.gov);
                tvPeolpeGov.setText(sb.toString());
            } else {
                StringBuffer sb = new StringBuffer();
                sb.append("已回复   ").append(nows.gov);
                tvPeolpeGov.setText(sb.toString());
            }

        }
        //问 状态
        if (nows.dealflag.equals("已审核")) {
            //已审核
            tvPeopleDealflag.setBackground(getResources().getDrawable(R.drawable.shape_gov_nows_red));
            tvPeopleDealflag.setTextColor(getResources().getColor(R.color.status_color_red));
            tvPeopleDealflag.setText("已审核");
        } else if (nows.dealflag.equals("已办结")) {
            //已办结
            tvPeopleDealflag.setBackground(getResources().getDrawable(R.drawable.shape_gov_nows_green));
            tvPeopleDealflag.setTextColor(getResources().getColor(R.color.SeaGreen));
            tvPeopleDealflag.setText("已办结");
        } else {
            //已转办
            tvPeopleDealflag.setBackground(getResources().getDrawable(R.drawable.shape_gov_nows_blue));
            tvPeopleDealflag.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            tvPeopleDealflag.setText("已转办");
        }

        //答页面是否展示
        if (nows.answer.equals("NULL")) {
            llPeopleAnswer.setVisibility(View.GONE);
            vLine.setVisibility(View.VISIBLE);
        } else {
            //设置参数
            //审核状态
            if (nows.dealflag.equals("已审核")) {
                //已审核
                tvPeopleAnswerTitleFlag.setBackground(getResources().getDrawable(R.drawable.shape_gov_nows_red));
                tvPeopleAnswerTitleFlag.setTextColor(getResources().getColor(R.color.status_color_red));
                tvPeopleAnswerTitleFlag.setText("已审核");
            } else if (nows.dealflag.equals("已办结")) {
                //已办结
                tvPeopleAnswerTitleFlag.setBackground(getResources().getDrawable(R.drawable.shape_gov_nows_green));
                tvPeopleAnswerTitleFlag.setTextColor(getResources().getColor(R.color.SeaGreen));
                tvPeopleAnswerTitleFlag.setText("已办结");
            } else {
                //已转办
                tvPeopleAnswerTitleFlag.setBackground(getResources().getDrawable(R.drawable.shape_gov_nows_blue));
                tvPeopleAnswerTitleFlag.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                tvPeopleAnswerTitleFlag.setText("已转办");
            }
            //回答标题
            tvPeopleAnswerTitle.setText(nows.gov);
            //回答时间
            tvPeopleAnswerTime.setText(nows.time);
            //回答内容
            tvPeopleAnswerContent.setText(nows.answer);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();


    }
}
