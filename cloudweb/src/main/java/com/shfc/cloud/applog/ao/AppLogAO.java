package com.shfc.cloud.applog.ao;

import com.shfc.cloud.applog.dto.AppLog;
import com.shfc.cloud.applog.dto.AppLogDTO;
import com.shfc.cloud.constant.ErrorConstant;
import com.shfc.cloud.utils.JsoupUtils;
import com.shfc.common.base.Logger;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * @Package com.shfc.cloud.applog.ao.AppLogAO
 * @Description: App Log 应用日志
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/16 10:42
 * version V1.0.0
 */
@Service
public class AppLogAO {

    @Value("${cloud.merchant.app.log.url}")
    private String appLogUrl;

    /**
     * 读取目录
     *
     * @param appLogDTO
     * @return
     */
    public ResultDO<List<AppLog>> dirList(AppLogDTO appLogDTO) {
        ResultDO<List<AppLog>> resultDO = new ResultDO<>();
        if (ValidateHelper.isEmpty(appLogDTO.getMerchantId()) || appLogDTO.getMerchantId() == 0l) {
            resultDO.setErrCode(ErrorConstant.NULL_MERCHANT_ID.getCode());
            resultDO.setErrMsg(ErrorConstant.NULL_MERCHANT_ID.getMsg());
            return resultDO;
        }
        String filePath = appLogDTO.getFilePath() == null ? "" : appLogDTO.getFilePath();

        if (!ValidateHelper.isEmpty(filePath)
                && filePath.contains(".")) {
            resultDO.setErrCode(ErrorConstant.ERROR_FILE_PATH.getCode());
            resultDO.setErrMsg(ErrorConstant.ERROR_FILE_PATH.getMsg());
            return resultDO;
        }
        // 拼装访问路径
        StringBuilder sb = new StringBuilder(appLogUrl);
        sb.append(appLogDTO.getMerchantId()).append("/").append(filePath);
        try {
            URL url = new URL(sb.toString());
            InputStream in = url.openStream();
        } catch (Exception e1) {
            Logger.error(AppLogAO.class, ErrorConstant.EXCEPTION_APP_LOG.getMsg(), e1);
            resultDO.setSuccess(true);
            return resultDO;
        }
        try {
            String[] dataArray = JsoupUtils.doGetRequestAppLog(sb.toString());

            resultDO.setSuccess(true);
            resultDO.setData(AppLog.convertArray(dataArray));

        } catch (IOException e) {
            Logger.error(AppLogAO.class, ErrorConstant.EXCEPTION_APP_LOG.getMsg(), e);
            resultDO.setErrCode(ErrorConstant.EXCEPTION_APP_LOG.getCode());
            resultDO.setErrMsg(ErrorConstant.EXCEPTION_APP_LOG.getMsg());
            return resultDO;
        }

        return resultDO;
    }

    /**
     * 下载文件
     * @param appLogDTO
     * @return
     */
    public ResultDO<InputStream> downloadFile(AppLogDTO appLogDTO) {

        ResultDO<InputStream> resultDO = new ResultDO<>();

        if (ValidateHelper.isEmpty(appLogDTO.getMerchantId()) || appLogDTO.getMerchantId() == 0l) {
            resultDO.setErrCode(ErrorConstant.NULL_MERCHANT_ID.getCode());
            resultDO.setErrMsg(ErrorConstant.NULL_MERCHANT_ID.getMsg());

            return resultDO;
        }
        String filePath = appLogDTO.getFilePath() == null ? "" : appLogDTO.getFilePath();
        if (ValidateHelper.isEmpty(filePath) ||
                !filePath.contains("/") || !filePath.contains(".")) {
            resultDO.setErrCode(ErrorConstant.ERROR_FILE_PATH.getCode());
            resultDO.setErrMsg(ErrorConstant.ERROR_FILE_PATH.getMsg());
            return resultDO;
        }

        // 拼装访问路径
        StringBuilder sb = new StringBuilder(appLogUrl);
        sb.append(appLogDTO.getMerchantId()).append("/").append(filePath);

        try {
            InputStream inputStream = JsoupUtils.download(sb.toString());
            resultDO.setSuccess(true);
            resultDO.setData(inputStream);
        } catch (Exception e) {
            Logger.error(AppLogAO.class, ErrorConstant.EXCEPTION_APP_LOG.getMsg(), e);
            resultDO.setErrCode(ErrorConstant.EXCEPTION_APP_LOG.getCode());
            resultDO.setErrMsg(ErrorConstant.EXCEPTION_APP_LOG.getMsg());
            return resultDO;
        }

        return resultDO;
    }
}
