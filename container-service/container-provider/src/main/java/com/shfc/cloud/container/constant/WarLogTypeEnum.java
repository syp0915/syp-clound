package com.shfc.cloud.container.constant;

/**
 * @Package com.shfc.cloud.container.constant.WarLogTypeEnum
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/5/24 11:45
 * version V1.0.0
 */
public enum WarLogTypeEnum {

	DOWNLOAD(0, "下载"),
	ROLLBACK(1, "回滚"),
	DEPLOY(2, "部署"),
	RESTART(3, "重启");

	private final int value;
	private final String name;

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	WarLogTypeEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public static String getNameByValue(Integer val) {
		if (val != null) {
			int value = val;
			for (WarLogTypeEnum constant : WarLogTypeEnum.values()) {
				if (constant.value == value) {
					return constant.name;
				}
			}
		}
		return "";
	}

	public WarLogTypeEnum getNameByValue(int value) {
		for (WarLogTypeEnum constant : WarLogTypeEnum.values()) {
			if (constant.value == value) {
				return constant;
			}
		}
		return null;
	}
}
