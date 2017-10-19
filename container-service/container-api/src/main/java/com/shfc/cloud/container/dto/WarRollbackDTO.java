package com.shfc.cloud.container.dto;

/**
 * @Package WarRollbackDTO
 * @Description: war包回滚dto
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/21 16:01
 * version V1.0.0
 */
public class WarRollbackDTO extends ContainerBaseDTO{

	/**
	 * 回滚war包名称
	 */
	private String rollWarName;

	/**
	 * 回滚war包版本号
	 */
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
