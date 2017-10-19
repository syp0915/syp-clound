package com.shfc.cloud.cloudbase.service;/**
 * @File ${package_name}${file_name}
 * @Description: TODO
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * @author ${user}
 * @date ${date} ${time}
 * @version V1.0
 */


import com.shfc.cloud.cloudbase.JunitBaseTest;
import com.shfc.cloud.cloudbase.dto.RegionInfoDTO;
import com.shfc.common.result.ResultDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 测试用例
 *
 * @author wky
 * @version V1.0
 * @create 2016-12-29 10:47
 **/
public class AreaServiceTest extends JunitBaseTest {
    @Autowired
    private AreaService areaService;

    @Test
    public void testAreaService() {

        ResultDO<List<RegionInfoDTO>> resultDO = areaService.getRegionBlockInfo("310000");
        System.out.println(String.valueOf(resultDO.getData()));
//
//        ResultDO<List<RegionInfoDTO>> resultDO_2 = areaService.getRegionBlockInfo("");
//        Assert.assertNull(resultDO_2.getData());
//
//
//        ResultDO<List<RegionInfoDTO>> resultDO_3 = areaService.getRegionBlockInfo("310001");
//        Assert.assertNull(resultDO_3.getData());
    }



}
