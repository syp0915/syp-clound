package com.shfc.sms.service;

import com.shfc.common.result.ResultDO;
import com.shfc.sms.JunitBaseTest;
import com.shfc.sms.dto.SmsMerchantTemplateDTO;
import com.shfc.sms.dto.TemplateResultDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 模板
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-02 10:49
 **/
public class SmsMerchantTemplateServiceTest extends JunitBaseTest {
    @Autowired
    private SmsMerchantTemplateService smsMerchantTemplateService;

    @Test
    public void testAddTemplate(){
        SmsMerchantTemplateDTO dto=new SmsMerchantTemplateDTO();
        dto.setTplContent("你的验证是#code#,请注意使用时间");
        dto.setMerchantId(1L);
        dto.setSignId(18L);
        dto.setChannelNo("999");

        ResultDO<TemplateResultDTO> resultDO=smsMerchantTemplateService.addTemplate(dto);

        System.out.println(resultDO);

    }

    @Test
    public void testGetTemplate(){
        SmsMerchantTemplateDTO dto=new SmsMerchantTemplateDTO();
        //dto.setTplId("1727538");
        dto.setMerchantId(1L);
        dto.setChannelNo("999");

        ResultDO<List<TemplateResultDTO>> resultDO=smsMerchantTemplateService.getTemplate(dto);

        System.out.println(resultDO.toString());

    }

    @Test
    public void testUpdateTemplate(){
        SmsMerchantTemplateDTO dto=new SmsMerchantTemplateDTO();
        dto.setTplContent("您的验证码是#code#");
        dto.setMerchantId(1L);
        dto.setSignId(1L);
        dto.setTplId(1729184L);

        ResultDO<TemplateResultDTO> resultDO=smsMerchantTemplateService.updateTemplate(dto);

        System.out.println(resultDO.getErrMsg());

    }

    @Test
    public void testDeleteTemplate(){
        SmsMerchantTemplateDTO dto=new SmsMerchantTemplateDTO();

        dto.setMerchantId(1L);
        dto.setChannelNo("999");
        dto.setTplId(1727538L);

        ResultDO<TemplateResultDTO> resultDO=smsMerchantTemplateService.deleteTemplate(dto);

        System.out.println(resultDO.getErrMsg());

    }
}
