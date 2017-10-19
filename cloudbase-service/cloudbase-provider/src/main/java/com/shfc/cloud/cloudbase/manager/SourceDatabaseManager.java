package com.shfc.cloud.cloudbase.manager;

import com.shfc.cloud.cloudbase.dao.SourceDatabaseMapper;
import com.shfc.cloud.cloudbase.domain.SourceDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package com.shfc.cloud.cloudbase.manager.SourceDatabaseManager
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/27 14:55
 * version V1.0.0
 */
@Service
public class SourceDatabaseManager {
	@Autowired
	private SourceDatabaseMapper sourceDatabaseMapper;

	public List<SourceDatabase> selectByDomainList(SourceDatabase sourceDatabase) {
		return sourceDatabaseMapper.selectByDomainList(sourceDatabase);
	}
}
