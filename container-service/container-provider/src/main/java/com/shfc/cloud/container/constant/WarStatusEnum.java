package com.shfc.cloud.container.constant;

/**
 * @Package com.shfc.cloud.container.constant.WAR_STATUS_ENUM
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/5/16 11:27
 * version V1.0.0
 */
public enum WarStatusEnum {
	NOT_DEPLOYED(0, "未部署"),
	USEING(1, "使用中"),
	DEPLOY_ERROR(2, "部署失败"),
	CLOSED(3, "已停用");

	private final int value;
	private final String name;

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	WarStatusEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public static String getNameByValue(Integer val) {
		if (val != null) {
			int value = val;
			for (WarStatusEnum constant : WarStatusEnum.values()) {
				if (constant.value == value) {
					return constant.name;
				}
			}
		}
		return "";
	}

	public WarStatusEnum getNameByValue(int value) {
		for (WarStatusEnum constant : WarStatusEnum.values()) {
			if (constant.value == value) {
				return constant;
			}
		}
		return null;
	}
}
