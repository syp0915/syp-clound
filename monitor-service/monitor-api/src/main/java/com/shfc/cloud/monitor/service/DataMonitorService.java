package com.shfc.cloud.monitor.service;

import com.shfc.cloud.monitor.dto.ChannelDataDTO;
import com.shfc.cloud.monitor.dto.LogListDTO;
import com.shfc.cloud.monitor.dto.VisistHistoryDTO;
import com.shfc.cloud.monitor.query.ChannelDataQuery;
import com.shfc.cloud.monitor.query.LogQuery;
import com.shfc.cloud.monitor.query.VisitHistoryQuery;
import com.shfc.common.result.ResultDO;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 数据监控服务
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-27 17:06
 **/
public interface DataMonitorService {
    /**
     * 监控服务-频道访问量统计
     * @return
     */
    public ResultDO<ChannelDataDTO> channelDataList(ChannelDataQuery query);
    /**
     * 监控服务-日志详情列表
     * @return
     */
    public ResultDO<LogListDTO> logDataList(LogQuery query);

    /**
     * 监控服务-机顶盒收视历史
     * @return
     */
    public ResultDO<VisistHistoryDTO> macVisitHistory(VisitHistoryQuery query);
}
