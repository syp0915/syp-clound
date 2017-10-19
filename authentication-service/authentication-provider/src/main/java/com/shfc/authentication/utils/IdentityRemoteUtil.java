package com.shfc.authentication.utils;

import com.shfc.common.http.ApacheHttpCilent;
import com.shfc.log.LogFileUtils;
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
public class IdentityRemoteUtil {

    private LogFileUtils logFileUtils= LogFileUtils.getInstance("authentication-provider");

    @Value("${remote.url}")
    private String remoteUrl;


    public String createRequest(Long merchantId,String channelNo,String toUrl,HashMap<String,String> paramMap)  {
        String url = String.format(remoteUrl+toUrl);
        logFileUtils.info(url);
        try {
            return ApacheHttpCilent.doPost(url.trim(),paramMap);
        } catch (IOException e) {
            logFileUtils.error(e.getMessage());
            return null;
        }
    }
}
