package com.shfc.mac.service;

import com.shfc.common.result.ResultDO;
import com.shfc.mac.JunitBaseTest;
import com.shfc.mac.dto.MacInfoDTO;
import com.shfc.mac.query.MacQuery;
import com.shfc.mybatis.pagination.Page;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package com.shfc.mac.service.MacListServiceTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/15 10:14
 * version V1.0.0
 */
public class MacListServiceTest extends JunitBaseTest {
    @Autowired
    private MacListService macListService;
    @Test
    public void testMacList(){
        MacQuery query = new MacQuery();
        //query.setDistrictId(310110L);
        query.setPageNumber(1);
        query.setPageSize(5);
        ResultDO<Page<MacInfoDTO>> resultDO = macListService.macList(query);
        System.out.println(resultDO.getData());
    }

    @Test
    public void testMacDetail(){
        MacQuery query = new MacQuery();
        query.setMac("00196843AC17");
        ResultDO<MacInfoDTO> resultDO = macListService.macDetail(query);
        if(resultDO.isSuccess()){
            System.out.println(resultDO.getData().toString());
        }else {
            System.out.println(resultDO.getErrMsg());
        }
    }
}
