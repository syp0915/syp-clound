package com.shfc.sms.yunpian;

import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.Sign;
import com.yunpian.sdk.model.SignRecord;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Package com.shfc.sms.yunpian.YunPianSignService
 * @Description: 云片签名服务
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/1 15:09
 * version V1.0.0
 */
@Service
public class YunPianSignService extends YunPianBaseService{
    /**
     * 添加签名
     * @param param
     * @return
     */
    public Result<Sign> addSign(Long merchantId, String channelNo, Map<String, String> param){
        return signApi.add(param);
    }

    /**
     * 更新签名
     * @param param
     * @return
     */
    public Result<Sign> updateSign(Long merchantId, String channelNo, Map<String, String> param){
        return signApi.update(param);
    }

    /**
     * 获取签名
     * @param param
     * @return
     */
    public Result<SignRecord> getSign(Long merchantId, String channelNo, Map<String, String> param){
        return signApi.get(param);
    }

    @Override
    public void initApi() {
        signApi = yunpianClient.sign();
    }
}
