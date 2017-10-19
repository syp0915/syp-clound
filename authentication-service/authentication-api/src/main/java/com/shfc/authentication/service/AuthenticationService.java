package com.shfc.authentication.service;

import com.shfc.authentication.dto.AuthenticationNameDTO;
import com.shfc.common.result.ResultDO;


/**
 * @author wuky
 * @version V1.0
 * @File com.shfc.base.service.AreaExtService.java
 * @Description: AuthenticationService
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * @date 2016年9月5日 下午6:39:37
 */
public interface AuthenticationService {

    /**
     * @Description: 身份证实名验证
     * @Title authenticationByInfo
     * @Author  wuky
     * @Date 2017/3/6 17:17
     * @param  dto
     * @return ResultDO<PlotAddressDTO>
     * @throws
     */
    ResultDO<Boolean> authenticationByInfo(AuthenticationNameDTO dto);

    /**
     * @Description: 身份证实名验证--认证宝
     * @Title identityId
     * @Author  wuky
     * @Date 2017/5/24 15:00
     * @param  dto
     * @returnResultDO<Boolean>
     * @throws
     */
    ResultDO<Boolean> identityId(AuthenticationNameDTO dto);
}
