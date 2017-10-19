package com.shfc.flowscreen.service;

import com.shfc.common.result.ResultDO;
import com.shfc.flowscreen.domain.FlowscreenRecord;

/**
 * @Package com.shfc.flowscreen.service.FlowscreenService
 * @Description: FlowscreenService
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/3/23 下午4:32
 * version V1.0.0
 */
public interface FlowscreenService {
    /**
     * 调用飘屏请求
     * @param flowscreenRecord
     * @return
     */
    public ResultDO<Object> flowscreenReq(FlowscreenRecord flowscreenRecord);
}
