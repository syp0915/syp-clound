package com.shfc.cloud.account.manager;

import com.fc.common.redis.RedisUtil;
import com.shfc.cloud.account.constant.ErrorConstant;
import com.shfc.cloud.account.dao.MerchantApikeyMapper;
import com.shfc.cloud.account.dao.MerchantMapper;
import com.shfc.cloud.account.dao.ServiceLeftSourceMapper;
import com.shfc.cloud.account.dao.ServiceMapper;
import com.shfc.cloud.account.domain.MerchantApikey;
import com.shfc.cloud.account.domain.ServiceLeftSource;
import com.shfc.cloud.account.dto.DeductDTO;
import com.shfc.cloud.account.dto.MerchantDTO;
import com.shfc.cloud.account.dto.MerchantInfoDTO;
import com.shfc.cloud.account.kafka.KafkaAccountServiceImpl;
import com.shfc.cloud.account.query.*;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.kafka.comsumer.KafkaConsumerClient;
import com.shfc.kafka.comsumer.dto.KafkaConsumerDto;
import com.shfc.kafka.producer.KafkaMessageProducerClient;
import com.shfc.log.LogFileUtils;
import com.shfc.mybatis.pagination.Page;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.shfc.cloud.account.manager.AccountManager
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 20:27
 * version V1.0.0
 */
@Service
public class AccountManager {

    private LogFileUtils logFileUtils = LogFileUtils.getInstance("account-provider");

    @Autowired
    private KafkaMessageProducerClient kafkaMessageProducerClient;

    @Autowired
    private KafkaConsumerClient kafkaConsumerClient;

    @Autowired
    private KafkaAccountServiceImpl kafkaTestServiceImpl;

    @Autowired(required = false)
    private ServiceLeftSourceMapper serviceLeftSourceMapper;

    @Autowired(required = false)
    private MerchantMapper merchantMapper;

    @Autowired(required = false)
    private MerchantApikeyMapper merchantApikeyMapper;

    @Autowired(required = false)
    private ServiceMapper serviceMapper;

    private static String ACCOUNT_APIKEY_AUTH = "cloud_account_apikey_";

    private static String ACCOUNT_KAFAKA = "cloud_account_kafka_deductBalance";


    /**
     * 定义kafka启动
     */
    @PostConstruct
    public void InitKafkaService(){
        KafkaConsumerDto kafkaConsumerDto = kafkaConsumerClient.getKafKaConsumerDto(ACCOUNT_KAFAKA, 3,kafkaTestServiceImpl);
        List<KafkaConsumerDto> list = new ArrayList<KafkaConsumerDto>();
        list.add(kafkaConsumerDto);
        kafkaConsumerClient.kafkaConsumer(list);
    }

    /**
     * 扣除余额
     * @param deductQuery
     * @return
     */
    public ResultDO deductBalance(DeductQuery deductQuery){
        ResultDO result = new ResultDO();
        Long startTimeMillis = System.currentTimeMillis();//获取当前系统时间
        JSONObject jsonObject = JSONObject.fromObject(deductQuery);//对象转换成json
        String topic = ACCOUNT_KAFAKA;
        String message = jsonObject.toString();
        kafkaMessageProducerClient.asyncSend(topic,message);//推送kafka消息
        result.setSuccess(true);
        logFileUtils.info("[商户模块]扣除余额;",deductQuery.getMerchantId(),deductQuery.getChannelNo(),AccountManager.class,"deductBalance",startTimeMillis);
        return result;
    }

    /**
     * 查询具体商户服务资源情况
     * @param query
     * @return
     */
    public ResultDO<ServiceLeftSource> selectLeftSource(SelectLeftSourceQuery query){
        ResultDO<ServiceLeftSource> result = new ResultDO<ServiceLeftSource>();
        Long startTimeMillis = System.currentTimeMillis();//获取当前系统时间
        try{
            DeductDTO deductDTO = new DeductDTO(query.getMerchantId(),query.getChannelNo(),query.getType().getTypeid());
            ServiceLeftSource serviceLeftSource = serviceLeftSourceMapper.selectByTypeId(deductDTO);
            result.setData(serviceLeftSource);
        }catch (Exception ex){
            result.setSuccess(false);
            result.setErrMsg(ex.getMessage());
            result.setErrCode(1);
            logFileUtils.error("[商户模块]查询具体商户服务资源情况;错误原因:"+ex.getMessage(),query.getMerchantId(),query.getChannelNo(),AccountManager.class,"selectLeftSource",startTimeMillis);
            return result;
        }
        result.setSuccess(true);
        logFileUtils.info("[商户模块]查询具体商户服务资源情况;",query.getMerchantId(),query.getChannelNo(),AccountManager.class,"selectLeftSource",startTimeMillis);
        return result;
    }

    /**
     * 商户详情
     * @param query
     * @return
     */
    public ResultDO<MerchantInfoDTO> merchantInfo(UserInfoQuery query){
        ResultDO<MerchantInfoDTO> result = new ResultDO<MerchantInfoDTO>();
        Long startTimeMillis = System.currentTimeMillis();//获取当前系统时间
        try {
            MerchantInfoDTO merchantInfoDTO = merchantMapper.selectMerchant(query);
            result.setData(merchantInfoDTO);
        }catch (Exception ex){
            result.setSuccess(false);
            result.setErrMsg(ex.getMessage());
            result.setErrCode(1);
            logFileUtils.error("[商户模块]查询具体商户详情;错误原因:"+ex.getMessage(),query.getMerchantId(),query.getChannelNo(),AccountManager.class,"merchantInfo",startTimeMillis);
            return result;
        }
        result.setSuccess(true);
        logFileUtils.info("[商户模块]查询具体商户详情;",query.getMerchantId(),query.getChannelNo(),AccountManager.class,"merchantInfo",startTimeMillis);
        return result;
    }

    /**
     * 商户列表
     * @param query
     * @return
     */
    public Page<MerchantDTO> selectMerchantList(UserListQuery query,Page page){
        Long startTimeMillis = System.currentTimeMillis();//获取当前系统时间
        try {
            merchantMapper.selectMerchantList(query,page);
        }catch (Exception ex){
            logFileUtils.error("[商户模块]商户列表;错误原因:"+ex.getMessage(),query.getMerchantId(),query.getChannelNo(),AccountManager.class,"selectMerchantList",startTimeMillis);
        }
        logFileUtils.info("[商户模块]商户列表;",query.getMerchantId(),query.getChannelNo(),AccountManager.class,"selectMerchantList",startTimeMillis);
        return page;
    }

    public ResultDO<MerchantApikey> apikeyInfo(String apikey){
        ResultDO<MerchantApikey> result = new ResultDO<MerchantApikey>();
        Long startTimeMillis = System.currentTimeMillis();//获取当前系统时间
        try {

            MerchantApikey merchantApikey = RedisUtil.get(ACCOUNT_APIKEY_AUTH+apikey, MerchantApikey.class);
            if(merchantApikey==null){
                merchantApikey = merchantApikeyMapper.selectMerchantByApikey(apikey);
                if(merchantApikey!=null && (!ValidateHelper.isEmpty(merchantApikey.getId()))){
                    RedisUtil.set(ACCOUNT_APIKEY_AUTH+apikey, merchantApikey,60*60*2);//redis存储数据
                }
            }
            if(merchantApikey==null || ValidateHelper.isEmpty(merchantApikey.getId())){
                logFileUtils.error("[商户模块]查询具体商户apikey;错误原因:未找到数据",1L,"",AccountManager.class,"apikeyInfo",startTimeMillis);
                result.setSuccess(false);
                result.setErrMsg(ErrorConstant.APIKEY_NULL_ERROR.getMsg());
                result.setErrCode(ErrorConstant.APIKEY_NULL_ERROR.getCode());
                return result;
            }else{
                result.setData(merchantApikey);
            }
        }catch (Exception ex){
            logFileUtils.error("[商户模块]查询具体商户apikey;错误原因:"+ex.getMessage(),1L,"",AccountManager.class,"apikeyInfo",startTimeMillis);
            result.setSuccess(false);
            result.setErrMsg(ex.getMessage());
            result.setErrCode(1);
            return result;
        }
        result.setSuccess(true);
        logFileUtils.info("[商户模块]查询具体商户apikey;",1L,"",AccountManager.class,"apikeyInfo",startTimeMillis);
        return result;
    }

    public ResultDO<Boolean> checkMerchant(CheckMerchantQuery query){
        ResultDO<Boolean> result = new ResultDO<Boolean>();
        Long startTimeMillis = System.currentTimeMillis();//获取当前系统时间
        boolean issuccess = false;
        try {
            com.shfc.cloud.account.domain.Service service = serviceMapper.selectService(query);
            if(service!=null && (!ValidateHelper.isEmpty(service.getId()))){
                issuccess = true;
            }
            result.setData(issuccess);
        }catch (Exception ex){
            logFileUtils.error("[商户模块]查询具体商户服务;错误原因:"+ex.getMessage(),query.getMerchantId(),query.getChannelNo(),AccountManager.class,"apikeyInfo",startTimeMillis);
            result.setSuccess(false);
            result.setErrMsg(ex.getMessage());
            result.setErrCode(1);
            return result;
        }
        result.setSuccess(true);
        logFileUtils.info("[商户模块]查询具体商户服务;",query.getMerchantId(),query.getChannelNo(),AccountManager.class,"apikeyInfo",startTimeMillis);
        return result;
    }
    public ResultDO clearRedis(String keyValue){
        Long startTimeMillis = System.currentTimeMillis();//获取当前系统时间
        ResultDO result = new ResultDO();
        RedisUtil.del(keyValue);//清除redis存储数据
        result.setSuccess(true);
        logFileUtils.info("[商户模块]清除redis缓存服务;",1L,"1",AccountManager.class,"clearApikey",startTimeMillis);
        return result;
    }
}
