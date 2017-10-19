package com.shfc.sms.manager;

import com.shfc.common.exception.AppException;
import com.shfc.mybatis.pagination.Page;
import com.shfc.sms.dao.SmsBatchRecordMapper;
import com.shfc.sms.dao.SmsRecordMapper;
import com.shfc.sms.dao.SmsVoiceMapper;
import com.shfc.sms.domain.SmsBatchRecord;
import com.shfc.sms.domain.SmsRecord;
import com.shfc.sms.domain.SmsVoice;
import com.shfc.sms.dto.SmsRecordResultDTO;
import com.shfc.sms.query.SmsRecordQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Package com.shfc.sms.manager.SmsRecordManager
 * @Description: 短信记录
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/1 14:49
 * version V1.0.0
 */
@Service
public class SmsRecordManager {
    @Autowired
    private SmsRecordMapper smsRecordMapper;
    @Autowired
    private SmsBatchRecordMapper smsBatchRecordMapper;
    @Autowired
    private SmsVoiceMapper smsVoiceMapper;

    @Transactional(rollbackFor = AppException.class)
    public Long insertSmsRecord(SmsRecord smsRecord) throws AppException{
        smsRecordMapper.insert(smsRecord);
        return smsRecord.getId();
    }

    /**
     * 批量插入
     * @param list
     * @return
     */
    public int insertSmsList(List<SmsRecord> list) {
        return smsRecordMapper.insertList(list);
    }
    @Transactional(rollbackFor = AppException.class)
    public Long batchSend (SmsBatchRecord record) throws AppException{
        smsBatchRecordMapper.insert(record);
        return record.getId();
    }
    @Transactional(rollbackFor = AppException.class)
    public void insertSmsVoice(SmsVoice record)throws AppException{
        smsVoiceMapper.insert(record);
    }

    /**
     * 单条发送短信记录查询
     * @param query
     * @return
     */
    public Page<SmsRecordResultDTO> smsRecordList(SmsRecordQuery query, Page page) {
        smsRecordMapper.smsRecordList(query,page);
        return page;
    }

    /**
     * 批量发送短信记录查询
     * @param query
     * @return
     */
    public Page<SmsRecordResultDTO> smsBatchRecordList(SmsRecordQuery query,Page page) {
        smsBatchRecordMapper.smsBatchRecordList(query,page);
        return page;
    }

    /**
     * 查询语音发送记录
     * @param query
     * @return
     */
    public  Page<SmsVoice> smsVoiceList(SmsRecordQuery query,Page page){
        smsVoiceMapper.smsVoiceList(query,page);
        return page;
    }
}
