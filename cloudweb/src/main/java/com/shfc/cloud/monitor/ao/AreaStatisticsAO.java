package com.shfc.cloud.monitor.ao;

import com.shfc.cloud.monitor.dto.AreaStatisticsDTO;
import com.shfc.cloud.monitor.query.SummaryQuery;
import com.shfc.cloud.monitor.service.SummanyTypeService;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
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
 * @date 2017-03-31 15:58
 * version V1.0.0
 **/
@Service
public class AreaStatisticsAO {

    @Autowired(required = false)
    private SummanyTypeService summanyTypeService;

    /**
     * 获取时间趋势周期数据对比结果
     * @param areaStatisticsDTO
     * @return
     */
    public ResultDO<Object> getAreaStatistics(AreaStatisticsDTO areaStatisticsDTO){
        ResultDO<Object> resultDO = new ResultDO<>();
        String result=checkEmptyParam(areaStatisticsDTO);
        if(result!=null){
            resultDO.setErrMsg(result);
            return resultDO;
        }
        SummaryQuery summaryQuery=copyBean(areaStatisticsDTO);
        resultDO=summanyTypeService.SummanyByType(summaryQuery);
        return resultDO;
    }

    /**
     * 检查必须参数是否为空/时间格式是否正确
     * @param areaStatisticsDTO
     * @return
     */
    public String checkEmptyParam(AreaStatisticsDTO areaStatisticsDTO){
        if (areaStatisticsDTO==null){
            return "请求参数不能为空";
        }else{
            if(ValidateHelper.isEmpty(areaStatisticsDTO.getSpan())){
                return "区间跨度不能为空";
            }
            if(ValidateHelper.isEmpty(areaStatisticsDTO.getQueryLevel())){
                return "地区查询维度等级不能为空";
            }
            if(ValidateHelper.isEmpty(areaStatisticsDTO.getParentId())){
                return "父级Id不能为空";
            }
        }
        return null;
    }

    /**
     * 参数传递
     * @param areaStatisticsDTO
     * @return
     */
    public SummaryQuery copyBean(AreaStatisticsDTO areaStatisticsDTO){
        SummaryQuery summaryQuery=new SummaryQuery();
        if(!ValidateHelper.isEmpty(areaStatisticsDTO.getQueryLevel())){
            if (areaStatisticsDTO.getQueryLevel()==0){
                summaryQuery.setDistrictId(310100);
            } //areaStatisticsDTO.getQueryLevel()==0默认districtId=310100
            if (areaStatisticsDTO.getQueryLevel()==1){
                summaryQuery.setDistrictId(Integer.parseInt(areaStatisticsDTO.getParentId()));
            }
            if (areaStatisticsDTO.getQueryLevel()==2){
                summaryQuery.setBlockId(Integer.parseInt(areaStatisticsDTO.getParentId()));
            }
        }
        if (!ValidateHelper.isEmpty(areaStatisticsDTO.getChannelNo())){
            summaryQuery.setChannelNo(areaStatisticsDTO.getChannelNo());
        }

        if (!ValidateHelper.isEmpty(areaStatisticsDTO.getStartTime())){
            summaryQuery.setStartTime(areaStatisticsDTO.getStartTime());
        }

        if (!ValidateHelper.isEmpty(areaStatisticsDTO.getSpan())){
            summaryQuery.setSpan(areaStatisticsDTO.getSpan());
        }

        if (!ValidateHelper.isEmpty(areaStatisticsDTO.getQueryLevel())){
            summaryQuery.setQueryLevel(areaStatisticsDTO.getQueryLevel());
        }

        if (!ValidateHelper.isEmpty(areaStatisticsDTO.getPageNumber())){
            summaryQuery.setPageNumber(areaStatisticsDTO.getPageNumber());
        }

        if (!ValidateHelper.isEmpty(areaStatisticsDTO.getPageSize())){
            summaryQuery.setPageSize(areaStatisticsDTO.getPageSize());
        }
        return summaryQuery;

    }



}
