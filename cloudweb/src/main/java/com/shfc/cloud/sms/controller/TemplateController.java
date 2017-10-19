package com.shfc.cloud.sms.controller;

import com.shfc.cloud.sms.ao.SmsAO;
import com.shfc.cloud.sms.dto.SmsTplWebDTO;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.sms.dto.SmsMerchantTemplateDTO;
import com.shfc.sms.dto.TemplateResultDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @Package com.shfc.cloud.sms.controller.TemplateController
 * @Description: 短信模板
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/16 15:44
 * version V1.0.0
 */
@Api(tags = "TemplateController", description = "短信模板")
@RestController
@RequestMapping(value = "/cloud/sms/",produces = MediaType.APPLICATION_JSON+";charset=UTF-8")
public class TemplateController {
    @Autowired
    private SmsAO smsAO;
    @ApiOperation(value = "新增短信模板", notes = "新增短信模板")
    @RequestMapping(value = "/addTemplate/{version}", method = RequestMethod.POST)
    public ResultDO<TemplateResultDTO> addTemplate(@ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody SmsTplWebDTO reqJson,
                                                   @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO<TemplateResultDTO> resultDO = new ResultDO<>();
        //SmsMerchantTemplateDTO query = JsonUtils.parseJavaObject(reqJson, SmsMerchantTemplateDTO.class);
        resultDO = smsAO.addTemplate(reqJson);
        return resultDO;
    }
    @ApiOperation(value = "获取短信模板", notes = "获取短信模板")
    @RequestMapping(value = "/getTemplate/{version}", method = RequestMethod.POST)
    public ResultDO<List<TemplateResultDTO>> getTemplate(@ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody SmsTplWebDTO reqJson,
                                                         @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO<List<TemplateResultDTO>> resultDO = new ResultDO<>();
        resultDO = smsAO.getTemplate(reqJson);
        return resultDO;
    }
    @ApiOperation(value = "修改短信模板", notes = "修改短信模板")
    @RequestMapping(value = "/updateTemplate/{version}", method = RequestMethod.POST)
    public ResultDO<TemplateResultDTO> updateTemplate(@ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody SmsTplWebDTO reqJson,
                                                      @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO<TemplateResultDTO> resultDO = new ResultDO<>();
        resultDO = smsAO.updateTemplate(reqJson);
        return resultDO;
    }
    @ApiOperation(value = "删除短信模板", notes = "删除短信模板")
    @RequestMapping(value = "/deleteTemplate/{version}", method = RequestMethod.POST)
    public ResultDO<TemplateResultDTO> deleteTemplate(@ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody SmsTplWebDTO reqJson,
                                                      @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO<TemplateResultDTO> resultDO = new ResultDO<>();
        resultDO = smsAO.deleteTemplate(reqJson);
        return resultDO;
    }
}
