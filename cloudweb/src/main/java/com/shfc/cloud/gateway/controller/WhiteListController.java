package com.shfc.cloud.gateway.controller;

import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.exception.CloudWebException;
import com.shfc.cloud.gateway.ao.WhiteListAO;
import com.shfc.cloud.gateway.dto.WhiteListDTO;
import com.shfc.cloud.gateway.dto.WhiteListWebDTO;
import com.shfc.cloud.gateway.service.WhiteListService;
import com.shfc.common.base.Logger;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 类注释
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/3/20 14:00
 * @see
 * @since 1.0
 */
@Api(tags = "WhiteListController", description = "商户ip白名单管理")
@RestController
@RequestMapping(value = "cloud/whiteListManage",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class WhiteListController {
    @Resource
    private WhiteListAO whiteListAO;
    /**
     * 商户ip白名单数据增加
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "新增", notes = "商户ip白名单数据增加")
    @RequestMapping(value = "/insert/{version}", method = RequestMethod.POST)
    public ResultDO insert(@ApiParam(name="reqJson",value="商户ip白名单新增请求参数", required=true)@RequestBody WhiteListWebDTO reqJson,
                           @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version) throws CloudWebException {
        Logger.info("商户ip白名单新增请求参数reqJson:{}",reqJson.toString());
        ResultDO result = new ResultDO();
        result=whiteListAO.insert(reqJson);
        return result;
    }
    /**
     * 商户ip白名单数据查询
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "查询", notes = "商户ip白名单数据查询")
    @RequestMapping(value = "/select/{version}", method = RequestMethod.POST)
    public ResultDO select(@ApiParam(name="reqJson",value="商户ip白名单查询请求参数", required=true)@RequestBody WhiteListWebDTO reqJson,
                           @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version) {
        Logger.info("商户ip白名单查询请求参数reqJson:{}",reqJson.toString());
        ResultDO result=new ResultDO();
        result=whiteListAO.select(reqJson);
        return result;
    }
    /**
     * 商户ip白名单数据删除
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "删除", notes = "商户ip白名单数据删除")
    @RequestMapping(value = "/delete/{version}", method = RequestMethod.POST)
    public ResultDO delete(@ApiParam(name="reqJson",value="商户ip白名单删除请求参数", required=true)@RequestBody WhiteListWebDTO reqJson,
                           @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version) {
        Logger.info("商户ip白名单删除请求参数reqJson:{}",reqJson.toString());
        ResultDO result = new ResultDO();
        result=whiteListAO.delete(reqJson);
        return result;
    }
}
