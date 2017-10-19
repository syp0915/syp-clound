package com.shfc.cloud.monitor.dto;

import java.io.Serializable;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author wuky
 * @version V1.0
 * @date 2017/3/27 上午11:06.
 */
public class BaseDTO implements Serializable {

    private static final long serialVersionUID = -1369234221194357904L;
    private Integer pageSize;//页面分页大小

    private Integer pageNumber;//当前页码

    private Long totalPageCount;//总页数

    private Long totalCount;//查询结果总数

    private Integer realPageSize;//实际分页大小

    private boolean isFirstPage;//是否第一页

    private boolean isLastPage;//是否最后一页

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Long getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(Long totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public Integer getRealPageSize() {
        return realPageSize;
    }

    public void setRealPageSize(Integer realPageSize) {
        this.realPageSize = realPageSize;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
