package com.shfc.cloud.monitor.service;

import com.shfc.cloud.monitor.dto.CacheRecordDTO;
import com.shfc.cloud.monitor.manager.CacheRecordManager;
import com.shfc.common.base.Logger;
import com.shfc.kafka.comsumer.BaseKafkaConsumerService;
import com.shfc.kafka.exception.BreakRepeatException;
import com.shfc.kafka.exception.NeedRepeatException;
import com.shfc.kafka.exception.NoNeedRepeatException;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package com.shfc.apistore.api.cache.kafka.CacheRecordConsume
 * @Description: 添加缓存记录消费者
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/30 20:28
 * version V1.0.0
 */
@Service
public class CacheRecordConsumeService implements BaseKafkaConsumerService {

	@Autowired
	private CacheRecordManager cacheRecordManager;

	@Override
	public String consumeMessage(String recordStr) throws NeedRepeatException, NoNeedRepeatException, BreakRepeatException {
		JSONObject reqObj = JSONObject.fromObject(recordStr);
		CacheRecordDTO dto = (CacheRecordDTO)JSONObject.toBean(reqObj,CacheRecordDTO.class);
		try{
			cacheRecordManager.insert(dto);
		}catch(Exception e){
			Logger.error(this.getClass(),"添加缓存记录失败",e);
			throw new NeedRepeatException("添加缓存记录失败");
		}

		return "true";
	}
}
