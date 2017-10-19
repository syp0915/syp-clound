package com.shfc.cloud.monitor.service;

import com.alibaba.fastjson.JSON;
import com.shfc.cloud.monitor.JunitBaseTest;
import com.shfc.cloud.monitor.query.SummaryQuery;
import com.shfc.cloud.monitor.query.TrendQuery;
import com.shfc.common.result.ResultDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sunyaping
 * @Package com.shfc.cloud.monitor.service
 * @Description TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-03-30 17:29
 * version V1.0.0
 **/
public class SummanyServiceTest extends JunitBaseTest {

    @Autowired
    private SummanyTypeService summanyTypeService;

    @Test
    public void TestSummany(){
        SummaryQuery summaryQuery=new SummaryQuery();
        /*summaryQuery.setBlockId(96);*/
        /*summaryQuery.setChannelNo("tiu");*/
        summaryQuery.setSpan(Long.parseLong("86400000"));
        summaryQuery.setQueryLevel(0);
        summaryQuery.setDistrictId(310100);
        ResultDO<Object> resultDO=summanyTypeService.SummanyByType(summaryQuery);
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print(JSON.toJSONString(resultDO));

    }
}
