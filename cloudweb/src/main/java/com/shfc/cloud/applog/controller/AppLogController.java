package com.shfc.cloud.applog.controller;

import com.shfc.cloud.applog.ao.AppLogAO;
import com.shfc.cloud.applog.dto.AppLog;
import com.shfc.cloud.applog.dto.AppLogDTO;
import com.shfc.cloud.exception.CloudWebException;
import com.shfc.cloud.utils.JSONParseUtils;
import com.shfc.common.result.ResultDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @Package com.shfc.cloud.applog.controller.AppLogController
 * @Description: App Log 应用日志
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/16 10:42
 * version V1.0.0
 */
@Api(tags = "AppLogController", description = "应用日志")
@RestController
@RequestMapping(value = "/cloud/appLog", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AppLogController {
    @Autowired
    private AppLogAO appLogAO;

    private final String v = "v1.0.0";

//    @ApiOperation(value = "获取目录", notes = "根据路径获取目录")
//    @RequestMapping(value = "/dir/" + version, method = RequestMethod.POST)
//    public ResultDO<List<AppLog>> dir(
//            @ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody AppLogDTO reqJson)
//            throws CloudWebException {
//
////        return appLogAO.dirList(JSONParseUtils.parseJavaObject(reqJson, AppLogDTO.class));
//        return appLogAO.dirList(reqJson);
//    }

    @ApiOperation(value = "获取目录", notes = "根据路径获取目录")
    @RequestMapping(value = "/dir/{version:.+}", method = RequestMethod.POST)
    public ResultDO<List<AppLog>> dir(
            @ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody AppLogDTO reqJson,
            @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version)
            throws CloudWebException {

        return appLogAO.dirList(reqJson);
    }

    @ApiOperation(value = "下载文件", notes = "根据文件路径下载文件")
    @RequestMapping(value = "/download/{version}", method = RequestMethod.POST)
    public void download(HttpServletResponse response,
                         @ApiParam(name="reqJson",value="目录请求参数", required=true)@RequestBody AppLogDTO reqJson,
                         @ApiParam(name="version",value="版本号", required=true, defaultValue ="v1.0.0" )@PathVariable("version") String version)
            throws IOException, CloudWebException {

        ResultDO<InputStream> resultDO = appLogAO.downloadFile(reqJson);
        // 下载失败
        if(!resultDO.isSuccess()){
            throw new CloudWebException(resultDO.getErrCode(),
                    resultDO.getErrMsg());
        }

        String filePath = reqJson.getFilePath();
        String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);

        InputStream inputStream = resultDO.getData();
        OutputStream os = response.getOutputStream();
        byte[] b = new byte[1024];
        int length;
        while ((length = inputStream.read(b)) > 0) {
            os.write(b, 0, length);
        }
        // 这里主要关闭。
        os.close();
        inputStream.close();
    }
}
