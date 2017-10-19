package com.shfc.sms.manager;

import com.shfc.mybatis.pagination.Page;
import com.shfc.sms.JunitBaseTest;
import com.shfc.sms.domain.SmsMerchantSign;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package com.shfc.sms.manager.SmsMerchantSignManagerTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/3/9 上午10:30
 * version V1.0.0
 */
public class SmsMerchantSignManagerTest extends JunitBaseTest {
    @Autowired
    private SmsMerchantSignManager smsMerchantSignManager;

    @Test
    public void TestSyncTpl(){
        smsMerchantSignManager.syncSign();
    }

    @Test
    public void testQuerySign(){
        Page<SmsMerchantSign> result = smsMerchantSignManager.querySign(new Page<SmsMerchantSign>(1,50));
        System.out.print(result);
    }
}
