package com.shfc.cloud.cloudbase.service;

import com.shfc.cloud.cloudbase.dao.SourceVirtualMapper;
import com.shfc.cloud.cloudbase.domain.SourceVirtual;
import com.shfc.cloud.cloudbase.manager.SourceVirtualManager;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package com.shfc.cloud.cloudbase.service.SourceVirtualServiceImpl
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/23 13:46
 * version V1.0.0
 */
@Service
public class SourceVirtualServiceImpl implements SourceVirtualService {

	@Autowired
	private SourceVirtualManager sourceVirtualManager;

	@Override
	public ResultDO<SourceVirtual> selectByPrimaryKey(Long id) {
		ResultDO<SourceVirtual> result = new ResultDO<SourceVirtual>();
		SourceVirtual virtual = sourceVirtualManager.selectByPrimaryKey(id);
		result.setSuccess(true);
		result.setData(virtual);
		return result;
	}

	@Override
	public ResultDO<List<SourceVirtual>> selectByDomainList(SourceVirtual sourceVirtual) {
		ResultDO<List<SourceVirtual>> result = new ResultDO<List<SourceVirtual>>();
		List<SourceVirtual> virtuals = sourceVirtualManager.selectByDomainList(sourceVirtual);
		result.setSuccess(true);
		result.setData(virtuals);
		return result;
	}
}
