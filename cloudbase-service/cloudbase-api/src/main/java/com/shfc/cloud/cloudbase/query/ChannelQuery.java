package com.shfc.cloud.cloudbase.query;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 频道号名称联想
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-25 13:52
 **/
public class ChannelQuery implements Serializable {
    private static final long serialVersionUID = 6276116331068329153L;

    private String keyword;
    private Integer num;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
