package com.shfc.cloud.account.service;

import com.shfc.cloud.account.domain.MerchantApikey;
import com.shfc.cloud.account.domain.ServiceLeftSource;
import com.shfc.cloud.account.dto.MerchantDTO;
import com.shfc.cloud.account.dto.MerchantInfoDTO;
import com.shfc.cloud.account.exception.AccountExceptionConstant;
import com.shfc.cloud.account.manager.AccountManager;
import com.shfc.cloud.account.query.*;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.mybatis.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package com.shfc.cloud.account.service.AccountServiceImpl
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 11:00
 * version V1.0.0
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountManager accountManager;

    /**
     * 余额扣除
     * @param deductQuery
     * @return
     */
    @Override
    public ResultDO deductBalance(DeductQuery deductQuery) {
        ResultDO result  = new ResultDO();
        if(ValidateHelper.isEmpty(deductQuery.getChannelNo()) || ValidateHelper.isEmpty(deductQuery.getMerchantId()) || ValidateHelper.isEmpty(deductQuery.getType()) || ValidateHelper.isEmpty(deductQuery.getNumber())){
            result.setSuccess(false);
            result.setErrCode(AccountExceptionConstant.REQUEST_PARAMETER_MISS.getCode());
            result.setErrMsg(AccountExceptionConstant.REQUEST_PARAMETER_MISS.getMsg());
            return result;
        }
        result = accountManager.deductBalance(deductQuery);
        return result;
    }

    /**
     * 商户详情
     * @param query
     * @return
     */
    @Override
    public ResultDO<MerchantInfoDTO> merchantInfo(UserInfoQuery query) {
        ResultDO result  = new ResultDO();
//        if(ValidateHelper.isEmpty(query.getChannelNo())){
//            result.setSuccess(false);
//            result.setErrCode(AccountExceptionConstant.REQUEST_PARAMETER_MISS.getCode());
//            result.setErrMsg(AccountExceptionConstant.REQUEST_PARAMETER_MISS.getMsg());
//            return result;
//        }
        if(ValidateHelper.isEmpty(query.getMerchantId()) && ValidateHelper.isEmpty(query.getMerchantNo())){
            result.setSuccess(false);
            result.setErrMsg(AccountExceptionConstant.MERCHANT_NOT_NULL.getMsg());
            result.setErrCode(AccountExceptionConstant.MERCHANT_NOT_NULL.getCode());
            return result;
        }
        result = accountManager.merchantInfo(query);
        return result;
    }

    /**
     * 查询具体商户服务资源情况
     * @param query
     * @return
     */
    @Override
    public ResultDO<ServiceLeftSource> selectLeftSource(SelectLeftSourceQuery query) {
        ResultDO<ServiceLeftSource> result  = new ResultDO<ServiceLeftSource>();
        if(ValidateHelper.isEmpty(query.getChannelNo()) || ValidateHelper.isEmpty(query.getMerchantId()) || ValidateHelper.isEmpty(query.getType())){
            result.setSuccess(false);
            result.setErrCode(AccountExceptionConstant.REQUEST_PARAMETER_MISS.getCode());
            result.setErrMsg(AccountExceptionConstant.REQUEST_PARAMETER_MISS.getMsg());
            return result;
        }
        result = accountManager.selectLeftSource(query);
        return result;
    }

    @Override
    public ResultDO<Page<MerchantDTO>> userList(UserListQuery query) {
        ResultDO<Page<MerchantDTO>> result = new ResultDO<Page<MerchantDTO>>();
        if(ValidateHelper.isEmpty(query.getChannelNo()) || ValidateHelper.isEmpty(query.getMerchantId())){
            result.setSuccess(false);
            result.setErrCode(AccountExceptionConstant.REQUEST_PARAMETER_MISS.getCode());
            result.setErrMsg(AccountExceptionConstant.REQUEST_PARAMETER_MISS.getMsg());
            return result;
        }
        Page<MerchantDTO> page = accountManager.selectMerchantList(query,query.getPage());
        result.setSuccess(true);
        result.setData(page);
        return result;
    }

    @Override
    public ResultDO<MerchantApikey> apikeyInfo(String apikey) {
        ResultDO<MerchantApikey> result = new ResultDO<MerchantApikey>();
        result = accountManager.apikeyInfo(apikey);
        return result;
    }

    @Override
    public ResultDO<Boolean> checkMerchant(CheckMerchantQuery query) {
        ResultDO<Boolean> result = new ResultDO<Boolean>();
        if(ValidateHelper.isEmpty(query.getChannelNo()) || ValidateHelper.isEmpty(query.getMerchantId())){
            result.setSuccess(false);
            result.setErrCode(AccountExceptionConstant.REQUEST_PARAMETER_MISS.getCode());
            result.setErrMsg(AccountExceptionConstant.REQUEST_PARAMETER_MISS.getMsg());
            return result;
        }
        result = accountManager.checkMerchant(query);
        return result;
    }

    @Override
    public ResultDO clearRedis(String keyValue) {
        ResultDO result = new ResultDO();
        if(ValidateHelper.isEmpty(keyValue)){
            result.setSuccess(false);
            result.setErrCode(AccountExceptionConstant.REQUEST_PARAMETER_MISS.getCode());
            result.setErrMsg(AccountExceptionConstant.REQUEST_PARAMETER_MISS.getMsg());
            return result;
        }
        result = accountManager.clearRedis(keyValue);
        return result;
    }

}
