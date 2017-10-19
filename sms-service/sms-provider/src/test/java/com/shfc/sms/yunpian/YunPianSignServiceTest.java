package com.shfc.sms.yunpian;

import com.shfc.sms.JunitBaseTest;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.Sign;
import com.yunpian.sdk.model.SignRecord;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package com.shfc.sms.yunpian.YunPianSignServiceTest
 * @Description: 测试
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/1 16:46
 * version V1.0.0
 */
public class YunPianSignServiceTest extends JunitBaseTest {
    @Autowired
    private YunPianSignService yunPianSignService;

    @Test
    public void testAddSign() throws InterruptedException {
        Map<String, String> param = new HashMap<>();
        param.put(SIGN, "你好吗");
        param.put(NOTIFY, "true");
        param.put(APPLYVIP, "false");
        param.put(ISONLYGLOBAL, "false");
        param.put(INDUSTRYTYPE, "其它");
        Result<Sign> result = yunPianSignService.addSign(1L,null, param);
        System.out.println("----------------------------" + result);

        Thread.sleep(5000L);
    }

    @Test
    public void testUpdateSign(){
        Map<String, String> param = new HashMap<>();
        param.put(OLD_SIGN, "你好吗");
        param.put(SIGN, "我很好");
        param.put(NOTIFY, "true");
        param.put(APPLYVIP, "false");
        param.put(ISONLYGLOBAL, "false");
        param.put(INDUSTRYTYPE, "其它");
        Result<Sign> result = yunPianSignService.updateSign(1L,null, param);
        System.out.println("----------------------------" + result);
    }

    @Test
    public void testGetSign(){
        Map<String, String> param = new HashMap<>();
        param.put(SIGN, "");
        param.put(PAGE_NUM, "1");
        param.put(PAGE_SIZE, "3");
        Result<SignRecord> result = yunPianSignService.getSign(1L,null, param);
        System.out.println("----------------------------" + result);
    }
}
