package com.shfc.mail.service;

import com.shfc.common.result.ResultDO;
import com.shfc.mail.domain.Email;
import com.shfc.mail.domain.MailConfig;

/**
 * @Package com.shfc.mail.service.EmailService
 * @Description: EmailService
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/10 11:13
 * version V1.0.0
 */
public interface EmailService {

    /**
     * 发送邮件
     * @param merchantId -商户id
     * @param email
     * @return
     */
    ResultDO<Boolean> sendEmail(Long merchantId,String channelNo, Email email);

    /**
     * 发送邮件
     * @param merchantId-商户id
     * @param mailConfig
     * @param email
     * @return
     */
    ResultDO<Boolean> sendEmail(Long merchantId,String channelNo, MailConfig mailConfig, Email email);
}
