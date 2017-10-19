package com.shfc.cloud.account.kafka;

import com.shfc.cloud.account.dao.ServiceLeftSourceMapper;
import com.shfc.cloud.account.dao.ServiceSourceLogMapper;
import com.shfc.cloud.account.domain.ServiceLeftSource;
import com.shfc.cloud.account.domain.ServiceSourceLog;
import com.shfc.cloud.account.dto.DeductDTO;
import com.shfc.cloud.account.query.DeductQuery;
import com.shfc.common.date.DateUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.kafka.comsumer.BaseKafkaConsumerService;
import com.shfc.kafka.exception.BreakRepeatException;
import com.shfc.kafka.exception.NeedRepeatException;
import com.shfc.kafka.exception.NoNeedRepeatException;
import com.shfc.log.LogFileUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package com.shfc.cloud.account.kafka.KafkaAccountServiceImpl
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/23 20:03
 * version V1.0.0
 */
@Service
public class KafkaAccountServiceImpl implements BaseKafkaConsumerService {

    private LogFileUtils logFileUtils = LogFileUtils.getInstance("account-provider");

    @Autowired(required = false)
    private ServiceLeftSourceMapper serviceLeftSourceMapper;

    @Autowired(required = false)
    private ServiceSourceLogMapper serviceSourceLogMapper;

    @Override
    public String consumeMessage(String message)
        throws NeedRepeatException, NoNeedRepeatException, BreakRepeatException {
        ResultDO result = new ResultDO();
        JSONObject object = JSONObject.fromObject(message);
        Long startTimeMillis = System.currentTimeMillis();//获取当前系统时间
        DeductQuery deductQuery = (DeductQuery)JSONObject.toBean(object,DeductQuery.class);
        try{
            DeductDTO deductDTO = new DeductDTO(deductQuery.getMerchantId(),deductQuery.getChannelNo(),deductQuery.getType().getTypeid());
            ServiceLeftSource serviceLeftSource = serviceLeftSourceMapper.selectByTypeId(deductDTO);
            if(serviceLeftSource!=null && serviceLeftSource.getId()!=null){
                double leftNum = serviceLeftSource.getLeftNum();
                if(leftNum<deductQuery.getNumber()){//余额不够
                    logFileUtils.error("[商户服务]扣除余额(kafka消费)错误原因:余额不够;",deductQuery.getMerchantId(),deductQuery.getChannelNo(),KafkaAccountServiceImpl.class,"deductBalance",startTimeMillis);
                    result.setSuccess(false);
                    result.setErrMsg("余额不够");
                    return "false";
//                    throw new NeedRepeatException();//重新执行这个消息
                }else{
                    leftNum = leftNum - deductQuery.getNumber();
                    serviceLeftSource.setLeftNum(leftNum);
                    serviceLeftSourceMapper.updateByPrimaryKeySelective(serviceLeftSource);
                    ServiceSourceLog serviceSourceLog = new ServiceSourceLog();
                    serviceSourceLog.setTypeId(serviceLeftSource.getTypeId());
                    serviceSourceLog.setTypeName(deductQuery.getType().getMsg());
                    serviceSourceLog.setMerchantId(deductQuery.getMerchantId().intValue());
                    serviceSourceLog.setChannelNumber(deductQuery.getChannelNo());
                    serviceSourceLog.setNum(deductQuery.getNumber());
                    serviceSourceLog.setCreateTime(DateUtils.getCurrentDate());
                    serviceSourceLogMapper.insert(serviceSourceLog);
                    logFileUtils.info("[商户服务]扣除余额(kafka消费);",deductQuery.getMerchantId(),deductQuery.getChannelNo(),KafkaAccountServiceImpl.class,"deductBalance",startTimeMillis);
                }
            }else{
                logFileUtils.error("[商户服务]扣除余额(kafka消费);未找到该资源",deductQuery.getMerchantId(),deductQuery.getChannelNo(),KafkaAccountServiceImpl.class,"deductBalance",startTimeMillis);
                result.setSuccess(false);
                result.setErrMsg("未找到该资源");
                return result.toString();
            }
        }catch (Exception ex){
            logFileUtils.error("[商户服务]扣除余额(kafka消费);错误原因:"+ex.getMessage(),deductQuery.getMerchantId(),deductQuery.getChannelNo(),KafkaAccountServiceImpl.class,"deductBalance",startTimeMillis);
            //throw new NeedRepeatException();//重新执行这个消息
        }
        return "true";
    }
}
