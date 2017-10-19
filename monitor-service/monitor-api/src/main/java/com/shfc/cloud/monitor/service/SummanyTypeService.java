package com.shfc.cloud.monitor.service;

import com.shfc.cloud.monitor.query.SummaryQuery;
import com.shfc.common.result.ResultDO;

/**
 * @author sunyaping
 * @Package com.shfc.cloud.monitor.service
 * @Description: 统计概况
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-03-30 16:39
 * version V1.0.0
 **/
public interface SummanyTypeService {

    /**
     * 根据区县、板块、小区Id统计概况
     * @param summaryQuery
     * @return
     */
    public ResultDO<Object> SummanyByType(SummaryQuery summaryQuery);
}
