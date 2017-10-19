package com.shfc.cloud.monitor.util;


import com.shfc.common.result.ResultDO;
import org.apache.log4j.Logger;

import java.io.*;

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

	private static Logger logger = Logger.getLogger(ExecuteCommand.class);

	public static ResultDO executeCmd(String cmd) throws IOException, InterruptedException {
		ResultDO result = new ResultDO();
		Process process =null;
		process = Runtime.getRuntime().exec(cmd);
		int status = process.waitFor();

		logger.info("脚本执行状态：" + status);

		StringBuffer cmdout = new StringBuffer();
		Boolean isPrettify = true;//是否美化
		String line = null;

		InputStream fis = null;
		if(status==0){
			fis = process.getInputStream();
			result.setSuccess(true);
		}else{
			fis = process.getErrorStream();
			result.setSuccess(false);
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		if (isPrettify == null || isPrettify) {
			while ((line = br.readLine()) != null) {
				cmdout.append(line);
			}
		} else {
			while ((line = br.readLine()) != null) {
				cmdout.append(line).append(System.getProperty("line.separator"));
			}
		}

		logger.info("执行系统命令后的结果为：" + cmdout.toString());

		if(status!=0){
			result.setErrCode(1);
			result.setErrMsg(cmdout.toString());
		}

		result.setData(cmdout.toString());
		return result;
	}


}
