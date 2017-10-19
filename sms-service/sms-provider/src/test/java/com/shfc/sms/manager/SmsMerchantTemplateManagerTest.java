package com.shfc.sms.manager;

import com.shfc.sms.JunitBaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-09 09:13
 **/
public class SmsMerchantTemplateManagerTest extends JunitBaseTest {
    @Autowired
    private SmsMerchantTemplateManager merchantTemplateManager;
    @Test
    public void TestSyncTpl(){
        merchantTemplateManager.syncTpl();

    }
}
