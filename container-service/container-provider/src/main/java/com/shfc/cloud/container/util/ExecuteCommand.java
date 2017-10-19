package com.shfc.cloud.container.util;

import com.shfc.common.base.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.shfc.cloud.container.util.ExecuteCommand
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/21 17:25
 * version V1.0.0
 */
public class ExecuteCommand {

	public static String executeCmd(String cmd) throws IOException, InterruptedException {
		Process process =null;
		List<String> processList = new ArrayList<String>();
		List<String> errProcessList = new ArrayList<String>();
		process = Runtime.getRuntime().exec(cmd);
		int status = process.waitFor();

		BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = "";
		while ((line = input.readLine()) != null) {
			processList.add(line);
		}
		input.close();

		StringBuffer data = new StringBuffer();
		if(processList!=null && processList.size()>0){
			for(String proc:processList){
				data.append(proc).append("\r\n");
			}
		}

		Logger.info(ExecuteCommand.class,"执行脚本返回："+data.toString()+",脚本执行状态："+status);

		StringBuffer errdata = new StringBuffer();
		if(errProcessList!=null && errProcessList.size()>0){
			for(String proc:errProcessList){
				errdata.append(proc).append("\r\n");
			}
		}

		Logger.info(ExecuteCommand.class,"执行脚本返回："+errdata.toString()+",脚本执行状态："+status);

		return data.toString();
	}

	public static int executeCmdRetStatus(String cmd) throws IOException, InterruptedException {
		Process process =null;
		List<String> processList = new ArrayList<String>();
		List<String> errProcessList = new ArrayList<String>();
		process = Runtime.getRuntime().exec(cmd);
		int status = process.waitFor();

		BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = "";
		while ((line = input.readLine()) != null) {
			processList.add(line);
		}
		input.close();

		BufferedReader errinput = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		String errline = "";
		while ((errline = errinput.readLine()) != null) {
			errProcessList.add(line);
		}
		errinput.close();

		StringBuffer data = new StringBuffer();
		if(processList!=null && processList.size()>0){
			for(String proc:processList){
				data.append(proc).append("\r\n");
			}
		}

		Logger.info(ExecuteCommand.class,"执行脚本ErrorStream返回："+data.toString()+",脚本执行状态："+status);

		StringBuffer errdata = new StringBuffer();
		if(errProcessList!=null && errProcessList.size()>0){
			for(String proc:errProcessList){
				errdata.append(proc).append("\r\n");
			}
		}

		Logger.info(ExecuteCommand.class,"执行脚本ErrorStream返回："+errdata.toString()+",脚本执行状态："+status);

		return status;

	}


}
