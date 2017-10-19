package com.shfc.sms.service;

import com.shfc.common.result.ResultDO;
import com.shfc.mybatis.pagination.Page;
import com.shfc.sms.JunitBaseTest;
import com.shfc.sms.domain.SmsBatchRecord;
import com.shfc.sms.domain.SmsRecord;
import com.shfc.sms.domain.SmsVoice;
import com.shfc.sms.dto.SmsRecordResultDTO;
import com.shfc.sms.query.SmsRecordQuery;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Package com.shfc.sms.service.SmsRecordServiceTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/7 16:13
 * version V1.0.0
 */
public class SmsRecordServiceTest extends JunitBaseTest {
    @Autowired
    private SmsRecordService smsRecordService;

    @Autowired
    private SmsVoiceRecordService smsVoiceRecordService;

    /**
     * 查询短信发送记录
     */
    @Test
    public void testQueryRecord(){
        SmsRecordQuery query = new SmsRecordQuery();
        query.setTemplateId(1L);
        query.setMerchantId(2L);
        query.setMobile("13816513175");
        query.setSendStatus("0");
        query.setBeginTime("2017-03-06 12:01:31");
        query.setEndTime("2017-03-06 17:01:31");
        ResultDO<Page<SmsRecordResultDTO>> pageList =  smsRecordService.smsRecordList(query);

        System.out.println(pageList.getData().getData().toString());
    }

    /**
     * 查询批量短信发送记录
     */
    @Test
    public void testQueryBatchRecord(){
        Page page = new Page();
        SmsRecordQuery query = new SmsRecordQuery();
        query.setTemplateId(1L);
        query.setMerchantId(2L);
        query.setMobile("13816513175");
        query.setSendStatus("0");
        query.setBeginTime("2017-03-06 12:01:31");
        query.setEndTime("2017-03-06 18:01:31");
        ResultDO<Page<SmsRecordResultDTO>> pageList =  smsRecordService.smsBatchRecordList(query);
        System.out.println(pageList.getData().getData().toString());
    }

    /**
     * 查询语音发送记录
     */
    @Test
    public void testQueryVoice(){
        Page page = new Page();
        SmsRecordQuery query = new SmsRecordQuery();
        query.setMerchantId(2L);
        query.setMobile("13816513175");
        query.setSendStatus("0");
        query.setBeginTime("2017-03-06 12:01:31");
        query.setEndTime("2017-03-06 18:01:31");
        ResultDO<Page<SmsVoice>> pageList = smsVoiceRecordService.smsVoiceList(query);
        System.out.println(pageList.getData().getData().toString());
    }
}
