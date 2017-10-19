package com.shfc.cloud.account.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.cloud.account.domain.Merchant.java
 * @Description: 商户表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author liaozm
 * @date 2017/03/25 15:30
 * version v1.0.0
 */
public class Merchant extends BaseBean {
    /**
     * 商户号
     */
    private String merchantNumber;

    /**
     * 公司id
     */
    private Long companyId;

    /**
     * 商户名
     */
    private String companyName;

    /**
     * 商户帐号
     */
    private String account;

    /**
     * 帐号密码
     */
    private String password;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系人电话
     */
    private String contactPhone;

    /**
     * 审核状态 0-审核中 1-审核失败 2-审核通过
     */
    private Integer reviewStatus;

    /**
     * 帐号状态 1-启用 2-停用
     */
    private Integer accountStatus;

    /**
     * 普通发票抬头
     */
    private String invoiceHeader;

    /**
     * 获取商户号
     *
     * @return merchant_number
     */
    public String getMerchantNumber() {
        return merchantNumber;
    }

    /**
     * 设置商户号
     *
     * @param merchantNumber
     */
    public void setMerchantNumber(String merchantNumber) {
        this.merchantNumber = merchantNumber == null ? null : merchantNumber.trim();
    }

    /**
     * 获取公司id
     *
     * @return company_id
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司id
     *
     * @param companyId
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取商户名
     *
     * @return company_name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置商户名
     *
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 获取商户帐号
     *
     * @return account
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置商户帐号
     *
     * @param account
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 获取帐号密码
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置帐号密码
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取联系人姓名
     *
     * @return contact_name
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * 设置联系人姓名
     *
     * @param contactName
     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     * 获取联系人电话
     *
     * @return contact_phone
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * 设置联系人电话
     *
     * @param contactPhone
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    /**
     * 获取审核状态 0-审核中 1-审核失败 2-审核通过
     *
     * @return review_status
     */
    public Integer getReviewStatus() {
        return reviewStatus;
    }

    /**
     * 设置审核状态 0-审核中 1-审核失败 2-审核通过
     *
     * @param reviewStatus
     */
    public void setReviewStatus(Integer reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    /**
     * 获取帐号状态 1-启用 2-停用
     *
     * @return account_status
     */
    public Integer getAccountStatus() {
        return accountStatus;
    }

    /**
     * 设置帐号状态 1-启用 2-停用
     *
     * @param accountStatus
     */
    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    /**
     * 获取普通发票抬头
     *
     * @return invoice_header
     */
    public String getInvoiceHeader() {
        return invoiceHeader;
    }

    /**
     * 设置普通发票抬头
     *
     * @param invoiceHeader
     */
    public void setInvoiceHeader(String invoiceHeader) {
        this.invoiceHeader = invoiceHeader == null ? null : invoiceHeader.trim();
    }
}