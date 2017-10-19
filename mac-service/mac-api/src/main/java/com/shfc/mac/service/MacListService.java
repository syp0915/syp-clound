package com.shfc.mac.service;

import com.shfc.common.result.ResultDO;
import com.shfc.mac.dto.MacInfoDTO;
import com.shfc.mac.query.MacQuery;
import com.shfc.mybatis.pagination.Page;

/**
 * @Package com.shfc.mac.service.MacListService
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/14 17:40
 * version V1.0.0
 */
public interface MacListService {
    /**
     * maclist查询
     * @param query
     * @return
     */
    ResultDO<Page<MacInfoDTO>> macList(MacQuery query);

    /**
     * 根据Mac查询详情
     * @param query
     * @return
     */
    ResultDO<MacInfoDTO> macDetail(MacQuery query);

}
