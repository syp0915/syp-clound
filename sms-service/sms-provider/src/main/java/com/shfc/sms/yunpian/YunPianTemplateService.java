package com.shfc.sms.yunpian;

import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.Template;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Package com.shfc.sms.yunpian.YunPianTemplateService
 * @Description: 云片模板服务
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/1 15:32
 * version V1.0.0
 */
@Service
public class YunPianTemplateService extends YunPianBaseService{
    /**
     * 添加模板
     * @param param
     * @return
     */
    public Result<Template> addTemplate(Long merchantId,String channelNo, Map<String, String> param){
        return tplApi.add(param);
    }

    /**
     * 获取模板
     * @param param
     * @return
     */
    public Result<List<Template>> getTemplate(Long merchantId,String channelNo, Map<String, String> param){
        return tplApi.get(param);
    }

    /**
     * 删除模板
     * @param param
     * @return
     */
    public Result<Template> deleteTemplate(Long merchantId,String channelNo, Map<String, String> param){
        return tplApi.del(param);
    }

    /**
     * 更新模板
     * @param param
     * @return
     */
    public Result<Template> updateTemplate(Long merchantId,String channelNo, Map<String, String> param){
        return tplApi.update(param);
    }

    @Override
    public void initApi() {
        tplApi = yunpianClient.tpl();
    }
}
