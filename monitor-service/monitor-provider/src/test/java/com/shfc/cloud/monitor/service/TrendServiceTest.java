package com.shfc.cloud.monitor.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.monitor.JunitBaseTest;
import com.shfc.cloud.monitor.dto.TrendDTO;
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
 * @date 2017-03-30 17:27
 * version V1.0.0
 **/
public class TrendServiceTest extends JunitBaseTest {
    @Autowired
    private TrendService trendService;

    @Test
    public void TestTrend(){
        TrendQuery trendQuery=new TrendQuery();
       /* trendQuery.setBlockId(7);
        trendQuery.setChannelNo("ttyuiu");//不必须
        trendQuery.setDistrictId(2);*/
        trendQuery.setStartTime(1496728169000L); //l必填*/
        /*trendQuery.setContrastiveStartTime(Long.parseLong("3232")); */
        trendQuery.setScale(Long.parseLong("86400000")); //必填
        trendQuery.setSpan(Long.parseLong("2592000000")); //必填
        /*trendQuery.setResidenceId(2);*/
        ResultDO<TrendDTO> resultDO=trendService.getTrendData(trendQuery);
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println(JSON.toJSONString(resultDO));

    }
}
