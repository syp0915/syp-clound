package com.shfc.cloud.monitor.service;

import com.shfc.cloud.monitor.JunitBaseTest;
import com.shfc.cloud.monitor.dto.CacheRecordDTO;
import com.shfc.kafka.exception.BreakRepeatException;
import com.shfc.kafka.exception.NeedRepeatException;
import com.shfc.kafka.exception.NoNeedRepeatException;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package com.shfc.cloud.monitor.service.CacheRecordConsumeServiceTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/4/1 13:52
 * version V1.0.0
 */
public class CacheRecordConsumeServiceTest extends JunitBaseTest {

	@Autowired
	private CacheRecordConsumeService cacheRecordConsumeService;

	@Test
	public void testConsumeMessage(){
		CacheRecordDTO dto = new CacheRecordDTO();
		dto.setMerchantId(1L);
		dto.setType("1");
		dto.setChannelNo("999");
		dto.setContent("abc");
		dto.setKey("1_999_a");
		dto.setStatus("1");

		JSONObject obj = JSONObject.fromObject(dto);
		try {
			cacheRecordConsumeService.consumeMessage(obj.toString());
		} catch (NeedRepeatException e) {
			e.printStackTrace();
		} catch (NoNeedRepeatException e) {
			e.printStackTrace();
		} catch (BreakRepeatException e) {
			e.printStackTrace();
		}
	}
}
