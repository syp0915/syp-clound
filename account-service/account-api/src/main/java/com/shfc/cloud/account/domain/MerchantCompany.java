package com.shfc.cloud.account.domain;

import com.shfc.common.httpbean.BaseBean;
import java.util.Date;

/**
 * @Package: com.shfc.cloud.account.domain.MerchantCompany.java
 * @Description: 公司表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author liaozm
 * @date 2017/03/25 15:30
 * version v1.0.0
 */
public class MerchantCompany extends BaseBean {
    /**
     * 公司名
     */
    private String name;

    /**
     * 联系人姓名
     */
    private String contacter;

    /**
     * 联系人电话
     */
    private String phone;

    /**
     * 营业执照编号
     */
    private String licenceCode;

    /**
     * 营业执照图片
     */
    private String licenceImgUrl;

    /**
     * 实名审核状态 0-审核中 1-未通过 2-通过 3-未认证
     */
    private Boolean auditStatus;

    /**
     * 审核失败原因
     */
    private String auditFailReason;

    /**
     * 注册时间
     */
    private Date registrationTime;

    /**
     * 获取公司名
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置公司名
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取联系人姓名
     *
     * @return contacter
     */
    public String getContacter() {
        return contacter;
    }

    /**
     * 设置联系人姓名
     *
     * @param contacter
     */
    public void setContacter(String contacter) {
        this.contacter = contacter == null ? null : contacter.trim();
    }

    /**
     * 获取联系人电话
     *
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系人电话
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取营业执照编号
     *
     * @return licence_code
     */
    public String getLicenceCode() {
        return licenceCode;
    }

    /**
     * 设置营业执照编号
     *
     * @param licenceCode
     */
    public void setLicenceCode(String licenceCode) {
        this.licenceCode = licenceCode == null ? null : licenceCode.trim();
    }

    /**
     * 获取营业执照图片
     *
     * @return licence_img_url
     */
    public String getLicenceImgUrl() {
        return licenceImgUrl;
    }

    /**
     * 设置营业执照图片
     *
     * @param licenceImgUrl
     */
    public void setLicenceImgUrl(String licenceImgUrl) {
        this.licenceImgUrl = licenceImgUrl == null ? null : licenceImgUrl.trim();
    }

    /**
     * 获取实名审核状态 0-审核中 1-未通过 2-通过 3-未认证
     *
     * @return audit_status
     */
    public Boolean getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置实名审核状态 0-审核中 1-未通过 2-通过 3-未认证
     *
     * @param auditStatus
     */
    public void setAuditStatus(Boolean auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * 获取审核失败原因
     *
     * @return audit_fail_reason
     */
    public String getAuditFailReason() {
        return auditFailReason;
    }

    /**
     * 设置审核失败原因
     *
     * @param auditFailReason
     */
    public void setAuditFailReason(String auditFailReason) {
        this.auditFailReason = auditFailReason == null ? null : auditFailReason.trim();
    }

    /**
     * 获取注册时间
     *
     * @return registration_time
     */
    public Date getRegistrationTime() {
        return registrationTime;
    }

    /**
     * 设置注册时间
     *
     * @param registrationTime
     */
    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }
}