package com.shfc.cloud.monitor.ao;

import com.shfc.cloud.monitor.dto.*;
import com.shfc.cloud.monitor.query.ChannelDataQuery;
import com.shfc.cloud.monitor.query.LogQuery;
import com.shfc.cloud.monitor.query.VisitHistoryQuery;
import com.shfc.cloud.monitor.service.DataMonitorService;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 监控服务
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-30 11:03
 **/
@Service
public class MonitorAO {

    @Autowired
    private DataMonitorService dataMonitorService;

    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public ResultDO<VisistHistoryDTO> macVisitHistory(StatisticsDTO dto){
        if(dto.getMerchantId()==null){
            ResultDO<VisistHistoryDTO> resultDO=new ResultDO<VisistHistoryDTO>();
            resultDO.setErrMsg("商户号不能为空");
            return resultDO;
        }


        VisitHistoryQuery query=new VisitHistoryQuery();
        if(!ValidateHelper.isEmpty(dto.getChannelNo())){
            query.setChannelNo(dto.getChannelNo());
        }
        try {
            if(!ValidateHelper.isEmpty(dto.getStartTime())){
                query.setStartTime(sdf.parse(dto.getStartTime()));
            }
            if(!ValidateHelper.isEmpty(dto.getEndTime())){
                query.setEndTime(sdf.parse(dto.getEndTime()));
            }
        } catch ( ParseException e ) {
            e.printStackTrace();
        }
        if(!ValidateHelper.isEmpty(dto.getDistrictId())){
            query.setDistrictId(dto.getDistrictId());
        }
        if(!ValidateHelper.isEmpty(dto.getBlockId())){
            query.setBlockId(dto.getBlockId());
        }
        if(!ValidateHelper.isEmpty(dto.getResidenceId())){
            query.setResidenceId(dto.getResidenceId());
        }
        if(!ValidateHelper.isEmpty(dto.getPageNumber())&&dto.getPageNumber()!=0){
            query.setPageNumber(dto.getPageNumber());
        }
        if(!ValidateHelper.isEmpty(dto.getPageSize())&&dto.getPageSize()!=0){
            query.setPageSize(dto.getPageSize());
        }


        return dataMonitorService.macVisitHistory(query);

    }

    public ResultDO<LogListDTO> logDataList(MacLogDTO dto){
        LogQuery query =new LogQuery();

        if(dto.getMerchantId()==null){
            ResultDO<LogListDTO> resultDO=new ResultDO<LogListDTO>();
            resultDO.setErrMsg("商户号不能为空");
            return resultDO;
        }

        if(!ValidateHelper.isEmpty(dto.getMac())){
            query.setMac(dto.getMac());
        }

        if(!ValidateHelper.isEmpty(dto.getChannelNo())){
            query.setChannelNo(dto.getChannelNo());
        }

        try {
            if(!ValidateHelper.isEmpty(dto.getStartTime())){
                query.setStartTime(sdf.parse(dto.getStartTime()));
            }
            if(!ValidateHelper.isEmpty(dto.getEndTime())){
                query.setEndTime(sdf.parse(dto.getEndTime()));
            }
        } catch ( ParseException e ) {
            e.printStackTrace();
        }


        if(!ValidateHelper.isEmpty(dto.getDistrictId())){
            query.setDistrictId(dto.getDistrictId());
        }
        if(!ValidateHelper.isEmpty(dto.getBlockId())){
            query.setBlockId(dto.getBlockId());
        }
        if(!ValidateHelper.isEmpty(dto.getResidenceId())){
            query.setResidenceId(dto.getResidenceId());
        }
        if(!ValidateHelper.isEmpty(dto.getPageNumber())&&dto.getPageNumber()!=0){
            query.setPageNumber(dto.getPageNumber());
        }
        if(!ValidateHelper.isEmpty(dto.getPageSize())&&dto.getPageSize()!=0){
            query.setPageSize(dto.getPageSize());
        }


        return dataMonitorService.logDataList(query);
    }

    public ResultDO<ChannelDataDTO> channelDataList(ChannelDTO dto){
        ChannelDataQuery query =new ChannelDataQuery();

        if(dto.getMerchantId()==null){
            ResultDO<ChannelDataDTO> resultDO=new ResultDO<ChannelDataDTO>();
            resultDO.setErrMsg("商户号不能为空");
            return resultDO;
        }

        if(!ValidateHelper.isEmpty(dto.getChannelNo())){
            query.setChannelNo(dto.getChannelNo());
        }

        if(!ValidateHelper.isEmpty(dto.getPageNumber())&&dto.getPageNumber()!=0){
            query.setPageNumber(dto.getPageNumber());
        }
        if(!ValidateHelper.isEmpty(dto.getPageSize())&&dto.getPageSize()!=0){
            query.setPageSize(dto.getPageSize());
        }


        return dataMonitorService.channelDataList(query);
    }
}
