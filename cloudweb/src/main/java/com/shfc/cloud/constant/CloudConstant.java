package com.shfc.cloud.constant;

import springfox.documentation.spring.web.json.Json;

/**
 * @Package com.shfc.cloud.constant.CloudConstant
 * @Description: CloudConstant
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/21 15:25
 * version V1.0.0
 */
public interface CloudConstant {

    /**
     * 请求apiKey-身份标识
     */
    String API_KEY = "apiKey";

    /**
     * 请求参数
     */
    String REQ_JSON= "reqJson";

    /**
     * 响应参数
     */
    String RESP_JSON= "respJson";

    /**
     * 时间戳
     */
    String TIMESTAMP= "timestamp";

    /**
     * 签名内容
     */
    String SIGNATURE= "signature";

    /**
     * 秘钥值
     */
    String ENCRYPT_KEY = "encryptKey";

    /**
     * 频道编号
     */
    String CHANNEL_NO = "channelNo";

    /**
     * 当前商户id
     */
    String CURRENT_MERCHANT_ID = "currentMerchantId";

    /**
     * 当前频道编号
     */
    String CURRENT_CHANNEL_NO = "currentChannelNo";

    /**
     * 当前频accessKey
     */
    String CURRENT_ACCESS_KEY = "currentAccessKey";
}
