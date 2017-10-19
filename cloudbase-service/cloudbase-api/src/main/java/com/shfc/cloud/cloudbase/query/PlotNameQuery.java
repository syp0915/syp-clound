package com.shfc.cloud.cloudbase.query;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-27 15:02
 **/
public class PlotNameQuery implements Serializable {

    private static final long serialVersionUID = -3095722640130901148L;

    private String keyword;

    private String districtId;

    private String blockId;

    private Integer num;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
