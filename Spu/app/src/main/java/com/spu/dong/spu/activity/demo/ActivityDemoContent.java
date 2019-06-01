package com.spu.dong.spu.activity.demo;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.spu.dong.spu.R;
import com.spu.dong.spu.activity.model.TipOffBeans;
import com.spu.dong.spu.activity.utils.DataUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityDemoContent extends Activity {

    @BindView(R.id.btn_inset)
    Button btnInset;
    @BindView(R.id.btn_query)
    Button btnQuery;
    @BindView(R.id.btn_delete)
    Button btnDelete;
    private Uri parse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_contentdemo);
        ButterKnife.bind(this);

        parse = Uri.parse("content://com.spu.dong.spu.ContentProviderDemo");

//       DbopenHelperDemo text = new DbopenHelperDemo(this);
//    SQLiteDatabase writableDatabase = text.getWritableDatabase();
//        writableDatabase.execSQL("create table true (_id integer primary key autoincrement,booId text, bookName text)");//创建表。
}

    @OnClick({R.id.btn_inset, R.id.btn_query, R.id.btn_delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_inset:
                ContentValues contentValues = new ContentValues();

                contentValues.put("bookName", "111");
                contentValues.put("booId","222222");//用来放title
                getContentResolver().insert(parse,contentValues);
                break;
            case R.id.btn_query:
                Cursor query = getContentResolver().query(parse, new String[]{"_id","booId","bookName"}, null, null, null);

                while (query.moveToNext()){

                    String bookName = query.getString(query.getColumnIndex("bookName"));
                    String booId = query.getString(query.getColumnIndex("booId"));
                    Log.i("dongdong",bookName+booId);
                }
                break;
            case R.id.btn_delete:
                getContentResolver().delete(parse,"booId=?",new String[]{"1111111"});
                break;

        }
    }
}
