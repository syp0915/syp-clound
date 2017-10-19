package com.shfc.flowscreen.remote;

import com.alibaba.fastjson.JSON;
import com.shfc.common.http.ApacheHttpCilent;
import com.shfc.common.math.RandomUtils;
import com.shfc.flowscreen.utils.EncryptUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Package com.shfc.flowscreen.remote.FlowscreenRemoteService
 * @Description: FlowscreenRemoteService
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/3/27 下午4:05
 * version V1.0.0
 */
@Service
public class FlowscreenRemoteService {
    private final static Logger logger = Logger.getLogger(FlowscreenRemoteService.class);

    private final String FLOWSCREEN_URL = "/ocntvbox/piaoping/";

    private final String version = "V1.0.0";

    @Value("${FLOWSCREEN_APPID}")
    private String appId;
    @Value("${FLOWSCREEN_SIGNTYPE}")
    private String signType;
    @Value("${FLOWSCREEN_APPSECRET}")
    private String appSecret;
    @Value("${FLOWSCREEN_HOST_URL}")
    private String flowscreenHostUrl;
    @Value("${FLOWSCREEN_VERSION}")
    private String flowscreenVersion;

    private Map<String, String> generateParamMap(String macParam,String urlParam) {
        Map<String, Object> paramMap = new HashMap<>();
        String str = System.currentTimeMillis() + RandomUtils.generateNumberString(5);
        paramMap.put("requestSeq", Long.valueOf(str));
        paramMap.put("appId", appId);
        paramMap.put("version", flowscreenVersion);
        paramMap.put("tvboxId", macParam);
        paramMap.put("url", urlParam);

        String data = JSON.toJSONString(paramMap);
        String params = data.concat(appSecret);

        String md5 = EncryptUtil.encrypt(params);

        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("appId", appId);
        requestMap.put("version", flowscreenVersion);
        requestMap.put("signType", signType);
        requestMap.put("params", data);
        requestMap.put("signCode", md5);
        return requestMap;

    }

    public String flowscreenReq(String macParam,String urlParam) throws IOException {
        String url = String.format(flowscreenHostUrl+FLOWSCREEN_URL) + version;
        logger.info("url="+url);
        Map<String, String> paramMap = generateParamMap(macParam,urlParam);
        return ApacheHttpCilent.doPost(url,paramMap);
    }
}
