package com.shfc.sms.service;

import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.sms.domain.SmsMerchantSign;
import com.shfc.sms.domain.SmsMerchantTemplate;
import com.shfc.sms.dto.SmsMerchantTemplateDTO;
import com.shfc.sms.dto.TemplateResultDTO;
import com.shfc.sms.enums.AuditStatus;
import com.shfc.sms.enums.SmsErrorCode;
import com.shfc.sms.manager.SmsMerchantTemplateManager;
import com.shfc.sms.yunpian.YunPianTemplateService;
import com.yunpian.sdk.constant.Code;
import com.yunpian.sdk.constant.YunpianConstant;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.Template;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package com.shfc.sms.service.SmsMerchantTemplateServiceImpl
 * @Description: 商户短信模板
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/1 14:42
 * version V1.0.0
 */
@Service
public class SmsMerchantTemplateServiceImpl implements SmsMerchantTemplateService {
    private static final Logger logger = Logger.getLogger(SmsMerchantTemplateServiceImpl.class);


    @Autowired(required = false)
    private YunPianTemplateService templateService;
    @Autowired(required = false)
    private SmsMerchantTemplateManager smsMerchantTemplateManager;

    @Override
    public ResultDO<TemplateResultDTO> addTemplate(SmsMerchantTemplateDTO dto) {
        ResultDO<TemplateResultDTO> resultDO = new ResultDO<TemplateResultDTO>();
        TemplateResultDTO templateResultDTO = new TemplateResultDTO();
        Map<String, String> param = new HashMap<String, String>();
        Long merchantId = dto.getMerchantId();//商户id
        String channelNo=dto.getChannelNo();
        Long smsSignId = dto.getSignId();//商户签名id
        String tplContent = dto.getTplContent();
        if (merchantId == null ||ValidateHelper.isEmpty(channelNo)|| smsSignId == null || ValidateHelper.isEmpty(tplContent)) {
            resultDO.setErrCode(SmsErrorCode.PARAMETER_NOT_NULL.getCode());
            resultDO.setErrMsg(SmsErrorCode.PARAMETER_NOT_NULL.getMsg());
            return resultDO;
        }
        //取签名
        SmsMerchantSign smsMerchantSign = smsMerchantTemplateManager.querySignBySignId(smsSignId);
        if (smsMerchantSign == null) {
            resultDO.setErrCode(SmsErrorCode.ENTITY_IS_NULL.getCode());
            resultDO.setErrMsg(SmsErrorCode.ENTITY_IS_NULL.getMsg());
            return resultDO;
        }
        logger.info("获取签名==" + smsMerchantSign.toString());
        //拼接模板内容
        StringBuffer content = new StringBuffer();
        content.append(smsMerchantSign.getMerchantSign()).append(tplContent);

        param.put(YunpianConstant.TPL_CONTENT, content.toString());

        Result<Template> result = templateService.addTemplate(dto.getMerchantId(),channelNo, param);
        logger.info("新增模板==" + result.toString());

        if (result.getCode() != Code.OK) {
            resultDO.setErrCode(result.getCode());
            resultDO.setErrMsg(result.getMsg() + result.getDetail());
            return resultDO;
        }
        Template tpl = result.getData();
        templateResultDTO.setTplContent(tpl.getTpl_content());//返回模板内容
        templateResultDTO.setCheckStatus(tpl.getCheck_status());//返回创建结果
        dto.setChannelTplId(tpl.getTpl_id());
        Long tplId  = smsMerchantTemplateManager.addTpl(dto, templateResultDTO);
        templateResultDTO.setTplId(tplId);//返回主键ID
        resultDO.setData(templateResultDTO);
        resultDO.setSuccess(true);
        return resultDO;

    }

    @Override
    public ResultDO<List<TemplateResultDTO>> getTemplate(SmsMerchantTemplateDTO dto) {
        ResultDO<List<TemplateResultDTO>> resultDO = new ResultDO<List<TemplateResultDTO>>();

        if (dto.getMerchantId() == null||ValidateHelper.isEmpty(dto.getChannelNo())) {
            resultDO.setErrCode(SmsErrorCode.PARAMETER_NOT_NULL.getCode());
            resultDO.setErrMsg(SmsErrorCode.PARAMETER_NOT_NULL.getMsg());
            return resultDO;
        }
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("merchantId", dto.getMerchantId());
        param.put("channelNo", dto.getChannelNo());
        param.put("tplId", dto.getTplId());
        List<TemplateResultDTO> list = smsMerchantTemplateManager.queryTplByTplId(param);
        //审核状态
        if (list.size() > 0) {
            for (TemplateResultDTO tem:list) {
                tem.setCheckStatus(AuditStatus.getNameByValue(Integer.parseInt(tem.getCheckStatus())));
            }
        }

        resultDO.setData(list);
        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public ResultDO<TemplateResultDTO> updateTemplate(SmsMerchantTemplateDTO dto) {
        ResultDO<TemplateResultDTO> resultDO = new ResultDO<TemplateResultDTO>();
        TemplateResultDTO templateResultDTO = new TemplateResultDTO();
        Long tplId = dto.getTplId();
        Long smsSignId = dto.getSignId();//商户签名id
        String tplContent = dto.getTplContent();
        //查询 通道模板ID
        SmsMerchantTemplate record  = smsMerchantTemplateManager.selectByPrimaryKey(tplId);//根据主键查询本地数据库记录
        if(record==null){
            resultDO.setErrCode(SmsErrorCode.ENTITY_IS_NULL.getCode());
            resultDO.setErrMsg(SmsErrorCode.ENTITY_IS_NULL.getMsg());
            return resultDO;
        }
        Long channelTplId = record.getChannelTplId();//通道模板ID，云片模板ID
        if (dto.getMerchantId() == null ||ValidateHelper.isEmpty(dto.getChannelNo())|| ValidateHelper.isEmpty(channelTplId) || ValidateHelper.isEmpty(tplContent)) {
            resultDO.setErrCode(SmsErrorCode.PARAMETER_NOT_NULL.getCode());
            resultDO.setErrMsg(SmsErrorCode.PARAMETER_NOT_NULL.getMsg());
            return resultDO;
        }
        Map<String, String> param = new HashMap<String, String>();
        param.put(YunpianConstant.TPL_ID, String.valueOf(channelTplId));

        Result<List<Template>> result = templateService.getTemplate(dto.getMerchantId(),dto.getChannelNo(), param);
        logger.info("获取模板信息===="+result.toString());

        if (result.getCode() != Code.OK) {
            resultDO.setErrCode(result.getCode());
            resultDO.setErrMsg(result.getMsg() + result.getDetail());
            return resultDO;
        }
        //取签名
        SmsMerchantSign smsMerchantSign = smsMerchantTemplateManager.querySignBySignId(smsSignId);
        if (smsMerchantSign == null) {
            resultDO.setErrCode(SmsErrorCode.ENTITY_IS_NULL.getCode());
            resultDO.setErrMsg(SmsErrorCode.ENTITY_IS_NULL.getMsg());
            return resultDO;
        }
        //拼接模板内容
        StringBuffer content = new StringBuffer();
        content.append(smsMerchantSign.getMerchantSign()).append(tplContent);

        param.put(YunpianConstant.TPL_CONTENT, content.toString());
        Result<Template> result1 = templateService.updateTemplate(dto.getMerchantId(),dto.getChannelNo(), param);
        logger.info("修改模板信息===="+result1.toString());

        if (result1.getCode() != Code.OK) {
            resultDO.setErrCode(result1.getCode());
            resultDO.setErrMsg(result1.getMsg() + result1.getDetail());
            return resultDO;
        }
        Template tpl = result1.getData();
        logger.info("修改模板===="+tpl.toString());
        templateResultDTO.setTplId(tplId);
        templateResultDTO.setTplContent(tpl.getTpl_content());
        templateResultDTO.setCheckStatus(tpl.getCheck_status());
        templateResultDTO.setReason(tpl.getReason());
        dto.setChannelTplId(tpl.getTpl_id());//保存最新返回的模板ID
        smsMerchantTemplateManager.updateTpl(dto, templateResultDTO);
        resultDO.setData(templateResultDTO);
        resultDO.setSuccess(true);
        return resultDO;

    }

    @Override
    public ResultDO<TemplateResultDTO> deleteTemplate(SmsMerchantTemplateDTO dto) {
        ResultDO<TemplateResultDTO> resultDO = new ResultDO<TemplateResultDTO>();
        TemplateResultDTO templateResultDTO = new TemplateResultDTO();
        Long merchantId  = dto.getMerchantId();//商户Id
        String channelNo = dto.getChannelNo();//频道号

        if(merchantId ==null || ValidateHelper.isEmptyString(channelNo)){
            resultDO.setErrCode(SmsErrorCode.PARAMETER_NOT_NULL.getCode());
            resultDO.setErrMsg(SmsErrorCode.PARAMETER_NOT_NULL.getMsg());
            return resultDO;
        }

        //查询 通道模板ID
        SmsMerchantTemplate record  = smsMerchantTemplateManager.selectByPrimaryKey(dto.getTplId());//根据主键查询本地数据库记录
        if(record==null){
            resultDO.setErrCode(SmsErrorCode.ENTITY_IS_NULL.getCode());
            resultDO.setErrMsg(SmsErrorCode.ENTITY_IS_NULL.getMsg());
            return resultDO;
        }
        Long channelTplId = record.getChannelTplId();//通道模板ID，云片模板ID
        logger.info("删除的模板ID==="+channelTplId);
        Map<String, String> map = new HashMap<String, String>();
        map.put(YunpianConstant.TPL_ID, String.valueOf(channelTplId));

        Result<Template> result = templateService.deleteTemplate(dto.getMerchantId(),dto.getChannelNo(), map);
        logger.info("删除模板==="+result.toString());
        if (result.getCode() != Code.OK) {
            resultDO.setErrCode(result.getCode());
            resultDO.setErrMsg(result.getMsg() + result.getDetail());
            return resultDO;
        }
        Template tpl = result.getData();
        templateResultDTO.setTplId(tpl.getTpl_id());
        templateResultDTO.setCheckStatus(tpl.getCheck_status());
        templateResultDTO.setReason(tpl.getReason());

        smsMerchantTemplateManager.delTpl(dto, templateResultDTO);
        resultDO.setData(templateResultDTO);
        resultDO.setSuccess(true);
        return resultDO;
    }

}
