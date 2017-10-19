package com.shfc.cloud.mail.dto;

import com.shfc.mail.domain.Email;
import com.shfc.mail.domain.MailConfig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Package com.shfc.cloud.piaop.dto.MailDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/3/22 下午01:57
 * version V1.0.0
 */
@ApiModel(value = "MailDTO")
public class MailDTO {
    @ApiModelProperty(value = "频道号",required = true)
    private String channelNo;

    @ApiModelProperty(value = "邮件信息",required = false)
    private Email email;

    @ApiModelProperty(value = "发件人信息",required = false)
    private MailConfig mailConfig;

    @ApiModelProperty(value = "附件信息",required = false)
    private Object[] attachments;

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public MailConfig getMailConfig() {
        return mailConfig;
    }

    public void setMailConfig(MailConfig mailConfig) {
        this.mailConfig = mailConfig;
    }

    public Object[] getAttachments() {
        return attachments;
    }

    public void setAttachments(Object[] attachments) {
        this.attachments = attachments;
    }
}
