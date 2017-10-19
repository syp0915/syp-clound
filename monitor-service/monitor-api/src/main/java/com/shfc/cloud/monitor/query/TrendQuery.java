package com.shfc.cloud.monitor.query;/**
 * Created by SYP on 2017/3/30.
 */

import java.io.Serializable;
import java.util.Date;

/**
 * @author sunyaping
 * @Package com.shfc.cloud.monitor.query
 * @Description:走势统计入参
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-03-30 14:47
 * version V1.0.0
 **/
public class TrendQuery extends SummaryQuery implements Serializable {


    /**
    * 对比起始时间
     */
    private Long contrastiveStartTime;


    /**
     * 时间刻度
     */
    private Long scale;

    /**
     * 区县Id
     */
    private Integer residenceId;

    public Long getContrastiveStartTime() {
        return contrastiveStartTime;
    }

    public void setContrastiveStartTime(Long contrastiveStartTime) {
        this.contrastiveStartTime = contrastiveStartTime;
    }

    public Long getScale() {
            return scale;
        }

    public void setScale(Long scale) {
            this.scale = scale;
        }

    public Integer getResidenceId() {
        return residenceId;
    }

    public void setResidenceId(Integer residenceId) {
        this.residenceId = residenceId;
    }
}
