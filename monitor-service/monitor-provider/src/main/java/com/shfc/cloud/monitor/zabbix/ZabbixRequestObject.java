package com.shfc.cloud.monitor.zabbix;

/**
 * @Package com.shfc.zabbix.ZabbixRequestObject
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/9 17:57
 * version V1.0.0
 */
public class ZabbixRequestObject extends ZabbixRequest {
	private Object params;

	public Object getParams() {
		return params;
	}

	public void setParams(Object params) {
		this.params = params;
	}
}
