package com.shfc.cloud.video.controller;

import com.shfc.cloud.exception.CloudWebException;
import com.shfc.cloud.video.ao.VideoAO;
import com.shfc.cloud.video.dto.*;
import com.shfc.cloud.video.query.DeleteWarQuery;
import com.shfc.common.result.ResultDO;
import com.shfc.mybatis.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Package com.shfc.cloud.resource.controller.ResourceController
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/16 15:34
 * version V1.0.0
 */
@Api(tags = "VideoController", description = "媒资管理")
@RestController
@RequestMapping("/cloud/video")
public class VideoController {

    @Autowired
    private VideoAO videoAO;

    /**
     * war包下载
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "war包下载", notes = "根据商户id或商户号")
    @RequestMapping(value = "/downloadWar/{version}", method = RequestMethod.POST)
    public void downloadWar(HttpServletResponse response,
                            @ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody DownloadWarDTOToWEB reqJson,
                            @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version) throws Exception {

        ResultDO<DownloadWarDTO> result = new ResultDO<DownloadWarDTO>();
        result = videoAO.downloadWar(reqJson.getWarId(),reqJson.getChannelNo(),reqJson.getMerchantId());
        // 下载失败
        if(!result.isSuccess()){
            throw new CloudWebException(result.getErrCode(),
                    result.getErrMsg());
        }
        File file = new File(result.getData().getUrl());//共享文件夹真实存储路径
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName="+file.getName());

        InputStream inputStream = new FileInputStream(file);
        OutputStream os = response.getOutputStream();
        byte[] b = new byte[2048];
        int length;
        while ((length = inputStream.read(b)) > 0) {
            os.write(b, 0, length);
        }
        // 这里主要关闭。
        os.close();
        inputStream.close();
    }

    /**
     * war包列表
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "war包列表", notes = "根据商户id或商户号")
    @RequestMapping(value = "/warlist/{version}", method = RequestMethod.POST)
    public ResultDO<Page<WarlistDTO>> warlist(@ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody WarlistDTO reqJson,
                                              @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO<Page<WarlistDTO>> result = videoAO.warlist(reqJson);
        return result;
    }

    /**
     * 资源列表
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "资源列表", notes = "根据商户id或商户号")
    @RequestMapping(value = "/resourceList/{version}", method = RequestMethod.POST)
    public ResultDO<Page<ResourceListDTO>> resourceList(@ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody ResourceListToWebDTO reqJson,
                                                        @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO<Page<ResourceListDTO>> result = videoAO.resourceList(reqJson);
        return result;
    }


    /**
     * 资源详情
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "资源详情", notes = "根据商户id或商户号")
    @RequestMapping(value = "/resourceInfo/{version}", method = RequestMethod.POST)
    public ResultDO<ResourceInfoDTOToWeb> resourceInfo(@ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody ResourceInfoWebDTO reqJson,
                                                  @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO<ResourceInfoDTOToWeb> result = videoAO.resourceInfo(reqJson);
        return result;
    }


    /**
     * 图片缩放
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "图片缩放", notes = "根据商户id或商户号")
    @RequestMapping(value = "/imgZoom/{version}", method = RequestMethod.POST)
    public ResultDO imgZoom(@ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody ImgZoomDTO reqJson,
                            @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO result = videoAO.imgZoom(reqJson);
        return result;
    }

//    /**
//     * 视频转码功能
//     * @param reqJson
//     * @param version
//     * @return
//     */
//    @ApiOperation(value = "视频转码", notes = "根据商户id或商户号")
//    @RequestMapping(value = "/videoTranscod/{version}", method = RequestMethod.POST)
//    public ResultDO<JSONObject> videoTranscod(@ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody VideoTranscodDTO reqJson,
//                                              @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
//        JSONObject object = new JSONObject();
//        object.put("url","http://shfc-attachment.oss-cn-shanghai.aliyuncs.com/image/2017/03/16/IMG_1489656342638_96775.jpg");
//        ResultDO<JSONObject> resultDO = new ResultDO<JSONObject>();
//        resultDO.setSuccess(true);
//        resultDO.setData(object);
//        return resultDO;
//    }

    /**
     * 资源审核功能
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "资源审核功能", notes = "根据商户id或商户号")
    @RequestMapping(value = "/resourceCheck/{version}", method = RequestMethod.POST)
    public ResultDO resourceCheck(@ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody ResourceCheckDTO reqJson,
                                  @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO result = videoAO.resourceCheck(reqJson);
        return result;
    }

    /**
     * war包列表
     * @param reqJson
     * @param version
     * @return
     */
    @ApiOperation(value = "war包删除", notes = "根据商户id或商户号")
    @RequestMapping(value = "/deleteWar/{version}", method = RequestMethod.POST)
    public ResultDO<Boolean> deleteWar(@ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody DeleteWarQuery reqJson,
                                              @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO<Boolean> result = videoAO.deleteWar(reqJson);
        return result;
    }

}