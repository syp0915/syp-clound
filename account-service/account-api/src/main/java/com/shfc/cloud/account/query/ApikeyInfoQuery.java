package com.shfc.cloud.account.query;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.account.query.ApikeyInfoQuery
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/24 18:00
 * version V1.0.0
 */
public class ApikeyInfoQuery implements Serializable{

    private String apikey;//apikey

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }
}
