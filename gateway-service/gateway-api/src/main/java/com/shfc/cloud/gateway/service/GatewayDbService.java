package com.shfc.cloud.gateway.service;

import com.shfc.cloud.gateway.dto.SourceDatabaseDTO;
import com.shfc.common.result.ResultDO;

/**
 * 类注释
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/3/28 14:21
 * @see 链接到其他资源
 * @since 1.0
 */
public interface GatewayDbService {
    ResultDO select(SourceDatabaseDTO sourceDatabaseDto);

    ResultDO insert(SourceDatabaseDTO sourceBaseDto, ResultDO result);

    ResultDO update(SourceDatabaseDTO sourceBaseDto, ResultDO result);

    ResultDO delete(SourceDatabaseDTO sourceBaseDto, ResultDO result);

    ResultDO selectData(SourceDatabaseDTO sourceBaseDto, ResultDO result);
}
