package com.shfc.cloud.area.controller;

import com.shfc.cloud.area.ao.AreaAO;
import com.shfc.cloud.area.dto.AreaDTO;
import com.shfc.cloud.cloudbase.dto.RegionInfoDTO;
import com.shfc.common.result.ResultDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-16 15:16
 **/
@Api(tags = "AreaController",description = "区域板块")
@RestController
@RequestMapping("/cloud/area")
public class AreaController {
    @Autowired(required = false)
    private AreaAO areaAO;

    /**
     * 区域板块查询
     *
     * @param version
     * @return
     */
    @ApiOperation(value = "区域板块查询",notes = "根据城市编号查询区域板块信息")
    @RequestMapping(value = "/queryArea/{version}",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON+";charset=UTF-8")
    public ResultDO<List<RegionInfoDTO>> queryArea(
            @ApiParam(name = "reqJson",value = "区域板块请求参数",required = true) @RequestBody AreaDTO reqJson,
            @ApiParam(name="version",value = "版本号",required = true,defaultValue ="v1.0.0" ) @PathVariable("version") String version){

        if(reqJson==null){
            ResultDO<List<RegionInfoDTO>> resultDO=new ResultDO<List<RegionInfoDTO>>();
            resultDO.setErrMsg("请求参数不能为空");
            return resultDO;
        }

        return areaAO.queryArea(reqJson);
    }

}

