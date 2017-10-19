package com.shfc.sms.service;

import com.shfc.common.result.ResultDO;
import com.shfc.mybatis.pagination.Page;
import com.shfc.sms.domain.SmsBatchRecord;
import com.shfc.sms.dto.SmsRecordResultDTO;
import com.shfc.sms.query.SmsRecordQuery;

/**
 * @Package com.shfc.sms.service.SmsRecordService
 * @Description: 短信记录查询
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/1 14:43
 * version V1.0.0
 */
public interface SmsRecordService {
    /**
     * 查询短信发送记录
     */
    public ResultDO<Page<SmsRecordResultDTO>> smsRecordList(SmsRecordQuery query);

    /**
     * 查询批量短信发送记录
     * @param query
     * @return
     */
    public ResultDO<Page<SmsRecordResultDTO>> smsBatchRecordList(SmsRecordQuery query);


}
