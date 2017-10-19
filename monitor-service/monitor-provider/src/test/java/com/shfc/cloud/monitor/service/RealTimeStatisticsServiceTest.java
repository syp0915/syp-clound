package com.shfc.cloud.monitor.service;/**
 * Created by SYP on 2017/3/29.
 */

import com.alibaba.fastjson.JSON;
import com.shfc.cloud.monitor.JunitBaseTest;
import com.shfc.cloud.monitor.query.RealTimeStatisticsQuery;
import com.shfc.common.result.ResultDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sunyaping
 * @Package com.shfc.cloud.monitor.service
 * @Description TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-03-29 13:25
 * version V1.0.0
 **/
public class RealTimeStatisticsServiceTest  extends JunitBaseTest {

    @Autowired
    private RealTimeStatisticsService realTimeStatisticsService;

    @Test
    public void TestRealTimeStatistics(){
        RealTimeStatisticsQuery asq=new RealTimeStatisticsQuery();
       /* asq.setBlockId("7");
        asq.setChannelNo("ttyuiu");
        asq.setDistrictId("2");*/
        asq.setPeriod(900000);
       /* asq.setResidenceId("2");*/
        ResultDO<Object> resultDO=realTimeStatisticsService.getActualStatistics(asq);
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print(JSON.toJSONString(resultDO.getData()));

    }
}
