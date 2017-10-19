package com.shfc.mac.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.mac.domain.MacInfo.java
 * @Description: 机顶盒mac信息表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author xiehb
 * @date 2017/04/26 14:56
 * version v1.0.0
 */
public class MacInfo extends BaseBean {
    /**
     * 机顶盒mac地址
     */
    private String mac;

    /**
     * 小区地址id
     */
    private Long residenceId;

    /**
     * 小区名称
     */
    private String residenceName;

    /**
     * 楼栋 ID
     */
    private Long buildingId;

    /**
     * 楼栋号
     */
    private String buildingNo;

    /**
     * 经度
     */
    private String lon;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 区县 ID
     */
    private Long districtId;

    /**
     * 区县名称
     */
    private String district;

    /**
     * 板块ID
     */
    private Long blockId;

    /**
     * 板块名称
     */
    private String block;

    /**
     * 机顶盒编号
     */
    private String serialNo;

    /**
     * 机顶盒型号
     */
    private String resCode;

    /**
     * 机顶盒名称 (SVA 超高清智能型机顶盒 )
     */
    private String resName;

    /**
     * 机顶盒类别(智能 2000 )
     */
    private String resCategory;

    /**
     * 获取机顶盒mac地址
     *
     * @return mac
     */
    public String getMac() {
        return mac;
    }

    /**
     * 设置机顶盒mac地址
     *
     * @param mac
     */
    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    /**
     * 获取小区地址id
     *
     * @return residence_id
     */
    public Long getResidenceId() {
        return residenceId;
    }

    /**
     * 设置小区地址id
     *
     * @param residenceId
     */
    public void setResidenceId(Long residenceId) {
        this.residenceId = residenceId;
    }

    /**
     * 获取小区名称
     *
     * @return residence_name
     */
    public String getResidenceName() {
        return residenceName;
    }

    /**
     * 设置小区名称
     *
     * @param residenceName
     */
    public void setResidenceName(String residenceName) {
        this.residenceName = residenceName == null ? null : residenceName.trim();
    }

    /**
     * 获取楼栋 ID
     *
     * @return building_id
     */
    public Long getBuildingId() {
        return buildingId;
    }

    /**
     * 设置楼栋 ID
     *
     * @param buildingId
     */
    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    /**
     * 获取楼栋号
     *
     * @return building_no
     */
    public String getBuildingNo() {
        return buildingNo;
    }

    /**
     * 设置楼栋号
     *
     * @param buildingNo
     */
    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo == null ? null : buildingNo.trim();
    }

    /**
     * 获取经度
     *
     * @return lon
     */
    public String getLon() {
        return lon;
    }

    /**
     * 设置经度
     *
     * @param lon
     */
    public void setLon(String lon) {
        this.lon = lon == null ? null : lon.trim();
    }

    /**
     * 获取纬度
     *
     * @return lat
     */
    public String getLat() {
        return lat;
    }

    /**
     * 设置纬度
     *
     * @param lat
     */
    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    /**
     * 获取区县 ID
     *
     * @return district_id
     */
    public Long getDistrictId() {
        return districtId;
    }

    /**
     * 设置区县 ID
     *
     * @param districtId
     */
    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    /**
     * 获取区县名称
     *
     * @return district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * 设置区县名称
     *
     * @param district
     */
    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    /**
     * 获取板块ID
     *
     * @return block_id
     */
    public Long getBlockId() {
        return blockId;
    }

    /**
     * 设置板块ID
     *
     * @param blockId
     */
    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    /**
     * 获取板块名称
     *
     * @return block
     */
    public String getBlock() {
        return block;
    }

    /**
     * 设置板块名称
     *
     * @param block
     */
    public void setBlock(String block) {
        this.block = block == null ? null : block.trim();
    }

    /**
     * 获取机顶盒编号
     *
     * @return serial_no
     */
    public String getSerialNo() {
        return serialNo;
    }

    /**
     * 设置机顶盒编号
     *
     * @param serialNo
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    /**
     * 获取机顶盒型号
     *
     * @return res_code
     */
    public String getResCode() {
        return resCode;
    }

    /**
     * 设置机顶盒型号
     *
     * @param resCode
     */
    public void setResCode(String resCode) {
        this.resCode = resCode == null ? null : resCode.trim();
    }

    /**
     * 获取机顶盒名称 (SVA 超高清智能型机顶盒 )
     *
     * @return res_name
     */
    public String getResName() {
        return resName;
    }

    /**
     * 设置机顶盒名称 (SVA 超高清智能型机顶盒 )
     *
     * @param resName
     */
    public void setResName(String resName) {
        this.resName = resName == null ? null : resName.trim();
    }

    /**
     * 获取机顶盒类别(智能 2000 )
     *
     * @return res_category
     */
    public String getResCategory() {
        return resCategory;
    }

    /**
     * 设置机顶盒类别(智能 2000 )
     *
     * @param resCategory
     */
    public void setResCategory(String resCategory) {
        this.resCategory = resCategory == null ? null : resCategory.trim();
    }

    /**
     * @Title toString
     * @Author xiehb
     * @Date 2017/04/26 14:56
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mac=").append(mac);
        sb.append(", residenceId=").append(residenceId);
        sb.append(", residenceName=").append(residenceName);
        sb.append(", buildingId=").append(buildingId);
        sb.append(", buildingNo=").append(buildingNo);
        sb.append(", lon=").append(lon);
        sb.append(", lat=").append(lat);
        sb.append(", districtId=").append(districtId);
        sb.append(", district=").append(district);
        sb.append(", blockId=").append(blockId);
        sb.append(", block=").append(block);
        sb.append(", serialNo=").append(serialNo);
        sb.append(", resCode=").append(resCode);
        sb.append(", resName=").append(resName);
        sb.append(", resCategory=").append(resCategory);
        sb.append("]");
        return sb.toString();
    }
}