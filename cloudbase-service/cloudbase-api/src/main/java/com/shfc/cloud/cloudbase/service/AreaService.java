package com.shfc.cloud.cloudbase.service;

import com.shfc.cloud.cloudbase.dto.RegionInfoDTO;
import com.shfc.common.result.ResultDO;

import java.util.List;


/**
 * @author wuky
 * @version V1.0
 * @File com.shfc.base.service.AreaExtService.java
 * @Description: TODO
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * @date 2016年9月5日 下午6:39:37
 */
public interface AreaService {

    /**
     * @Description: 区域板块信息
     * @Title queryPlotByKeyword
     * @Author  wuky
     * @Date 2017/1/3 17:17
     * @param  cityId
     * @return ResultDO<PlotAddressDTO>
     * @throws
     */
    ResultDO<List<RegionInfoDTO>> getRegionBlockInfo(String cityId);


}
