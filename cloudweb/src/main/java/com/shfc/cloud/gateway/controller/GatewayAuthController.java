package com.shfc.cloud.gateway.controller;

import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.applog.dto.AppLogDTO;
import com.shfc.cloud.constant.CloudConstant;
import com.shfc.cloud.exception.CloudWebException;
import com.shfc.cloud.gateway.ao.GatewayAuthAO;
import com.shfc.cloud.gateway.dto.GatewayAuthDTO;
import com.shfc.cloud.gateway.dto.GatewayAuthWebDTO;
import com.shfc.cloud.gateway.service.GatewayAuthService;
import com.shfc.cloud.utils.HttpSessionUtils;
import com.shfc.cloud.utils.JSONParseUtils;
import com.shfc.common.base.Logger;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 类注释
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/3/20 15:25
 * @since 1.0
 */
@Api(tags = "GatewayAuthController", description = "网关权限管理")
@RestController
@RequestMapping(value="cloud/gatewayAuth",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GatewayAuthController {

    @Resource
    private GatewayAuthAO gatewayAuthAO;
    /**
     * 网关权限新增
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "新增", notes = "网关权限新增")
    @RequestMapping(value = "/insert/{version}", method = RequestMethod.POST)
    public ResultDO insert( @ApiParam(name="reqJson",value="网关权限新增请求参数", required=true)@RequestBody GatewayAuthWebDTO reqJson,
                           @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version) throws CloudWebException {
        Logger.info("网关权限新增传入的参数reqJson:{}",reqJson.toString());
        ResultDO result = new ResultDO();
        result=gatewayAuthAO.insert(reqJson);
        return result;
    }
    /**
     * 网关权限查询
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "查询", notes = "网关权限查询")
    @RequestMapping(value = "/select/{version}", method = RequestMethod.POST)
    public ResultDO select(@ApiParam(name="reqJson",value="网关权限查询请求参数", required=true)@RequestBody GatewayAuthWebDTO reqJson,
                           @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version) {
        Logger.info("网关权限查询传入的参数reqJson:{}",reqJson.toString());
        ResultDO result = new ResultDO();
        result=gatewayAuthAO.select(reqJson);
        return result;
    }
    /**
     * 网关权限删除
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "删除", notes = "网关权限删除")
    @RequestMapping(value = "/delete/{version}", method = RequestMethod.POST)
    public ResultDO delete( @ApiParam(name="reqJson",value="网关权限修改请求参数", required=true)@RequestBody GatewayAuthWebDTO reqJson,
                            @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version) {
        Logger.info("网关权限删除传入的参数reqJson:{}",reqJson.toString());
        ResultDO result = new ResultDO();
        result=gatewayAuthAO.delete(reqJson);
        return result;
    }
    /**
     * 网关权限修改
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "修改", notes = "网关权限修改")
    @RequestMapping(value = "/update/{version}", method = RequestMethod.POST)
    public ResultDO update( @ApiParam(name="reqJson",value="网关权限修改请求参数", required=true)@RequestBody GatewayAuthWebDTO reqJson,
                            @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version) throws CloudWebException {
        Logger.info("网关权限修改传入的参数reqJson:{}",reqJson.toString());
        ResultDO result = new ResultDO();
        result=gatewayAuthAO.update(reqJson);
        return result;
    }
}
