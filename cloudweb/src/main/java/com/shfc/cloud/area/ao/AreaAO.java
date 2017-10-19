package com.shfc.cloud.area.ao;

import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.area.dto.AreaDTO;
import com.shfc.cloud.cloudbase.dto.RegionInfoDTO;
import com.shfc.cloud.cloudbase.service.AreaService;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-16 15:17
 **/
@Service
public class AreaAO {
    @Autowired(required = false)
    private AreaService areaService;

    public ResultDO<List<RegionInfoDTO>> queryArea(AreaDTO dto){
        ResultDO<List<RegionInfoDTO>> resultDO=new ResultDO<List<RegionInfoDTO>>();
        if(ValidateHelper.isEmpty(dto.getCityId())){
            resultDO.setErrMsg("请求参数不能为空");
            return resultDO;
        }
        JSONObject object=new JSONObject();



        ResultDO<List<RegionInfoDTO>> result=areaService.getRegionBlockInfo(dto.getCityId());
        if(!result.isSuccess()){
            resultDO.setErrMsg(result.getErrMsg());
            return resultDO;
        }

        resultDO.setData(result.getData());
        resultDO.setSuccess(true);

        return resultDO;
    }
}
