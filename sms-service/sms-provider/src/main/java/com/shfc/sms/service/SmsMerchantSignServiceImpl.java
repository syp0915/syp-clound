package com.shfc.sms.service;

import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.sms.domain.SmsMerchantSign;
import com.shfc.sms.dto.SmsMerchantSignDTO;
import com.shfc.sms.dto.SmsSignDTO;
import com.shfc.sms.enums.AuditStatus;
import com.shfc.sms.enums.SmsErrorCode;
import com.shfc.sms.manager.SmsMerchantSignManager;
import com.shfc.sms.yunpian.YunPianSignService;
import com.yunpian.sdk.constant.Code;
import com.yunpian.sdk.constant.YunpianConstant;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.Sign;
import com.yunpian.sdk.model.SignRecord;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package com.shfc.sms.service.SmsMerchantSignServiceImpl
 * @Description: 短信商户签名
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/1 14:41
 * version V1.0.0
 */
@Service
public class SmsMerchantSignServiceImpl implements SmsMerchantSignService{
    private static final Logger logger = Logger.getLogger(SmsMerchantSignServiceImpl.class);
    @Autowired
    private YunPianSignService yunPianSignService;
    @Autowired
    private SmsMerchantSignManager smsMerchantSignManager;

    @Override
    public ResultDO<SmsSignDTO> addSign(SmsMerchantSignDTO smsMerchantSignDTO) {
        ResultDO<SmsSignDTO> resultDO = new ResultDO<>();
        Map<String, String> param =new HashMap<>();
        Long merchantId = smsMerchantSignDTO.getMerchantId();//商户id
        String channelNo = smsMerchantSignDTO.getChannelNo();//频道号
        String signStr = smsMerchantSignDTO.getSign();
        String industryType = smsMerchantSignDTO.getIndustryType();
        if(null == merchantId || ValidateHelper.isEmpty(signStr) || ValidateHelper.isEmpty(channelNo)){
            resultDO.setErrCode(SmsErrorCode.PARAMETER_NOT_NULL.getCode());
            resultDO.setErrMsg(SmsErrorCode.PARAMETER_NOT_NULL.getMsg());
            return resultDO;
        }
        param.put(YunpianConstant.SIGN, smsMerchantSignDTO.getSign());
        if (!ValidateHelper.isEmpty(industryType)) {//添加所属行业
            param.put(YunpianConstant.INDUSTRYTYPE , industryType);
        }
        Result<Sign> result = yunPianSignService.addSign(merchantId, channelNo, param);
        logger.info("新增签名==" + result.toString());
        if(result.getCode() != Code.OK){
            resultDO.setErrCode(result.getCode());
            resultDO.setErrMsg(result.getMsg());
            return resultDO;
        }
        Sign sign = result.getData();
        SmsSignDTO smsSignDTO = new SmsSignDTO();
        smsSignDTO.setApplyState(sign.getApply_state());
        smsSignDTO.setSign(sign.getSign());
        smsSignDTO.setIndustryType(sign.getIndustry_type());
        Long signId = smsMerchantSignManager.addMerchantSign(smsMerchantSignDTO , smsSignDTO);
        smsSignDTO.setSignId(signId);
        resultDO.setSuccess(true);
        resultDO.setErrCode(result.getCode());
        resultDO.setData(smsSignDTO);
        return resultDO;
    }

    @Override
    public ResultDO<SmsSignDTO> updateSign(SmsMerchantSignDTO smsMerchantSignDTO) {
        ResultDO<SmsSignDTO> resultDO = new ResultDO<>();
        Map<String, String> param =new HashMap<>();
        Long signId = smsMerchantSignDTO.getSignId();
        Long merchantId = smsMerchantSignDTO.getMerchantId();//商户id
        String channelNo = smsMerchantSignDTO.getChannelNo();//频道号
        String oldSignStr = smsMerchantSignDTO.getOldSign();//原始签名
        String signStr = smsMerchantSignDTO.getSign();//签名
        String industryType = smsMerchantSignDTO.getIndustryType();
        if(null == merchantId || ValidateHelper.isEmpty(oldSignStr) || ValidateHelper.isEmpty(signStr)
                || ValidateHelper.isEmpty(channelNo)){
            resultDO.setErrCode(SmsErrorCode.PARAMETER_NOT_NULL.getCode());
            resultDO.setErrMsg(SmsErrorCode.PARAMETER_NOT_NULL.getMsg());
            return resultDO;
        }
        if (!ValidateHelper.isEmpty(industryType)) {//添加所属行业
            param.put(YunpianConstant.INDUSTRYTYPE , industryType);
        }
        param.put(YunpianConstant.SIGN , signStr);
        Result<SignRecord> result = yunPianSignService.getSign(merchantId, channelNo, param);
        logger.info("获取签名=="+result.toString());
        if(result.getCode()!=Code.OK){
            resultDO.setErrCode(result.getCode());
            resultDO.setErrMsg(result.getMsg()+result.getDetail());
            return resultDO;
        }

        //根据原始签名查询对应签名信息
        oldSignStr = "【"+oldSignStr+"】";
        SmsMerchantSign smsMerchantSign = smsMerchantSignManager.getSign(oldSignStr, merchantId);
        if (null == smsMerchantSign) {
            resultDO.setErrCode(SmsErrorCode.ENTITY_IS_NULL.getCode());
            resultDO.setErrMsg(SmsErrorCode.ENTITY_IS_NULL.getMsg());
            return resultDO;
        }

        param.put(YunpianConstant.OLD_SIGN , oldSignStr);
        Result<Sign> result1 = yunPianSignService.updateSign(merchantId, channelNo, param);
        logger.info("修改签名=="+result.toString());
        if(result1.getCode() != Code.OK){
            resultDO.setErrCode(result1.getCode());
            resultDO.setErrMsg(result1.getMsg()+","+result1.getDetail());
            return resultDO;
        }
        Sign sign = result1.getData();
        smsMerchantSign.setMerchantSign(sign.getSign());//商户签名
        smsMerchantSign.setIndustryType(sign.getIndustry_type());
        SmsSignDTO smsSignDTO = new SmsSignDTO();

        //禅道BUG#1747，缺少signId字段，20170410，by:chenxs
        smsSignDTO.setSignId(signId);

        smsSignDTO.setApplyState(sign.getApply_state());
        smsSignDTO.setSign(sign.getSign());
        smsSignDTO.setIndustryType(sign.getIndustry_type());
        smsMerchantSignManager.updateSignById(smsMerchantSign);

        resultDO.setSuccess(true);
        resultDO.setErrCode(result.getCode());
        resultDO.setData(smsSignDTO);
        return resultDO;
    }

    @Override
    public ResultDO<SmsSignDTO> getSignById(Long signId) {
        ResultDO<SmsSignDTO> resultDO = new ResultDO<>();
        SmsSignDTO result = new SmsSignDTO();
        if(null == signId){
            resultDO.setErrCode(SmsErrorCode.SIGN_ID_NOT_NULL.getCode());
            resultDO.setErrMsg(SmsErrorCode.SIGN_ID_NOT_NULL.getMsg());
            return resultDO;
        }
        SmsMerchantSign smsMerchantSign = smsMerchantSignManager.getSignById(signId);
        if(smsMerchantSign!=null){
            result.setSignId(smsMerchantSign.getId());
            result.setSign(smsMerchantSign.getMerchantSign());
            result.setChannelNo(smsMerchantSign.getChannelNo());
            result.setCheckStatus(AuditStatus.getNameByValue(smsMerchantSign.getSignStatus()));
            result.setRemark(smsMerchantSign.getReason());
            resultDO.setSuccess(true);
            resultDO.setData(result);
            return resultDO;
        }
        return resultDO;
    }

   /* @Override
    public ResultDO<List<SmsMerchantSign>> querySignByMerchantId(Long merchantId) {
        ResultDO<List<SmsMerchantSign>> resultDO = new ResultDO<>();
        if(null == merchantId){
            resultDO.setErrMsg("商户ID不能为空");
            return resultDO;
        }
        List<SmsMerchantSign> list = smsMerchantSignManager.querySignByMerchantId(merchantId);
        resultDO.setSuccess(true);
        resultDO.setData(list);
        return resultDO;
    }*/
}
