package com.spu.dong.spu.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.spu.dong.spu.R;
import com.spu.dong.spu.activity.flyn.Eyes;
import com.spu.dong.spu.activity.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WebActivity extends Activity {

    public static final String URL = "url";
    @BindView(R.id.iv_back)
    ImageView ivBack;

    @BindView(R.id.tv_author)
    TextView tvAuthor;
    @BindView(R.id.ll_user)
    LinearLayout llUser;
    @BindView(R.id.pb_loading)
    ProgressBar mPbLoading;
    @BindView(R.id.iv_detail)
    ImageView ivDetail;

    @BindView(R.id.wv_content)
    WebView mWvContent;
    @BindView(R.id.iv_web_image)
    ImageView ivWebImage;
    private String url;

    private int[] mStatusColors = new int[]{
            R.color.colorRedDeep,
            R.color.status_color_grey,
    };

    @OnClick(R.id.iv_detail)
    public void showShare(){
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_SEND);
//        intent.putExtra(Intent.EXTRA_TEXT, "www.baidu.com");
//        intent.setType("text/plain");
//        startActivity(Intent.createChooser(intent,"分享"));

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        List<ResolveInfo> resolveInfos = getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (resolveInfos.isEmpty()) {
            return;
        }
        List<Intent> targetIntents = new ArrayList<>();
        for (ResolveInfo info : resolveInfos) {
            ActivityInfo ainfo = info.activityInfo;
            switch (ainfo.packageName) {
                case "com.tencent.mm":
                    addShareIntent(targetIntents, ainfo);
                    break;
                case "com.tencent.mobileqq":
                    addShareIntent(targetIntents, ainfo);
                    break;
                case "com.sina.weibo":
                    addShareIntent(targetIntents, ainfo);
                    break;
            }
        }
        if (targetIntents == null || targetIntents.size() == 0) {
            return;
        }
        Intent chooserIntent = Intent.createChooser(targetIntents.remove(0), "请选择分享平台");
        if (chooserIntent == null) {
            return;
        }
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, targetIntents.toArray(new Parcelable[]{}));
        try {
            startActivity(chooserIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "找不到该分享应用组件", Toast.LENGTH_SHORT).show();
        }
        //startActivity(Intent.createChooser(intent, getTitle()));
    }


    private void addShareIntent(List<Intent> list, ActivityInfo ainfo) {
        Intent target = new Intent(Intent.ACTION_SEND);
        target.setType("text/plain");
        target.putExtra(Intent.EXTRA_TEXT, url);
        target.setPackage(ainfo.packageName);
        target.setClassName(ainfo.packageName, ainfo.name);
        list.add(target);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);
        url = getIntent().getStringExtra(URL);
        mWvContent.loadUrl(url);
        initListener();
      //  Eyes.setStatusBarColor(WebActivity.this, UIUtils.getColor(R.color.white));
    }


    private void initListener() {
        WebSettings settings = mWvContent.getSettings();

        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setBuiltInZoomControls(true);//support zoom
        settings.setUseWideViewPort(true);// 这个很关键
        settings.setLoadWithOverviewMode(true);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int mDensity = metrics.densityDpi;
        if (mDensity == 240) {
            settings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        } else if (mDensity == 160) {
            settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        } else if(mDensity == 120) {
            settings.setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
        }else if(mDensity == DisplayMetrics.DENSITY_XHIGH){
            settings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        }else if (mDensity == DisplayMetrics.DENSITY_TV){
            settings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        }
        mWvContent.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                mPbLoading.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                mPbLoading.setVisibility(View.GONE);
            }


            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                //加载不出来 显示
//                ivWebImage.setVisibility(View.VISIBLE);
//                mWvContent.setVisibility(View.GONE);

            }

            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
                //加载不出来 显示
                ivWebImage.setVisibility(View.VISIBLE);
                mWvContent.setVisibility(View.GONE);
            }
        });

        mWvContent.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                mPbLoading.setProgress(newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                if (title.contains("404") || title.contains("500") || title.contains("Error")||title.contains("找不到")||title.contains("网页无法打开")) {
                    //加载不出来 显示
                    ivWebImage.setVisibility(View.VISIBLE);
                    mWvContent.setVisibility(View.GONE);
                }
            }


        });

        mWvContent.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && mWvContent.canGoBack()) {  //表示按返回键
                        mWvContent.goBack();   //后退
                        return true;    //已处理
                    }
                }
                return false;
            }
        });
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
