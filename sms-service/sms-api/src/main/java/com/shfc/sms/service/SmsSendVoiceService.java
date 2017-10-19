package com.shfc.sms.service;

import com.shfc.common.result.ResultDO;
import com.shfc.sms.dto.SendVoiceDTO;
import com.shfc.sms.dto.VoiceResultDTO;

/**
 * @Package com.shfc.sms.service.SmsSendVoiceService
 * @Description: 语音发送
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/1 14:39
 * version V1.0.0
 */
public interface SmsSendVoiceService {
    /**
     * 发送语音验证码
     * @param sendVoiceDTO
     * @return
     */
    public ResultDO<VoiceResultDTO> sendVoice(SendVoiceDTO sendVoiceDTO);
}
