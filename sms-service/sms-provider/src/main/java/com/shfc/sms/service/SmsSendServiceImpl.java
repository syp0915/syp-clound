package com.shfc.sms.service;

import com.alibaba.fastjson.JSONObject;
import com.shfc.common.base.RegexUtils;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.exception.AppException;
import com.shfc.common.result.ResultDO;
import com.shfc.sms.domain.SmsBatchRecord;
import com.shfc.sms.domain.SmsMerchantTemplate;
import com.shfc.sms.domain.SmsRecord;
import com.shfc.sms.dto.SendSmsDTO;
import com.shfc.sms.dto.SmsBatchResultDTO;
import com.shfc.sms.dto.SmsResultDTO;
import com.shfc.sms.enums.ChannelType;
import com.shfc.sms.enums.SmsErrorCode;
import com.shfc.sms.enums.SmsLogStatus;
import com.shfc.sms.enums.YesNo;
import com.shfc.sms.manager.SmsMerchantTemplateManager;
import com.shfc.sms.manager.SmsRecordManager;
import com.shfc.sms.yunpian.YunPianSmsService;
import com.yunpian.sdk.constant.YunpianConstant;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsBatchSend;
import com.yunpian.sdk.model.SmsSingleSend;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Package com.shfc.sms.service.SmsSendServiceImpl
 * @Description: 发送短信服务
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/1 14:45
 * version V1.0.0
 */
@Service
public class SmsSendServiceImpl implements SmsSendService {
    private static final Logger logger = Logger.getLogger(SmsSendServiceImpl.class);
    @Autowired
    private YunPianSmsService yunPianSmsService;
    @Autowired
    private SmsRecordManager smsRecordManager;
    @Autowired
    private SmsMerchantTemplateManager smsMerchantTemplateManager;

    @Override
    public ResultDO<SmsResultDTO> singleSend(SendSmsDTO sendSmsDTO) {
        ResultDO<SmsResultDTO> resultDO = new ResultDO<>();
        SmsResultDTO smsResultDTO = new SmsResultDTO();
        String mobile = sendSmsDTO.getMobile();//手机号
        String text = sendSmsDTO.getText();//短信内容
        Long merchantId = sendSmsDTO.getMerchantId();//商户id
        String channelNo = sendSmsDTO.getChannelNo();//频道号
        Long templateId = sendSmsDTO.getTemplateId();
        String checkParam = checkSingleSend(merchantId,mobile,text,channelNo, templateId);
        if(checkParam!=null){
            resultDO.setErrCode(SmsErrorCode.getValueByName(checkParam));
            resultDO.setErrMsg(checkParam);
            return resultDO;
        }

        //修改禅道BUG#1774，20170412，by chenxiushen
        SmsMerchantTemplate smsMerchantTemplate = smsMerchantTemplateManager.selectByPrimaryKey(templateId);
        if(smsMerchantTemplate == null){
            resultDO.setErrCode(SmsErrorCode.SIGN_ERROR_CONTENT.getCode());
            resultDO.setErrMsg(SmsErrorCode.SIGN_ERROR_CONTENT.getMsg());
            return resultDO;
        }
        String tempStr = smsMerchantTemplate.getContent();
        Integer start = tempStr.indexOf("【");
        Integer end = tempStr.indexOf("】");
        if(start == -1 || end == -1){
            resultDO.setErrCode(SmsErrorCode.SIGN_ERROR_CONTENT.getCode());
            resultDO.setErrMsg(SmsErrorCode.SIGN_ERROR_CONTENT.getMsg());
            return resultDO;
        }
        StringBuilder sign = new StringBuilder(tempStr.substring(start, end + 1));
        String content = sign.append(text).toString();
        logger.info("content="+content);

        Map<String, String> queryMap = new HashMap<>();
        queryMap.put(YunpianConstant.MOBILE,mobile);
        queryMap.put(YunpianConstant.TEXT,content);
        Result<SmsSingleSend> yunpianResult = yunPianSmsService.smsSingleSend(merchantId, sendSmsDTO.getChannelNo(), queryMap);
        logger.info("singleSend=="+yunpianResult.toString());
        if(yunpianResult.getCode().intValue()!=0){
            resultDO.setErrCode(SmsErrorCode.SMS_OPERATOR_ERROR.getCode());
            resultDO.setErrMsg(yunpianResult.getMsg()+yunpianResult.getDetail());
            return resultDO;
        }else {
            SmsSingleSend smsSingleSend = yunpianResult.getData();
            SmsRecord record = new SmsRecord();//本地数据库实体
            record.setMerchantId(merchantId);//商户id
            record.setChannelNo(channelNo);
            record.setMobile(sendSmsDTO.getMobile());//手机号
            record.setContent(sendSmsDTO.getText());//内容
            record.setSmsFee(new BigDecimal(smsSingleSend.getFee()));//短信费用
            record.setSmsUnit(smsSingleSend.getUnit());//计费单位默认RMB
            record.setSendCount(smsSingleSend.getCount());//发送条数
            record.setSendStatus(smsSingleSend.getCode());//发送状态
            record.setChannelSid(smsSingleSend.getSid());//短信id
            record.setTemplateId(sendSmsDTO.getTemplateId());//商户短信模板id
            record.setChannel(ChannelType.YUNPIAN.getValue());//短信通道(0-云片)
            record.setCreater(merchantId);
            try {
                smsRecordManager.insertSmsRecord(record);
            } catch (AppException e) {
                logger.error("单条短信插入异常" , e);
            }
//            smsResultDTO.setSid(record.getId());
            smsResultDTO.setCode(smsSingleSend.getCode());
            smsResultDTO.setMsg("发送成功");
            smsResultDTO.setMobile(sendSmsDTO.getMobile());
            smsResultDTO.setCount(smsSingleSend.getCount());
            //smsResultDTO.setMsgId(String.valueOf(System.currentTimeMillis()));
            resultDO.setSuccess(true);
            resultDO.setData(smsResultDTO);
            return resultDO;
        }
    }

    /**
     * 批量发送相同内容的短信
     * @param sendSmsDTO
     * @return
     */
    @Override
    public ResultDO<SmsBatchResultDTO> batchSend(SendSmsDTO sendSmsDTO) {
        ResultDO<SmsBatchResultDTO> resultDO = new ResultDO<>();
        SmsBatchResultDTO batchResultDTO = new SmsBatchResultDTO();
        List<SmsResultDTO> nativeList = new ArrayList<>();
        String mobile = sendSmsDTO.getMobile();
        String text = sendSmsDTO.getText();
        Long merchantId = sendSmsDTO.getMerchantId();//商户id
        String channelNo = sendSmsDTO.getChannelNo();//频道号
        Long templateId = sendSmsDTO.getTemplateId();//模板ID
        String checkParam = checkBatchSend(merchantId,mobile,text,channelNo,templateId);
        if(checkParam != null){
            resultDO.setErrMsg(checkParam);
            return resultDO;
        }

        //修改禅道BUG#1774，20170412，by chenxiushen
        SmsMerchantTemplate smsMerchantTemplate = smsMerchantTemplateManager.selectByPrimaryKey(templateId);
        if(smsMerchantTemplate == null){
            resultDO.setErrCode(SmsErrorCode.SIGN_ERROR_CONTENT.getCode());
            resultDO.setErrMsg(SmsErrorCode.SIGN_ERROR_CONTENT.getMsg());
            return resultDO;
        }
        String tempStr = smsMerchantTemplate.getContent();
        Integer start = tempStr.indexOf("【");
        Integer end = tempStr.indexOf("】");
        if(start == -1 || end == -1){
            resultDO.setErrCode(SmsErrorCode.SIGN_ERROR_CONTENT.getCode());
            resultDO.setErrMsg(SmsErrorCode.SIGN_ERROR_CONTENT.getMsg());
            return resultDO;
        }
        StringBuilder sign = new StringBuilder(tempStr.substring(start, end + 1));
        String content = sign.append(text).toString();
        logger.info("content="+content);

        Map<String, String> queryMap = new HashMap<>();
        queryMap.put(YunpianConstant.MOBILE,mobile);
        queryMap.put(YunpianConstant.TEXT,content);
        Result<SmsBatchSend> batchSend = yunPianSmsService.smsBatchSend(merchantId, sendSmsDTO.getChannelNo(), queryMap);
       /* String str= "{\"total_count\":4,\"total_fee\":\"0.4000\",\"unit\":\"RMB\",\"data\":[{\"code\":0,\"msg\":\"发送成功\",\"count\":1,\"fee\":0.05,\"unit\":\"RMB\",\"mobile\":\"13000000000\",\"sid\":3310228964},{\"code\":0,\"msg\":\"发送成功\",\"count\":1,\"fee\":0.05,\"unit\":\"RMB\",\"mobile\":\"13000000001\",\"sid\":3310228965},{\"code\":0,\"msg\":\"发送成功\",\"count\":1,\"fee\":0.05,\"unit\":\"RMB\",\"mobile\":\"13000000002\",\"sid\":3310228966},{\"code\":0,\"msg\":\"发送成功\",\"count\":1,\"fee\":0.05,\"unit\":\"RMB\",\"mobile\":\"13000000000\",\"sid\":3310228967}]}";
        Result<SmsBatchSend> batchSend = new Result<>() ;
        SmsBatchSend tempRecord  = JSONObject.parseObject(str, SmsBatchSend.class);
        batchSend.setData(tempRecord);*/

        logger.info("batchSend=="+batchSend.toString());
        if(batchSend.getCode().intValue()!=0){
            resultDO.setErrCode(SmsErrorCode.SMS_OPERATOR_ERROR.getCode());
            resultDO.setErrMsg(batchSend.getMsg());
            return resultDO;
        }else {
            SmsBatchSend smsBatchSend = batchSend.getData();
            SmsBatchRecord record = new SmsBatchRecord();//本地数据库实体
            record.setMerchantId(merchantId);//商户id
            record.setChannelNo(channelNo);//频道号
            record.setMobile(sendSmsDTO.getMobile());//手机号
            record.setTotalCount(smsBatchSend.getTotal_count());//批量发送成功总条数
            record.setTotalFee(new BigDecimal(smsBatchSend.getTotal_fee()));//批量发送抽取总费用
            record.setSmsUnit(smsBatchSend.getUnit());//短信通道计费单位"RMB"
            record.setContent(sendSmsDTO.getText());//发送内容
            record.setBatchType(YesNo.NO.getValue());//0批量发送相同内容，1批量发送不同内容
            record.setSendStatus(SmsLogStatus.SUCCESS.getValue());//发送状态
            record.setTemplateId(sendSmsDTO.getTemplateId());//商户短信模板id
            record.setChannel(ChannelType.YUNPIAN.getValue());//短信通道(0-云片)
            record.setCreater(merchantId);
            List<SmsSingleSend> singData = smsBatchSend.getData();//批量发送接口返回的单条发送结果
            try {
                Long batchId  = smsRecordManager.batchSend(record);//保存批量记录
                List<SmsRecord> target = new ArrayList<>();
                changeValue(singData,target,sendSmsDTO,batchId);//取出data保存批量发送的明细短信
                smsRecordManager.insertSmsList(target);//保存明细
            } catch (AppException e) {
                logger.error("批量相同内容短信插入异常" , e);
            }
            change(singData,nativeList);
            resultDO.setSuccess(true);
            batchResultDTO.setTotalCount(smsBatchSend.getTotal_count());
            batchResultDTO.setDataList(nativeList);
            resultDO.setData(batchResultDTO);
            return resultDO;
        }
    }

    /**
     * 批量发送不同内容的短信
     * @param sendSmsDTO
     * @return
     */
    @Override
    public ResultDO<SmsBatchResultDTO> multiSend(SendSmsDTO sendSmsDTO) {
        ResultDO<SmsBatchResultDTO> resultDO = new ResultDO<>();
        SmsBatchResultDTO batchResultDTO = new SmsBatchResultDTO();
        List<SmsResultDTO> nativeList = new ArrayList<>();
        Map<String, String> queryMap = new HashMap<>();
        String mobile = sendSmsDTO.getMobile();//批量手机号
        String text = sendSmsDTO.getText();//不同的内容
        Long merchantId = sendSmsDTO.getMerchantId();//商户id
        String channelNo = sendSmsDTO.getChannelNo();//频道号
        Long templateId = sendSmsDTO.getTemplateId();//模板ID
        String checkParam  = checkMulti(merchantId,mobile,text,channelNo, templateId);
        if(checkParam!=null){
            resultDO.setErrMsg(checkParam);
            return resultDO;
        }

        //修改禅道BUG#1774，20170412，by chenxiushen
        SmsMerchantTemplate smsMerchantTemplate = smsMerchantTemplateManager.selectByPrimaryKey(templateId);
        if(smsMerchantTemplate == null){
            resultDO.setErrCode(SmsErrorCode.SIGN_ERROR_CONTENT.getCode());
            resultDO.setErrMsg(SmsErrorCode.SIGN_ERROR_CONTENT.getMsg());
            return resultDO;
        }
        String tempStr = smsMerchantTemplate.getContent();
        Integer start = tempStr.indexOf("【");
        Integer end = tempStr.indexOf("】");
        if(start == -1 || end == -1){
            resultDO.setErrCode(SmsErrorCode.SIGN_ERROR_CONTENT.getCode());
            resultDO.setErrMsg(SmsErrorCode.SIGN_ERROR_CONTENT.getMsg());
            return resultDO;
        }
        String sign = tempStr.substring(start, end + 1);
        String[] textArray = text.split(",");
        StringBuilder newContent =  new StringBuilder();
        newContent.append(sign);
        newContent.append(textArray[0]);
        for(int i = 1; i < textArray.length; i++){
            newContent.append(",");
            newContent.append(sign);
            newContent.append(textArray[i]);
        }
        logger.info("content="+newContent);

        queryMap.put(YunpianConstant.MOBILE,mobile);
        queryMap.put(YunpianConstant.TEXT,newContent.toString());
        Result<SmsBatchSend> batchSend = yunPianSmsService.smsMultiSend(merchantId, sendSmsDTO.getChannelNo(), queryMap);
        /*String str= "{\"total_count\":4,\"total_fee\":\"0.4000\",\"unit\":\"RMB\",\"data\":[{\"code\":0,\"msg\":\"发送成功\",\"count\":1,\"fee\":0.05,\"unit\":\"RMB\",\"mobile\":\"13000000000\",\"sid\":3310228964},{\"code\":0,\"msg\":\"发送成功\",\"count\":1,\"fee\":0.05,\"unit\":\"RMB\",\"mobile\":\"13000000001\",\"sid\":3310228965},{\"code\":0,\"msg\":\"发送成功\",\"count\":1,\"fee\":0.05,\"unit\":\"RMB\",\"mobile\":\"13000000002\",\"sid\":3310228966},{\"code\":0,\"msg\":\"发送成功\",\"count\":1,\"fee\":0.05,\"unit\":\"RMB\",\"mobile\":\"13000000000\",\"sid\":3310228967}]}";
        Result<SmsBatchSend> batchSend = new Result<>() ;
        SmsBatchSend tempRecord  = JSONObject.parseObject(str, SmsBatchSend.class);
        batchSend.setData(tempRecord);*/

        logger.info("multiSend=="+batchSend.toString());
        if(batchSend.getCode().intValue()!=0){
            resultDO.setErrCode(SmsErrorCode.SMS_OPERATOR_ERROR.getCode());
            resultDO.setErrMsg(batchSend.getMsg());
            return resultDO;
        }else {
            SmsBatchSend smsBatchSend = batchSend.getData();
            SmsBatchRecord record = new SmsBatchRecord();//本地数据库实体
            record.setMerchantId(merchantId);//商户id
            record.setChannelNo(channelNo);//频道号
            record.setMobile(sendSmsDTO.getMobile());//手机号
            record.setTotalCount(smsBatchSend.getTotal_count());//批量发送成功总条数
            record.setTotalFee(new BigDecimal(smsBatchSend.getTotal_fee()));//批量发送抽取总费用
            record.setSmsUnit(smsBatchSend.getUnit());//短信通道计费单位"RMB"
            record.setContent(sendSmsDTO.getText());//发送内容
            record.setBatchType(YesNo.YES.getValue());//0批量发送相同内容，1批量发送不同内容
            record.setSendStatus(SmsLogStatus.SUCCESS.getValue());//发送状态
            record.setTemplateId(templateId);//商户短信模板id
            record.setChannel(ChannelType.YUNPIAN.getValue());//短信通道(0-云片)
            record.setCreater(merchantId);
            List<SmsSingleSend> singData = smsBatchSend.getData();//批量发送接口返回的单条发送结果
            try {
                Long batchId = smsRecordManager.batchSend(record);
                List<SmsRecord> target = new ArrayList<>();
                changeMultiSendValue(singData,target,sendSmsDTO,batchId);//取出data保存批量发送的明细短信
                smsRecordManager.insertSmsList(target);//保存明细
            } catch (AppException e) {
                logger.error("批量不同内容短信插入异常" , e);
            }
            change(singData,nativeList);
            resultDO.setSuccess(true);
            batchResultDTO.setTotalCount(smsBatchSend.getTotal_count());
            batchResultDTO.setDataList(nativeList);
            resultDO.setData(batchResultDTO);
            return resultDO;
        }
    }

    /**
     * 单条发送入参校验
     * @param mobile
     * @param text
     * @return
     */
    private String checkSingleSend(Long merchantId,String mobile,String text,String channelNo, Long templateId){
        if(merchantId==null || ValidateHelper.isEmptyString(channelNo) || ValidateHelper.isEmptyString(mobile) || ValidateHelper.isEmptyString(text) || ValidateHelper.isEmpty(templateId)){
            return SmsErrorCode.PARAMETER_NOT_NULL.getMsg();
        }
        if(!RegexUtils.isMobile(mobile)){
            return SmsErrorCode.PHONE_FORMAT_ERROR.getMsg();
        }
        /*if(merchantId==null){
            return "商户id不能为空！";
        }
        if(ValidateHelper.isEmptyString(mobile)){
            return "手机号不能为空！";
        }
        if(!RegexUtils.isMobile(mobile)){
            return "手机号格式不正确！";
        }
        if(ValidateHelper.isEmptyString(text)){
            return "发送内容不能为空！";
        }
        if(ValidateHelper.isEmptyString(channelNo)){
            return "频道号不能为空！";
        }*/
        return null;
    }

    /**
     * 批量发送相同内容入参校验
     * @param mobile
     * @param text
     * @return
     */
    private String checkBatchSend(Long merchantId,String mobile,String text,String channelNo,Long templateId){
        if(merchantId==null || ValidateHelper.isEmptyString(channelNo) || ValidateHelper.isEmptyString(mobile) || ValidateHelper.isEmptyString(text)){
            return SmsErrorCode.PARAMETER_NOT_NULL.getMsg();
        }
        String [] mobileArr = mobile.split(",");
        if(mobileArr.length==1){
            if(!RegexUtils.isMobile(mobile)){
                return  SmsErrorCode.PHONE_FORMAT_ERROR.getMsg();
            }
        }else {
            for(int i=0;i<mobileArr.length;i++){
                if(!RegexUtils.isMobile(mobileArr[i])){
                    return  SmsErrorCode.PHONE_FORMAT_ERROR.getMsg();
                }
            }
        }
        return null;
    }

    private String  checkMulti(Long merchantId,String mobile, String text,String channelNo,Long templateId) {
        if(merchantId==null || ValidateHelper.isEmptyString(channelNo) || ValidateHelper.isEmptyString(mobile) || ValidateHelper.isEmptyString(text) ){
            return SmsErrorCode.PARAMETER_NOT_NULL.getMsg();
        }
        String [] mobileArr = mobile.split(",");
        String [] textArr = text.split(",");
        if(mobileArr.length!=textArr.length){
            return SmsErrorCode.PHONE_MULTI_ERROR.getMsg();
        }
        if(mobileArr.length==1){
            if(!RegexUtils.isMobile(mobile)){
                return SmsErrorCode.PHONE_FORMAT_ERROR.getMsg();
            }
        }else {
            for(int i=0;i<mobileArr.length;i++){
                if(!RegexUtils.isMobile(mobileArr[i])){
                    return SmsErrorCode.PHONE_FORMAT_ERROR.getMsg();
                }
            }
        }
        return null;
    }

    public void change(List<SmsSingleSend> batchList,List<SmsResultDTO> nativeList){
        for(Iterator<SmsSingleSend> it = batchList.iterator(); it.hasNext();){
            SmsSingleSend singleSend = it.next();
            SmsResultDTO nataveDTO = new SmsResultDTO();
            BeanUtils.copyProperties(singleSend,nataveDTO);
            nativeList.add(nataveDTO);
        }
    }

    /**
     * 批量发送相同内容
     * source集合的值转到target
     * @param source
     * @param target
     */
    public void changeValue(List<SmsSingleSend> source,List<SmsRecord> target,SendSmsDTO sendSmsDTO,Long batchId){
        String mobile = sendSmsDTO.getMobile();//批量手机号
        String text = sendSmsDTO.getText();//不同的内容
        Long merchantId = sendSmsDTO.getMerchantId();//商户id
        String channelNo = sendSmsDTO.getChannelNo();//频道号
        Long templateId = sendSmsDTO.getTemplateId();//模板ID
        for(Iterator<SmsSingleSend> it = source.iterator(); it.hasNext();){
            SmsSingleSend singleSend = it.next();
            SmsRecord record = new SmsRecord();
            record.setMerchantId(merchantId);//商户id
            record.setChannelNo(channelNo);//频道号
            record.setTemplateId(templateId);
            record.setChannel(ChannelType.YUNPIAN.getValue());//短信通道(0-云片)
            record.setMobile(singleSend.getMobile());//具体的手机号
            record.setContent(text);//短信内容
            record.setSmsFee(BigDecimal.valueOf(singleSend.getFee()));//短信通道收取费用
            record.setSmsUnit(singleSend.getUnit());//费用单位
            record.setSendCount(singleSend.getCount());//计费条数
            record.setSendStatus(singleSend.getCode());//发送状态(0-成功 1-失败)
            record.setChannelSid(singleSend.getSid());//保存SID
            record.setSource(batchId);//短信记录批量发送记录的ID
            record.setCreater(merchantId);
            target.add(record);
        }
        logger.info("批量发送相同内容target==size()=="+target.size()+" ===  "+target.toString());
    }

    /**
     * 批量发送不同内容
     * @param source
     * @param target
     */
    public void changeMultiSendValue(List<SmsSingleSend> source,List<SmsRecord> target,SendSmsDTO sendSmsDTO,Long batchId){
        String mobile = sendSmsDTO.getMobile();//批量手机号
        String text = sendSmsDTO.getText();//不同的内容
        Long merchantId = sendSmsDTO.getMerchantId();//商户id
        String channelNo = sendSmsDTO.getChannelNo();//频道号
        Long templateId = sendSmsDTO.getTemplateId();//模板ID
        String [] mobileArr = mobile.split(",");
        String [] textArr = text.split(",");
        ArrayList<String> mobileList = new ArrayList<>(Arrays.asList(mobileArr));
        ArrayList<String> textList = new ArrayList<>(Arrays.asList(textArr));
        for(Iterator<SmsSingleSend> it = source.iterator(); it.hasNext();){
            SmsSingleSend singleSend = it.next();
            SmsRecord record = new SmsRecord();
            record.setMerchantId(merchantId);//商户id
            record.setChannelNo(channelNo);//频道号
            record.setChannel(ChannelType.YUNPIAN.getValue());//短信通道(0-云片)
            String returnMobile = singleSend.getMobile();
            record.setMobile(returnMobile);//具体的手机号
            String returnText  = getValueByPhone(mobileList,textList,returnMobile);
            record.setContent(returnText);//短信内容
            record.setSmsFee(BigDecimal.valueOf(singleSend.getFee()));//短信通道收取费用
            record.setSmsUnit(singleSend.getUnit());//费用单位
            record.setSendCount(singleSend.getCount());//计费条数
            record.setSendStatus(singleSend.getCode());//发送状态(0-成功 1-失败)
            record.setChannelSid(singleSend.getSid());//保存SID
            record.setTemplateId(templateId);//商户短信模板id
            record.setSource(batchId);//短信记录批量发送记录的ID
            record.setCreater(merchantId);
            target.add(record);
        }
        logger.info("批量发送不同内容target==size()=="+target.size()+" ===  "+target.toString());
    }

    /**
     *  String phone ="1381651,1328989";
     *  String text = "[上海房产]1234,【东方基恩】1234";
     *  根据手机号查询返回具体的text
     * @param mobileList
     * @param textList
     * @param findPhone
     * @return
     */
    public String getValueByPhone(ArrayList<String> mobileList,ArrayList<String> textList,String findPhone){
        int findIndex  = mobileList.indexOf(findPhone);
        String findText  = textList.get(findIndex);
        Iterator<String> mobileIt  = mobileList.iterator();
        Iterator<String> textIt = textList.iterator();
        while (mobileIt.hasNext()){
            String phoneChird = mobileIt.next();
            if(phoneChird.equals(findPhone)){
                mobileIt.remove();
                break;
            }
        }
        while (textIt.hasNext()){
            String textChird = textIt.next();
            if(textChird.equals(findText)){
                textIt.remove();
                break;
            }
        }
        return findText;
    }
}