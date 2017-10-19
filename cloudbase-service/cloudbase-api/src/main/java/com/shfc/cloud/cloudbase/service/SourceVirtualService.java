package com.shfc.cloud.cloudbase.service;

import com.shfc.cloud.cloudbase.domain.SourceVirtual;
import com.shfc.common.result.ResultDO;

import java.util.List;

/**
 * @Package com.shfc.cloud.cloudbase.service.SourceVirtualService
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/23 13:44
 * version V1.0.0
 */
public interface SourceVirtualService {

	/**
	 * @Description: 根据主键获取一条数据库记录
	 * @Title selectByPrimaryKey
	 * @Author lv bin
	 * @Date 2017/03/22 15:30
	 * @param id
	 * @return com.shfc.cloud.container.domain.SourceVirtual
	 * @throws []
	 */
	ResultDO<SourceVirtual> selectByPrimaryKey(Long id);

	/**
	 * 不分页根据对象查询数据库记录
	 * @param sourceVirtual
	 * @return
	 */
	ResultDO<List<SourceVirtual>> selectByDomainList(SourceVirtual sourceVirtual);

}
