package com.shfc.cloud.account.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.cloud.account.domain.MerchantApikey.java
 * @Description: 商户apikey
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author liaozm
 * @date 2017/03/25 15:30
 * version v1.0.0
 */
public class MerchantApikey extends BaseBean {
    /**
     * 商户id
     */
    private Long merchantId;

    /**
     * apikey
     */
    private String apiKey;

    /**
     * encrypKey
     */
    private String encrypKey;

    /**
     * 0:未生效 1:已生效
     */
    private Boolean status;

    /**
     * 获取商户id
     *
     * @return merchant_id
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * 设置商户id
     *
     * @param merchantId
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * 获取apikey
     *
     * @return apikey
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * 设置apikey
     *
     * @param apiKey
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey == null ? null : apiKey.trim();
    }

    /**
     * 获取0:未生效 1:已生效
     *
     * @return status
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置0:未生效 1:已生效
     *
     * @param status
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getEncrypKey() {
        return encrypKey;
    }

    public void setEncrypKey(String encrypKey) {
        this.encrypKey = encrypKey;
    }
}