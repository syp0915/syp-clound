package com.shfc.mail.manager;

import com.alibaba.fastjson.JSON;
import com.shfc.common.base.Logger;
import com.shfc.mail.dao.EmailRecordMapper;
import com.shfc.mail.domain.Email;
import com.shfc.mail.domain.EmailRecord;
import com.shfc.mail.enums.EmailChannel;
import com.shfc.mail.enums.EmailErrorCode;
import com.shfc.mail.enums.EmailStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Package com.shfc.mail.manager.EmailRecordManager
 * @Description: EmailRecordManager
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/14 17:39
 * version V1.0.0
 */
@Service
public class EmailRecordManager {
    @Autowired
    private EmailRecordMapper emailRecordMapper;

    @Async
    public void saveEmailRecord(Long merchantId,String channelNo, Email email, EmailStatus status,
                                EmailChannel channel, String reason){
        EmailRecord emailRecord = new EmailRecord();

        emailRecord.setMerchantId(merchantId);
        emailRecord.setChannelNo(channelNo);
        emailRecord.setStatus(status.getValue());
        emailRecord.setReqContent(JSON.toJSONString(email));
        emailRecord.setChannel(channel.getValue());
        emailRecord.setReason(reason);
        emailRecord.setCreater(merchantId);

        try {
            emailRecordMapper.insert(emailRecord);
        }catch (Exception e){
            Logger.error(EmailRecordManager.class, EmailErrorCode.EMAILSEND_SAVE_ERROR.getMsg(), e);
        }
    }
}
