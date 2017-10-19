package com.shfc.cloud.account.ao;

import com.shfc.cloud.account.constant.CheckStatusConstant;
import com.shfc.cloud.account.dto.MerchantDTO;
import com.shfc.cloud.account.dto.MerchantInfoDTO;
import com.shfc.cloud.account.dto.UserInfoDTO;
import com.shfc.cloud.account.dto.UserListDTO;
import com.shfc.cloud.account.query.UserInfoQuery;
import com.shfc.cloud.account.query.UserListQuery;
import com.shfc.cloud.account.service.AccountService;
import com.shfc.cloud.common.ao.BaseAO;
import com.shfc.cloud.constant.ErrorConstant;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.mybatis.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package com.shfc.cloud.account.ao.AccountAO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/16 17:04
 * version V1.0.0
 */
@Service
public class AccountAO extends BaseAO{

    @Autowired
    private AccountService accountService;

    public ResultDO<MerchantInfoDTO> userInfo(UserInfoDTO userInfoDTO){
        ResultDO<MerchantInfoDTO> result = new ResultDO<MerchantInfoDTO>();
        result = checkCommonData(userInfoDTO.getMerchantId(),userInfoDTO.getChannelNo());
        if(!result.isSuccess()){
            return result;
        }
        if(ValidateHelper.isEmpty(userInfoDTO.getMerchantNo())){
            result.setErrCode(ErrorConstant.NULL_MERCHANTNO.getCode());
            result.setErrMsg(ErrorConstant.NULL_MERCHANTNO.getMsg());
            result.setSuccess(false);
            return result;
        }
        UserInfoQuery query = new UserInfoQuery();
        query.setMerchantId(userInfoDTO.getMerchantId());
        query.setChannelNo(userInfoDTO.getChannelNo());
        query.setMerchantNo(userInfoDTO.getMerchantNo());
        result = accountService.merchantInfo(query);
        return result;
    }

    public ResultDO<Page<MerchantDTO>> userList(UserListDTO userListDTO){
        ResultDO<Page<MerchantDTO>> result = new ResultDO<Page<MerchantDTO>>();
        result = checkCommonData(userListDTO.getMerchantId(),userListDTO.getChannelNo());
        if(!result.isSuccess()){
            return result;
        }
        if(ValidateHelper.isEmpty(userListDTO.getPageSize())){
            result.setErrCode(ErrorConstant.NULL_ACCOUNT_PAGESIZE.getCode());
            result.setErrMsg(ErrorConstant.NULL_ACCOUNT_PAGESIZE.getMsg());
            result.setSuccess(false);
            return result;
        }
        if(ValidateHelper.isEmpty(userListDTO.getPageNumber())){
            result.setErrCode(ErrorConstant.NULL_ACCOUNT_PAGENUMBER.getCode());
            result.setErrMsg(ErrorConstant.NULL_ACCOUNT_PAGENUMBER.getMsg());
            result.setSuccess(false);
            return result;
        }
        UserListQuery query = new UserListQuery();
        if(!ValidateHelper.isEmpty(userListDTO.getStatus())){
            CheckStatusConstant status = CheckStatusConstant.getConstantByValue(userListDTO.getStatus());
            query.setStatus(status);
        }
        query.setMerchantId(userListDTO.getMerchantId());
        query.setChannelNo(userListDTO.getChannelNo());
        query.setAccount(userListDTO.getAccount());
        query.setCompanyName(userListDTO.getCompanyName());
        Page page = new Page();
        page.setPageSize(userListDTO.getPageSize());
        page.setPageNumber(userListDTO.getPageNumber());
        query.setPage(page);
        result = accountService.userList(query);
        return result;
    }

}
