package com.shfc.cloud.gateway.service;

import com.shfc.cloud.gateway.dto.GatewayAuthDTO;
import com.shfc.common.result.ResultDO;

/**
 * 类注释
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/3/27 9:44
 * @since 1.0
 */
public interface GatewayAuthService {
    ResultDO insert(GatewayAuthDTO gatewayAuthDTO);

    ResultDO select(long merchantId, String channelNo);

    ResultDO delete(String id);

    ResultDO update(GatewayAuthDTO gatewayAuthDTO);
}
