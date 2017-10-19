package com.shfc.mail.service;

import com.alibaba.fastjson.JSON;
import com.shfc.common.base.Logger;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.log.LogFileUtils;
import com.shfc.mail.domain.Email;
import com.shfc.mail.domain.MailAttach;
import com.shfc.mail.domain.MailConfig;
import com.shfc.mail.enums.EmailChannel;
import com.shfc.mail.enums.EmailErrorCode;
import com.shfc.mail.enums.EmailStatus;
import com.shfc.mail.manager.EmailRecordManager;
import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.activation.URLDataSource;
import javax.mail.internet.MimeMessage;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * @Package com.shfc.mail.service.EmailServiceImpl
 * @Description: EmailService
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/10 11:14
 * version V1.0.0
 */
@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSenderImpl javaMailSender;
    @Value("${mail.smtp.auth}")
    private String MAIL_SMTP_AUTH;
    @Value("${mail.smtp.timeout}")
    private String MAIL_SMTP_TIMEOUT;
    @Value("${mail.from}")
    private String MAIL_FROM;

    @Autowired
    private EmailRecordManager emailRecordManager;

    private LogFileUtils logDataUtils = LogFileUtils.getInstance("mail-provider");

    @Override
    public ResultDO<Boolean> sendEmail(Long merchantId,String channelNo, Email email) {

        long startTimeMillis = System.currentTimeMillis();

        ResultDO<Boolean> resultDO = new ResultDO<>();
        String verify = verifyEmail(email);
        if (verify != null) {
            resultDO.setErrMsg(verify);
            emailRecordManager.saveEmailRecord(merchantId,channelNo, email, EmailStatus.FAILED, EmailChannel.DEFAULT, verify);
            logDataUtils.error("发送邮件", merchantId,String.valueOf(channelNo), EmailServiceImpl.class, "sendEmail", startTimeMillis);
            return resultDO;
        }

        String error = sendMail(javaMailSender, email, MAIL_FROM);
        if(error != null){
            resultDO.setErrMsg(error);
            emailRecordManager.saveEmailRecord(merchantId,channelNo, email, EmailStatus.EXCEPTION, EmailChannel.DEFAULT, error);
            logDataUtils.error("发送邮件", merchantId,channelNo, EmailServiceImpl.class, "sendEmail", startTimeMillis);
            return resultDO;
        }
        resultDO.setSuccess(true);
        logDataUtils.info("发送邮件", merchantId,channelNo, EmailServiceImpl.class, "sendEmail", startTimeMillis);
        emailRecordManager.saveEmailRecord(merchantId,channelNo, email, EmailStatus.SUCCESS, EmailChannel.DEFAULT, null);

        return resultDO;
    }

    @Override
    public ResultDO<Boolean> sendEmail(Long merchantId,String channelNo, MailConfig mailConfig, Email email) {
        long startTimeMillis = System.currentTimeMillis();
        ResultDO<Boolean> resultDO = new ResultDO<>();
        String verifyConfig = verifyConfig(mailConfig);
        if (verifyConfig != null) {
            resultDO.setErrMsg(verifyConfig);
            emailRecordManager.saveEmailRecord(merchantId,channelNo, email, EmailStatus.FAILED, EmailChannel.CUSTOM, verifyConfig);
            logDataUtils.error("发送邮件", merchantId,channelNo, EmailServiceImpl.class, "sendEmail", startTimeMillis);
            return resultDO;
        }
        String verifyEmail = email.verifyEmail();
        if (verifyEmail != null) {
            resultDO.setErrMsg(verifyEmail);
            emailRecordManager.saveEmailRecord(merchantId,channelNo, email, EmailStatus.FAILED, EmailChannel.CUSTOM, verifyEmail);
            logDataUtils.error("发送邮件", merchantId,channelNo, EmailServiceImpl.class, "sendEmail", startTimeMillis);
            return resultDO;
        }
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        senderImpl.setHost(mailConfig.getEmailHost());
        senderImpl.setUsername(mailConfig.getEmailUserName());
        senderImpl.setPassword(mailConfig.getEmailPassword());

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", MAIL_SMTP_AUTH); // 设为true，服务器进行认证
        prop.put("mail.smtp.timeout", MAIL_SMTP_TIMEOUT);
        if(mailConfig.getEmailHost().endsWith("qq.com")){
            // qq 服务器需要ssl
            try {
                MailSSLSocketFactory sf = new MailSSLSocketFactory();
                sf.setTrustAllHosts(true);
                prop.put("mail.smtp.ssl.enable", "true");
                prop.put("mail.smtp.ssl.socketFactory", sf);
            } catch (GeneralSecurityException e) {
            }
        }
        senderImpl.setJavaMailProperties(prop);
        String error = sendMail(senderImpl, email, mailConfig.getEmailFrom());
        if(error != null){
            resultDO.setErrMsg(error);
            logDataUtils.error("发送邮件", merchantId,channelNo, EmailServiceImpl.class, "sendEmail", startTimeMillis);
            emailRecordManager.saveEmailRecord(merchantId,channelNo, email, EmailStatus.EXCEPTION, EmailChannel.CUSTOM, error);
            return resultDO;
        }
        resultDO.setSuccess(true);
        logDataUtils.error("发送邮件", merchantId,channelNo, EmailServiceImpl.class, "sendEmail", startTimeMillis);
        emailRecordManager.saveEmailRecord(merchantId,channelNo, email, EmailStatus.SUCCESS, EmailChannel.CUSTOM, null);
        return resultDO;
    }


    private String sendMail(JavaMailSender javaMailSender, Email email, String fromMail){
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper  messageHelper = new MimeMessageHelper(mailMessage, true, email.getEncoding());
            messageHelper.setFrom(fromMail);
            messageHelper.setTo(email.getToEmails());
            if(!ValidateHelper.isEmpty(email.getCcEmails())){
                messageHelper.setCc(email.getCcEmails());
            }
            if(!ValidateHelper.isEmpty(email.getBccEmails())){
                messageHelper.setBcc(email.getBccEmails());
            }
            messageHelper.setSubject(email.getSubject());
            // true 表示启动HTML格式的邮件
            messageHelper.setText(email.getHtmlContent(), true);
            if(!ValidateHelper.isEmpty(email.getAttachments())){
                for(MailAttach attach: email.getAttachments()){
                    try {
                        URLDataSource url = new URLDataSource(new URL(attach.getPath()));
                        messageHelper.addAttachment(attach.getName(), url);
                    } catch (MalformedURLException e) {
                        Logger.error(EmailServiceImpl.class, EmailErrorCode.ATTA_ADD_ERROR.getMsg() + JSON.toJSONString(email), e);//附件添加异常
                        return e.getMessage();
                    }
                }
            }

            javaMailSender.send(mailMessage);
        } catch (Exception e) {
            Logger.error(EmailServiceImpl.class, EmailErrorCode.EMAILSEND_ERROR.getMsg() + JSON.toJSONString(email), e);//邮件发送异常
            return e.getMessage();
        }

        return null;
    }

    /**
     * Email参数校验
     */
    private String verifyEmail(Email email){
        if(ValidateHelper.isEmpty(email.getToEmails())){
            return EmailErrorCode.TOEMAILS_NOT_NULL.getMsg();//收件人不能为空
        }
        if(ValidateHelper.isEmpty(email.getSubject())){
            return EmailErrorCode.SUBJECT_NOT_NULL.getMsg();//邮件主题不能为空
        }
        if(ValidateHelper.isEmpty(email.getHtmlContent())){
            return EmailErrorCode.HTMLCONTENT_NOT_NULL.getMsg();//邮件内容不能为空
        }

        return null;
    }

    /**
     * MailConfig参数校验
     */
    private String verifyConfig(MailConfig mailConfig){
        if(ValidateHelper.isEmpty(mailConfig.getEmailHost())){
            return EmailErrorCode.EMAILHOST_NOT_NULL.getMsg();//邮箱服务器不能为空
        }
        if(ValidateHelper.isEmpty(mailConfig.getEmailUserName())){
            return EmailErrorCode.EMAILUSERNAME_NOT_NULL.getMsg();//邮箱服务器用户名不能为空
        }
        if(ValidateHelper.isEmpty(mailConfig.getEmailPassword())){
            return EmailErrorCode.EMAILPASSWORD_NOT_NULL.getMsg();//邮箱服务器密码不能为空
        }
        if(ValidateHelper.isEmpty(mailConfig.getEmailFrom())){
            return EmailErrorCode.EMAILFROM_NOT_NULL.getMsg();//发件人邮箱不能为空
        }
        if(!mailConfig.getEmailFrom().contains("@")){
            return EmailErrorCode.EMAIL_FORMAT_ERR.getMsg();//邮箱格式错误
        }
        String suffix = mailConfig.getEmailFrom().split("@")[1];
        if(!mailConfig.getEmailHost().endsWith(suffix)){
            return EmailErrorCode.EMAILHOST_EMAILFROM_NOT_CON.getMsg();//发件邮箱必须与邮箱服务保持一致
        }

        return null;
    }
}
