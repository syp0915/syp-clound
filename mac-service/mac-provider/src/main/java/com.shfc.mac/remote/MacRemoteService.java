package com.shfc.mac.remote;

import com.alibaba.fastjson.JSONObject;
import com.shfc.mac.Utils.InvokeBase;
import com.shfc.mac.utils.MD5Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Package com.shfc.mac.remote.MacRemoteService
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/14 17:46
 * version V1.0.0
 */
@Service
public class MacRemoteService {
    private final static Logger logger = Logger.getLogger(MacRemoteService.class);

    private final String MAC_LIST_URL = "/mac/list/";

    private final String MAC_DETAIL_URL = "/mac/detail/";

    @Value("${MAC_APPID}")
    private String appId;
    @Value("${MAC_REMOTE_SIGNTYPE}")
    private String signType;
    @Value("${MAC_APPSECRET}")
    private String appSecret;
    @Value("${MAC_HOST_URL}")
    private String macHostUrl;
    @Value("${MAC_VERSION}")
    private String version;

    private Map<String, String>  generateParamMap(String params) {
        Map<String, String> paramMap = new HashMap<String, String>();
        String sourceStr = "appId=" + appId + "&version=" + version
                + "&signType=" + signType + "&params=" + params + "&appSecret="
                + appSecret;
        String signCode = MD5Util.getMd5Code(sourceStr, "utf-8");
        paramMap.put("appId", appId);
        paramMap.put("version", version);
        paramMap.put("signType", signType);
        paramMap.put("signCode", signCode);
        paramMap.put("params", params);
        return paramMap;
    }
    /**
     * 根据行政区获取机顶盒列表
     * @param paramMap
     * @return
     */
    public String macList(Map<String, String> paramMap)  {
        String params = JSONObject.toJSONString(paramMap);
        Map<String,String> map = generateParamMap(params);
        String url = String.format(macHostUrl+MAC_LIST_URL);
        logger.info("url="+url);
        try {
            return InvokeBase.post(url, map);
        } catch (IOException e) {
            logger.error(e);
            return null;
        }
    }

    /**
     * 根据 mac 地址获取机顶盒信息
     * @param paramMap
     * @return
     */
    public String macDetail(Map<String, String> paramMap){
        String params = JSONObject.toJSONString(paramMap);
        Map<String,String> map = generateParamMap(params);
        String url = String.format(macHostUrl+MAC_DETAIL_URL);
        logger.info("url="+url);
        try {
            return InvokeBase.post(url, map);
        } catch (IOException e) {
            logger.error(e);
            return null;
        }
    }

}
