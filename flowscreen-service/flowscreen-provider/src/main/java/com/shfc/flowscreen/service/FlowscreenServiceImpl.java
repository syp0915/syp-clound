package com.shfc.flowscreen.service;

import com.alibaba.fastjson.JSON;
import com.shfc.common.result.ResultDO;
import com.shfc.flowscreen.domain.FlowscreenRecord;
import com.shfc.log.LogFileUtils;
import com.shfc.flowscreen.enums.FlowscreenErrorCode;
import com.shfc.flowscreen.enums.FlowscreenStatus;
import com.shfc.flowscreen.manager.FlowscreenRecordManager;
import com.shfc.flowscreen.remote.FlowscreenRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;

/**
 * @Package com.shfc.flowscreen.service.FlowscreenServiceImpl
 * @Description: FlowscreenServiceImpl
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/3/23 下午8:11
 * version V1.0.0
 */
@Service
public class FlowscreenServiceImpl implements FlowscreenService {
    @Autowired
    private FlowscreenRecordManager flowscreenRecordManager;
    @Autowired
    private FlowscreenRemoteService flowscreenRemoteService;

    private LogFileUtils logDataUtils = LogFileUtils.getInstance("flowscreen-provider");

    @Override
    public ResultDO<Object> flowscreenReq(FlowscreenRecord flowscreenRecord) {
        String verify = verifyParam(flowscreenRecord);
        ResultDO<Object> resultDO = new ResultDO<>();
        if (verify != null) {
            resultDO.setErrMsg(verify);
            return resultDO;
        }
        long timeMillis = System.currentTimeMillis();
        String result = null;
        try {
            result = flowscreenRemoteService.flowscreenReq(flowscreenRecord.getMac(),flowscreenRecord.getUrl());
        }catch (Exception e){
            flowscreenRecordManager.saveEmailRecord(flowscreenRecord, FlowscreenStatus.EXCEPTION,e.getMessage());
            logDataUtils.error("飘屏请求",flowscreenRecord.getMerchantId(),String.valueOf(flowscreenRecord.getChannelNo()), FlowscreenServiceImpl.class,"flowscreenReq",timeMillis);
            resultDO.setErrMsg(FlowscreenErrorCode.FLOWSCREEN_REQ_ERROR.getMsg());
            return resultDO;
        }

        if (!StringUtils.isEmpty(result)) {
            HashMap<String,Object> resultMap =  JSON.parseObject(result,HashMap.class);
            String resStatus =  (String) resultMap.get("code");
            if (resStatus.equals("05001200000")) {//成功
                flowscreenRecordManager.saveEmailRecord(flowscreenRecord, FlowscreenStatus.SUCCESS,null);
                logDataUtils.info("飘屏请求",flowscreenRecord.getMerchantId(),String.valueOf(flowscreenRecord.getChannelNo()), FlowscreenServiceImpl.class,"flowscreenReq",timeMillis);
                resultDO.setSuccess(true);
                return resultDO;
            }else {
                String msg = (String)resultMap.get("msg");
                flowscreenRecordManager.saveEmailRecord(flowscreenRecord, FlowscreenStatus.FAILED,msg);
                logDataUtils.error("飘屏请求",flowscreenRecord.getMerchantId(),flowscreenRecord.getChannelNo(), FlowscreenServiceImpl.class,"flowscreenReq",System.currentTimeMillis());
                resultDO.setErrMsg(msg);
                return resultDO;
            }
        }
        return resultDO;
    }

    private String verifyParam(FlowscreenRecord flowscreenRecord) {
        if (null == flowscreenRecord.getMerchantId()) {
            return FlowscreenErrorCode.MERCHANTID_NOT_NULL.getMsg();
        }
        if (null == flowscreenRecord.getChannelNo()) {
            return FlowscreenErrorCode.CHANNELNO_NOT_NULL.getMsg();
        }
        if (null == flowscreenRecord.getMac()) {
            return FlowscreenErrorCode.MAC_NOT_NULL.getMsg();
        }
        if (null == flowscreenRecord.getUrl()) {
            return FlowscreenErrorCode.URL_NOT_NULL.getMsg();
        }
        return null;
    }

}
