package com.shfc.cloud.monitor.ao;

import com.shfc.cloud.monitor.dto.TimeTrendDTO;
import com.shfc.cloud.monitor.dto.TrendDTO;
import com.shfc.cloud.monitor.query.TrendQuery;
import com.shfc.cloud.monitor.service.TrendService;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sunyaping
 * @Package com.shfc.cloud.monitor.ao
 * @Description :TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-03-31 14:29
 * version V1.0.0
 **/
@Service
public class TimeTrendAO {

    @Autowired(required = false)
    private TrendService trendService;

    //private static final String JSON_TYPEERR_MSG = "请检查请求参数类型是否有误";

    /**
     * 获取时间趋势周期数据对比结果
     * @param timeTrendDTO
     * @return
     */
    public ResultDO<TrendDTO> getTimeTrend(TimeTrendDTO timeTrendDTO){
        ResultDO<TrendDTO> resultDO = new ResultDO<TrendDTO>();
        String result=checkEmptyParam(timeTrendDTO);
        if(result!=null){
            resultDO.setErrMsg(result);
            return resultDO;
        }
        TrendQuery trendQuery=getParams(timeTrendDTO);
        resultDO = trendService.getTrendData(trendQuery);
        return resultDO;
    }


    /**
     * 检查必须参数是否为空/时间格式是否正确
     * @param timeTrendDTO
     * @return
     */
    public String checkEmptyParam(TimeTrendDTO timeTrendDTO){
        if (timeTrendDTO==null){
            return "请求参数不能为空";
        }else{
            if(ValidateHelper.isEmpty(timeTrendDTO.getSpan())){
                return "区间跨度不能为空";
            }
            if (ValidateHelper.isEmpty(timeTrendDTO.getScale())){
                return "时间刻度不能为空";
            }
        }
        return null;
    }
    public  TrendQuery getParams(TimeTrendDTO timeTrendDTO){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TrendQuery trendQuery=new TrendQuery();
        if(!ValidateHelper.isEmpty(timeTrendDTO.getChannelNo())){
            trendQuery.setChannelNo(timeTrendDTO.getChannelNo());
        }
        if(!ValidateHelper.isEmpty(timeTrendDTO.getSpan())){
            trendQuery.setSpan((long)timeTrendDTO.getSpan());
        }
        if(!ValidateHelper.isEmpty(timeTrendDTO.getBlockId())){
            trendQuery.setBlockId(Integer.parseInt(timeTrendDTO.getBlockId()));
        }
        if(!ValidateHelper.isEmpty(timeTrendDTO.getContrastiveStartTime())){
            trendQuery.setContrastiveStartTime(timeTrendDTO.getContrastiveStartTime());
        }
        if(!ValidateHelper.isEmpty(timeTrendDTO.getDistrictId())){
            trendQuery.setDistrictId(Integer.parseInt(timeTrendDTO.getDistrictId()));
        }
        if(!ValidateHelper.isEmpty(timeTrendDTO.getResidenceId())){
            trendQuery.setResidenceId(Integer.parseInt(timeTrendDTO.getResidenceId()));
        }
        if(!ValidateHelper.isEmpty(timeTrendDTO.getScale())){
            trendQuery.setScale((long)timeTrendDTO.getScale());
        }
        if(!ValidateHelper.isEmpty(timeTrendDTO.getStartTime())){
            trendQuery.setStartTime(timeTrendDTO.getStartTime());
        }
        return trendQuery;
    }


}
