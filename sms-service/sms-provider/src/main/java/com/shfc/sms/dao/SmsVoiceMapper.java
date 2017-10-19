package com.shfc.sms.dao;

import com.shfc.mybatis.pagination.Page;
import com.shfc.sms.domain.SmsVoice;
import com.shfc.sms.query.SmsRecordQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.sms.dao.SmsVoiceMapper.java
 * @Description: 语音发送记录
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author lv bin
 * @date 2017/03/01 14:18
 * version v1.0.0
 */
@Repository
public interface SmsVoiceMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/01 14:18
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author lv bin
     * @Date 2017/03/01 14:18
     * @param record
     * @return int
     * @throws []
     */
    int insert(SmsVoice record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/03/01 14:18
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(SmsVoice record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/01 14:18
     * @param id
     * @return com.shfc.sms.domain.SmsVoice
     * @throws []
     */
    SmsVoice selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/03/01 14:18
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(SmsVoice record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/01 14:18
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(SmsVoice record);

    /**
     * 查询语音发送记录
     * @param query
     * @return
     */
    List<SmsVoice> smsVoiceList(@Param("query") SmsRecordQuery query,Page page);
}