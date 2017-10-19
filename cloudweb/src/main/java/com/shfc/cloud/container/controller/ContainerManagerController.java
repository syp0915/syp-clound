package com.shfc.cloud.container.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.container.ao.ContainerManagerAO;
import com.shfc.cloud.container.dto.WarDeployWebDTO;
import com.shfc.cloud.container.dto.WarRollbackWebDTO;
import com.shfc.cloud.monitor.dto.BaseWebDTO;
import com.shfc.common.result.ResultDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Package com.shfc.cloud.container.controller.ContainerManagerController
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/18 9:56
 * version V1.0.0
 */
@Api(tags = "ContainerManagerController", description = "容器管理")
@RestController
@RequestMapping("/cloud/containerManager")
public class ContainerManagerController {

	@Autowired
	private ContainerManagerAO containerManagerAO;
	/**
	 * 服务器部署请求
	 *
	 * @param reqJson
	 * @param version
	 * @return
	 */
	@ApiOperation(value = "war包部署请求", notes = "执行war包部署")
	@RequestMapping(value = "/serverDeployReq/{version}", method = RequestMethod.POST)
	public ResultDO serverDeployReq(@ApiParam(name="reqJson",value="war包部署请求参数", required=true)@RequestBody WarDeployWebDTO reqJson, @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version) {
		return containerManagerAO.serverDeployReq(reqJson);
	}

	/**
	 * 服务器回滚请求
	 *
	 * @param reqJson
	 * @param version
	 * @return
	 */
	@ApiOperation(value = "war包回滚", notes = "执行war包回滚操作")
	@RequestMapping(value = "/serverDeployRollbackReq/{version}", method = RequestMethod.POST)
	public ResultDO<JSONObject> serverDeployRollbackReq(@ApiParam(name="reqJson",value="war包回滚请求参数", required=true)@RequestBody WarRollbackWebDTO reqJson, @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version) {
		return containerManagerAO.serverDeployRollback(reqJson);
	}

	/**
	 * 服务器重启请求
	 *
	 * @param reqJson
	 * @param version
	 * @return
	 */
	@ApiOperation(value = "tomcat重启", notes = "执行tomcat重启操作")
	@RequestMapping(value = "/serverRestartReq/{version}", method = RequestMethod.POST)
	public ResultDO<JSONObject> serverRestartReq(@ApiParam(name="reqJson",value="tomcat重启请求参数", required=true)@RequestBody BaseWebDTO reqJson, @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version) {
		return containerManagerAO.serverRestartReq(reqJson);
	}
}
