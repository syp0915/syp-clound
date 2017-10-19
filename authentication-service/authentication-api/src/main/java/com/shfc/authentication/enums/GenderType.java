/**
 * @Title: AuditStatus.java
 * @Package com.fc.house.enums
 * @Description: 审核状态
 * Copyright: Copyright (c) 2016 
 * Company:上海房产
 * 
 * @author lvbin
 * @date 2016年9月13日 上午10:11:31
 * @version V1.0
 */
package com.shfc.authentication.enums;

import com.shfc.common.base.ValidateHelper;

public enum GenderType {

	Male("男", 0),
	Female("女", 1);

	private final String name;
	private final Integer value;

	public String getName() {
		return name;
	}

	public Integer getValue() {
		return value;
	}

	GenderType(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public static String getNameByValue(Integer val) {
		if (val != null) {
			int value = val;
			for (GenderType status : GenderType.values()) {
				if (status.value == value) {
					return status.name;
				}
			}
		}
		return "";
	}

	public static Integer getValueByName(String name) {
		if (!ValidateHelper.isEmpty(name)) {
			String value = name;
			for (GenderType status : GenderType.values()) {
				if (status.name.equals(value)) {
					return status.value;
				}
			}
		}
		return null;
	}

}
