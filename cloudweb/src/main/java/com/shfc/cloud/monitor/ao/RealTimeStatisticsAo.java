package com.shfc.cloud.monitor.ao;


import com.shfc.cloud.monitor.query.RealTimeStatisticsQuery;
import com.shfc.common.base.ValidateHelper;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shfc.cloud.monitor.service.RealTimeStatisticsService;
import com.shfc.cloud.monitor.dto.RealTimeStatisticsDTO;
import com.shfc.common.result.ResultDO;

/**
 * @Package com.shfc.cloud.monitor.ao
 * @Description: 实时监控
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @author sunyaping
 * @date 2017-03-28 16:42
 * version V1.0.0
 **/
@Service
public class RealTimeStatisticsAo {

    @Autowired(required = false)
    private RealTimeStatisticsService realTimeStatisticsService;

    private static final String JSON_TYPEERR_MSG = "请检查请求参数类型是否有误";

    public ResultDO<Object> getRealTimeSummary(RealTimeStatisticsDTO rtsDTO){
        ResultDO<Object> resultDO = new ResultDO<>();
        RealTimeStatisticsQuery asQuery=new RealTimeStatisticsQuery();
        String checkResult=checkEmptyParam(rtsDTO);
        if(checkResult!=null) {
            resultDO.setErrMsg(checkResult);
            return resultDO;
        }
        asQuery.setChannelNo(rtsDTO.getChannelNo());
        asQuery.setPeriod(rtsDTO.getPeriod());
        //小区，板块，区县的优先级为 小区>板块>区县，即优先级高的参数不为空的情况下，全部低优先级的参数会被忽略。
        if(ValidateHelper.isEmpty(rtsDTO.getResidenceId())){
            if(ValidateHelper.isEmpty(rtsDTO.getBlockId())){
                if(!ValidateHelper.isEmpty(rtsDTO.getDistrictId())){
                    asQuery.setDistrictId(rtsDTO.getDistrictId()); //如果小区为空，板块为空时，按照区县查
                }
            }else{
                if(!ValidateHelper.isEmpty(rtsDTO.getBlockId())){{
                    asQuery.setBlockId(rtsDTO.getBlockId()); //如果小区为空，板块不为空时，按照板块查
                }}

            }
        }
        if(!ValidateHelper.isEmpty(rtsDTO.getResidenceId())){
            asQuery.setResidenceId(rtsDTO.getResidenceId()); //如果小区不为空，按照小区查
        }
        resultDO = realTimeStatisticsService.getActualStatistics(asQuery);
        return resultDO;
    }
    /**
     * 判断请求参数是否为空
     * @param rtsDTO
     * @return
     */
    public String checkEmptyParam(RealTimeStatisticsDTO rtsDTO){
        if(rtsDTO==null){
            return "请求参数不能为空!";
        }else{
            if(ValidateHelper.isEmpty(rtsDTO.getPeriod())){
                return "时间纬度不能为空!";
            }
        }
        return null;
    }

}
