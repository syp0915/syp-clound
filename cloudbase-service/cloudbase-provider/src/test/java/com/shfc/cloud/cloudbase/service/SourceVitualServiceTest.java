package com.shfc.cloud.cloudbase.service;

import com.shfc.cloud.cloudbase.JunitBaseTest;
import com.shfc.cloud.cloudbase.domain.SourceVirtual;
import com.shfc.common.result.ResultDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Package com.shfc.cloud.cloudbase.service.SourceVitualServiceTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/28 10:17
 * version V1.0.0
 */
public class SourceVitualServiceTest extends JunitBaseTest {

	@Autowired
	private SourceVirtualService sourceVirtualService;

	@Test
	public void testSelectByPrimaryKey(){
		ResultDO<SourceVirtual> resultDO = sourceVirtualService.selectByPrimaryKey(1l);
	}

	@Test
	public void testSelectByDomainList(){
		SourceVirtual sourceVirtual = new SourceVirtual();
		sourceVirtual.setMerchantId(1L);
		sourceVirtual.setChannelNumber("999");
		ResultDO<List<SourceVirtual>> resultDO = sourceVirtualService.selectByDomainList(sourceVirtual);
	}


}
