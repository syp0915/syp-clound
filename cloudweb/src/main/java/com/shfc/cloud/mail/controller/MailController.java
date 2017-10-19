package com.shfc.cloud.mail.controller;

import com.shfc.cloud.exception.CloudWebException;
import com.shfc.cloud.mail.ao.MailAO;
import com.shfc.cloud.mail.dto.MailDTO;
import com.shfc.cloud.utils.JSONParseUtils;
import com.shfc.common.result.ResultDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;

/**
 * @Package com.shfc.cloud.mail.controller
 * @Description: MailController
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/3/16 下午6:44
 * version V1.0.0
 */
@Api(tags = "MailController", description = "发送邮件")
@RestController
@RequestMapping("/cloud/mail/")
public class MailController {

    @Autowired
    private MailAO mailAO;
    private static final String JSON_ERR_MSG = "json格式错误,请检查请求参数";

    @ApiOperation(value = "发送邮件", notes = "发送默认邮件或自定义邮件")
    @RequestMapping(value = "/sendMail/{version}", method = RequestMethod.POST)
    public ResultDO<Boolean> sendMail(
            @ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody MailDTO reqJson,
            @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version) {
        if (null == reqJson) {
            ResultDO<Boolean> resultDO = new ResultDO<>();
            resultDO.setErrMsg(JSON_ERR_MSG);
            return resultDO;
        }
        return mailAO.sendEmail(reqJson);
    }
}
