package com.shfc.cloud.cloudbase.service;

import com.shfc.cloud.cloudbase.JunitBaseTest;
import com.shfc.cloud.cloudbase.dto.ChannelDTO;
import com.shfc.common.result.ResultDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-28 14:07
 **/
public class ChannelServiceTest extends JunitBaseTest {
    @Autowired
    private ChannelService channelService;

    @Test
    public void testQueryChannelByNo(){
        ResultDO<ChannelDTO> resultDO=channelService.queryChannelByNo("999");
        System.out.println(resultDO.getData());

    }
}
