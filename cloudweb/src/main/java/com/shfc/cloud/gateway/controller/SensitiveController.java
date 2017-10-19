package com.shfc.cloud.gateway.controller;

import com.shfc.cloud.exception.CloudWebException;
import com.shfc.cloud.gateway.ao.SensitiveAO;
import com.shfc.cloud.gateway.dto.SensitiveWebDTO;
import com.shfc.cloud.gateway.service.SensitiveService;
import com.shfc.common.base.Logger;
import com.shfc.common.result.ResultDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 敏感词管理
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/3/21 10:45
 * @since 1.0
 */
@Slf4j
@Api(tags = "SensitiveController", description = "敏感词管理")
@RestController
@RequestMapping(value="cloud/sensitive",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SensitiveController {
    @Resource
    private SensitiveAO sensitiveAO;
    @Resource
    private SensitiveService sensitiveService;
    /**
     * 敏感词新增
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "新增", notes = "敏感词新增")
    @RequestMapping(value = "/insert/{version}", method = RequestMethod.POST)
    public ResultDO insert(@ApiParam(name="reqJson",value="敏感词新增请求参数", required=true)@RequestBody SensitiveWebDTO reqJson,
                           @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version) throws CloudWebException {
        Logger.info("敏感词新增请求参数reqJson:{}",reqJson.toString());
        ResultDO result = new ResultDO();
        result=sensitiveAO.insert(reqJson);
        return result;
    }
    /**
     * 敏感词查询
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "查询", notes = "敏感词查询")
    @RequestMapping(value = "/select/{version}", method = RequestMethod.POST)
    public ResultDO  select(@ApiParam(name="reqJson",value="敏感词查询请求参数", required=true)@RequestBody SensitiveWebDTO reqJson,
                                                @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version) throws CloudWebException {
        Logger.info("敏感词查询请求参数reqJson:{}",reqJson.toString());
        return sensitiveAO.select(reqJson);
    }
    /**
     * 敏感词删除
     * @param version
     * @return
     */
    @ApiOperation(value = "删除", notes = "敏感词删除")
    @RequestMapping(value = "/delete/{version}", method = RequestMethod.POST)
    public ResultDO delete(@ApiParam(name="reqJson",value="敏感词删除请求参数", required=true)@RequestBody SensitiveWebDTO   reqJson,
                           @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        Logger.info("敏感词删除请求参数reqJson:{}",reqJson.toString());
        ResultDO result = new ResultDO();
        result=sensitiveAO.delete(reqJson);
        return result;
    }
}
