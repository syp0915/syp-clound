package com.shfc.cloud.flowscreen.controller;

import com.shfc.cloud.exception.CloudWebException;
import com.shfc.cloud.flowscreen.ao.FlowscreenAO;
import com.shfc.cloud.flowscreen.dto.FlowscreenDTO;
import com.shfc.cloud.utils.JSONParseUtils;
import com.shfc.common.result.ResultDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Package com.shfc.apistore.flowscreen.controller.FlowscreenController
 * @Description: FlowscreenController
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/3/30 上午9:37
 * version V1.0.0
 */
@Api(tags = "FlowscreenController", description = "飘频请求")
@RestController
@RequestMapping("/cloud/flowscreen")
public class FlowscreenController {

    @Autowired
    private FlowscreenAO flowscreenAO;
    private static final String JSON_ERR_MSG = "json格式错误,请检查请求参数";

    @ApiOperation(value = "飘频请求" , notes = "接受飘频请求并处理")
    @RequestMapping(value = "/flowscreenReq/{version}", method = RequestMethod.POST)
    public ResultDO<Object> flowscreenReq(
            @ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody FlowscreenDTO reqJson,
            @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO<Object> resultDO = new ResultDO<>();
        if (null == reqJson) {
            resultDO.setErrMsg(JSON_ERR_MSG);
            return resultDO;
        }
        return flowscreenAO.flowscreenReq(reqJson);
    }
}
