package com.shfc.cloud.monitor.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.monitor.dto.RealTimeSummaryDTO;
import com.shfc.cloud.monitor.query.RealTimeStatisticsQuery;
import com.shfc.cloud.monitor.util.DataRemoteUtil;
import com.shfc.cloud.monitor.util.MD5Util;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.log.LogFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.HashMap;

/**
 * @author sunyaping
 * @Package com.shfc.cloud.monitor.service
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-03-29 9:34
 * version V1.0.0
 **/
@Service
public class RealTimeStatisticsServiceImpl implements RealTimeStatisticsService{

    private LogFileUtils logFileUtils= LogFileUtils.getInstance("monitor-provider");

    private static final String CHANNEL_URL = "/realtime/summary/";

    @Autowired(required = false)
    private DataRemoteUtil dataRemoteUtil;


    @Value("${remote.appId}")
    private String appId;

    @Value("${remote.signType}")
    private String signType;

    @Value("${remote.version}")
    private String version;

    @Value("${remote.appSecret}")
    private String appSecret;


    @Override
    public ResultDO<Object> getActualStatistics(RealTimeStatisticsQuery asQuery){
        ResultDO<Object> resultDO=new ResultDO<Object>();
        HashMap<String,String> params=setParam(asQuery);

        String param = JSON.toJSONString(params);

        HashMap<String, String> paramMap = new HashMap<>();

        String signCode = MD5Util.getSignCode(appId, version, signType, param, appSecret).toUpperCase();
        paramMap.put("appId", appId);
        paramMap.put("version", version);
        paramMap.put("signType", signType);
        paramMap.put("signCode", signCode);
        paramMap.put("params", param);
        //返回请求结果
        String result= dataRemoteUtil.createRequest(CHANNEL_URL+version,paramMap);
        logFileUtils.info("楼上接口返回数据："+result);
        if(ValidateHelper.isEmpty(result)){
            resultDO.setErrMsg("接口没有数据");
            return resultDO;
        }
        logFileUtils.info(result);
        JSONObject object= JsonUtils.parseJavaObject(result, JSONObject.class);
        RealTimeSummaryDTO realTimeSummaryDTO=new RealTimeSummaryDTO();
        if(object.getString("status").equals("success")) {
            JSONObject obj = (JSONObject) object.get("realtimeSummary");
            if (obj != null) {
                realTimeSummaryDTO = JsonUtils.parseJavaObject(obj.toString(), RealTimeSummaryDTO.class);
                resultDO.setData(realTimeSummaryDTO);
            } else {
                resultDO.setData(realTimeSummaryDTO);
            }
            resultDO.setSuccess(true);
            return resultDO;
        }else {
            resultDO.setErrMsg(object.getString("errMsg"));
            resultDO.setData(null);
            return resultDO;
        }
    }

    /**
     * 参数判断
     * @param asQuery
     * @return
     */
    public HashMap<String,String> setParam(RealTimeStatisticsQuery asQuery){
        HashMap<String,String> params=new HashMap<String,String>();
        if (!ValidateHelper.isEmpty(asQuery.getChannelNo())){
            params.put("channelNo",asQuery.getChannelNo());
        }

        if (!ValidateHelper.isEmpty(asQuery.getPeriod())){
            params.put("period",String.valueOf(asQuery.getPeriod()));
        }

        if (!ValidateHelper.isEmpty(asQuery.getDistrictId())){
            params.put("districtId",asQuery.getDistrictId());
        }

        if (!ValidateHelper.isEmpty(asQuery.getBlockId())){
            params.put("blockId",asQuery.getBlockId());
        }

        if (!ValidateHelper.isEmpty(asQuery.getResidenceId())){
            params.put("residenceId",asQuery.getResidenceId());
        }
        return params;

    }
}
