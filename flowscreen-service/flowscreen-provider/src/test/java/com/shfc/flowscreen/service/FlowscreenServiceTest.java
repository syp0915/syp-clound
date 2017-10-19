package com.shfc.flowscreen.service;

import com.shfc.common.result.ResultDO;
import com.shfc.flowscreen.JunitBaseTest;
import com.shfc.flowscreen.domain.FlowscreenRecord;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package com.shfc.flowscreen.service.FlowscreenServiceTest
 * @Description: FlowscreenServiceTest
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/3/23 下午7:18
 * version V1.0.0
 */
public class FlowscreenServiceTest extends JunitBaseTest {
    @Autowired
    private FlowscreenService flowscreenService;
    @Test
    public void testFlowscreenReq() {
        FlowscreenRecord flowscreenRecord = new FlowscreenRecord();
        flowscreenRecord.setMerchantId(1L);
        flowscreenRecord.setChannelNo("999");
        flowscreenRecord.setUrl("http://10.27.97.219:9999/path/page.html?par");
        flowscreenRecord.setMac("98bc576855c5");
        ResultDO<Object> resultDO = flowscreenService.flowscreenReq(flowscreenRecord);
        String msg = resultDO.getErrMsg();
    }
}
