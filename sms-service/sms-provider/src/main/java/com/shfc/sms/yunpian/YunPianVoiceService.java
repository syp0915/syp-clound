package com.shfc.sms.yunpian;

import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.VoiceSend;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Package com.shfc.sms.yunpian.YunPianVoiceService
 * @Description: 云片语音服务
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/1 15:35
 * version V1.0.0
 */
@Service
public class YunPianVoiceService extends YunPianBaseService{
    /**
     * 语言验证码
     * @param merchantId
     * @param param
     * @return
     */
    public Result<VoiceSend> voiceSend(Long merchantId, String channelNo, Map<String, String> param){
        return voiceApi.send(param);
    }

    @Override
    public void initApi() {
        voiceApi = yunpianClient.voice();
    }
}
