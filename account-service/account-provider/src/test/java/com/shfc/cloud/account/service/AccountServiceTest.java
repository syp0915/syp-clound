package com.shfc.cloud.account.service;

import com.shfc.cloud.account.JunitBaseTest;
import com.shfc.cloud.account.constant.CheckStatusConstant;
import com.shfc.cloud.account.constant.DeductConstant;
import com.shfc.cloud.account.query.*;
import com.shfc.common.result.ResultDO;
import com.shfc.mybatis.pagination.Page;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package com.shfc.cloud.account.service.AccountServiceTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/27 14:58
 * version V1.0.0
 */
public class AccountServiceTest extends JunitBaseTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testDeductBalance(){
        DeductQuery deductQuery = new DeductQuery();
        deductQuery.setMerchantId(1L);
        deductQuery.setChannelNo("997");
        deductQuery.setNumber(1);
        deductQuery.setType(DeductConstant.Image);
        ResultDO result = accountService.deductBalance(deductQuery);
        System.out.println(result.isSuccess()+"----"+result.getErrMsg());
        while (true){

        }
    }

    @Test
    public void testSelectLeftSource(){
        SelectLeftSourceQuery query = new SelectLeftSourceQuery();
        query.setType(DeductConstant.Image);
        query.setChannelNo("997");
        query.setMerchantId(1L);
        ResultDO result = accountService.selectLeftSource(query);
        System.out.println(result.isSuccess()+"----"+result.getErrMsg());
    }

    @Test
    public void testMerchantInfo(){
        UserInfoQuery query = new UserInfoQuery();
        query.setMerchantId(1L);
        query.setChannelNo("997");
        ResultDO result = accountService.merchantInfo(query);
        System.out.println(result.isSuccess()+"----"+result.getErrMsg());
    }

    @Test
    public void testuserList(){
        UserListQuery query = new UserListQuery();
        query.setMerchantId(1L);
        query.setChannelNo("997");
        query.setStatusCode(CheckStatusConstant.All.getCode());
        Page page = new Page();
        page.setPageSize(20);
        page.setPageNumber(1);
        query.setPage(page);
        ResultDO result = accountService.userList(query);
        System.out.println(result.isSuccess()+"----"+result.getErrMsg());
    }

    @Test
    public void testApikeyInfo(){
        String apikey = "b81e83861a63a5339c40490aec67834f35cfc0a6";
//        String ACCOUNT_APIKEY_AUTH = "redis模块_2_997_201704211834";
//        Object obj = RedisUtil.get(ACCOUNT_APIKEY_AUTH);
//        System.out.println(obj+"------"+obj.toString());
//        RedisUtil.set(ACCOUNT_APIKEY_AUTH+apikey, null);//redis存储数据
        ResultDO result = accountService.apikeyInfo(apikey);
        System.out.println(result.isSuccess()+"----"+result.getErrMsg());
    }
    @Test
    public void testClearRedis(){
        String keyValue = "cloud_account_apikey_a6b9e216b8be4a37bd9e9aee92ef5bb8";
        ResultDO result = accountService.clearRedis(keyValue);
        System.out.println(result.isSuccess()+"----"+result.getErrMsg());
    }

    @Test
    public void testcheckMerchant(){
        CheckMerchantQuery query = new CheckMerchantQuery();
        query.setMerchantId(1L);
        query.setChannelNo("997");
        ResultDO<Boolean> result = accountService.checkMerchant(query);
        System.out.println(result.isSuccess()+"----"+result.getErrMsg()+"ccccccccc"+result.getData());
    }


    @Test
    public void testKafka() throws Exception {
//        Properties prop = new Properties();
//        prop.put("zookeeper.connect", "192.168.201.37:2181");
//        prop.put("metadata.broker.list", "192.168.201.37:9092");
//        prop.put("serializer.class", StringEncoder.class.getName());
//        prop.put("producer.type", "sync");
//        Producer<String, String> producer = new Producer<String, String>(new ProducerConfig(prop));
//        int i = 0;
//        while(true){
//            producer.send(new KeyedMessage<String, String>("test111", "msg:"+i++));
//            Thread.sleep(1000);
//        }

    }

}
