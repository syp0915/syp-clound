package com.shfc.cloud.cache.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package com.shfc.cloud.cache.controller.CacheController
 * @Description: 缓存服务
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lusz
 * @date 2017/3/21 10:36
 * version V1.0.0
 */
@RestController
@RequestMapping("/cloud/cache")
public class CacheController {
	@RequestMapping(value = "/get/{version}", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON+";charset=UTF-8")
	public ResultDO singleSend(@RequestParam("reqJson") String reqJson, @PathVariable("version") String version){
		ResultDO<JSONObject> resultDO = new ResultDO<JSONObject>();
		JSONObject object = JsonUtils.parseJavaObject(reqJson, JSONObject.class);
		String channelNo  = object.getString("channelNo");
		String key =  object.getString("key");
		if(channelNo == null){
			resultDO.setErrMsg("频道编号不能为空!");
			return resultDO;
		}
		if(ValidateHelper.isEmptyString(key)){
			resultDO.setErrMsg("key不能为空!");
			return resultDO;
		}
		JSONObject data = new JSONObject();
		data.put("key",key);
		data.put("content","缓存数据");
		resultDO.setSuccess(true);
		resultDO.setData(data);
		return resultDO;
	}

	@RequestMapping(value = "/list/{version}", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON+";charset=UTF-8")
	public ResultDO sendVoice(@RequestParam("reqJson") String reqJson, @PathVariable("version") String version){
		ResultDO<JSONArray> resultDO = new ResultDO<JSONArray>();
		JSONObject object = JsonUtils.parseJavaObject(reqJson, JSONObject.class);
		String channelNo  = object.getString("channelNo");
		String key =  object.getString("key");
		if(channelNo == null){
			resultDO.setErrMsg("频道编号不能为空!");
			return resultDO;
		}
		JSONArray list = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("key","oneKey");//商户ID
		jsonObject.put("content","缓存内容1");//商户号
		list.add(jsonObject);

		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("key","secondKey");//商户ID
		jsonObject2.put("content","缓存内容2");//商户号
		list.add(jsonObject2);
		resultDO.setSuccess(true);
		resultDO.setData(list);
		return resultDO;
	}
}
