package com.shfc.mac.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.shfc.mac.dto.MacListRemoteDTO
 * @Description: 调用mac列表接口返回的json解析类
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/28 18:14
 * version V1.0.0
 */
public class MacListRemoteDTO implements Serializable {
    private Integer realPageSize;//分页参数，页面实际大小
    private Integer pageNo;//分页参数，当前页码
    private Integer pageSize;//分页参数，页面分页大小
    private Integer totalPageCount;//分页参数，总页码
    private Integer totalCount;//分页参数，总数量
    private Boolean isFirstPage;//分页参数，是否第一页
    private Boolean isLastPage;//分页参数，是否最后页
    private List<MacInfoDTO> result = new ArrayList<>();
    private String resMessage;
    private String resStatus;

    public Integer getRealPageSize() {
        return realPageSize;
    }

    public void setRealPageSize(Integer realPageSize) {
        this.realPageSize = realPageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(Integer totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public Boolean getFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(Boolean firstPage) {
        isFirstPage = firstPage;
    }

    public Boolean getLastPage() {
        return isLastPage;
    }

    public void setLastPage(Boolean lastPage) {
        isLastPage = lastPage;
    }

    public List<MacInfoDTO> getResult() {
        return result;
    }

    public void setResult(List<MacInfoDTO> result) {
        this.result = result;
    }

    public String getResMessage() {
        return resMessage;
    }

    public void setResMessage(String resMessage) {
        this.resMessage = resMessage;
    }

    public String getResStatus() {
        return resStatus;
    }

    public void setResStatus(String resStatus) {
        this.resStatus = resStatus;
    }
}
