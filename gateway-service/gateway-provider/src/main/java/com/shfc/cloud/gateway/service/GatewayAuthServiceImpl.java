package com.shfc.cloud.gateway.service;

import com.shfc.cloud.gateway.constant.ErrorConstant;
import com.shfc.cloud.gateway.domain.GatewayInterfaceAuth;
import com.shfc.cloud.gateway.dto.GatewayAuthDTO;
import com.shfc.cloud.gateway.manager.GatewayAuthManager;
import com.shfc.common.result.ResultDO;
import com.shfc.log.LogFileUtils;
import com.sun.jersey.api.client.filter.LoggingFilter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类注释
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/3/27 9:45
 * @since 1.0
 */
@Service
public class GatewayAuthServiceImpl implements GatewayAuthService {
    @Resource
    private GatewayAuthManager gatewayAuthManager;
    LogFileUtils logFileUtils = LogFileUtils.getInstance("gateway-service");
    @Override
    public ResultDO insert(GatewayAuthDTO gatewayAuthDTO) {

        long startTime=System.currentTimeMillis();
        ResultDO resultDO = new ResultDO();
        try{
        if (gatewayAuthManager.insert(gatewayAuthDTO)) {
            resultDO.setSuccess(true);
        } else {
            resultDO.setErrCode(ErrorConstant.DATABASE_ERROR_OCCURRED.getCode());
            resultDO.setErrMsg(ErrorConstant.DATABASE_ERROR_OCCURRED.getMsg());
            resultDO.setSuccess(false);
            return resultDO;
        }
        }catch(Exception e){
            resultDO.setErrCode(ErrorConstant.DATABASE_ERROR_OCCURRED.getCode());
            resultDO.setErrMsg(ErrorConstant.DATABASE_ERROR_OCCURRED.getMsg());
            e.printStackTrace();
            return resultDO;
        }
        logFileUtils.info("网关模块",gatewayAuthDTO.getMerchantId(),gatewayAuthDTO.getChannelNo(),GatewayAuthServiceImpl.class,"insert",startTime);
        return resultDO;
    }

    @Override
    public ResultDO select(long merchantId, String channelNo) {
        long startTime=System.currentTimeMillis();
        Map map=new HashMap();
        map.put("merchantId",merchantId);
        map.put("channelNo",channelNo);
        ResultDO resultDO = new ResultDO();
        try{
            List<GatewayInterfaceAuth> list = gatewayAuthManager.select(map);
            resultDO.setData(list);
            resultDO.setSuccess(true);
        }catch(Exception e){
            resultDO.setErrCode(ErrorConstant.DATABASE_ERROR_OCCURRED.getCode());
            resultDO.setErrMsg(ErrorConstant.DATABASE_ERROR_OCCURRED.getMsg());
            e.printStackTrace();
            return resultDO;
        }
        logFileUtils.info("网关模块",merchantId,channelNo,GatewayAuthServiceImpl.class,"select",startTime);
        return resultDO;
    }

    @Override
    public ResultDO delete(String id) {
        ResultDO resultDO = new ResultDO();
        GatewayInterfaceAuth gatewayInterfaceAuth = new GatewayInterfaceAuth();
        gatewayInterfaceAuth.setId(Long.valueOf(id));
        gatewayInterfaceAuth.setStatus("1");
        try{
        if (gatewayAuthManager.delete(gatewayInterfaceAuth)) {
            resultDO.setSuccess(true);
        } else {
            resultDO.setErrCode(ErrorConstant.DATABASE_ERROR_OCCURRED.getCode());
            resultDO.setErrMsg(ErrorConstant.DATABASE_ERROR_OCCURRED.getMsg());
            resultDO.setSuccess(false);
            return resultDO;
        }
        }catch(Exception e){
            resultDO.setErrCode(ErrorConstant.DATABASE_ERROR_OCCURRED.getCode());
            resultDO.setErrMsg(ErrorConstant.DATABASE_ERROR_OCCURRED.getMsg());
            e.printStackTrace();
            return resultDO;
        }
        return resultDO;
    }

    @Override
    public ResultDO update(GatewayAuthDTO gatewayAuthDTO) {
        long startTime=System.currentTimeMillis();
        ResultDO resultDO = new ResultDO();
        GatewayInterfaceAuth gatewayInterfaceAuth = new GatewayInterfaceAuth();
        gatewayInterfaceAuth.setChannelNo(gatewayAuthDTO.getChannelNo());
        gatewayInterfaceAuth.setId(gatewayAuthDTO.getId());
        gatewayInterfaceAuth.setEndDate(gatewayAuthDTO.getEndTime());
        gatewayInterfaceAuth.setStartDate(gatewayAuthDTO.getStartTime());
        gatewayInterfaceAuth.setMerchantId(gatewayAuthDTO.getMerchantId());
        gatewayInterfaceAuth.setValidity(gatewayAuthDTO.getValidity());
        try{
        if (gatewayAuthManager.update(gatewayInterfaceAuth)) {
            resultDO.setSuccess(true);
        } else {
            resultDO.setErrCode(ErrorConstant.DATABASE_ERROR_OCCURRED.getCode());
            resultDO.setErrMsg(ErrorConstant.DATABASE_ERROR_OCCURRED.getMsg());
            resultDO.setSuccess(false);
            return resultDO;
        }
        }catch(Exception e){
            resultDO.setErrCode(ErrorConstant.DATABASE_ERROR_OCCURRED.getCode());
            resultDO.setErrMsg(ErrorConstant.DATABASE_ERROR_OCCURRED.getMsg());
            e.printStackTrace();
            return resultDO;
        }
        logFileUtils.info("网关模块",gatewayAuthDTO.getMerchantId(),gatewayAuthDTO.getChannelNo(),GatewayAuthServiceImpl.class,"update",startTime);
        return resultDO;
    }
}
