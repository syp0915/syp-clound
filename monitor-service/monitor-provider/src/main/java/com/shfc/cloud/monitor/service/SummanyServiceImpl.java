package com.shfc.cloud.monitor.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.monitor.dto.SummanyDTO;
import com.shfc.cloud.monitor.dto.SummanyDetailDTO;
import com.shfc.cloud.monitor.query.SummaryQuery;
import com.shfc.cloud.monitor.util.DataRemoteUtil;
import com.shfc.cloud.monitor.util.MD5Util;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.log.LogFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * @author sunyaping
 * @Package com.shfc.cloud.monitor.service
 * @Description:据区县、板块、小区Id统计概况
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-03-30 16:56
 * version V1.0.0
 **/
@Service
public class SummanyServiceImpl implements SummanyTypeService{

    private LogFileUtils logFileUtils= LogFileUtils.getInstance("monitor-provider");

    private static  String toUrl="";

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

    public ResultDO<Object> SummanyByType(SummaryQuery summaryQuery){
        ResultDO<Object> resultDO=new ResultDO<Object>();
        HashMap<String,String> params=getParams(summaryQuery);

        String param = JSON.toJSONString(params);

        HashMap<String, String> paramMap = new HashMap<>();

        String signCode = MD5Util.getSignCode(appId, version, signType, param, appSecret).toUpperCase();
        paramMap.put("appId", appId);
        paramMap.put("version", version);
        paramMap.put("signType", signType);
        paramMap.put("signCode", signCode);
        paramMap.put("params", param);

        String result= dataRemoteUtil.createRequest(toUrl+version,paramMap);
        logFileUtils.info("楼上接口返回数据："+result);
        if(ValidateHelper.isEmpty(result)){
            resultDO.setErrMsg("接口没有数据");
            return resultDO;
        }
        logFileUtils.info(result);
        SummanyDTO summanyDTO=new SummanyDTO();
        JSONObject object= JsonUtils.parseJavaObject(result,JSONObject.class);
        if(object.getString("status").equals("success")){
            JSONArray array=(JSONArray)object.get("summaries");
            if (array!=null && array.size()>0){
                summanyDTO=getSummanyDTO(array,summaryQuery);
                resultDO.setSuccess(true);
                resultDO.setData(summanyDTO);
                return resultDO;
            }else{
                resultDO.setSuccess(true);
                summanyDTO.setSunmmanyList(new JSONArray());
                summanyDTO.setQueryLevel(summaryQuery.getQueryLevel());
                resultDO.setData(summanyDTO);
                return resultDO;
            }
        }else{
            resultDO.setErrMsg(object.getString("errMsg"));
            resultDO.setData(null);
            return resultDO;
        }
    }

    /**
     * 参数判断
     * @param summaryQuery
     * @return
     */
    public   HashMap<String,String> getParams(SummaryQuery summaryQuery){
        HashMap<String,String> params=new HashMap<String,String>();
        if (!ValidateHelper.isEmpty(summaryQuery.getChannelNo())){
            params.put("channelNo",summaryQuery.getChannelNo());
        }
        if (!ValidateHelper.isEmpty(summaryQuery.getStartTime())){
            params.put("startTime",String.valueOf(summaryQuery.getStartTime()));
        }
        if (!ValidateHelper.isEmpty(summaryQuery.getSpan())){
            params.put("span",String.valueOf(summaryQuery.getSpan()));
        }
        if(!ValidateHelper.isEmpty(summaryQuery.getQueryLevel())){
            if (summaryQuery.getQueryLevel()==0){
                toUrl = "/summary/district/";
            }
            if(summaryQuery.getQueryLevel()==1){
                if(!ValidateHelper.isEmpty(summaryQuery.getDistrictId())){
                    params.put("districtId", String.valueOf(summaryQuery.getDistrictId()));
                    toUrl="/summary/block/";
                }
            }
            if (summaryQuery.getQueryLevel()==2){
                if(!ValidateHelper.isEmpty(summaryQuery.getBlockId())){
                    params.put("blockId",String.valueOf(summaryQuery.getBlockId()));
                    toUrl="/summary/residence/";
                }
            }
        }

        return params;
    }

    /**
     * 获取返回值
     * @param array
     * @return
     */
    public SummanyDTO getSummanyDTO(JSONArray array,SummaryQuery summaryQuery){
        SummanyDTO summanyDTO=new SummanyDTO();
        JSONArray jsonArr = new JSONArray();
        if (array!=null && array.size()>0){
            for (int i=0;i<array.size();i++){
                SummanyDetailDTO summanyDetailDTO=new SummanyDetailDTO();
                int nv=0;
                int pv=0;
                int uv=0;
                if(checkObject(((JSONObject)array.get(i)).get("nv"))){
                    nv=((JSONObject)array.get(i)).getIntValue("nv");
                }
                if(checkObject(((JSONObject)array.get(i)).get("pv"))){
                    pv=((JSONObject)array.get(i)).getIntValue("pv");
                }
                if(checkObject(((JSONObject)array.get(i)).get("uv"))){
                    uv=((JSONObject)array.get(i)).getIntValue("uv");
                }
                if(!ValidateHelper.isEmpty(summaryQuery.getQueryLevel())){
                    if(summaryQuery.getQueryLevel()==0){
                        String districtId="";
                        String districtName="";
                        if(checkObject(((JSONObject)array.get(i)).get("districtId"))){
                            districtId=((JSONObject)array.get(i)).getString("districtId");
                        }
                        if(checkObject(((JSONObject)array.get(i)).get("districtName"))){
                            districtName=((JSONObject)array.get(i)).getString("districtName");
                        }
                        summanyDetailDTO.setPointId(districtId);
                        summanyDetailDTO.setPointName(districtName);
                    }
                    if(summaryQuery.getQueryLevel()==1){
                        String blockId="";
                        String blockName="";
                        if(checkObject(((JSONObject)array.get(i)).get("blockId"))){
                            blockId=((JSONObject)array.get(i)).getString("blockId");
                        }
                        if(checkObject(((JSONObject)array.get(i)).get("blockName"))){
                            blockName=((JSONObject)array.get(i)).getString("blockName");
                        }
                        summanyDetailDTO.setPointId(blockId);
                        summanyDetailDTO.setPointName(blockName);
                    }if(summaryQuery.getQueryLevel()==2){
                        String residenceId="";
                        String residenceName="";
                        if(checkObject(((JSONObject)array.get(i)).get("residenceId"))){
                            residenceId=((JSONObject)array.get(i)).getString("residenceId");
                        }
                        if(checkObject(((JSONObject)array.get(i)).get("residenceName"))){
                            residenceName=((JSONObject)array.get(i)).getString("residenceName");
                        }
                        summanyDetailDTO.setPointId(residenceId);
                        summanyDetailDTO.setPointName(residenceName);
                    }
                }
                double latitude=0.00;
                if(checkObject(((JSONObject)array.get(i)).get("lat"))){
                    latitude=((JSONObject)array.get(i)).getDouble("lat");
                }
                double longitude=0.00;
                if(checkObject(((JSONObject)array.get(i)).get("lon"))){
                    longitude=((JSONObject)array.get(i)).getDouble("lon");
                }
                Long avgTop=0L;
                if(checkObject(((JSONObject)array.get(i)).get("avgTop"))){
                    avgTop=((JSONObject)array.get(i)).getLong("avgTop");
                }
                summanyDetailDTO.setLatitude(latitude);
                summanyDetailDTO.setLongitude(longitude);
                summanyDetailDTO.setAvgTop(avgTop);
                summanyDetailDTO.setNv(nv);
                summanyDetailDTO.setPv(pv);
                summanyDetailDTO.setUv(uv);
                jsonArr.add(summanyDetailDTO);
            }
        }
        summanyDTO.setSunmmanyList(jsonArr);
        summanyDTO.setQueryLevel(summaryQuery.getQueryLevel());
        return summanyDTO;
    }

    public boolean checkObject(Object object) {
        if (object != null && !object.equals("null")) {
            return true;
        } else {
            return false;
        }
    }

    public Date doubleToDate(Double d){
        Date t=new Date();
        Calendar base = Calendar.getInstance();
        //Delphi的日期类型从1899-12-30开始
        base.set(1899, 11, 30, 0, 0, 0);
        base.add(Calendar.DATE, d.intValue());
        base.add(Calendar.MILLISECOND,(int)((d % 1) * 24 * 60 * 60 * 1000));
        t=base.getTime();

        return t;

    }




}
