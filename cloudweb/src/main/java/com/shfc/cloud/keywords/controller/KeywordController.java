package com.shfc.cloud.keywords.controller;

import com.shfc.cloud.cloudbase.dto.ChannelDTO;
import com.shfc.cloud.cloudbase.dto.PlotDTO;
import com.shfc.cloud.keywords.ao.KeywordAO;
import com.shfc.cloud.keywords.dto.ChannelNameDTO;
import com.shfc.cloud.keywords.dto.PlotNameDTO;
import com.shfc.common.result.ResultDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 关键词联想
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-17 13:45
 **/
@Api(value = "KeywordController")
@RestController
@RequestMapping("/cloud/keyword")
public class KeywordController {
    @Autowired(required = false)
    private KeywordAO keywordAO;
    /**
     * 小区名称联想
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "小区名称联想",notes = "根据关键词查询小区名称")
    @RequestMapping(value = "/plotName/{version}",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON+";charset=UTF-8")
    public ResultDO<List<PlotDTO>> plotName(
            @ApiParam(name = "reqJson",value = "小区名称联想请求参数",required = true)@RequestBody PlotNameDTO reqJson,
            @ApiParam(name = "version",value = "版本号",required = true,defaultValue = "v1.0.0") @PathVariable("version") String version){

        if(reqJson==null){
            ResultDO<List<PlotDTO>> resultDO=new ResultDO<List<PlotDTO>>();
            resultDO.setErrMsg("请求参数不能为空");
            return resultDO;
        }
        return keywordAO.queryPlotNameBykeyword(reqJson);
    }


    /**
     * 频道号/名称联想
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "频道号/名称联想",notes = "根据关键词查询频道号/名称联想")
    @RequestMapping(value = "/channel/{version}",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON+";charset=UTF-8")
    public ResultDO<List<ChannelDTO>> channel(
            @ApiParam(name = "reqJson",value = "频道号/名称联想请求参数",required = true)@RequestBody ChannelNameDTO reqJson,
            @ApiParam(name = "version",value = "版本号",required = true,defaultValue = "v1.0.0")@PathVariable("version") String version) {
        if(reqJson==null){
            ResultDO<List<ChannelDTO>> resultDO=new ResultDO<List<ChannelDTO>>();
            resultDO.setErrMsg("请求参数不能为空");
            return resultDO;
        }
        return keywordAO.queryChannelBykeyword(reqJson);
    }

}
