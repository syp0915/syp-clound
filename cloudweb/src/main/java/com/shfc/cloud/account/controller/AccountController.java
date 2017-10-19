package com.shfc.cloud.account.controller;

import com.shfc.cloud.account.ao.AccountAO;
import com.shfc.cloud.account.dto.MerchantDTO;
import com.shfc.cloud.account.dto.MerchantInfoDTO;
import com.shfc.cloud.account.dto.UserInfoDTO;
import com.shfc.cloud.account.dto.UserListDTO;
import com.shfc.common.result.ResultDO;
import com.shfc.mybatis.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Package com.shfc.cloud.account.controller.AccountController
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/16 17:04
 * version V1.0.0
 */
@Api(tags = "AccountController", description = "商户管理")
@RestController
@RequestMapping(value = "/cloud/account" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AccountController{

    @Autowired
    private AccountAO accountAO;

    /**
     * 用户详细信息
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "获取用户详细信息", notes = "根据商户id或商户号")
    @RequestMapping(value = "/userInfo/{version}", method = RequestMethod.POST)
    public ResultDO<MerchantInfoDTO> userInfo(@ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody UserInfoDTO reqJson,
                                              @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO<MerchantInfoDTO> result = accountAO.userInfo(reqJson);
        return result;
    }

    /**
     * 用户列表
     * @param reqJson
     * @param version
     * @return
     */
    @RequestMapping(value = "/userList/{version}", method = RequestMethod.POST)
    public ResultDO<Page<MerchantDTO>> userList(@ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody UserListDTO reqJson,
                                                @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO<Page<MerchantDTO>> result = accountAO.userList(reqJson);
        return result;
    }
}
