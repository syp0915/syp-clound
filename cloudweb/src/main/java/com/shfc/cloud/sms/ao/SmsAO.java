package com.shfc.cloud.sms.ao;

import com.shfc.cloud.account.constant.DeductConstant;
import com.shfc.cloud.account.domain.ServiceLeftSource;
import com.shfc.cloud.account.query.DeductQuery;
import com.shfc.cloud.account.query.SelectLeftSourceQuery;
import com.shfc.cloud.account.service.AccountService;
import com.shfc.cloud.common.ao.BaseAO;
import com.shfc.cloud.constant.CloudConstant;
import com.shfc.cloud.sms.dto.*;
import com.shfc.cloud.utils.HttpSessionUtils;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.mybatis.pagination.Page;
import com.shfc.sms.dto.*;
import com.shfc.sms.enums.SmsErrorCode;
import com.shfc.sms.query.SmsRecordQuery;
import com.shfc.sms.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package com.shfc.cloud.sms.ao.SmsAO
 * @Description: 短信发送
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/13 10:37
 * version V1.0.0
 */
@Service
public class SmsAO extends BaseAO{
    @Autowired
    private SmsMerchantSignService smsMerchantSignService;
    @Autowired
    private SmsMerchantTemplateService smsMerchantTemplateService;
    @Autowired
    private SmsSendService smsSendService;
    @Autowired
    private SmsRecordService smsRecordService;
    @Autowired
    private SmsSendVoiceService smsSendVoiceService;
    @Autowired
    private AccountService accountService;

    public ResultDO<SmsSignDTO> addSign(SmsSignWebDTO webDTO){
        SmsMerchantSignDTO query = new SmsMerchantSignDTO();
        BeanUtils.copyProperties(webDTO,query);
        ResultDO<SmsSignDTO> resultDO = new ResultDO<SmsSignDTO>();
        resultDO=checkCommonData(query.getMerchantId(),query.getChannelNo());
        if (!resultDO.isSuccess()){
            return resultDO;
        }
        String checkResult  = checkAddSignParam(query);
        if(checkResult!=null){
            resultDO.setErrMsg(checkResult);
            return resultDO;
        }

        resultDO = smsMerchantSignService.addSign(query);
        return resultDO;

       /* Long currentMerchantId =  HttpSessionUtils.getObject(CloudConstant.CURRENT_MERCHANT_ID);
        query.setMerchantId(currentMerchantId);*/


    }

    public ResultDO<SmsSignDTO> getSignById(SmsSignWebDTO webDTO){
        SmsMerchantSignDTO query = new SmsMerchantSignDTO();
        BeanUtils.copyProperties(webDTO,query);
        ResultDO<SmsSignDTO> resultDO = new ResultDO<SmsSignDTO>();
        Long signId = query.getSignId();
        resultDO=checkCommonData(query.getMerchantId(),query.getChannelNo());
        if(!resultDO.isSuccess()){
            return resultDO;
        }
        if(signId==null){
            resultDO.setErrMsg("签名ID不能为空！");
            return resultDO;
        }
        resultDO = smsMerchantSignService.getSignById(signId);
        return resultDO;
    }

    public ResultDO<SmsSignDTO> updateSign(SmsSignWebDTO webDTO){
        SmsMerchantSignDTO query = new SmsMerchantSignDTO();
        BeanUtils.copyProperties(webDTO,query);
        ResultDO<SmsSignDTO> resultDO = new ResultDO<SmsSignDTO>();
        Long signId = query.getSignId();
        String oldSign = query.getOldSign();
        resultDO=checkCommonData(query.getMerchantId(),query.getChannelNo());
        if(!resultDO.isSuccess()){
            return resultDO;
        }
        if(signId==null){
            resultDO.setErrMsg("签名ID不能为空！");
            return resultDO;
        }
        if (ValidateHelper.isEmptyString(oldSign)){
            resultDO.setErrMsg("原签名不能为空！");
            return resultDO;
        }
        String checkResult  = checkAddSignParam(query);
        if(checkResult!=null){
            resultDO.setErrMsg(checkResult);
            return resultDO;
        }

        resultDO = smsMerchantSignService.updateSign(query);
        return resultDO;
    }

    public String checkAddSignParam(SmsMerchantSignDTO query){
        String sign =  query.getSign();
        String oldSign = query.getOldSign();
        if(ValidateHelper.isEmptyString(sign)){
            return "签名不能为空!";
        }else {
            if(sign.indexOf("【")!=-1 || sign.indexOf("】")!=-1){
                return "签名不能包含【】!";
            }
            if(sign.length()<3 || sign.length()>8){
                return "签名只能3到8个字!";
            }
            if(sign.equals("云片网")){
                return "签名内容不合法!";
            }
        }
        if (!ValidateHelper.isEmptyString(oldSign)){
            if(oldSign.indexOf("【")!=-1 || oldSign.indexOf("】")!=-1){
                return "签名不能包含【】!";
            }
            if(oldSign.length()<3 || oldSign.length()>8){
                return "签名只能3到8个字!";
            }
            if(oldSign.equals("云片网")){
                return "签名内容不合法!";
            }
        }
        return null;
    }

    /**
     * 新增频道号
     * @param webDTO
     * @return
     */
    public ResultDO<TemplateResultDTO> addTemplate(SmsTplWebDTO webDTO){
        SmsMerchantTemplateDTO query = new SmsMerchantTemplateDTO();
        BeanUtils.copyProperties(webDTO,query);
        ResultDO<TemplateResultDTO> resultDO = new ResultDO<>();
        resultDO=checkCommonData(query.getMerchantId(),query.getChannelNo());
        if(!resultDO.isSuccess()){
            return resultDO;
        }
        String checkResult  = checkAddTemParam(query);
        if(checkResult!=null){
            resultDO.setErrMsg(checkResult);
            return resultDO;
        }
        resultDO = smsMerchantTemplateService.addTemplate(query);
        return resultDO;
    }

    public ResultDO<List<TemplateResultDTO>> getTemplate(SmsTplWebDTO webDTO){
        SmsMerchantTemplateDTO query = new SmsMerchantTemplateDTO();
        BeanUtils.copyProperties(webDTO,query);
        ResultDO<List<TemplateResultDTO>> resultDO = new ResultDO<>();
        Long merchantId = query.getMerchantId();
        String channelNo  = query.getChannelNo();
        Long tplId =   query.getTplId();
        resultDO=checkCommonData(merchantId,channelNo);
        if(!resultDO.isSuccess()){
            return resultDO;
        }
        if(tplId==null){
            resultDO.setErrMsg("模板id不能为空!");
            return resultDO;
        }
        resultDO = smsMerchantTemplateService.getTemplate(query);
        return resultDO;
    }
    public ResultDO<TemplateResultDTO> updateTemplate(SmsTplWebDTO webDTO){
        SmsMerchantTemplateDTO query = new SmsMerchantTemplateDTO();
        BeanUtils.copyProperties(webDTO,query);
        ResultDO<TemplateResultDTO> resultDO = new ResultDO<>();
        Long tplId = query.getTplId();
        if(tplId ==null){
            resultDO.setErrMsg("模板id不能为空!");
            return resultDO;
        }
        resultDO=checkCommonData(query.getMerchantId(),query.getChannelNo());
        if(!resultDO.isSuccess()){
            return resultDO;
        }
        String checkResult  = checkAddTemParam(query);
        if(checkResult!=null){
            resultDO.setErrMsg(checkResult);
            return resultDO;
        }
        Long currentMerchantId =  HttpSessionUtils.getObject(CloudConstant.CURRENT_MERCHANT_ID);
        query.setMerchantId(currentMerchantId);
        resultDO = smsMerchantTemplateService.updateTemplate(query);
        return resultDO;
    }
    public ResultDO<TemplateResultDTO> deleteTemplate(SmsTplWebDTO webDTO){
        SmsMerchantTemplateDTO query = new SmsMerchantTemplateDTO();
        BeanUtils.copyProperties(webDTO,query);
        ResultDO<TemplateResultDTO> resultDO = new ResultDO<>();
        resultDO=checkCommonData(query.getMerchantId(),query.getChannelNo());
        if(!resultDO.isSuccess()){
            return resultDO;
        }
        Long tplId = query.getTplId();
        if(tplId == null){
            resultDO.setErrMsg("模板id不能为空!");
            return resultDO;
        }
        Long currentMerchantId =  HttpSessionUtils.getObject(CloudConstant.CURRENT_MERCHANT_ID);
        query.setMerchantId(currentMerchantId);
        resultDO = smsMerchantTemplateService.deleteTemplate(query);
        return resultDO;
    }

    public String checkAddTemParam(SmsMerchantTemplateDTO query){
        String tplContent = query.getTplContent();
        Long signId  = query.getSignId();

        if(ValidateHelper.isEmptyString(tplContent)){
            return "模板内容不能为空!";
        }
        if(signId == null){
            return "签名ID不能为空！";
        }
        return null;
    }

    public String checkSendParam(SendSmsDTO query){
        String mobile =  query.getMobile();
        String text =  query.getText();

        if(ValidateHelper.isEmptyString(mobile)){
            return "手机号不能为空!";
        }
        if(ValidateHelper.isEmptyString(text)){
            return "短信内容不能为空!";
        }
        return null;
    }

    public String checkVoiceParam(SendVoiceDTO query){
        String mobile =  query.getMobile();
        String code =  query.getCode();
        if(ValidateHelper.isEmptyString(mobile)){
            return "手机号不能为空!";
        }
        if(ValidateHelper.isEmptyString(code)){
            return "验证码不能为空!";
        }
        return null;
    }


    /**
     * 查询商户余量信息
     * @param query
     * @param smsType 0单条，1批量
     * @return
     */
    public String queryMerchantMargin(SendSmsDTO query, Integer smsType){
        SelectLeftSourceQuery leftSourceQuery = new SelectLeftSourceQuery() ;
        leftSourceQuery.setMerchantId(query.getMerchantId());//商户ID
        leftSourceQuery.setChannelNo(query.getChannelNo());//频道号
        leftSourceQuery.setType(DeductConstant.Message);//查询短信
        ResultDO resultDO =checkCommonData(query.getMerchantId(),query.getChannelNo());
        if(!resultDO.isSuccess()){
            return resultDO.getErrMsg();
        }
        //查询余量信息
        ResultDO<ServiceLeftSource> selectLeftSource = accountService.selectLeftSource(leftSourceQuery);
        if(!selectLeftSource.isSuccess()){
            return selectLeftSource.getErrMsg();
        }else {
            ServiceLeftSource leftSource = selectLeftSource.getData();
            if(leftSource!=null){
                Integer status = leftSource.getStatus();
                if(status.intValue()!=2){
                    return  SmsErrorCode.MERCHANT_MARGIN_ERROR.getMsg();
                }
                double leftNum  = leftSource.getLeftNum();//短信剩余量
                if(leftNum<=0){
                    return "短信剩余条数不足，请充值！";
                }
                if(smsType.intValue()==0){  //单条发送的余量校验
                    if(query.getText()!=null){
                        if(query.getText().length()>=69){
                            if(leftNum<=2){
                                return "短信内容过长，短信剩余条数可能不足，请充值！";
                            }
                        }
                    }

                }else { //批量校验
                    String [] mobileArr = query.getMobile().split(",");
                    if(mobileArr.length>=leftNum){
                        return "短信剩余条数不足，请充值！";
                    }
                }
            }else {
                return "商户余量信息不正确！";
            }
        }
        return null;
    }

    /**
     * 商户的短信余量修改
     * @param query
     * @return
     */
    public ResultDO deductBalance(SendSmsDTO query, Integer count){
        DeductQuery deductQuery = new DeductQuery();
        deductQuery.setMerchantId(query.getMerchantId());
        deductQuery.setChannelNo(query.getChannelNo());
        deductQuery.setType(DeductConstant.Message);
        deductQuery.setNumber(count);
        ResultDO resultDO =checkCommonData(query.getMerchantId(),query.getChannelNo());
        if(!resultDO.isSuccess()){
            return resultDO;
        }
        return  accountService.deductBalance(deductQuery);
    }

    /**
     * 单条发送短信
     * @param sendSmsWebDTO
     * @return
     */
    public ResultDO<SmsResultDTO> singleSend(SendSmsWebDTO sendSmsWebDTO){
        ResultDO<SmsResultDTO> resultDO = new ResultDO<>();
        SendSmsDTO query = new SendSmsDTO();
        BeanUtils.copyProperties(sendSmsWebDTO,query);
        Long templateId=query.getTemplateId();
        if(templateId==null){
            resultDO.setErrMsg("模板id不能为空");
            return resultDO;
        }
        resultDO=checkCommonData(query.getMerchantId(),query.getChannelNo());
        if(!resultDO.isSuccess()){
            return resultDO;
        }
        String checkResult  = checkSendParam(query);
        SmsMerchantTemplateDTO smsMerchantTemplateDTO=new SmsMerchantTemplateDTO();
        smsMerchantTemplateDTO.setMerchantId(sendSmsWebDTO.getMerchantId());
        smsMerchantTemplateDTO.setChannelNo(sendSmsWebDTO.getChannelNo());
        smsMerchantTemplateDTO.setTplId(sendSmsWebDTO.getTemplateId());
        //短信模板id验证
        ResultDO<List<TemplateResultDTO>>list = smsMerchantTemplateService.getTemplate(smsMerchantTemplateDTO);
        if(list==null){
            resultDO.setErrMsg("模板未审核");
            return resultDO;
        }
        if(checkResult!=null){
            resultDO.setErrMsg(checkResult);
            return resultDO;
        }
        String marginResult  = queryMerchantMargin(query,0);
        if(marginResult != null){
            resultDO.setErrMsg(marginResult);
            return resultDO;
        }else {
            //调用发送逻辑
            resultDO = smsSendService.singleSend(query);
            //发送成功，扣费
            if(resultDO.isSuccess()){
                Integer count  = resultDO.getData().getCount();
                deductBalance(query,count);
            }
            return resultDO;
        }
    }

    /**
     * 查询短信记录
     * @param webDTO
     * @return
     */
    public ResultDO<Page<SmsRecordResultDTO>> smsRecordList(SmsRecordWebDTO webDTO){
        ResultDO<Page<SmsRecordResultDTO>> resultDO = new ResultDO<>();
        SmsRecordQuery query = new SmsRecordQuery();
        BeanUtils.copyProperties(webDTO,query);
        resultDO=checkCommonData(query.getMerchantId(),query.getChannelNo());
        if(!resultDO.isSuccess()){
            return resultDO;
        }
        resultDO = smsRecordService.smsRecordList(query);
        return resultDO;
    }

    /**
     * 查询批量短信记录
     * @param webDTO
     * @return
     */
    public ResultDO<Page<SmsRecordResultDTO>> smsBatchRecordList(SmsRecordWebDTO webDTO){
        ResultDO<Page<SmsRecordResultDTO>> resultDO = new ResultDO<>();
        SmsRecordQuery query = new SmsRecordQuery();
        BeanUtils.copyProperties(webDTO,query);
        resultDO=checkCommonData(query.getMerchantId(),query.getChannelNo());
        if(!resultDO.isSuccess()){
            return resultDO;
        }
        resultDO = smsRecordService.smsBatchRecordList(query);
        return resultDO;
    }

    /**
     * 发送语音验证码
     * @param sendVoiceWebDTO
     * @return
     */
    public ResultDO<VoiceResultDTO> sendVoice(SendVoiceWebDTO sendVoiceWebDTO){
        ResultDO<VoiceResultDTO> resultDO = new ResultDO<>();
        SendVoiceDTO query = new SendVoiceDTO();
        BeanUtils.copyProperties(sendVoiceWebDTO,query);
        resultDO=checkCommonData(query.getMerchantId(),query.getChannelNo());
        if(!resultDO.isSuccess()){
            return resultDO;
        }
        String checkResult  = checkVoiceParam(query);
        if(checkResult!=null){
            resultDO.setErrMsg(checkResult);
            return resultDO;
        }
        SendSmsDTO changeQuery = new SendSmsDTO();//临时的转换类
        BeanUtils.copyProperties(query,changeQuery);
        String marginResult  = queryMerchantMargin(changeQuery,0);
        if(marginResult != null){
            resultDO.setErrMsg(marginResult);
            return resultDO;
        }else {
            //调用发送逻辑
            resultDO = smsSendVoiceService.sendVoice(query);
            //发送成功，扣费
            if(resultDO.isSuccess()){
                String count =  resultDO.getData().getCount();
                deductBalance(changeQuery,Integer.valueOf(count));
            }
            return resultDO;
        }
    }

    /**
     * 批量发送相同内容的短信
     * @param webDTO
     * @return
     */
    public ResultDO<SmsBatchResultDTO> batchSend(SendSmsWebDTO webDTO){
        ResultDO<SmsBatchResultDTO> resultDO = new ResultDO<>();
        SendSmsDTO query = new SendSmsDTO();
        BeanUtils.copyProperties(webDTO,query);
        resultDO=checkCommonData(query.getMerchantId(),query.getChannelNo());
        if(!resultDO.isSuccess()){
            return resultDO;
        }
        String checkResult  = checkSendParam(query);
        if(checkResult!=null){
            resultDO.setErrMsg(checkResult);
            return resultDO;
        }
        String marginResult  = queryMerchantMargin(query,1);//批量发送的校验
        if(marginResult != null){
            resultDO.setErrMsg(marginResult);
            return resultDO;
        }else {
            //调用发送逻辑
            resultDO = smsSendService.batchSend(query);
            //发送成功，扣费
            if(resultDO.isSuccess()){
                Integer count =  resultDO.getData().getTotalCount();
                deductBalance(query,count);
            }
            return resultDO;
        }
    }

    /**
     * 批量发送不同内容的短信
     * @param webDTO
     * @return
     */
    public ResultDO<SmsBatchResultDTO> multiSend(SendSmsWebDTO webDTO){
        ResultDO<SmsBatchResultDTO> resultDO = new ResultDO<>();
        SendSmsDTO query = new SendSmsDTO();
        BeanUtils.copyProperties(webDTO,query);
        resultDO=checkCommonData(query.getMerchantId(),query.getChannelNo());
        if(!resultDO.isSuccess()){
            return resultDO;
        }
        String checkResult  = checkSendParam(query);
        if(checkResult!=null){
            resultDO.setErrMsg(checkResult);
            return resultDO;
        }
        String marginResult  = queryMerchantMargin(query,1);//批量发送的校验
        if(marginResult != null){
            resultDO.setErrMsg(marginResult);
            return resultDO;
        }else {
            //调用发送逻辑
            resultDO = smsSendService.multiSend(query);
            //发送成功，扣费
            if(resultDO.isSuccess()){
                Integer count =  resultDO.getData().getTotalCount();
                deductBalance(query,count);
            }
            return resultDO;
        }
    }
}
