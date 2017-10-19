package com.shfc.cloud.authentication.ao;

import com.shfc.authentication.dto.AuthenticationNameDTO;
import com.shfc.authentication.service.AuthenticationService;
import com.shfc.cloud.account.constant.DeductConstant;
import com.shfc.cloud.account.domain.ServiceLeftSource;
import com.shfc.cloud.account.query.DeductQuery;
import com.shfc.cloud.account.query.SelectLeftSourceQuery;
import com.shfc.cloud.account.service.AccountService;
import com.shfc.cloud.authentication.dto.AuthenticationDTO;
import com.shfc.cloud.constant.CloudConstant;
import com.shfc.cloud.constant.ErrorConstant;
import com.shfc.cloud.utils.HttpSessionUtils;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 实名认证
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-21 09:45
 **/
@Service
public class AuthenticationAO {
    @Autowired(required = false)
    private AuthenticationService authenticationService;
    @Autowired
    private AccountService accountService;

    public ResultDO<Boolean> authenticationByInfo(AuthenticationDTO dto){
        ResultDO<Boolean> resultDO=new ResultDO<Boolean>();
        AuthenticationNameDTO authenticationNameDTO=new AuthenticationNameDTO();
        String name=dto.getName();
        String id=dto.getId();
        String channelNo=dto.getChannelNo();
        Long merchantId = HttpSessionUtils.getObject(CloudConstant.CURRENT_MERCHANT_ID);

        if(merchantId==null){
            resultDO.setErrMsg("商户号不能为空");
            return resultDO;
        }

        if(channelNo==null){
            resultDO.setErrCode(ErrorConstant.NULL_CHANNEL_NO.getCode());
            resultDO.setErrMsg(ErrorConstant.NULL_CHANNEL_NO.getMsg());
            return resultDO;
        }

        if(ValidateHelper.isEmpty(name)){
            resultDO.setErrCode(ErrorConstant.NAME_NOT_NULL.getCode());
            resultDO.setErrMsg(ErrorConstant.NAME_NOT_NULL.getMsg());
            return resultDO;
        }
        if(ValidateHelper.isEmpty(id)){
            resultDO.setErrCode(ErrorConstant.ID_NOT_NULL.getCode());
            resultDO.setErrMsg(ErrorConstant.ID_NOT_NULL.getMsg());
            return resultDO;
        }
        //查看套餐剩余
        String marginResult=queryMerchantMargin(merchantId,dto);
        if(marginResult!=null){
            resultDO.setErrMsg(marginResult);
            return resultDO;
        }

        authenticationNameDTO.setName(name);
        authenticationNameDTO.setId(id);
        authenticationNameDTO.setChannelNo(channelNo);
        authenticationNameDTO.setMerchantId(merchantId);
        ResultDO<Boolean> result=authenticationService.identityId(authenticationNameDTO);
        if(!result.isSuccess()){
            resultDO.setErrMsg(result.getErrMsg());
            return resultDO;
        }
        //调用成功后扣费
        deductBalance(merchantId,dto);

        resultDO.setData(result.getData());
        resultDO.setSuccess(true);
        return resultDO;
    }

    /**
    * 查询商户余量信息
    * @param dto
     * @param merchantId
    * @return
    */
    public String queryMerchantMargin(Long merchantId,AuthenticationDTO dto){
        SelectLeftSourceQuery query=new SelectLeftSourceQuery();
        query.setMerchantId(merchantId);//商户ID
        query.setChannelNo(dto.getChannelNo());//频道号
        query.setType(DeductConstant.Certification);//查询验证
        ResultDO<ServiceLeftSource> resultDO=accountService.selectLeftSource(query);
        if(!resultDO.isSuccess()){
            return resultDO.getErrMsg();
        }else {
            ServiceLeftSource leftSource = resultDO.getData();
            if(leftSource!=null){
                double leftNum  = leftSource.getLeftNum();//验证服务剩余量
                if(leftNum<=0){
                    return "短信剩余条数不足，请充值！";
                }
            }else {
                return "商户余量信息不正确！";
            }
        }

        return null;
    }

    /**
     * 商户的认证余量修改
     * @param dto
     * @param merchantId
     * @return
     */
    public void deductBalance(Long merchantId,AuthenticationDTO dto){
        DeductQuery deductQuery = new DeductQuery();
        deductQuery.setMerchantId(merchantId);
        deductQuery.setChannelNo(dto.getChannelNo());
        deductQuery.setType(DeductConstant.Certification);
        deductQuery.setNumber(1);//
        accountService.deductBalance(deductQuery);
    }
}
