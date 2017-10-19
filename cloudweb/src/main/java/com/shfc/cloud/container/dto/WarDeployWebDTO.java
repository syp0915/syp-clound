package com.shfc.cloud.container.dto;

import com.shfc.cloud.monitor.dto.BaseWebDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Package com.shfc.cloud.dto.ContainerManageDTO
 * @Description: war包部署dto
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/21 15:56
 * version V1.0.0
 */
@ApiModel(value = "WarDeployWebDTO")
public class WarDeployWebDTO extends BaseWebDTO {

	@ApiModelProperty(value = "war包ID",required = true)
	private String warId;

	public String getWarId() {
		return warId;
	}

	public void setWarId(String warId) {
		this.warId = warId;
	}
}
