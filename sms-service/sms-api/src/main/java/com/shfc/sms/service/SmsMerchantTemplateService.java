package com.shfc.sms.service;

import com.shfc.common.result.ResultDO;
import com.shfc.sms.dto.SmsMerchantTemplateDTO;
import com.shfc.sms.dto.TemplateResultDTO;

import java.util.List;

/**
 * @Package com.shfc.sms.service.SmsMerchantTemplateService
 * @Description: 商户短信模板
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/1 14:40
 * version V1.0.0
 */
public interface SmsMerchantTemplateService {
    /**
     * 添加模板
     * @param dto
     * @return
     */
    ResultDO<TemplateResultDTO> addTemplate(SmsMerchantTemplateDTO dto);

    /**
     * 获取模板
     * @param dto
     * @return
     */
    ResultDO<List<TemplateResultDTO>> getTemplate(SmsMerchantTemplateDTO dto);

    /**
     * 更新模板
     * @param dto
     * @return
     */
    ResultDO<TemplateResultDTO> updateTemplate(SmsMerchantTemplateDTO dto);
    /**
     * 删除
     * @param dto
     * @return
     */
    ResultDO<TemplateResultDTO> deleteTemplate(SmsMerchantTemplateDTO dto);


}
