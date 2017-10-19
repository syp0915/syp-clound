package com.shfc.sms.manager;

import com.shfc.common.base.Logger;
import com.shfc.common.date.DateUtils;
import com.shfc.common.exception.AppException;
import com.shfc.mybatis.pagination.Page;
import com.shfc.sms.dao.SmsMerchantSignMapper;
import com.shfc.sms.domain.SmsMerchantSign;
import com.shfc.sms.dto.SmsMerchantSignDTO;
import com.shfc.sms.dto.SmsSignDTO;
import com.shfc.sms.enums.AuditStatus;
import com.shfc.sms.enums.ChannelType;
import com.shfc.sms.enums.YesNo;
import com.shfc.sms.yunpian.YunPianSignService;
import com.yunpian.sdk.constant.Code;
import com.yunpian.sdk.constant.YunpianConstant;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.Sign;
import com.yunpian.sdk.model.SignRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package com.shfc.sms.manager.SmsMerchantSignManager
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/3/6 下午3:45
 * version V1.0.0
 */
@Service
public class SmsMerchantSignManager {
    @Autowired
    private SmsMerchantSignMapper smsMerchantSignMapper;
    @Autowired
    private YunPianSignService yunPianSignService;

    @Transactional(rollbackFor = AppException.class)
    public Long addMerchantSign(SmsMerchantSignDTO smsMerchantSignDTO , SmsSignDTO smsSignDTO) {
        SmsMerchantSign record = new SmsMerchantSign();
        record.setMerchantId(smsMerchantSignDTO.getMerchantId());//商户id
        record.setChannelNo(smsMerchantSignDTO.getChannelNo());//频道号
        record.setMerchantSign(smsSignDTO.getSign());//商户签名
        record.setSignStatus(AuditStatus.getValueByName(smsSignDTO.getApplyState()));//签名状态
        record.setReason(smsSignDTO.getRemark());
        record.setChannel(ChannelType.YUNPIAN.getValue());//短信通道 0-云片
        record.setIsVip(YesNo.NO.getValue());//是否专用通道 0－否，1-是
        record.setIndustryType(smsSignDTO.getIndustryType());//行业类型
        record.setCreater(smsMerchantSignDTO.getMerchantId());//创建人
        try {
            smsMerchantSignMapper.insert(record);
            return record.getId();
        }catch ( Exception e ){
            Logger.error(SmsMerchantSignManager.class, "addMerchantSign数据库修改异常", e);
        }
        return null;
    }

    public SmsMerchantSign getSign(String sign , Long merchantId){
        Map<String , Object> map = new HashMap();
        map.put("sign" , sign);
        map.put("merchantId" , merchantId);
        return smsMerchantSignMapper.getSign(map);
    }

    /**
     * 根据主键ID和商户ID查询签名记录
     */
    public SmsMerchantSign getSignById(Long signId,Long merchantId){
        Map<String , Object> map = new HashMap();
        map.put("id" , signId);
        map.put("merchantId" , merchantId);
        return smsMerchantSignMapper.getSignById(map);
    }

    @Transactional(rollbackFor = AppException.class)
    public void updateSignById(SmsMerchantSign record) {
        try {
            smsMerchantSignMapper.updateByPrimaryKeySelective(record);
        }catch ( Exception e ){
            Logger.error(SmsMerchantSignManager.class, "updateSignById数据库修改异常", e);
        }
    }

    /**
     * 根据签名ID查询签名
     * @param signId
     * @return
     */
    public SmsMerchantSign getSignById(Long signId){
        return smsMerchantSignMapper.selectByPrimaryKey(signId);
    }

    /**
     * 根据商户ID查询签名
     * @param merchantId
     * @return
     */
    public List<SmsMerchantSign> querySignByMerchantId(Long merchantId){
        return smsMerchantSignMapper.querySignByMerchantId(merchantId);
    }

    /**
     * 分页查询签名
     * @return
     */
    public Page<SmsMerchantSign> querySign(Page<SmsMerchantSign> page) {
        smsMerchantSignMapper.querySign(page);
        return page;
    }

    /**
     * 定时更新签名审核状态
     */
    public void syncSign() {
        Logger.info(SmsMerchantSignManager.class, DateUtils.getCurrentTime() + "开始签名审核状态查询服务");
        Page<SmsMerchantSign>  page = querySign(new Page<SmsMerchantSign>(1,50));
        //分页更新数据
        for (int number = 1 ; number <= page.getTotalPage() ; number ++) {
            Page<SmsMerchantSign>  resultPage = querySign(new Page<SmsMerchantSign>(number,50));
            resultPage = querySign(resultPage);
            //更新数据
            if (null != resultPage.getData()) {
                for (SmsMerchantSign smsMerchantSign:resultPage.getData()) {
                    Map<String, String> param = new HashMap<>();
                    param.put(YunpianConstant.SIGN, smsMerchantSign.getMerchantSign());
                    Result<SignRecord> result = yunPianSignService.getSign(smsMerchantSign.getMerchantId(),smsMerchantSign.getChannelNo(), param);
                    Logger.info(SmsMerchantSignManager.class, "获取签名==" + result.toString());
                    if (result.getCode() == Code.OK) {
                        SignRecord signRecord = result.getData();
                        for (Sign sign : signRecord.getSign()) {
                            Map<String , Object> map = new HashMap();
                            map.put("sign" , sign.getSign());
                            map.put("merchantId" , null);
                            SmsMerchantSign record = smsMerchantSignMapper.getSign(map);
                            record.setSignStatus(AuditStatus.getValueByName(sign.getCheck_status()));
                            record.setReason(sign.getRemark());
                            try {
                                smsMerchantSignMapper.updateByPrimaryKeySelective(record);
                            } catch ( Exception e ) {
                                Logger.error(SmsMerchantSignManager.class, "定时更新签名审核状态异常", e);
                            }
                        }
                    }

                }
            }
        }
    }
}
