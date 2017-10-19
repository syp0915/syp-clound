package com.shfc.cloud.monitor.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.account.constant.ErrorConstant;
import com.shfc.cloud.monitor.dto.TrendDTO;
import com.shfc.cloud.monitor.dto.TrendDetailDTO;
import com.shfc.cloud.monitor.query.TrendQuery;
import com.shfc.cloud.monitor.util.DataRemoteUtil;
import com.shfc.cloud.monitor.util.MD5Util;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.log.LogFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

/**
 * @author sunyaping
 * @Package com.shfc.cloud.monitor.service
 * @Description TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-03-30 14:58
 * version V1.0.0
 **/
@Service
public class TrendServiceImpl implements TrendService {

    private LogFileUtils logFileUtils = LogFileUtils.getInstance("monitor-provider");

    private static final String CHANNEL_URL = "/trend/";

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

    public ResultDO<TrendDTO> getTrendData(TrendQuery trendQuery) {
        ResultDO<TrendDTO> resultDO = new ResultDO<TrendDTO>();
        HashMap<String, String> params = setParam(trendQuery);

        String param = JSON.toJSONString(params);

        HashMap<String, String> paramMap = new HashMap<>();

        String signCode = MD5Util.getSignCode(appId, version, signType, param, appSecret).toUpperCase();
        paramMap.put("appId", appId);
        paramMap.put("version", version);
        paramMap.put("signType", signType);
        paramMap.put("signCode", signCode);
        paramMap.put("params", param);

        //返回请求结果
        String result = dataRemoteUtil.createRequest(CHANNEL_URL+version, paramMap);
        logFileUtils.info("楼上接口返回数据："+result);
        if(ValidateHelper.isEmpty(result)){
            resultDO.setErrMsg("接口没有数据");
            return resultDO;
        }
        logFileUtils.info(result);
        JSONObject object = JsonUtils.parseJavaObject(result, JSONObject.class);
        if (object.getString("status").equals("success")) {
            JSONObject obj =(JSONObject)object.get("trend");
            TrendDTO adto = new TrendDTO();
            if(obj!=null) {
                JSONArray currentArray = (JSONArray) obj.get("current");
                JSONArray contrastiveArray = (JSONArray) obj.get("contrastive");
                JSONArray cureentTrendList = new JSONArray();
                JSONArray contrastiveTrendList = new JSONArray();
                adto = setDistrictSummaryDTO(currentArray, "current", adto, cureentTrendList);
                adto = setDistrictSummaryDTO(contrastiveArray, "contrastive", adto, contrastiveTrendList);
            }
            resultDO.setSuccess(true);
            resultDO.setData(adto);
            return resultDO;
        }
        else {
            resultDO.setErrMsg(object.getString("errMsg"));
            resultDO.setErrCode(ErrorConstant.BAD_REQUEST.getCode());
            resultDO.setData(null);
            return resultDO;
        }
    }

    /**
     * 根据不同的key填充集合
     *
     * @param array
     * @param key
     * @param adto
     */
    public TrendDTO setDistrictSummaryDTO(JSONArray array, String key, TrendDTO adto,JSONArray arrayType) {
        if (array!=null && array.size() > 0) {
            for (int i = 0; i < array.size(); i++) {
                int nv = 0;
                int pv =0;
                int uv=0;
                Object objnv=((JSONObject) array.get(i)).get("nv");
                if(objnv!=null && !objnv.equals("null")){
                    nv = ((JSONObject) array.get(i)).getIntValue("nv");
                }
                Object objpv=((JSONObject) array.get(i)).get("pv");
                if(objpv!=null && !objpv.equals("null")){
                    pv = ((JSONObject) array.get(i)).getIntValue("pv");
                }
                Object objuv=((JSONObject) array.get(i)).get("uv");
                if(objuv!=null && !objuv.equals("null")){
                    uv = ((JSONObject) array.get(i)).getIntValue("uv");
                }
                Long timeBegin =null;
                Object objTimeBegin=((JSONObject) array.get(i)).get("timeBegin");
                if(objTimeBegin!=null && !objTimeBegin.equals("null")){
                    timeBegin = ((JSONObject) array.get(i)).getLong("timeBegin");
                }
                Long timeEnd=null;
                Object objTimeEnd=((JSONObject) array.get(i)).get("timeEnd");
                if(objTimeEnd!=null && !objTimeEnd.equals("null")){
                    timeEnd = ((JSONObject) array.get(i)).getLong("timeEnd");
                }
                Long avgTop =null;
                Object obj=((JSONObject) array.get(i)).get("avgTop");
                if(obj!=null && !obj.equals("null")){
                    avgTop = ((JSONObject) array.get(i)).getLong("avgTop");
                }
                TrendDetailDTO districtSummaryDTO = new TrendDetailDTO();
                districtSummaryDTO.setNv(nv);
                districtSummaryDTO.setPv(pv);
                districtSummaryDTO.setUv(uv);
                districtSummaryDTO.setTimeBegin(new Date(timeBegin));
                districtSummaryDTO.setTimeEnd(new Date(timeEnd));
                districtSummaryDTO.setAvgTop(avgTop);
                if (key.equals("current")) {
                    arrayType.add(districtSummaryDTO);
                }
                if (key.equals("contrastive")) {
                    arrayType.add(districtSummaryDTO);
                }
            }
        }
        if (key.equals("current")) {
            adto.setCureentTrendList(array);
        }
        if (key.equals("contrastive")) {
            adto.setContrastiveTrendList(array);
        }
        return adto;
    }

    /**
     * 请求参数判断
     * @param trendQuery
     * @return
     */
    public HashMap<String, String> setParam(TrendQuery trendQuery) {
        HashMap<String, String> params = new HashMap<String, String>();
        if (!ValidateHelper.isEmpty(trendQuery.getChannelNo())) {
            params.put("channelNo", trendQuery.getChannelNo());
        }
        if (!ValidateHelper.isEmpty(trendQuery.getStartTime())) {
            params.put("startTime", String.valueOf(trendQuery.getStartTime()));
        }
        if (!ValidateHelper.isEmpty(trendQuery.getContrastiveStartTime())) {
            params.put("contrastiveStartTime", String.valueOf(trendQuery.getContrastiveStartTime()));
        }
        if (!ValidateHelper.isEmpty(trendQuery.getSpan())) {
            params.put("span", String.valueOf(trendQuery.getSpan()));
        }
        if (!ValidateHelper.isEmpty(trendQuery.getScale())) {
            params.put("scale", String.valueOf(trendQuery.getScale()));
        }
        if (!ValidateHelper.isEmpty(trendQuery.getDistrictId())) {
            params.put("districtId", String.valueOf(trendQuery.getDistrictId()));
        }
        if (!ValidateHelper.isEmpty(trendQuery.getBlockId())) {
            params.put("blockId", String.valueOf(trendQuery.getBlockId()));
        }
        if (!ValidateHelper.isEmpty(trendQuery.getBlockId())) {
            params.put("residenceId", String.valueOf(trendQuery.getBlockId()));
        }
        return params;
    }


}
