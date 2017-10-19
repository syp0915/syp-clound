package com.shfc.cloud.monitor.service;

import com.alibaba.fastjson.JSON;
import com.shfc.cloud.monitor.JunitBaseTest;
import com.shfc.cloud.monitor.dto.ChannelDataDTO;
import com.shfc.cloud.monitor.dto.LogListDTO;
import com.shfc.cloud.monitor.dto.VisistHistoryDTO;
import com.shfc.cloud.monitor.query.ChannelDataQuery;
import com.shfc.cloud.monitor.query.LogQuery;
import com.shfc.cloud.monitor.query.VisitHistoryQuery;
import com.shfc.common.result.ResultDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-27 17:57
 **/
public class DataMonitorServiceTest extends JunitBaseTest {
    @Autowired(required = false)
    private DataMonitorService dataMonitorService;

    @Test
    public void testChannelDataList(){
        ChannelDataQuery query=new ChannelDataQuery();
        //query.setChannelNo("00119");
        ResultDO<ChannelDataDTO> resultDO=dataMonitorService.channelDataList(query);
        System.out.println(JSON.toJSONString(resultDO));

    }

    @Test
    public void testLogDataList() throws ParseException {
        LogQuery query=new LogQuery();
        //query.setMac("00196843A529");
        //query.setStartTime(new Date(1488080000));
        //query.setBlockId("155");

        ResultDO<LogListDTO> resultDO=dataMonitorService.logDataList(query);

        System.out.println(JSON.toJSONString(resultDO));
    }

    @Test
    public void testMacVisitHistory(){
        VisitHistoryQuery query=new VisitHistoryQuery();
       // query.setChannelNo("999");
        //query.setStartTime(new Date(1489334400000L));

        ResultDO<VisistHistoryDTO> resultDO=dataMonitorService.macVisitHistory(query);
        System.out.println(JSON.toJSONString(resultDO));

    }
}
