package com.shfc.cloud.gateway.ao;

import com.shfc.cloud.constant.ErrorConstant;
import com.shfc.cloud.gateway.dto.SensitiveDTO;
import com.shfc.cloud.gateway.dto.SensitiveWebDTO;
import com.shfc.cloud.gateway.service.SensitiveService;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/4/5 10:11
 * @since 1.0
 */
@Service
public class SensitiveAO {
    @Resource
    private SensitiveService sensitiveService;

    public ResultDO insert(SensitiveWebDTO reqJson) {
        ResultDO result = new ResultDO();
        if(ValidateHelper.isEmptyString(reqJson.getSensitiveWord())){
            result.setSuccess(false);
            result.setErrMsg("敏感词内容不能为空");
            result.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            return result;
        }
        SensitiveDTO sensitiveDTO=new SensitiveDTO();
        BeanUtils.copyProperties(reqJson,sensitiveDTO);
        result=sensitiveService.insert(sensitiveDTO);
        return  result;
    }

    public ResultDO  select(SensitiveWebDTO reqJson) {
        String sensitiveWord=reqJson.getSensitiveWord();
        return sensitiveService.select(sensitiveWord);

    }

    public ResultDO delete(SensitiveWebDTO reqJson) {
        ResultDO result = new ResultDO();
        try{
            String id=reqJson.getId();
            if(ValidateHelper.isEmptyString(id)){
                result.setSuccess(false);
                result.setErrMsg("id不能为空");
                result.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            }
            result=sensitiveService.delete(id);
        }catch(Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setErrMsg("数据格式错误");
            result.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
        }
        return result;
    }
}
