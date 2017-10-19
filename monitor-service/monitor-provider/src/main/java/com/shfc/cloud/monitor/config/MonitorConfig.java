package com.shfc.cloud.monitor.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


/**
 * @Package com.shfc.cloud.monitor.config.MonitorConfig
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/22 20:53
 * version V1.0.0
 */
@Service
public class MonitorConfig {

	@Value("${monitor.zabbix.admin}")
	private String zabbixUser;

	@Value("${monitor.zabbix.pwd}")
	private String zabbixPassword;

	@Value("${monitor.zabbix.url}")
	private String zabbixUrl;

	@Value("${monitor.dbshell.path}")
	private String dbShellPath;

	@Value("${monitor.dbfile.path}")
	private String dbfilePath;

	public String getZabbixUser() {
		return zabbixUser;
	}

	public void setZabbixUser(String zabbixUser) {
		this.zabbixUser = zabbixUser;
	}

	public String getZabbixPassword() {
		return zabbixPassword;
	}

	public void setZabbixPassword(String zabbixPassword) {
		this.zabbixPassword = zabbixPassword;
	}

	public String getZabbixUrl() {
		return zabbixUrl;
	}

	public void setZabbixUrl(String zabbixUrl) {
		this.zabbixUrl = zabbixUrl;
	}

	public String getDbShellPath() {
		return dbShellPath;
	}

	public void setDbShellPath(String dbShellPath) {
		this.dbShellPath = dbShellPath;
	}

	public String getDbfilePath() {
		return dbfilePath;
	}

	public void setDbfilePath(String dbfilePath) {
		this.dbfilePath = dbfilePath;
	}
}
