package com.shfc.sms.yunpian;

import com.yunpian.sdk.YunpianClient;
import com.yunpian.sdk.api.SignApi;
import com.yunpian.sdk.api.SmsApi;
import com.yunpian.sdk.api.TplApi;
import com.yunpian.sdk.api.VoiceApi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Package com.shfc.sms.yunpian.YunPianBaseService
 * @Description: 云片基础服务
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/1 16:04
 * version V1.0.0
 */
public abstract class YunPianBaseService{

    public YunpianClient yunpianClient;

    public SignApi signApi;

    public SmsApi smsApi;

    public TplApi tplApi;

    public VoiceApi voiceApi;

    /**
     * 初始化构造
     */
    @PostConstruct
    public void init(){
        yunpianClient = new YunpianClient().init();
        initApi();
    }

    /**
     * 初始化API
     */
    public abstract void initApi();

    /**
     * 销毁
     */
    @PreDestroy
    public void destroy(){
        yunpianClient.close();
    }
}
