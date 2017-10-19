package com.shfc.cloud.monitor.service;

import com.shfc.kafka.comsumer.KafkaConsumerClient;
import com.shfc.kafka.comsumer.dto.KafkaConsumerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.shfc.cache.service.CacheRecordConsume
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/31 16:42
 * version V1.0.0
 */
@Service
public class CacheRecordConsume {

	@Autowired
	private KafkaConsumerClient consumerClient;

	private static final String CACHE_RECORD_TOPIC = "cacheRecordAdd";

	@Autowired
	private CacheRecordConsumeService cacheRecordConsumeService;
	/**
	 * 定义kafka启动
	 */
	@PostConstruct
	public void startKafkaConsumer(){
		KafkaConsumerDto kafkaConsumerDto = consumerClient.getKafKaConsumerDto(CACHE_RECORD_TOPIC, 3,cacheRecordConsumeService);
		List<KafkaConsumerDto> list = new ArrayList<KafkaConsumerDto>();
		list.add(kafkaConsumerDto);
		consumerClient.kafkaConsumer(list);
	}
}
