package com.shfc.cloud.video.controller;

/**
 * @Package com.shfc.cloud.video.controller.VideoUploadController
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/5/5 14:19
 * version V1.0.0
 */

import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.video.ao.VideoAO;
import com.shfc.cloud.video.dto.UploadFileDTO;
import com.shfc.cloud.video.dto.UploadWarDTO;
import com.shfc.common.result.ResultDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;

/**
 * @Package com.shfc.cloud.resource.controller.ResourceController
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/16 15:34
 * version V1.0.0
 */
@Api(tags = "VideoUploadController", description = "媒资管理")
@RestController
@RequestMapping("/cloudUpload/video")
public class VideoUploadController {

    @Autowired
    private VideoAO videoAO;

    /**
     * war包上传
     * @param version
     * @return
     */
    @ApiOperation(value = "war包上传", notes = "根据商户id或商户号")
    @RequestMapping(value = "/uploadWar/{version}", method = RequestMethod.POST)
    public ResultDO uploadWar(@RequestParam("warContent") CommonsMultipartFile file,
                              @RequestParam("merchantId") String merchantId,
                              @RequestParam("channelNo") String channelNo,
                              @RequestParam("environment") String environment,
                              @RequestParam("warVersion") String warVersion,
                              @RequestParam("uploadId") String uploadId,
                              @RequestParam("warName") String warName,
                              @PathVariable("version") String version){
        ResultDO result = new ResultDO();
        UploadWarDTO uploadWarDTO = new UploadWarDTO();
        uploadWarDTO.setMerchantId(Long.parseLong(merchantId));
        uploadWarDTO.setChannelNo(channelNo);
        uploadWarDTO.setEnvironment(Integer.parseInt(environment));
        uploadWarDTO.setUploadId(Long.parseLong(uploadId));
        uploadWarDTO.setWarName(warName);
        uploadWarDTO.setWarVersion(warVersion);
        try {
            uploadWarDTO.setWarContent(file.getInputStream());
        } catch (IOException e) {
            result.setErrCode(-1);
            result.setErrMsg(e.getMessage());
            return result;
        }
        result = videoAO.uploadWar(uploadWarDTO,file.getOriginalFilename());
        return result;
    }

    /**
     * 资源文件上传
     * @param version
     * @return
     */
    @ApiOperation(value = "资源文件上传", notes = "根据商户id或商户号")
    @RequestMapping(value = "/uploadFile/{version}", method = RequestMethod.POST)
    public ResultDO<JSONObject> uploadFile(@RequestParam("file") CommonsMultipartFile file,
                                           @RequestParam("merchantId") String merchantId,
                                           @RequestParam("channelNo") String channelNo,
                                           @RequestParam("type") String type,
                                           @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO<JSONObject> result = new ResultDO<JSONObject>();
        UploadFileDTO uploadFileDTO = new UploadFileDTO();
        uploadFileDTO.setMerchantId(Long.parseLong(merchantId));
        uploadFileDTO.setChannelNo(channelNo);

        try {
            uploadFileDTO.setFile(file.getInputStream());
        } catch (IOException e) {
            result.setErrCode(-1);
            result.setErrMsg(e.getMessage());
            return result;
        }
        uploadFileDTO.setType(Integer.parseInt(type));
        result = videoAO.uploadFile(uploadFileDTO,file.getOriginalFilename());
        return result;
    }

    /**
     * 资源文件上传
     * @param version
     * @return
     */
    @ApiOperation(value = "资源文件上传", notes = "根据商户id或商户号")
    @RequestMapping(value = "/uploadFileTogd/{version}", method = RequestMethod.POST)
    public ResultDO<String> uploadFileTogd(@RequestParam("file") CommonsMultipartFile file,
                                       @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version){
        ResultDO<String> result = new ResultDO<String>();
        UploadFileDTO uploadFileDTO = new UploadFileDTO();
        try {
            uploadFileDTO.setFile(file.getInputStream());
        } catch (IOException e) {
            result.setErrCode(-1);
            result.setErrMsg(e.getMessage());
            return result;
        }
        result = videoAO.uploadFileToGD(uploadFileDTO,file.getOriginalFilename());
        return result;
    }
}
