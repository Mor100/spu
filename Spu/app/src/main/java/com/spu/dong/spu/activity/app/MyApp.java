package com.spu.dong.spu.activity.app;


import org.litepal.LitePalApplication;

/**
 * @author ChayChan
 * @description: Application类
 * @date 2017/6/10  15:44
 */

public class MyApp extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();

        //**************************************相关第三方SDK的初始化等操作*************************************************
        LitePalApplication.initialize(getApplicationContext());//初始化litePal
    }
}
