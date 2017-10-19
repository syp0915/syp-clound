package com.shfc.mail.service;

import com.shfc.mail.JunitBaseTest;
import com.shfc.mail.domain.Email;
import com.shfc.mail.domain.MailAttach;
import com.shfc.mail.domain.MailConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package com.shfc.mail.service.EmailServiceTest
 * @Description: EmailService
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/10 13:48
 * version V1.0.0
 */
public class EmailServiceTest extends JunitBaseTest {
    @Autowired
    private EmailService emailService;

    @Test
    public void testSendEmail(){
        Email email = new Email();
        email.setToEmails(new String[]{"1058969381@qq.com"});
        email.setCcEmails(new String[]{"316476844@qq.com"});
        email.setBccEmails(new String[]{"598942480@qq.com"});
        email.setSubject("邮件服务测试");
        email.setHtmlContent("\" <p style=\\\"text-align: left;\\\">\\n\" +\n" +
                "                \"     尽管房地产低迷，但没有影响到房地产税相关政策的出台。尽管中国房地产业协会副会长任志强近日表示：“房地产税和房价没关系”。但是买房的朋友依然非常关注相应税收的情况，究竟征收的标准是什么，税该如何计算?<br/>\\n\" +\n" +
                "                \" </p>\\n\" +\n" +
                "                \" <p style=\\\"text-align: left;\\\">\\n\" +\n" +
                "                \"     &nbsp;&nbsp;\\n\" +\n" +
                "                \" </p>\\n\" +\n" +
                "                \" <p style=\\\"text-align: left;\\\">\\n\" +\n" +
                "                \"     房产税征收标准及税收如何计算\\n\" +\n" +
                "                \" </p>\\n\" +\n");
        email.setAttachments(new MailAttach[]{
                new MailAttach("red.jpg", "http://hi.csdn.net/attachment/201012/29/8394323_1293613306CGzE.jpg"),
                new MailAttach("black.jpg", "http://hi.csdn.net/attachment/201012/29/8394323_1293614183gD0H.jpg")});
        emailService.sendEmail(1L,"999", email);
    }

    @Test
    public void testSendEmailAndConfig(){
        MailConfig mailConfig = new MailConfig();
        mailConfig.setEmailHost("smtp.qq.com");
        mailConfig.setEmailUserName("316476844@qq.com");
        mailConfig.setEmailPassword("lhspvisiiiaebifh");
        mailConfig.setEmailFrom("316476844@qq.com");

        Email email = new Email();
        email.setToEmails(new String[]{"lvbin@oriental-finance.com"});
        email.setSubject("127982179邮件服务测试");
        email.setHtmlContent("<p style=\\\"text-align: left;\\\">\\n\" +\n" +
                "                \"     尽管房地产低迷，但没有影响到房地产税相关政策的出台。尽管中国房地产业协会副会长任志强近日表示：“房地产税和房价没关系”。但是买房的朋友依然非常关注相应税收的情况，究竟征收的标准是什么，税该如何计算?<br/>\\n\" +\n" +
                "                \" <p style=\\\"text-align: left;\\\">\\n\" +\n" +
                "                \"     房产税征收标准及税收如何计算\\n\" +\n" +
                "                \" </p>\\n\" +\n");
        email.setAttachments(new MailAttach[]{
                new MailAttach("red.jpg", "http://hi.csdn.net/attachment/201012/29/8394323_1293613306CGzE.jpg"),
                new MailAttach("black.jpg", "http://hi.csdn.net/attachment/201012/29/8394323_1293614183gD0H.jpg")});


        emailService.sendEmail(1L,"999", mailConfig, email);
    }
}
