package com.shfc.cloud.gateway.ao;

import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.constant.ErrorConstant;
import com.shfc.cloud.gateway.dto.WhiteListDTO;
import com.shfc.cloud.gateway.dto.WhiteListWebDTO;
import com.shfc.cloud.gateway.service.WhiteListService;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.mybatis.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 类注释
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/4/5 10:11
 * @since 1.0
 */
@Service
public class WhiteListAO {
    @Resource
    private WhiteListService whiteListService;
    public ResultDO insert(WhiteListWebDTO reqJson) {
        ResultDO result=new ResultDO();
        if(ValidateHelper.isEmptyString(reqJson.getIp())){
            result.setSuccess(false);
            result.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            result.setErrMsg("ip不能为空");
            return result;
        }
        WhiteListDTO whiteListDTO=new WhiteListDTO();
        BeanUtils.copyProperties(reqJson,whiteListDTO);
        result=whiteListService.insert(whiteListDTO);
        return result;
    }

    public ResultDO select(WhiteListWebDTO reqJson) {
        ResultDO result=new ResultDO();
        Long merchantId=reqJson.getMerchantId();
        Page page=new Page();
        if(reqJson.getPageSize()!=null){
            page.setPageSize(reqJson.getPageSize());
        }
        if(reqJson.getPageNumber()!=null){
            page.setPageNumber(reqJson.getPageNumber());
        }

        if(merchantId==null){
            result.setSuccess(false);
            result.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            result.setErrMsg("商户id不能为空");
            return result;
        }
        WhiteListDTO whiteListDTO=new WhiteListDTO();
        BeanUtils.copyProperties(reqJson,whiteListDTO);

        result=whiteListService.select(whiteListDTO,page);
        return result;
    }

    public ResultDO delete(WhiteListWebDTO reqJson) {
        ResultDO result=new ResultDO();
        String id=reqJson.getId();
        if(ValidateHelper.isEmptyString(id)){
            result.setSuccess(false);
            result.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            result.setErrMsg("id不能为空");
            return result;
        }
        result=whiteListService.delete(id);
        return result;
    }
}
