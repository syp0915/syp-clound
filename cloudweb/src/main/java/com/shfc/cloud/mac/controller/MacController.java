package com.shfc.cloud.mac.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.mac.ao.MacAO;
import com.shfc.cloud.mac.dto.MacDetailWebDTO;
import com.shfc.cloud.mac.dto.MacWebDTO;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.mac.dto.MacInfoDTO;
import com.shfc.mac.query.MacQuery;
import com.shfc.mybatis.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.shfc.cloud.mac.controller.MacController
 * @Description: mac查询
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/17 17:31
 * version V1.0.0
 */
@Api(tags = "MacController", description = "mac查询")
@RestController
@RequestMapping(value = "/cloud/mac/",produces = MediaType.APPLICATION_JSON+";charset=UTF-8")
public class MacController {
    @Autowired
    private MacAO macAO;

    @ApiOperation(value = "查询mac详情",notes = "查询mac详情")
    @RequestMapping(value = "/macDetail/{version}", method = RequestMethod.POST)
    public ResultDO<MacInfoDTO> macDetail(@ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody MacDetailWebDTO reqJson,
                                          @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO<MacInfoDTO> resultDO = new ResultDO<>();
        resultDO =  macAO.macDetail(reqJson);
        return resultDO;
    }


    @ApiOperation(value = "查询mac列表",notes = "查询mac列表")
    @RequestMapping(value = "/macList/{version}", method = RequestMethod.POST)
    public ResultDO<Page<MacInfoDTO>> macList(@ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody MacWebDTO reqJson,
                                              @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO<Page<MacInfoDTO>> resultDO = new ResultDO<>();
        resultDO = macAO.macList(reqJson);
        return resultDO;
    }
}
