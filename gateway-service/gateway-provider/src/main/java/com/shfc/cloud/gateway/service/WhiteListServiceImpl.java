package com.shfc.cloud.gateway.service;

import com.shfc.cloud.gateway.constant.ErrorConstant;
import com.shfc.cloud.gateway.domain.GatewayIpWhite;
import com.shfc.cloud.gateway.dto.WhiteListDTO;
import com.shfc.cloud.gateway.manager.WhiteListManager;
import com.shfc.common.result.ResultDO;
import com.shfc.mybatis.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类注释
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/3/27 9:31
 * @since 1.0
 */
@Service
public class WhiteListServiceImpl implements WhiteListService {

    @Resource
    private WhiteListManager whiteListManager;

    @Override
    public ResultDO insert(WhiteListDTO whiteListDTO) {
        ResultDO resultDO=new ResultDO();
        try {
            if(whiteListManager.insert(whiteListDTO)){
                resultDO.setSuccess(true);
            }else{
                resultDO.setErrCode(ErrorConstant.DATABASE_ERROR_OCCURRED.getCode());
                resultDO.setErrMsg(ErrorConstant.DATABASE_ERROR_OCCURRED.getMsg());
                resultDO.setSuccess(false);
                return resultDO;
            }
        }catch(Exception e){
            resultDO.setErrCode(ErrorConstant.UNKNOWN_ERROR.getCode());
            resultDO.setErrMsg(ErrorConstant.UNKNOWN_ERROR.getMsg());
            return resultDO;
        }


        return resultDO;
    }

    @Override
    public ResultDO select(WhiteListDTO whiteListDTO,Page page) {
        ResultDO resultDO=new ResultDO();
        try {
        Page<GatewayIpWhite> list =whiteListManager.select(whiteListDTO,page);
        resultDO.setData(list);
        resultDO.setSuccess(true);
        }catch(Exception e){
            resultDO.setErrCode(ErrorConstant.UNKNOWN_ERROR.getCode());
            resultDO.setErrMsg(ErrorConstant.UNKNOWN_ERROR.getMsg());
            return resultDO;
        }

        return resultDO;
    }

    @Override
    public ResultDO delete(String id) {
        ResultDO resultDO=new ResultDO();
        GatewayIpWhite gatewayIpWhite=new GatewayIpWhite();
        gatewayIpWhite.setId(Long.valueOf(id));
        gatewayIpWhite.setStatus("1");
        try {
        if(whiteListManager.update(gatewayIpWhite)){
            resultDO.setSuccess(true);
        }else{
            resultDO.setErrCode(ErrorConstant.DATABASE_ERROR_OCCURRED.getCode());
            resultDO.setErrMsg(ErrorConstant.DATABASE_ERROR_OCCURRED.getMsg());
            resultDO.setSuccess(false);
            return resultDO;
        }
        }catch(Exception e){
            resultDO.setErrCode(ErrorConstant.UNKNOWN_ERROR.getCode());
            resultDO.setErrMsg(ErrorConstant.UNKNOWN_ERROR.getMsg());
            return resultDO;
        }
        return resultDO;
    }

    @Override
    public boolean isIpAllowVisit(long merchantId, String ip) {
        List<GatewayIpWhite> list =whiteListManager.selectByMerchantId(merchantId);
        for(GatewayIpWhite gatewayIpWhite:list){
        if(gatewayIpWhite.getIp().equals(ip)){
            return true;
        }
        }
        return false;
    }
}
