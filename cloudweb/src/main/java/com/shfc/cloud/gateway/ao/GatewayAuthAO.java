package com.shfc.cloud.gateway.ao;

import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.constant.ErrorConstant;
import com.shfc.cloud.gateway.dto.GatewayAuthDTO;
import com.shfc.cloud.gateway.dto.GatewayAuthWebDTO;
import com.shfc.cloud.gateway.service.GatewayAuthService;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 类注释
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/4/5 10:10
 * @since 1.0
 */
@Service
public class GatewayAuthAO {
    @Resource
    private GatewayAuthService gatewayAuthService;
    public ResultDO insert(GatewayAuthWebDTO reqJson) {
        ResultDO result = new ResultDO();
        if(ValidateHelper.isEmptyString(reqJson.getChannelNo())){
            result.setSuccess(false);
            result.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            result.setErrMsg("频道号不能为空");
            return result;
        }
        if((Long)reqJson.getMerchantId()==null){
            result.setSuccess(false);
            result.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            result.setErrMsg("商户id不能为空");
            return result;
        }
        if(ValidateHelper.isEmptyString(reqJson.getStartTime())){
            result.setSuccess(false);
            result.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            result.setErrMsg("开始时间不能为空");
            return result;
        }
        if(ValidateHelper.isEmptyString(reqJson.getEndTime())){
            result.setSuccess(false);
            result.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            result.setErrMsg("截止时间不能为空");
            return result;
        }
        if((Integer) reqJson.getValidity()==null){
            result.setSuccess(false);
            result.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            result.setErrMsg("有效期不能为空");
            return result;
        }
        GatewayAuthDTO gatewayAuthDTO=new GatewayAuthDTO();
        BeanUtils.copyProperties(reqJson,gatewayAuthDTO);
        result=gatewayAuthService.insert(gatewayAuthDTO);
        return result;
    }

    public ResultDO select(GatewayAuthWebDTO reqJson) {
        ResultDO result = new ResultDO();
        long merchantId=  reqJson.getMerchantId();
        String channelNo= reqJson.getChannelNo();
        if((Long)merchantId==null){
            result.setSuccess(false);
            result.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            result.setErrMsg("商户id不能为空");
            return result;
        }
        if(ValidateHelper.isEmptyString(channelNo)){
            result.setSuccess(false);
            result.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            result.setErrMsg("频道号不能为空");
            return result;
        }
        result=gatewayAuthService.select(merchantId,channelNo);
        return result;
    }

    public ResultDO delete(GatewayAuthWebDTO reqJson) {
        ResultDO result = new ResultDO();
        String id= String.valueOf(reqJson.getId());
        if(ValidateHelper.isEmptyString(id)){
            result.setSuccess(false);
            result.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            result.setErrMsg("id不能为空");
            return result;
        }
        result=gatewayAuthService.delete(id);
        return result;
    }

    public ResultDO update(GatewayAuthWebDTO reqJson) {
        ResultDO result = new ResultDO();
        if(ValidateHelper.isEmptyString(reqJson.getChannelNo())){
            result.setSuccess(false);
            result.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            result.setErrMsg("频道号不能为空");
            return result;
        }
        if((Long)reqJson.getMerchantId()==null){
            result.setSuccess(false);
            result.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            result.setErrMsg("商户id不能为空");
            return result;
        }
        if(ValidateHelper.isEmptyString(reqJson.getStartTime())){
            result.setSuccess(false);
            result.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            result.setErrMsg("开始时间不能为空");
            return result;
        }
        if(ValidateHelper.isEmptyString(reqJson.getEndTime())){
            result.setSuccess(false);
            result.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            result.setErrMsg("截止时间不能为空");
            return result;
        }
        if((Integer) reqJson.getValidity()==null){
            result.setSuccess(false);
            result.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            result.setErrMsg("有效期不能为空");
            return result;
        }
        GatewayAuthDTO gatewayAuthDTO=new GatewayAuthDTO();
        BeanUtils.copyProperties(reqJson,gatewayAuthDTO);
        result=gatewayAuthService.update(gatewayAuthDTO);
        return result;
    }
}
