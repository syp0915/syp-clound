package com.shfc.authentication.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-05-24 16:41
 **/
public class IdentityDTO implements Serializable {
    /*
        认证类型  0000
     */
    private String authType;
    /*
        第三方交易流水
     */
    private String thirdPartTrans;
    /*
        数据源
     */
    private String source;
    /*
        姓名
     */
    private String name;
    /*
        身份证号
     */
    private String identityNo;


    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getThirdPartTrans() {
        return thirdPartTrans;
    }

    public void setThirdPartTrans(String thirdPartTrans) {
        this.thirdPartTrans = thirdPartTrans;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }
}