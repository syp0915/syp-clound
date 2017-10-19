package com.shfc.cloud.mail;

import com.shfc.cloud.JunitBaseMockMvcTest;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @Package com.shfc.cloud.mail
 * @Description: MailControllerTest
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/3/16 下午6:45
 * version V1.0.0
 */
public class MailControllerTest extends JunitBaseMockMvcTest {
    @Test
    public void testMailSend() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/mail/sendMail/v1.0.0")
                .param("reqJson", "{\n" +
                        "    \"accessKey\": \"111\",\n" +
                        "    \"signature\": \"112211\",\n" +
                        "    \"channelNo\": \"999\",\n" +
                        "    \"email\": {\n" +
                        "        \"toEmails\": [\n" +
                        "            \"zhoumin@oriental-finance.com\"\n" +
                        "        ],\n" +
                        "        \"subject\": \"测试邮件\",\n" +
                        "        \"htmlContent\": \"这是一个邮件，内容内容内容。。。。。\",\n" +
                        "        \"ccEmails\": [\n" +
                        "            \"zhouminpz@126.com\"\n" +
                        "        ],\n" +
                        "        \"bccEmails\": [\n" +
                        "            \"1584450392@qq.com\"\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    \"mailConfig\": {\n" +
                        "        \"emailHost\": \"smtp.qq.com\",\n" +
                        "        \"emailUserName\": \"1584450392@qq.com\",\n" +
                        "        \"emailPassword\": \"ajdhkajhfdanb\",\n" +
                        "        \"emailFrom\": \"1584450392@qq.com\"\n" +
                        "    },\n" +
                        "    \"attachments\": [\n" +
                        "        {\n" +
                        "            \"name\": \"red.jpg\",\n" +
                        "            \"path\": \"\\\"http://hi.csdn.net/attachment/201012/29/8394323_1293613306CGzE.jpg\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"name\": \"black.jpg\",\n" +
                        "            \"path\": \"http://hi.csdn.net/attachment/201012/29/8394323_1293614183gD0H.jpg\"\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
