package com.shfc.cloud.authentication.controller;

import com.shfc.cloud.authentication.ao.AuthenticationAO;
import com.shfc.cloud.authentication.dto.AuthenticationDTO;
import com.shfc.common.result.ResultDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 实名认证
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-21 09:46
 **/
@Api(tags = "AuthenticationController",description = "实名认证")
@RestController
@RequestMapping("/cloud/authenticate")
public class AuthenticationController {
    @Autowired(required = false)
    private AuthenticationAO authenticationAO;

    /**
     * 两要素认证
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "两要素认证",notes = "根据姓名身份证号码判断两者是否一致")
    @RequestMapping(value = "/authenticationByInfo/{version}",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON+";charset=UTF-8")
    public ResultDO<Boolean> authenticationByInfo(
            @ApiParam(name = "reqJson",value = "两要素验证请求参数",required = true) @RequestBody AuthenticationDTO reqJson,
            @ApiParam(name="version",value = "版本号",required = true,defaultValue ="v1.0.0" ) @PathVariable("version") String version){


        if(reqJson==null){
            ResultDO<Boolean> resultDO=new ResultDO<Boolean>();
            resultDO.setErrMsg("请求参数不能为空");
            return resultDO;
        }

        return authenticationAO.authenticationByInfo(reqJson);
    }
}
