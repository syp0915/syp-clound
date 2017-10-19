package com.shfc.cloud.monitor.constant;

/**
 * @Package com.shfc.cloud.monitor.constant.MonitorIttemKeyConstant
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/23 15:07
 * version V1.0.0
 */
public class MonitorItemKeyConstant {

	/**
	 * cpu 监控项 key
	 */
	public static final String CPU_ITEM_KEY = "system.cpu.load[percpu,avg1]";

//	/**
//	 * DB 监控项 key
//	 */
//	public static final String DB_ITEM_KEY = "system.cpu.util[,idle]";

	/**
	 * 磁盘空间 监控项 key
	 */
	public static final String DISK_ITEM_KEY = "vfs.fs.size[/,used]";

	/**
	 * tomcat 进程监控
	 */
	public static final String TOMCAT_ITEM_KEY = "proc.num[,,,tomcat]";
}
