package com.shfc.mac.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.mac.dto.MacInfoDTO
 * @Description: MacData类用于接收接口解析的数据
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/28 16:15
 * version V1.0.0
 */
public class MacInfoDTO implements Serializable{
    //private Long id;//主键ID

    private String mac;//机顶盒mac地址

    private Long residenceId;//小区地址id

    private String residenceName;//小区名称

    private Long buildingId;//楼栋 ID

    private String buildingNo;//楼栋号

    private String lon;//经度

    private String lat;//纬度

    private Long districtId;//区县 ID

    private String district;//区县名称

    private Long blockId;//板块ID

    private String block;//板块名称

    private String serialNo;//机顶盒编号

    private String resCode;//机顶盒型号

    private String resName;//机顶盒名称 (SVA 超高清智能型机顶盒 )

    private String resCategory;//机顶盒类别(智能 2000 )


    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Long getResidenceId() {
        return residenceId;
    }

    public void setResidenceId(Long residenceId) {
        this.residenceId = residenceId;
    }

    public String getResidenceName() {
        return residenceName;
    }

    public void setResidenceName(String residenceName) {
        this.residenceName = residenceName;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResCategory() {
        return resCategory;
    }

    public void setResCategory(String resCategory) {
        this.resCategory = resCategory;
    }

    @Override
    public String toString() {
        return "MacInfoDTO{" +
                "mac='" + mac + '\'' +
                ", residenceId=" + residenceId +
                ", residenceName='" + residenceName + '\'' +
                ", buildingId=" + buildingId +
                ", buildingNo='" + buildingNo + '\'' +
                ", lon='" + lon + '\'' +
                ", lat='" + lat + '\'' +
                ", districtId=" + districtId +
                ", district='" + district + '\'' +
                ", blockId=" + blockId +
                ", block='" + block + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", resCode='" + resCode + '\'' +
                ", resName='" + resName + '\'' +
                ", resCategory='" + resCategory + '\'' +
                '}';
    }
}
