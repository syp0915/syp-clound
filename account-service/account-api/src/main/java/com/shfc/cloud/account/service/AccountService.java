package com.shfc.cloud.account.service;

import com.shfc.cloud.account.domain.MerchantApikey;
import com.shfc.cloud.account.domain.ServiceLeftSource;
import com.shfc.cloud.account.dto.MerchantDTO;
import com.shfc.cloud.account.dto.MerchantInfoDTO;
import com.shfc.cloud.account.query.*;
import com.shfc.common.result.ResultDO;
import com.shfc.mybatis.pagination.Page;

/**
 * @Package com.shfc.cloud.account.service.AccountService
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/18 17:24
 * version V1.0.0
 */
public interface AccountService {

    /**
     * 商户短信，语音验证码，认证 扣除
     * @param deductQuery
     * @return
     */
    ResultDO deductBalance(DeductQuery deductQuery);

    /**
     * 商户详细信息
     * @return
     */
    ResultDO<MerchantInfoDTO> merchantInfo(UserInfoQuery userInfoQuery);

    /**
     * 查询具体商户服务资源情况
     * @return
     */
    ResultDO<ServiceLeftSource> selectLeftSource(SelectLeftSourceQuery query);

    /**
     * 资源列表
     * @param query
     * @return
     */
    ResultDO<Page<MerchantDTO>> userList(UserListQuery query);

    /**
     * 根据apikey查询数据
     * @return
     */
    ResultDO<MerchantApikey> apikeyInfo(String apikey);

    /**
     * 根据apikey查询数据
     * @return
     */
    ResultDO<Boolean> checkMerchant(CheckMerchantQuery query);

    /**
     * 清除缓存
     * @return
     */
    ResultDO clearRedis(String keyValue);
}
