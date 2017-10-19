package com.shfc.cloud.monitor.util;

import com.alibaba.fastjson.JSON;
import com.shfc.common.http.ApacheHttpCilent;
import com.shfc.log.LogFileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-27 19:31
 **/
@Service
public class DataRemoteUtil {

    private LogFileUtils logFileUtils= LogFileUtils.getInstance("monitor-provider");

    private static Logger logger = Logger.getLogger(DataRemoteUtil.class);

    @Value("${data.host.url}")
    private String dataUrl;


    public String createRequest(String toUrl,HashMap<String,String> paramMap)  {
        String url = String.format(dataUrl+toUrl);
        logFileUtils.info(url);
        try {
            logger.info("remote request url is ------>" + url);
            logger.info("remote request param is -----> " + JSON.toJSONString(paramMap));
            String result = ApacheHttpCilent.doPost(url.trim(),paramMap);
            logger.info("remote response result is -----> " + result);
            return result;
        } catch (IOException e) {
            logFileUtils.error(e.getMessage());
            return null;
        }
    }
}
