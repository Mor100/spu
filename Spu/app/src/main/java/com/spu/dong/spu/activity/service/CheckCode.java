package com.spu.dong.spu.activity.service;

import java.io.Serializable;

/**
 * Name: VerifyEntry
 * Author: xulong
 * Comment: 验证码返回json实例
 * Date: 2016-07-15 10:46.
 */
public class CheckCode implements Serializable {


    /**
     * tranId : 5131515678945845785467
     * return_code : 0
     * return_message : OK
     */

    private String return_code;
    private String return_message;
    private String tranId;

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_message() {
        return return_message;
    }

    public void setReturn_message(String return_message) {
        this.return_message = return_message;
    }

    public void setTranId(String tranId) {
        this.tranId = tranId;
    }

    public String getTranId() {
        return tranId;
    }


}
