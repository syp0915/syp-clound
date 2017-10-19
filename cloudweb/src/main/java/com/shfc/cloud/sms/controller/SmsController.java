package com.shfc.cloud.sms.controller;

import com.shfc.cloud.sms.ao.SmsAO;
import com.shfc.cloud.sms.dto.SendSmsWebDTO;
import com.shfc.cloud.sms.dto.SendVoiceWebDTO;
import com.shfc.cloud.sms.dto.SmsRecordWebDTO;
import com.shfc.common.result.ResultDO;
import com.shfc.mybatis.pagination.Page;
import com.shfc.sms.dto.SmsBatchResultDTO;
import com.shfc.sms.dto.SmsRecordResultDTO;
import com.shfc.sms.dto.SmsResultDTO;
import com.shfc.sms.dto.VoiceResultDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;

/**
 * @Package com.shfc.apistore.api.sms.controller.SmsController
 * @Description: 短信发送
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/13 10:36
 * version V1.0.0
 */
@Api(tags = "SmsController", description = "短信发送")
@RestController
@RequestMapping(value = "/cloud/sms",produces = MediaType.APPLICATION_JSON+";charset=UTF-8")
public class SmsController {
    @Autowired
    private SmsAO smsAO;

    /**
     * 单条短信发送
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "发送单条短信", notes = "发送单条短信")
    @RequestMapping(value = "/singleSend/{version}", method = RequestMethod.POST)
    public ResultDO<SmsResultDTO> singleSend(@ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody SendSmsWebDTO reqJson,
                                             @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO<SmsResultDTO> resultDO = new ResultDO<>();
        resultDO = smsAO.singleSend(reqJson);
        return resultDO;
    }

    /**
     * 查询短信记录
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "查询短信记录", notes = "查询短信记录")
    @RequestMapping(value = "/smsRecordList/{version}", method = RequestMethod.POST)
    public ResultDO<Page<SmsRecordResultDTO>> smsRecordList (@ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody SmsRecordWebDTO reqJson,
                                                             @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO<Page<SmsRecordResultDTO>> resultDO = new ResultDO<>();
        resultDO = smsAO.smsRecordList(reqJson);
        return resultDO;
    }

    /**
     * 查询批量短信记录
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "查询批量短信记录", notes = "查询批量短信记录")
    @RequestMapping(value = "/smsBatchRecordList/{version}", method = RequestMethod.POST)
    public ResultDO<Page<SmsRecordResultDTO>> smsBatchRecordList (@ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody SmsRecordWebDTO reqJson,
                                                                  @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO<Page<SmsRecordResultDTO>> resultDO = new ResultDO<>();
        resultDO = smsAO.smsBatchRecordList(reqJson);
        return resultDO;
    }

    /**
     * 发送语音验证码
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "发送语音验证码", notes = "发送语音验证码")
    @RequestMapping(value = "/sendVoice/{version}", method = RequestMethod.POST)
    public ResultDO<VoiceResultDTO> sendVoice(@ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody SendVoiceWebDTO reqJson,
                                              @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO<VoiceResultDTO> resultDO = new ResultDO<>();
        resultDO = smsAO.sendVoice(reqJson);
        return resultDO;
    }

    /**
     * 批量发送相同内容
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "批量发送相同内容", notes = "批量发送相同内容")
    @RequestMapping(value = "/batchSend/{version}", method = RequestMethod.POST)
    public ResultDO<SmsBatchResultDTO> batchSend(@ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody SendSmsWebDTO reqJson,
                                                 @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO<SmsBatchResultDTO> resultDO = new ResultDO<>();
        resultDO = smsAO.batchSend(reqJson);
        return resultDO;
    }

    /**
     * 批量发送不同内容
     * @param version
     * @return
     */
    @ApiOperation(value = "批量发送不同内容", notes = "批量发送不同内容")
    @RequestMapping(value = "/multiSend/{version}", method = RequestMethod.POST)
    public ResultDO<SmsBatchResultDTO> multiSend(@ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody SendSmsWebDTO reqJson,
                                                 @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO<SmsBatchResultDTO> resultDO = new ResultDO<SmsBatchResultDTO>();
        resultDO = smsAO.multiSend(reqJson);
        return resultDO;
    }

}
