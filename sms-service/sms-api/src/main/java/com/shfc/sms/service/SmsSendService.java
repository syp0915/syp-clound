package com.shfc.sms.service;

import com.shfc.common.result.ResultDO;
import com.shfc.sms.dto.SendSmsDTO;
import com.shfc.sms.dto.SmsBatchResultDTO;
import com.shfc.sms.dto.SmsResultDTO;

import java.util.List;

/**
 * @Package com.shfc.sms.service.SmsSendService
 * @Description: 发送短信服务
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/1 14:41
 * version V1.0.0
 */
public interface SmsSendService {
    /**
     * 发送单条短信
     * @param sendSmsDTO
     * @return
     */
    public ResultDO<SmsResultDTO> singleSend(SendSmsDTO sendSmsDTO);

    /**
     * 批量发送相同内容的短信
     * @param sendSmsDTO
     * @return
     */
    public ResultDO<SmsBatchResultDTO> batchSend(SendSmsDTO sendSmsDTO);
    /**
     * 批量发送不同内容的短信
     * @param sendSmsDTO
     * @return
     */
    public ResultDO<SmsBatchResultDTO> multiSend(SendSmsDTO sendSmsDTO);


}
