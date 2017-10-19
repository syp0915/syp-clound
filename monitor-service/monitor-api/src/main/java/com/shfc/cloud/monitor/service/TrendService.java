package com.shfc.cloud.monitor.service;

import com.shfc.cloud.monitor.dto.TrendDTO;
import com.shfc.cloud.monitor.query.TrendQuery;
import com.shfc.common.result.ResultDO;

/**
 * @author sunyaping
 * @Package com.shfc.cloud.monitor.service
 * @Description：TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-03-30 14:48
 * version V1.0.0
 **/
public interface TrendService {
    /**
     * 走势统计
     * @param dto
     * @return
     */
    ResultDO<TrendDTO> getTrendData(TrendQuery dto);
}
