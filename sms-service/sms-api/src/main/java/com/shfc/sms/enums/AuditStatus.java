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
package com.shfc.sms.enums;

import com.shfc.common.base.ValidateHelper;

public enum AuditStatus {

	CHECKING("CHECKING", 0),
	SUCCESS("SUCCESS", 1),
	FAIL("FAIL", 2);

	private final String name;
	private final Integer value;

	public String getName() {
		return name;
	}

	public Integer getValue() {
		return value;
	}

	AuditStatus(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public static String getNameByValue(Integer val) {
		if (val != null) {
			int value = val;
			for (AuditStatus status : AuditStatus.values()) {
				if (status.value == value) {
					return status.name;
				}
			}
		}
		return "";
	}

	public AuditStatus getTypeByValue(Integer value) {
		for (AuditStatus status : AuditStatus.values()) {
			if (status.value == value) {
				return status;
			}
		}
		return null;
	}

	public static Integer getValueByName(String name) {
		if (!ValidateHelper.isEmpty(name)) {
			String value = name;
			for (AuditStatus status : AuditStatus.values()) {
				if (status.name.equals(value)) {
					return status.value;
				}
			}
		}
		return null;
	}

}
