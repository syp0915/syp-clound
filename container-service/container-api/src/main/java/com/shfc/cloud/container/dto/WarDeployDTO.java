package com.shfc.cloud.container.dto;

/**
 * @Package com.shfc.cloud.dto.ContainerManageDTO
 * @Description: war包部署dto
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/21 15:56
 * version V1.0.0
 */
public class WarDeployDTO extends ContainerBaseDTO{

	private String warId;

	public String getWarId() {
		return warId;
	}

	public void setWarId(String warId) {
		this.warId = warId;
	}
}
