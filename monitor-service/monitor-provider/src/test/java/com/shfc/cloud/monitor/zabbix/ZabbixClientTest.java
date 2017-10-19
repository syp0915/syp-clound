package com.shfc.cloud.monitor.zabbix;

import com.shfc.cloud.monitor.JunitBaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package com.shfc.cloud.monitor.zabbix.ZabbixClientTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/4/18 19:06
 * version V1.0.0
 */
public class ZabbixClientTest extends JunitBaseTest {

	@Autowired
	private ZabbixClient zabbixClient;

	@Test
	public void testQueryTrendByItemId(){
		try {
//			long timeFrom = (System.currentTimeMillis()-1000*60*60*48)/1000;
//			long timeTill = (System.currentTimeMillis()-1000*60*60*24)/1000;
			long timeFrom = (System.currentTimeMillis()-1000*60*60*25)/1000;
			long timeTill = System.currentTimeMillis();
			zabbixClient.queryTrendByItemId("85471",24,3,timeFrom,null);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
