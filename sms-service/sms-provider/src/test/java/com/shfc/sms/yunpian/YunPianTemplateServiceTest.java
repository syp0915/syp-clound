package com.shfc.sms.yunpian;

import com.shfc.sms.JunitBaseTest;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.Template;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 模板测试
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-08 13:46
 **/
public class YunPianTemplateServiceTest extends JunitBaseTest {
    @Autowired
    private YunPianTemplateService yunPianTemplateService;

    @Test
    public void TestAddTemplate(){
        Map<String,String> params=new HashMap<String,String>();
        params.put(TPL_CONTENT,"【东方云】您的订单编号是#code#");
        Result<Template> result=yunPianTemplateService.addTemplate(1L,"999",params);
        System.out.println(result);
    }

    @Test
    public void TestGetTemplate(){
        Map<String,String> params=new HashMap<String,String>();
        params.put(TPL_ID,"1727902");
        Result<List<Template>> result=yunPianTemplateService.getTemplate(1L,"999",params);
        System.out.println(result);
    }

    @Test
    public void TestDeleteTemplate(){
        Map<String,String> params=new HashMap<String,String>();
        params.put(TPL_ID,"1729048");
        Result<Template> result=yunPianTemplateService.deleteTemplate(1L,"999",params);
        System.out.println(result);
    }

    @Test
    public void TestUpdateTemplate(){
        Map<String,String> params=new HashMap<String,String>();
        params.put(TPL_ID,"1727536");
        params.put(TPL_CONTENT,"【东方云】您的订单编号是#code#");

        Result<Template> result=yunPianTemplateService.updateTemplate(1L,"999",params);
        System.out.println(result);
    }

}
