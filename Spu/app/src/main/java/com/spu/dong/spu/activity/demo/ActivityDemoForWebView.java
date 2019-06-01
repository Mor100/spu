package com.spu.dong.spu.activity.demo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.spu.dong.spu.R;

import java.lang.reflect.Method;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityDemoForWebView extends Activity {


    @BindView(R.id.webview)
    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_demo_webview);
        ButterKnife.bind(this);

        webView.loadUrl("file:///android_asset/html/news1.html");
        WebSettings webSettings=webView.getSettings();
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);


    }


}
