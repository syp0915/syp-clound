package com.shfc.cloud.cloudbase.domain;

import com.shfc.common.httpbean.BaseBean;

import java.util.Date;

public class Plot extends BaseBean {
    private Long id;//主键

    private Long residenceId;//估价宝小区id

    private Long cityId;//小区所在城市

    private Long blockId;//板块id

    private Long districtId;//区域id

    private String plotName;//小区名称

    private String plotAlias;//小区别名

    private String plotPinyin;//小区名称全拼

    private String plotPinyinAbbr;//小区名称拼音缩写

    private String plotAddress;//小区地址

    private String plotPostcode;//小区邮编

    private String longtitude;//小区X坐标

    private String latitude;//小区Y坐标

    private Long creator;//数据创建人id

    private Date createTime;//数据创建时间

    private Long modifier;//数据修改人id

    private Date modifyTime;//数据修改时间

    private Long version;//数据版本，用于乐观锁

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResidenceId() {
        return residenceId;
    }

    public void setResidenceId(Long residenceId) {
        this.residenceId = residenceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName == null ? null : plotName.trim();
    }

    public String getPlotAlias() {
        return plotAlias;
    }

    public void setPlotAlias(String plotAlias) {
        this.plotAlias = plotAlias == null ? null : plotAlias.trim();
    }

    public String getPlotPinyin() {
        return plotPinyin;
    }

    public void setPlotPinyin(String plotPinyin) {
        this.plotPinyin = plotPinyin == null ? null : plotPinyin.trim();
    }

    public String getPlotPinyinAbbr() {
        return plotPinyinAbbr;
    }

    public void setPlotPinyinAbbr(String plotPinyinAbbr) {
        this.plotPinyinAbbr = plotPinyinAbbr == null ? null : plotPinyinAbbr.trim();
    }

    public String getPlotAddress() {
        return plotAddress;
    }

    public void setPlotAddress(String plotAddress) {
        this.plotAddress = plotAddress == null ? null : plotAddress.trim();
    }

    public String getPlotPostcode() {
        return plotPostcode;
    }

    public void setPlotPostcode(String plotPostcode) {
        this.plotPostcode = plotPostcode == null ? null : plotPostcode.trim();
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude == null ? null : longtitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}