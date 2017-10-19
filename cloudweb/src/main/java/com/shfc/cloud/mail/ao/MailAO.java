package com.shfc.cloud.mail.ao;

import com.shfc.cloud.constant.CloudConstant;
import com.shfc.cloud.mail.dto.MailDTO;
import com.shfc.cloud.utils.HttpSessionUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.mail.domain.Email;
import com.shfc.mail.domain.MailAttach;
import com.shfc.mail.domain.MailConfig;
import com.shfc.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 17/3/16 下午6:43
 * @Package com.shfc.cloud.mail.ao.MailAo
 * @Description: mail ao
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/3/15 下午2:15
 * version V1.0.0
 */
@Service
public class MailAO {
    @Autowired
    private EmailService emailService;

    public ResultDO<Boolean> sendEmail(MailDTO mailDTO){
        String channelNo = mailDTO.getChannelNo();
        Email email = mailDTO.getEmail();
        MailConfig mailConfig = mailDTO.getMailConfig();
        Long merchantId = HttpSessionUtils.getObject(CloudConstant.CURRENT_MERCHANT_ID);
        ResultDO<Boolean> resultDO = new ResultDO<>();
        if (null == email) {
            resultDO.setErrMsg("邮件基本信息不能为空");
            return resultDO;
        }
        Object[] objects = mailDTO.getAttachments();
        if (null != objects && objects.length != 0) {//将附件信息进行封装
            MailAttach[] mailAttaches = new MailAttach[objects.length];
            for (int i = 0 ; i < objects.length ; i++){
                Map<String , String> map = (HashMap)objects[i];
                mailAttaches[i] = new MailAttach(map.get("name"), map.get("path"));
            }
            email.setAttachments(mailAttaches);
        }
        if (null == mailDTO.getMailConfig()) {//默认发送邮件
            return emailService.sendEmail(merchantId,channelNo,email);
        }else {//自定义发送邮件
            return emailService.sendEmail(merchantId,channelNo, mailConfig,email);
        }
    }
}
