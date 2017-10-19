package com.shfc.cloud.monitor.controller;

import com.shfc.cloud.monitor.ao.ResourceMonitorAO;
import com.shfc.cloud.monitor.dto.*;
import com.shfc.common.result.ResultDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Package com.shfc.cloud.monitor.controller.ResourceMonitorController
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/16 15:13
 * version V1.0.0
 */
@Api(tags = "ResourceMonitorController", description = "资源监控")
@RestController
@RequestMapping("/cloud/resMonitor")
public class ResourceMonitorController {

	@Autowired
	private ResourceMonitorAO resourceMonitorAO;
	/**
	 * 获取资源监控最新数据
	 *
	 * @param reqJson
	 * @param version
	 * @return
	 */
	@ApiOperation(value = "最新监控数据获取", notes = "获取最新cpu、数据库空间、磁盘空间、缓存调用监控数据")
	@RequestMapping(value = "/getLastedMonitorData/{version}", method = RequestMethod.POST)
	public ResultDO<MonitorCurrentDTO> getResLastedData(
			@ApiParam(name="reqJson",value="资源监控请求参数", required=true)@RequestBody BaseWebDTO reqJson,
			@ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version) {
		ResultDO<MonitorCurrentDTO> resultDO = resourceMonitorAO.getLastedMonitorData(reqJson);
		return resultDO;
	}

	/**
	 * 获取资源监控明细
	 *
	 * @param reqJson
	 * @param version
	 * @return
	 */
	@ApiOperation(value = "资源监控数据列表获取", notes = "获取cpu监控数据列表")
	@RequestMapping(value = "/getResMonitorDetail/{version}", method = RequestMethod.POST)
	public ResultDO<ResourceMonitorDetailDTO> getResMonitorDetail(
			@ApiParam(name="reqJson",value="资源监控请求参数", required=true)@RequestBody ResMonitorDetailWebDTO reqJson,
			@ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version) {
		return resourceMonitorAO.getResMonitorDetailData(reqJson);
	}

	/**
	 * 缓存监控明细查询
	 *
	 * @param reqJson
	 * @param version
	 * @return
	 */
	@ApiOperation(value = "缓存监控明细获取", notes = "获取缓存监控明细数据")
	@RequestMapping(value = "/getCacheMonitorDetail/{version}", method = RequestMethod.POST)
	public ResultDO getCacheMonitorDetail(@RequestBody BaseWebDTO reqJson, @PathVariable("version") String version) {
		return resourceMonitorAO.getCacheMonitorDetail(reqJson);
	}


	/**
	 * 图片监控详情查询
	 *
	 * @param reqJson
	 * @param version
	 * @return
	 */
	@ApiOperation(value = "图片空间监控数据列表获取", notes = "获取图片空间监控数据")
	@RequestMapping(value = "/getImgMonitorDetail/{version}", method = RequestMethod.POST)
	public ResultDO<SpaceUseMonitorDetailDTO> getImgMonitorDetail(
			@ApiParam(name="reqJson",value="资源监控请求参数", required=true)@RequestBody BaseWebDTO reqJson,
			@ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version) {
		return resourceMonitorAO.getImgMonitorDetail(reqJson);
	}

	/**
	 * 数据库空间使用详情查询
	 *
	 * @param reqJson
	 * @param version
	 * @return
	 */
	@ApiOperation(value = "数据库空间监控数据获取", notes = "获取数据库空间监控数据")
	@RequestMapping(value = "/getDBMonitorDetail/{version}", method = RequestMethod.POST)
	public ResultDO<SpaceUseMonitorDetailDTO> getDBMonitorDetail(
			@ApiParam(name="reqJson",value="数据库空间监控请求参数", required=true)@RequestBody BaseWebDTO reqJson,
			@ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version) {
		return resourceMonitorAO.getDBMonitorDetail(reqJson);
	}

	/**
	 * tomcat运行状态查询
	 *
	 * @param reqJson
	 * @param version
	 * @return
	 */
	@ApiOperation(value = "服务器运行状态获取", notes = "获取服务器运行状态数据")
	@RequestMapping(value = "/getServerStatus/{version}", method = RequestMethod.POST)
	public ResultDO<ServerStatusDTO> getServerStatus(
			@ApiParam(name="reqJson",value="服务器运行状态监控请求参数", required=true)@RequestBody BaseWebDTO reqJson,
			@ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version) {
		return resourceMonitorAO.getServerStatus(reqJson);
	}

	/**
	 * 磁盘监控详情查询
	 *
	 * @param reqJson
	 * @param version
	 * @return
	 */
	@ApiOperation(value = "磁盘监控详情查询", notes = "磁盘监控详情查询")
	@RequestMapping(value = "/getDiskMonitorDetail/{version}", method = RequestMethod.POST)
	public ResultDO<SpaceUseMonitorDetailDTO> getDiskMonitorDetail(
			@ApiParam(name="reqJson",value="磁盘监控详情查询请求参数", required=true)@RequestBody BaseWebDTO reqJson,
			@ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version) {
		return resourceMonitorAO.getDiskMonitorDetail(reqJson);
	}




}
