package com.shfc.sms.service;

import com.shfc.common.result.ResultDO;
import com.shfc.mybatis.pagination.Page;
import com.shfc.sms.domain.SmsVoice;
import com.shfc.sms.manager.SmsRecordManager;
import com.shfc.sms.query.SmsRecordQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * @Package com.shfc.sms.service.SmsVoiceRecordServiceImpl
 * @Description: 语音发送记录
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/1 14:47
 * version V1.0.0
 */
@Service
public class SmsVoiceRecordServiceImpl implements SmsVoiceRecordService {
    private static final Logger logger = Logger.getLogger(SmsVoiceRecordServiceImpl.class);

    @Autowired
    private SmsRecordManager smsRecordManager;
    @Override
    public ResultDO<Page<SmsVoice>> smsVoiceList(SmsRecordQuery query) {
        ResultDO<Page<SmsVoice>> resultDO = new ResultDO<>();
        Page<SmsVoice> listPage =  smsRecordManager.smsVoiceList(query,query.getPage());
        resultDO.setSuccess(true);
        resultDO.setData(listPage);
        return resultDO;
    }
}
