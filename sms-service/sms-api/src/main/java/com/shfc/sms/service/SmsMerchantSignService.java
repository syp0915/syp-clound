package com.shfc.sms.service;

import com.shfc.common.result.ResultDO;
import com.shfc.sms.domain.SmsMerchantSign;
import com.shfc.sms.dto.SmsMerchantSignDTO;
import com.shfc.sms.dto.SmsSignDTO;

import java.util.List;

/**
 * @Package com.shfc.sms.service.SmsMerchantSignService
 * @Description: 短信商户签名
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/1 14:39
 * version V1.0.0
 */
public interface SmsMerchantSignService {
    /**
     * 增加签名
     * @return
     */
    ResultDO<SmsSignDTO> addSign(SmsMerchantSignDTO smsMerchantSignDTO);

    /**
     * 更新签名
     * @return
     */
    ResultDO<SmsSignDTO> updateSign(SmsMerchantSignDTO smsMerchantSignDTO);

    /**
     * 根据签名ID获取签名信息
     * @param signId
     * @return
     */
    ResultDO<SmsSignDTO> getSignById(Long signId);

    /**
     * 根据商户ID获取签名信息
     * @param merchantId
     * @return
     * 方法废弃
     */
    //ResultDO<List<SmsMerchantSign>> querySignByMerchantId(Long merchantId);
}
