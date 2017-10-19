package com.shfc.cloud.monitor.manager;

import com.shfc.cloud.monitor.constant.MonitorErrorConstant;
import com.shfc.cloud.monitor.dao.CacheRecordMapper;
import com.shfc.cloud.monitor.domain.CacheRecord;
import com.shfc.cloud.monitor.dto.CacheRecordDTO;
import com.shfc.common.base.Logger;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Package com.shfc.cache.manager.CacheRecordManager
 * @Description: 缓存操作记录manager
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/31 13:56
 * version V1.0.0
 */
@Service
public class CacheRecordManager {
	@Autowired
	private CacheRecordMapper cacheRecordMapper;

	/**
	 * 添加缓存操作记录
	 * @param dto
	 * @return
	 */
	public ResultDO insert(CacheRecordDTO dto){
		CacheRecord cacheRecord = new CacheRecord();
		cacheRecord.setMerchantId(dto.getMerchantId());
		cacheRecord.setChannelNo(dto.getChannelNo());
		cacheRecord.setKey(dto.getKey());
		cacheRecord.setContent(dto.getContent());
		cacheRecord.setType(dto.getType());
		cacheRecord.setStatus(dto.getStatus());
		cacheRecord.setCreateTime(new Date());
		int result = cacheRecordMapper.insertSelective(cacheRecord);
		ResultDO resultDO = new ResultDO();
		if(result>0){
			resultDO.setSuccess(true);
		}else{
			Logger.error(this.getClass(),"添加缓存操作记录失败，key="+dto.getKey());
			resultDO.setSuccess(false);
			resultDO.setErrCode(MonitorErrorConstant.ERROR_ADD_CACHE_RECORD.getCode());
			resultDO.setErrMsg(MonitorErrorConstant.ERROR_ADD_CACHE_RECORD.getMsg());
		}
		return resultDO;
	}
}
