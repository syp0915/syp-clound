package com.shfc.cloud.monitor.zabbix;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package com.shfc.zabbix.ZabbixRequestParams
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/9 17:57
 * version V1.0.0
 */
public class ZabbixRequestParams extends ZabbixRequest {
	private Map<String, Object> params = new HashMap<String, Object>();

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}


	public void putParam(String key, Object value) {
		params.put(key, value);
	}

	public Object removeParam(String key) {
		return params.remove(key);
	}
}
