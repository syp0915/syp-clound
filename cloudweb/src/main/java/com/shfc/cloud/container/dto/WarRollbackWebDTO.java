package com.shfc.cloud.container.dto;

import com.shfc.cloud.monitor.dto.BaseWebDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Package WarRollbackDTO
 * @Description: war包回滚dto
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/21 16:01
 * version V1.0.0
 */
@ApiModel(value = "WarRollbackWebDTO")
public class WarRollbackWebDTO extends BaseWebDTO {

	/**
	 * 回滚war包名称
	 */
	@ApiModelProperty(value = "回滚war包名",required = true)
	private String rollWarName;

	/**
	 * 回滚war包版本号
	 */
	@ApiModelProperty(value = "回滚war包版本号",required = true)
	private String rollWarVersion;

	public String getRollWarName() {
		return rollWarName;
	}

	public void setRollWarName(String rollWarName) {
		this.rollWarName = rollWarName;
	}

	public String getRollWarVersion() {
		return rollWarVersion;
	}

	public void setRollWarVersion(String rollWarVersion) {
		this.rollWarVersion = rollWarVersion;
	}
}
