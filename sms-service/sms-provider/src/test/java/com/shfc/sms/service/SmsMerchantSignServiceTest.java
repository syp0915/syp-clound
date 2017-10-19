package com.shfc.sms.service;

import com.shfc.common.result.ResultDO;
import com.shfc.sms.JunitBaseTest;
import com.shfc.sms.domain.SmsMerchantSign;
import com.shfc.sms.dto.SmsMerchantSignDTO;
import com.shfc.sms.dto.SmsSignDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @Package com.shfc.sms.service
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/3/6 下午1:41
 * version V1.0.0
 */
public class SmsMerchantSignServiceTest extends JunitBaseTest {
    @Autowired
    private SmsMerchantSignService smsMerchantSignService;

    @Test
    public void testAddSign(){
        SmsMerchantSignDTO smsMerchantSignDTO_1 = new SmsMerchantSignDTO();
        smsMerchantSignDTO_1.setMerchantId(1L);
        smsMerchantSignDTO_1.setChannelNo("997");
        smsMerchantSignDTO_1.setSign("测试所属行业");
        smsMerchantSignDTO_1.setIndustryType("生产/加工/制造");
        smsMerchantSignDTO_1.setNotify(0);
        ResultDO<SmsSignDTO> resultDO_1 = smsMerchantSignService.addSign(smsMerchantSignDTO_1);
        Assert.assertNotNull(resultDO_1);

        /*SmsMerchantSignDTO smsMerchantSignDTO_2 = new SmsMerchantSignDTO();
        smsMerchantSignDTO_2.setMerchantId(1L);
        smsMerchantSignDTO_2.setSign("嘿嘿嘿");
        smsMerchantSignDTO_2.setIndustryType("IT");
        smsMerchantSignDTO_2.setNotify(0);
        ResultDO<SmsSignDTO> resultDO_2 = smsMerchantSignService.addSign(smsMerchantSignDTO_2);
        Assert.assertNotNull(resultDO_2);*/
    }

    @Test
    public void testUpdateSign(){
        SmsMerchantSignDTO smsMerchantSignDTO_1 = new SmsMerchantSignDTO();
        smsMerchantSignDTO_1.setMerchantId(1L);
        smsMerchantSignDTO_1.setSignId(22L);
        smsMerchantSignDTO_1.setOldSign("所属行业");
        smsMerchantSignDTO_1.setSign("测试所属行业");
        smsMerchantSignDTO_1.setIndustryType("物联网");
        smsMerchantSignDTO_1.setNotify(0);
        smsMerchantSignDTO_1.setChannelNo("997");
        ResultDO<SmsSignDTO> resultDO_1 = smsMerchantSignService.updateSign(smsMerchantSignDTO_1);
        Assert.assertNotNull(resultDO_1);
    }

    @Test
    public void testGetSignById(){
        ResultDO<SmsSignDTO> resultDO = smsMerchantSignService.getSignById(9L);
        Assert.assertNotNull(resultDO);
    }

 /*   @Test
    public void testQuerySignByMerchantId(){
        ResultDO<List<SmsMerchantSign>> resultDO = smsMerchantSignService.querySignByMerchantId(1L);
        Assert.assertNotNull(resultDO);
    }*/
}
