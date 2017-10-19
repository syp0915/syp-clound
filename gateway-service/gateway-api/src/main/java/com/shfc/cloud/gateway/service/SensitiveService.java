package com.shfc.cloud.gateway.service;

import com.shfc.cloud.gateway.dto.SensitiveDTO;
import com.shfc.common.result.ResultDO;

import java.util.List;

/**
 * 类注释
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/3/23 14:12
 * @since 1.0
 */
public interface SensitiveService {
    ResultDO insert(SensitiveDTO reqJson);

    ResultDO select(String sensitiveWord);

    ResultDO delete(String id);
}
