package com.shfc.cloud.cloudbase.service;

import com.shfc.cloud.cloudbase.domain.SourceDatabase;
import com.shfc.cloud.cloudbase.manager.SourceDatabaseManager;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package com.shfc.cloud.cloudbase.service.SourceDatabaseServiceImpl
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/27 14:52
 * version V1.0.0
 */
@Service
public class SourceDatabaseServiceImpl implements SourceDatabaseService {
	@Autowired
	private SourceDatabaseManager sourceDatabaseManager;
	@Override
	public ResultDO<List<SourceDatabase>> selectByDomainList(SourceDatabase sourceDatabase) {
		ResultDO<List<SourceDatabase>> result = new ResultDO<List<SourceDatabase>>();
		List<SourceDatabase> databases = sourceDatabaseManager.selectByDomainList(sourceDatabase);
		result.setSuccess(true);
		result.setData(databases);
		return result;
	}
}
