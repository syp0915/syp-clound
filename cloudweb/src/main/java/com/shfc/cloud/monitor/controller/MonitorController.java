package com.shfc.cloud.monitor.controller;

import com.shfc.cloud.exception.CloudWebException;
import com.shfc.cloud.monitor.ao.AreaStatisticsAO;
import com.shfc.cloud.monitor.ao.MonitorAO;
import com.shfc.cloud.monitor.ao.RealTimeStatisticsAo;
import com.shfc.cloud.monitor.ao.TimeTrendAO;
import com.shfc.cloud.monitor.dto.*;
import com.shfc.cloud.utils.JSONParseUtils;
import com.shfc.common.result.ResultDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Package com.shfc.cloud.applog.controller.AppLogController
 * @Description: App Log 应用日志
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/16 10:42
 * version V1.0.0
 */
@Api(tags = "MonitorController",description = "监控服务")
@RestController
@RequestMapping("/cloud/monitor")
public class MonitorController {

    @Autowired
    private RealTimeStatisticsAo rtAo;

    @Autowired
    private TimeTrendAO timeTrendAO;


    @Autowired
    private MonitorAO monitorAO;

    @Autowired
    private AreaStatisticsAO areaStatisticsAO;

    /**
     * 实时统计
     * @param realTimeStatisticsDTO
     * @param version
     * @return
     */
    @ApiOperation(value = "监控服务-实时监控", notes = "监控服务实时统计")
    @RequestMapping(value = "/graphic/actualStatistics/{version}", method = RequestMethod.POST)
    public ResultDO<Object> actualStatistics(
            @ApiParam(name="reqJson",value="实时统计请求参数", required=true)@RequestBody  RealTimeStatisticsDTO  realTimeStatisticsDTO,
            @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version)throws CloudWebException {
        ResultDO<Object> resultDO = rtAo.getRealTimeSummary(realTimeStatisticsDTO);
        return resultDO;
    }

    @ApiOperation(value = "监控服务-时间趋势", notes = "监控服务-时间趋势")
    @RequestMapping(value = "/graphic/timeTrend/{version}", method = RequestMethod.POST)
    public ResultDO<TrendDTO> timeTrend(
            @ApiParam(name="reqJson",value="时间趋势请求参数", required=true)@RequestBody TimeTrendDTO timeTrendDTO,
            @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version) throws CloudWebException{
        ResultDO<TrendDTO> resultDO = timeTrendAO.getTimeTrend(timeTrendDTO);
        return resultDO;
    }
    @ApiOperation(value = "监控服务-地区趋势", notes = "监控服务-地区趋势")
    @RequestMapping(value = "/graphic/districtTrend/{version}", method = RequestMethod.POST)
    public ResultDO<Object> districtTrend(
            @ApiParam(name="reqJson",value = "监控服务-统计列表请求参数",required = false)@RequestBody AreaStatisticsDTO areaStatisticsDTO,
            @ApiParam(name="version",value = "版本号",required = true,defaultValue = "v1.0.0")@PathVariable("version") String version) throws CloudWebException{
        ResultDO<Object> resultDO =  areaStatisticsAO.getAreaStatistics(areaStatisticsDTO);
        return resultDO;
    }
    /**
     * 统计列表
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "监控服务-统计列表",notes = "监控服务-统计列表")
    @RequestMapping(value = "/list/statisticsList/{version}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultDO<VisistHistoryDTO> statisticsList(
            @ApiParam(name="reqJson",value = "监控服务-统计列表请求参数",required = false) @RequestBody StatisticsDTO reqJson,
            @ApiParam(name="version",value = "版本号",required = true,defaultValue = "v1.0.0") @PathVariable(name = "version") String version){

        return monitorAO.macVisitHistory(reqJson);
    }

    /**
     * 日志列表
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "监控服务-日志列表",notes = "监控服务-日志列表")
    @RequestMapping(value = "/list/logList/{version}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultDO<LogListDTO> logList(
            @ApiParam(name = "reqJson",value = "日志列表请求参数",required = false) @RequestBody MacLogDTO reqJson,
            @ApiParam(name = "version",value = "版本号",defaultValue = "v1.0.0") @PathVariable(name="version") String version){


        return monitorAO.logDataList(reqJson);
    }

    /**
     * 频道列表
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "监控服务-频道列表",notes = "监控服务-频道列表")
    @RequestMapping(value = "/list/channelList/{version}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultDO<ChannelDataDTO> channelList(
            @ApiParam(name = "reqJson",value = "频道列表请求参数",required = false) @RequestBody ChannelDTO reqJson,
            @ApiParam(name = "version",value = "版本号",defaultValue = "v1.0.0") @PathVariable(name="version") String version){

        return monitorAO.channelDataList(reqJson);
    }
}