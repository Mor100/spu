package com.spu.dong.spu.activity.service;



import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Name: ServiceApi
 * Author: dongdong
 * Comment: 定义retrofit请求接口，即程序中都需要什么请求操作
 * Date: 2016-07-12 15:25.
 */
public interface ServerApi {


    /**
     * 发送短信，获取登录验证码
     *
     * @param
     */
    @GET("{uuid}/{tranId}/m001/{jobnum}")
    Call<CheckCode> sendSms2(@Path("uuid") String uuid,
                             @Path("tranId") String tranId,
                             @Path("jobnum") String jobnum);
    @GET("{uuid}/{tranId}/m001/{jobnum}")
    Observable<CheckCode> sendSms3(@Path("uuid") String uuid,
                                   @Path("tranId") String tranId,
                                   @Path("jobnum") String jobnum);
    /**
     * 发送短信，获取登录验证码
     *
     * @param
     */
    @GET("{uuid}/{tranId}/m001/{jobnum}")
    Call<CheckCode> sendSms(@Path("uuid") String uuid,
                            @Path("tranId") String tranId,
                            @Path("jobnum") String jobnum);

}
