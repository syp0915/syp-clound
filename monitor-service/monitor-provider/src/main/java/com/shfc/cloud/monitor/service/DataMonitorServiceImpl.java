package com.shfc.cloud.monitor.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.shfc.cloud.cloudbase.dto.ChannelDTO;
import com.shfc.cloud.cloudbase.service.ChannelService;
import com.shfc.cloud.monitor.dto.*;
import com.shfc.cloud.monitor.query.ChannelDataQuery;
import com.shfc.cloud.monitor.query.LogQuery;
import com.shfc.cloud.monitor.query.VisitHistoryQuery;
import com.shfc.cloud.monitor.util.DataRemoteUtil;
import com.shfc.cloud.monitor.util.MD5Util;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.date.DateUtils;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.log.LogFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-27 17:28
 **/
@Service
public class DataMonitorServiceImpl implements DataMonitorService {

    private LogFileUtils logFileUtils= LogFileUtils.getInstance("monitor-provider");

    private static final String CHANNEL_URL = "/channel/summary/";

    private static final String LOG_URL="/mac/visit/log/";

    private static final String VISIT_URL="/mac/visit/history/";

    @Autowired(required = false)
    private DataRemoteUtil dataRemoteUtil;

    @Autowired(required = false)
    private ChannelService channelService;

    @Value("${remote.appId}")
    private String appId;

    @Value("${remote.signType}")
    private String signType;

    @Value("${remote.version}")
    private String version;

    @Value("${remote.appSecret}")
    private String appSecret;

    /**
     * 监控服务-频道访问量统计
     * @param query
     * @return
     */
    @Override
    public ResultDO<ChannelDataDTO> channelDataList(ChannelDataQuery query) {
        Long startTimeMillis=System.currentTimeMillis();
        ResultDO<ChannelDataDTO> resultDO=new ResultDO<ChannelDataDTO>();
        ChannelDataDTO channelDataDTO=new ChannelDataDTO();
        String channelNo=query.getChannelNo();
        Integer pageSize=query.getPageSize();
        Integer pageNo=query.getPageNumber();

        HashMap<String,Object> params=new HashMap<String,Object>();
        if(!ValidateHelper.isEmpty(channelNo)){
            params.put("channelNo",channelNo);
        }
        //时间传前一天的0点开始的24个小时
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add((Calendar.DATE),-1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        params.put("startTime",calendar.getTimeInMillis());
        // params.put("startTime","1489197720");//测试时用
        params.put("span",86400000);//默认查询一天的数据
        params.put("pageSize",pageSize);
        params.put("pageNo",pageNo);
//        params.put("startTime", 1497715200373L);
//        params.put("span", 86400000);
//        params.put("pageNo", 1);
//        params.put("pageSize", 20);


        String param = JSON.toJSONString(params);

        HashMap<String, String> paramMap = new HashMap<>();

        String signCode = MD5Util.getSignCode(appId, version, signType, param, appSecret).toUpperCase();
        paramMap.put("appId", appId);
        paramMap.put("version", version);
        paramMap.put("signType", signType);
        paramMap.put("signCode", signCode);
        paramMap.put("params", param);

        String result= dataRemoteUtil.createRequest(CHANNEL_URL+version,paramMap);
        logFileUtils.error("监控模块",query.getMerchantId(),channelNo,DataMonitorServiceImpl.class,"channelDataList",startTimeMillis);
        if(ValidateHelper.isEmpty(result)){
            resultDO.setErrMsg("接口没有数据");
            return resultDO;
        }
        logFileUtils.info(result);
        JSONObject object= JsonUtils.parseJavaObject(result, JSONObject.class);
        if(object.getString("status").toLowerCase().equals("success")){
            JSONArray array=(JSONArray)object.get("channelSummaries");
            List<VisitDataDTO> list=new ArrayList<VisitDataDTO>();
            for(int i=0;i<array.size();i++){
                VisitDataDTO dataDTO=new VisitDataDTO();
                int nv=((JSONObject)array.get(i)).getIntValue("nv");
                int pv=((JSONObject)array.get(i)).getIntValue("pv");
                int uv=((JSONObject)array.get(i)).getIntValue("uv");
                String cNo=((JSONObject)array.get(i)).getString("channelNo");
                ResultDO<ChannelDTO> resp=channelService.queryChannelByNo(cNo);
                if(!resp.isSuccess()){
                    resultDO.setErrMsg(resp.getErrMsg());
                    return resultDO;
                }
                dataDTO.setNv(nv);
                dataDTO.setPv(pv);
                dataDTO.setUv(uv);
                dataDTO.setChannelNo(cNo);
                if(resp.getData()!=null) {
                    dataDTO.setMerchantNo(resp.getData().getMerchantNo());
                    dataDTO.setChannelName(resp.getData().getChannelName());
                }
                list.add(dataDTO);
            }
            channelDataDTO.setDataList(list);
            channelDataDTO.setPageNumber(object.getInteger("pageNo"));
            channelDataDTO.setPageSize(object.getInteger("pageSize"));
            channelDataDTO.setRealPageSize(object.getInteger("realPageSize"));
            channelDataDTO.setTotalPageCount(object.getLong("totalPageCount"));
            channelDataDTO.setTotalCount(object.getLong("totalCount"));
            channelDataDTO.setFirstPage(object.getBoolean("isFirstPage"));
            channelDataDTO.setLastPage(object.getBoolean("isLastPage"));
            resultDO.setData(channelDataDTO);
            resultDO.setSuccess(true);
            return resultDO;
        }else {
            resultDO.setErrMsg(object.getString("errMsg"));
            return resultDO;
        }


    }
    /**
     * 监控服务-日志详情列表
     * @return
     */
    @Override
    public ResultDO<LogListDTO> logDataList(LogQuery query) {
        logFileUtils.info(JSON.toJSONString(query));
        Long startTimeMillis=System.currentTimeMillis();
        ResultDO<LogListDTO> resultDO=new ResultDO<LogListDTO>();
        long span=0;
        HashMap<String,String> params=new HashMap<String,String>();

        if(!ValidateHelper.isEmpty(query.getMac())){
            params.put("mac",query.getMac());
        }

        if(!ValidateHelper.isEmpty(query.getChannelNo())){
            params.put("channelNo",query.getChannelNo());
        }
        if(!ValidateHelper.isEmpty(query.getDistrictId())){
            params.put("districtId",query.getDistrictId());
        }
        if(!ValidateHelper.isEmpty(query.getBlockId())){
            params.put("blockId",query.getBlockId());
        }
        if(!ValidateHelper.isEmpty(query.getResidenceId())){
            params.put("residenceId",query.getResidenceId());
        }

        if(query.getStartTime()!=null){
            params.put("startTime",String.valueOf(query.getStartTime().getTime()));
        }

        if(query.getStartTime()!=null&&query.getEndTime()!=null){
            span=query.getEndTime().getTime()-query.getStartTime().getTime();
        }else{//默认最近一个月内
            span=(long)30*24*60*60*1000;
        }
        params.put("span",String.valueOf(span));

        params.put("pageSize",String.valueOf(query.getPageSize()));
        params.put("pageNo",String.valueOf(query.getPageNumber()));

        String param = new Gson().toJson(params);

        HashMap<String, String> paramMap = new HashMap<>();

        String signCode = MD5Util.getSignCode(appId, version, signType, param, appSecret).toUpperCase();
        paramMap.put("appId", appId);
        paramMap.put("version", version);
        paramMap.put("signType", signType);
        paramMap.put("signCode", signCode);
        paramMap.put("params", param);

        String result= dataRemoteUtil.createRequest(LOG_URL+version,paramMap);
        logFileUtils.error("监控模块",query.getMerchantId(),query.getChannelNo(),DataMonitorServiceImpl.class,"logDataList",startTimeMillis);
        if(ValidateHelper.isEmpty(result)){
            resultDO.setErrMsg("接口没有数据");
            return resultDO;
        }
        logFileUtils.info(result);
        LogListDTO logListDTO=new LogListDTO();
        List<LogDTO> list=new ArrayList<LogDTO>();
        JSONObject object=JsonUtils.parseJavaObject(result,JSONObject.class);
        if(object.getString("status").equals("success")){
            JSONArray array=(JSONArray) object.get("histories");
            if(array==null){
                resultDO.setErrMsg("接口数据为空");
                return resultDO;
            }
            for(int i=0;i<array.size();i++){
                String mac=((JSONObject)array.get(i)).getString("mac");
                String channelNo=((JSONObject)array.get(i)).getString("channelNo");
                String districtName=((JSONObject)array.get(i)).getString("districtName");
                String blockName=((JSONObject)array.get(i)).getString("blockName");
                String residenceName=((JSONObject)array.get(i)).getString("residenceName");
                Date date=new Date(((JSONObject)array.get(i)).getLong("time"));
                String time=DateUtils.formatDate(date,"yyyy-MM-dd HH:mm:ss");
                LogDTO logDTO=new LogDTO();
                logDTO.setMac(mac);
                logDTO.setChannelNo(channelNo);
                logDTO.setRegion(districtName+"-"+blockName);
                logDTO.setResidenceName(residenceName);
                logDTO.setTime(time);
                list.add(logDTO);
            }
            logListDTO.setDataList(list);
            logListDTO.setPageNumber(object.getInteger("pageNo"));
            logListDTO.setPageSize(object.getInteger("pageSize"));
            logListDTO.setRealPageSize(object.getInteger("realPageSize"));
            logListDTO.setTotalPageCount(object.getLong("totalPageCount"));
            logListDTO.setTotalCount(object.getLong("totalCount"));
            logListDTO.setFirstPage(object.getBoolean("isFirstPage"));
            logListDTO.setLastPage(object.getBoolean("isLastPage"));

            resultDO.setData(logListDTO);
            resultDO.setSuccess(true);
            return resultDO;

        }else{
            resultDO.setErrMsg(object.getString("errMsg"));
            return resultDO;
        }

    }
    /**
     * 监控服务-机顶盒收视历史
     * @return
     */
    @Override
    public ResultDO<VisistHistoryDTO> macVisitHistory(VisitHistoryQuery query) {
        Long startTimeMillis=System.currentTimeMillis();
        ResultDO<VisistHistoryDTO> resultDO=new ResultDO<VisistHistoryDTO>();
        HashMap<String,String> params=new HashMap<String,String>();

        long span=0;
        if(!ValidateHelper.isEmpty(query.getChannelNo())){
            params.put("channelNo",query.getChannelNo());
        }
        if(!ValidateHelper.isEmpty(query.getDistrictId())){
            params.put("districtId",query.getDistrictId());
        }
        if(!ValidateHelper.isEmpty(query.getBlockId())){
            params.put("blockId",query.getBlockId());
        }
        if(!ValidateHelper.isEmpty(query.getResidenceId())){
            params.put("residenceId",query.getResidenceId());
        }
        if(!ValidateHelper.isEmpty(query.getStartTime())){
            params.put("startTime",String.valueOf(query.getStartTime().getTime()));
        }

        params.put("pageSize",String.valueOf(query.getPageSize()));
        params.put("pageNo",String.valueOf(query.getPageNumber()));

        if(query.getStartTime()!=null&&query.getEndTime()!=null){
            span=query.getEndTime().getTime()-query.getStartTime().getTime();
        }else{//默认最近一个月内
            span=(long)30*24*60*60*1000;
        }
        params.put("span",String.valueOf(span));

        String param = new Gson().toJson(params);

        HashMap<String, String> paramMap = new HashMap<>();

        String signCode = MD5Util.getSignCode(appId, version, signType, param, appSecret).toUpperCase();
        paramMap.put("appId", appId);
        paramMap.put("version", version);
        paramMap.put("signType", signType);
        paramMap.put("signCode", signCode);
        paramMap.put("params", param);

        String result= dataRemoteUtil.createRequest(VISIT_URL+version,paramMap);
        logFileUtils.error("监控模块",query.getMerchantId(),query.getChannelNo(),DataMonitorServiceImpl.class,"macVisitHistory",startTimeMillis);
        if(ValidateHelper.isEmpty(result)){
            resultDO.setErrMsg("接口没有数据");
            return resultDO;
        }

        JSONObject jsonObject=JsonUtils.parseJavaObject(result,JSONObject.class);
        VisistHistoryDTO visistHistoryDTO=new VisistHistoryDTO();
        List<HistoryDTO> list=new ArrayList<HistoryDTO>();
        if(jsonObject.getString("status").equals("success")){
            JSONArray array=(JSONArray)jsonObject.get("histories");
            if(array!=null && array.size()>0) {
                for (int i = 0; i < array.size(); i++) {
                    JSONObject object = ((JSONObject) array.get(i));
                    String mac = object.getString("mac");
                    String channelNo = object.getString("channelNo");
                    long pv = object.getLong("pv");
                    String firstVisitTime = DateUtils.formatDate(new Date(object.getLong("firstVisitTime")), "yyyy-MM-dd HH:mm:ss");
                    String lastVisitTime = DateUtils.formatDate(new Date(object.getLong("lastVisitTime")), "yyyy-MM-dd HH:mm:ss");
                    long totalTop = object.getLong("totalTop");
                    HistoryDTO dto = new HistoryDTO();
                    dto.setMac(mac);
                    dto.setPv(pv);
                    dto.setChannelNo(channelNo);
                    dto.setFirstVisitTime(firstVisitTime);
                    dto.setLastVisitTime(lastVisitTime);
                    dto.setViewLength(totalTop);
                    list.add(dto);
                }
            }
            visistHistoryDTO.setDataList(list);
            resultDO.setData(visistHistoryDTO);
            resultDO.setSuccess(true);
            return resultDO;

        }else{
            resultDO.setErrMsg(jsonObject.getString("errMsg"));
            return resultDO;
        }

    }

}
