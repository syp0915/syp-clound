package com.shfc.cloud.monitor.service;

import com.shfc.common.result.ResultDO;
import com.shfc.cloud.monitor.query.RealTimeStatisticsQuery;

/**
 * @author sunyaping
 * @Package com.shfc.cloud.monitor.service
 * @Description：TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-03-28 17:59
 * version V1.0.0
 **/
public interface RealTimeStatisticsService {
    /**
     * 实时概况统计
     * @param asQuery
     * @return
     */
    public ResultDO<Object> getActualStatistics(RealTimeStatisticsQuery asQuery);

}
