package com.shfc.cloud.cloudbase.service;

import com.shfc.cloud.cloudbase.JunitBaseTest;
import com.shfc.cloud.cloudbase.domain.SourceDatabase;
import com.shfc.common.result.ResultDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Package com.shfc.cloud.cloudbase.service.SourceDatabaseServiceTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/28 19:36
 * version V1.0.0
 */
public class SourceDatabaseServiceTest extends JunitBaseTest{

	@Autowired
	private SourceDatabaseService sourceDatabaseService;
	@Test
	public void testSelectByDomainList(){
		SourceDatabase sourceDatabase = new SourceDatabase();
		sourceDatabase.setMerchantId(1L);
		sourceDatabase.setChannelNo("999");
		ResultDO<List<SourceDatabase>> resultDO = sourceDatabaseService.selectByDomainList(sourceDatabase);

	}
}
