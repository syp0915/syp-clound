package com.shfc.cloud.cloudbase.service;

import com.shfc.cloud.cloudbase.domain.SourceDatabase;
import com.shfc.common.result.ResultDO;

import java.util.List;

/**
 * @Package com.shfc.cloud.cloudbase.service.SourceDatabaseService
 * @Description: 资源数据库信息服务接口
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/27 14:38
 * version V1.0.0
 */
public interface SourceDatabaseService {
	/**
	 * 不分页根据对象查询数据库记录
	 * @param sourceDatabase
	 * @return
	 */
	ResultDO<List<SourceDatabase>> selectByDomainList(SourceDatabase sourceDatabase);

}
