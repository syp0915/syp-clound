package com.shfc.flowscreen.manager;

import com.shfc.common.base.Logger;
import com.shfc.flowscreen.dao.FlowscreenRecordMapper;
import com.shfc.flowscreen.domain.FlowscreenRecord;
import com.shfc.flowscreen.enums.FlowscreenErrorCode;
import com.shfc.flowscreen.enums.FlowscreenStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Package com.shfc.flowscreen.manager.FlowscreenRecordManager
 * @Description: FlowscreenRecordManager
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/3/23 下午8:14
 * version V1.0.0
 */
@Service
public class FlowscreenRecordManager {
    @Autowired
    private FlowscreenRecordMapper flowscreenRecordMapper;

    @Async
    public void saveEmailRecord(FlowscreenRecord flowscreenRecord, FlowscreenStatus status, String reason){
        flowscreenRecord.setStatus(status.getValue());
        flowscreenRecord.setReason(reason);
        flowscreenRecord.setCreater(flowscreenRecord.getMerchantId());
        try {
            flowscreenRecordMapper.insert(flowscreenRecord);
        }catch (Exception e){
            Logger.error(FlowscreenRecordManager.class, FlowscreenErrorCode.FLOWSCREEN_SAVE_ERROR.getMsg(), e);
        }
    }
}
