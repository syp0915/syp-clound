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
public enum NotifyType {

	Notify("需要通知,默认", 0),
	NotPass("仅审核不通过时通知", 1),
	Pass("仅审核通过时通知", 2),
	NotNotify("不需要通知", 3);

	private final String name;
	private final Integer value;

	public String getName() {
		return name;
	}

	public Integer getValue() {
		return value;
	}

	NotifyType(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public static String getNameByValue(Integer val) {
		if (val != null) {
			int value = val;
			for (NotifyType status : NotifyType.values()) {
				if (status.value == value) {
					return status.name;
				}
			}
		}
		return "";
	}

	public NotifyType getTypeByValue(Integer value) {
		for (NotifyType status : NotifyType.values()) {
			if (status.value == value) {
				return status;
			}
		}
		return null;
	}

}
