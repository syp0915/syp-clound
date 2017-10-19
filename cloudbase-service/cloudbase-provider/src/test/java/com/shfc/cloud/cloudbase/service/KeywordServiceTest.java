package com.shfc.cloud.cloudbase.service;


import com.shfc.cloud.cloudbase.JunitBaseTest;
import com.shfc.cloud.cloudbase.dto.ChannelDTO;
import com.shfc.cloud.cloudbase.dto.PlotDTO;
import com.shfc.cloud.cloudbase.query.ChannelQuery;
import com.shfc.cloud.cloudbase.query.PlotNameQuery;
import com.shfc.common.result.ResultDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-25 14:37
 **/
public class KeywordServiceTest extends JunitBaseTest{
    @Autowired(required = false)
    private KeywordService keywordService;

    @Test
    public void testQueryPlotNameBykeyword(){
        PlotNameQuery query=new PlotNameQuery();
        query.setKeyword("峰");
        //query.setNum(5);
//        query.setDistrictId("310109");
//        query.setBlockId("167");
        ResultDO<List<PlotDTO>> resultDO=keywordService.queryPlotNameBykeyword(query);
        System.out.println(resultDO.getData());
    }

    @Test
    public void testQueryChannelBykeyword(){
        ChannelQuery query=new ChannelQuery();
        query.setKeyword("99");
        //query.setNum(10);
        ResultDO<List<ChannelDTO>> resultDO=keywordService.queryChannelBykeyword(query);
        System.out.println(resultDO.getData());
    }

}
