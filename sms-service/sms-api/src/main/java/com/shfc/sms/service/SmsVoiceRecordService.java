package com.shfc.sms.service;

import com.shfc.common.result.ResultDO;
import com.shfc.mybatis.pagination.Page;
import com.shfc.sms.domain.SmsVoice;
import com.shfc.sms.query.SmsRecordQuery;

import java.util.List;

/**
 * @Package com.shfc.sms.service.SmsVoiceRecordService
 * @Description: 语音发送记录
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/1 14:47
 * version V1.0.0
 */
public interface SmsVoiceRecordService {
    /**
     * 查询语音发送记录
     */
    public ResultDO<Page<SmsVoice>> smsVoiceList(SmsRecordQuery query);
}
