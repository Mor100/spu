package com.spu.dong.spu.activity.service;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Name: ServiceGenerator
 * Author: xulong
 * Comment: 获取服务器对象
 * Date: 2016-07-12 15:25.
 */

public class ServiceGenerator {
    private static final String SERVER_BASE_URL6 = "http://211.167.101.7:8081/mboss/";//外网接口
    //private static final String SERVER_BASE_URL9 = "http://10.10.25.107:8081/mboss/";//公司接口
    //  private static final String SERVER_BASE_URL9 = "http://10.10.26.50:8081/mboss/";//公司接口
    //测试z
     private static final String SERVER_BASE_URL9 = "http://211.167.101.7:8081/mboss/";//现场最新衍射地址
    //    //迁徙地址
    //  private static finl String SERVER_BASE_URL9 = "http://192.168.82.151:8081/mboss/";//现场最新衍射地址
    //正式-ik
    //  private static final String SERVER_BASE_URL9 = "http://211.167.101.20:8081/mboss/";//现场最新衍射地址
    //右边地址35077573115]
    //private static final  String SERVER_BASE_URL9= "http://192.168.1.106:8880/mboss/";//公司地址
    static OkHttpClient.Builder httpBuilder  =new OkHttpClient.Builder();
    static OkHttpClient client       =httpBuilder.readTimeout(3, TimeUnit.MINUTES)
            .connectTimeout(3, TimeUnit.MINUTES).writeTimeout(3, TimeUnit.MINUTES) //设置超时
            .build();
    private static  Retrofit.Builder mBuilder = new Retrofit.Builder()
            .baseUrl(SERVER_BASE_URL9).client(client)
            .addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()) ;

    //用于受理单页面   处理

    private static Retrofit.Builder mBuilder1 = new Retrofit.Builder()
            .baseUrl(SERVER_BASE_URL9).client(client);



    /**
     * 生成服务器对象
     *
     * @param serviceClass
     * @param <S>
     * @return
     */
    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = mBuilder.build();

        return retrofit.create(serviceClass);
    }

    /**
     * 生成服务器对象：受理单页面
     *
     * @param serviceClass
     * @param <S>
     * @return
     */
    public static <S> S createService1(Class<S> serviceClass) {
        Retrofit retrofit = mBuilder1.build();

        return retrofit.create(serviceClass);
    }






}
