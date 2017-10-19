package com.shfc.cloud.gateway.service;
import com.shfc.mybatis.pagination.Page;
import com.shfc.cloud.gateway.dto.WhiteListDTO;
import com.shfc.common.result.ResultDO;

/**
 * 类注释
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/3/27 9:30
 * @since 1.0
 */
public interface WhiteListService {
    ResultDO insert(WhiteListDTO whiteListDTO);

    ResultDO select(WhiteListDTO reqJson,Page page);

    ResultDO delete(String id);

    boolean isIpAllowVisit(long merchantId, String ip);
}
