package com.shfc.authentication.sdk.service;

import com.shfc.authentication.sdk.api.DefaultApi;
import com.shfc.authentication.sdk.wxlink.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 调用京东万象api
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-10 09:30
 **/
@Service
public class WxService {
    @Autowired
    private DefaultApi defaultApi;

    /**
     * 校验姓名，身份证是否一致
     * 校验姓名，身份证是否一致
     * @param merchantId 商户Id，不可为空 (required)
     * @param params 参数集合 (required)
     * @param appkey 万象平台提供的appkey (required)
     * @return ApiResponse&lt;String&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public String authenticate(Long merchantId,String channelNo, HashMap<String,String> params, String appkey) throws ApiException {
        return defaultApi.certVerify("",params.get("name"),params.get("idcard"),appkey);
    }

}
