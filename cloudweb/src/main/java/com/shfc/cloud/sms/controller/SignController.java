package com.shfc.cloud.sms.controller;

import com.shfc.cloud.sms.ao.SmsAO;
import com.shfc.cloud.sms.dto.SmsSignWebDTO;
import com.shfc.common.result.ResultDO;
import com.shfc.sms.dto.SmsSignDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * @Package com.shfc.cloud.sms.controller.SignController
 * @Description: 短信签名
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/21 11:10
 * version V1.0.0
 */
@Api(tags = "SignController", description = "短信签名")
@RestController
@RequestMapping(value = "/cloud/sms/",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SignController {
    @Autowired
    private SmsAO smsAO;

    @ApiOperation(value = "添加短信签名", notes = "添加短信签名")
    @RequestMapping(value = "/addSign/{version}", method = RequestMethod.POST)
    public ResultDO<SmsSignDTO> addSign(@ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody SmsSignWebDTO reqJson,
                                        @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO<SmsSignDTO> resultDO = new ResultDO<SmsSignDTO>();
        resultDO = smsAO.addSign(reqJson);
        return resultDO;
    }
    @ApiOperation(value = "获取短信签名", notes = "获取短信签名")
    @RequestMapping(value = "/getSignById/{version}", method = RequestMethod.POST)
    public ResultDO<SmsSignDTO> getSignById(@ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody SmsSignWebDTO reqJson,
                                            @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO<SmsSignDTO> resultDO = new ResultDO<SmsSignDTO>();
        resultDO = smsAO.getSignById(reqJson);
        return resultDO;
    }
    @ApiOperation(value = "修改短信签名", notes = "修改短信签名")
    @RequestMapping(value = "/updateSign/{version}", method = RequestMethod.POST)
    public ResultDO<SmsSignDTO> updateSign(@ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody SmsSignWebDTO reqJson,
                                           @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO<SmsSignDTO> resultDO = new ResultDO<SmsSignDTO>();
        resultDO = smsAO.updateSign(reqJson);
        return resultDO;
    }
}
