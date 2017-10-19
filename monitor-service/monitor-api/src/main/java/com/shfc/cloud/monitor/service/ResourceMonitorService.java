package com.shfc.cloud.monitor.service;

import com.shfc.cloud.monitor.dto.*;
import com.shfc.common.result.ResultDO;

import javax.xml.ws.ServiceMode;

/**
 * @Package com.shfc.cloud.monitor.service.ResourceMonitorService
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/22 19:52
 * version V1.0.0
 */

public interface ResourceMonitorService {

    /**
     * 资源监控最新数据查询
     * @return
     */
    ResultDO<MonitorCurrentDTO> getLastedMonitorData(MonitorBaseDTO dto);

    /**
     * 资源监控明细查询
     * @return
     */
    ResultDO<ResourceMonitorDetailDTO> getResourceMonitorDetail(ResMonitorDetailDTO dto);

    /**
     * 缓存监控明细查询
     * @return
     */
    ResultDO getCacheMonitorDetail(MonitorBaseDTO dto);

    /**
     * 图片监控详情
     * @return
     */
    ResultDO<SpaceUseMonitorDetailDTO> getImgMonitorDetail(MonitorBaseDTO dto);

    /**
     * 数据库空间使用详情
     * @return
     */
    ResultDO<SpaceUseMonitorDetailDTO> getDBMonitorDetail(MonitorBaseDTO dto);

    /**
     * tomcat运行状态监控
     * @return
     */
    ResultDO<ServerStatusDTO> getServerStatus(MonitorBaseDTO dto);

    /**
     * 磁盘空间使用详情
     * @return
     */
    ResultDO<SpaceUseMonitorDetailDTO> getDiskMonitorDetail(MonitorBaseDTO dto);
}
