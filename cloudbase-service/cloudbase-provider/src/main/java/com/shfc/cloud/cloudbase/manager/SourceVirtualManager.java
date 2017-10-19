package com.shfc.cloud.cloudbase.manager;

import com.shfc.cloud.cloudbase.dao.SourceVirtualMapper;
import com.shfc.cloud.cloudbase.domain.SourceVirtual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package com.shfc.cloud.cloudbase.manager.SourceVirtualManager
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/23 13:47
 * version V1.0.0
 */
@Service
public class SourceVirtualManager {
	@Autowired
	private SourceVirtualMapper sourceVirtualMapper;

	public SourceVirtual selectByPrimaryKey(Long id) {
		return sourceVirtualMapper.selectByPrimaryKey(id);
	}

	public List<SourceVirtual> selectByDomainList(SourceVirtual sourceVirtual) {
		return sourceVirtualMapper.selectByDomainList(sourceVirtual);
	}
}
