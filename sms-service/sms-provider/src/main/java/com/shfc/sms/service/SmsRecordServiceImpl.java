package com.shfc.sms.service;

import com.shfc.common.result.ResultDO;
import com.shfc.mybatis.pagination.Page;
import com.shfc.sms.domain.SmsBatchRecord;
import com.shfc.sms.domain.SmsRecord;
import com.shfc.sms.dto.SmsRecordResultDTO;
import com.shfc.sms.manager.SmsRecordManager;
import com.shfc.sms.query.SmsRecordQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package com.shfc.sms.service.SmsRecordServiceImpl
 * @Description: 短信记录查询
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/1 14:44
 * version V1.0.0
 */
@Service
public class SmsRecordServiceImpl implements SmsRecordService {
    private static final Logger logger = Logger.getLogger(SmsRecordServiceImpl.class);

    @Autowired
    private SmsRecordManager smsRecordManager;
    @Override
    public ResultDO<Page<SmsRecordResultDTO>> smsRecordList(SmsRecordQuery query) {
        ResultDO<Page<SmsRecordResultDTO>> resultDO = new ResultDO<>();
        Page<SmsRecordResultDTO> listPage =  smsRecordManager.smsRecordList(query,query.getPage());
        resultDO.setSuccess(true);
        resultDO.setData(listPage);
        return resultDO;
    }

    @Override
    public ResultDO<Page<SmsRecordResultDTO>> smsBatchRecordList(SmsRecordQuery query) {
        ResultDO<Page<SmsRecordResultDTO>> resultDO = new ResultDO<>();
        Page<SmsRecordResultDTO> listPage =  smsRecordManager.smsBatchRecordList(query,query.getPage());
        resultDO.setSuccess(true);
        resultDO.setData(listPage);
        return resultDO;
    }
}
