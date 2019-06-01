package com.spu.dong.spu.activity.kai.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.spu.dong.spu.R;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SuggestionActivity extends AppCompatActivity {
    private Toolbar tbTitle;
    private TextView tvSuggestion, tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);

        tbTitle = (Toolbar) findViewById(R.id.tb_suggestion);
        tvSuggestion = (TextView) findViewById(R.id.tv_suggestion);
        tvEmail = (TextView) findViewById(R.id.tv_email);

        setSupportActionBar(tbTitle);
        tbTitle.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tbTitle.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (TextUtils.equals(tvSuggestion.getText().toString(), "") && TextUtils.equals(tvEmail.getText().toString(), "")){
                    Toast.makeText(SuggestionActivity.this, "文本不能为空", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(SuggestionActivity.this, "提交成功", Toast.LENGTH_LONG).show();
                    finish();
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_submit, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
//        if (menu != null && menu.getClass() == MenuBuilder.class){
//            try {
//                Method method = menu.getClass().getDeclaredMethod("setOptionalIconVisible",Boolean.TYPE);
//                method.setAccessible(true);
//                method.invoke(menu,true);
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        }
        menu.findItem(R.id.menu_submit).setVisible(true);
        invalidateOptionsMenu();
        return super.onPrepareOptionsMenu(menu);
    }
}
