package com.shfc.sms.yunpian;

import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsBatchSend;
import com.yunpian.sdk.model.SmsSingleSend;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Package com.shfc.sms.yunpian.YunPianSmsService
 * @Description: 云片短信服务
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/1 15:33
 * version V1.0.0
 */
@Service
public class YunPianSmsService extends YunPianBaseService{
    /**
     * 单条发送
     * @param param
     * @return
     */
    public Result<SmsSingleSend> smsSingleSend(Long merchantId, String channelNo, Map<String, String> param){
        return smsApi.single_send(param);
    }

    /**
     * 批量发送相同内容
     * @param param
     * @return
     */
    public Result<SmsBatchSend> smsBatchSend(Long merchantId, String channelNo, Map<String, String> param){
        return smsApi.batch_send(param);
    }

    /**
     * 批量发送不同内容
     * @param param
     * @return
     */
    public Result<SmsBatchSend> smsMultiSend(Long merchantId, String channelNo, Map<String, String> param){
        return smsApi.multi_send(param);
    }

    @Override
    public void initApi() {
        smsApi = yunpianClient.sms();
    }
}
