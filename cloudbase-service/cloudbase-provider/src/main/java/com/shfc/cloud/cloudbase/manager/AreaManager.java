package com.shfc.cloud.cloudbase.manager;


import com.shfc.cloud.cloudbase.dao.BaseBlockMapper;
import com.shfc.cloud.cloudbase.dao.BaseDistrictMapper;
import com.shfc.cloud.cloudbase.domain.BaseBlock;
import com.shfc.cloud.cloudbase.domain.BaseDistrict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaManager {
	

	@Autowired(required=false)
	private BaseDistrictMapper baseDistrictMapper;
	@Autowired(required=false)
	private BaseBlockMapper baseBlockMapper;
	
	public List<BaseDistrict> selectByCityId(String cityId) {
		return baseDistrictMapper.selectByCityId(cityId);
	}
	
	public List<BaseBlock>  selectByDistrictId(long districtId) {
		return baseBlockMapper.selectByDistrictId(districtId);
	}

	public BaseBlock  queryByBlockId(long blockId) {
		return baseBlockMapper.selectByPrimaryKey(blockId);
	}


	

}
