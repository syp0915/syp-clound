package com.shfc.cloud.gateway.manager;

import com.shfc.cloud.gateway.dao.SourceDatabaseMapper;
import com.shfc.cloud.gateway.domain.SourceDataInfo;
import com.shfc.cloud.gateway.domain.SourceDatabase;
import com.shfc.cloud.gateway.dto.SourceDatabaseDTO;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 类注释
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/3/28 14:37
 * @since 1.0
 */
@Service
public class GatewayDbManager {
    @Resource
    private SourceDatabaseMapper sourceDataMapper;
    public SourceDataInfo select(SourceDatabaseDTO sourceDatabaseDto) {
        SourceDataInfo sourceDataInfo=new SourceDataInfo();
        BeanUtils.copyProperties(sourceDatabaseDto,sourceDataInfo);
        return sourceDataMapper.selectByMerchantId(sourceDataInfo);
    }
}
