package com.shfc.sms.dao;

import com.shfc.sms.domain.SmsLog;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.sms.dao.SmsLogMapper.java
 * @Description: 短信通道调用日志
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author lv bin
 * @date 2017/03/01 14:18
 * version v1.0.0
 */
@Repository
public interface SmsLogMapper {
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
    int insert(SmsLog record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/03/01 14:18
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(SmsLog record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/01 14:18
     * @param id
     * @return com.shfc.sms.domain.SmsLog
     * @throws []
     */
    SmsLog selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/03/01 14:18
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(SmsLog record);

    /**
     * @Title updateByPrimaryKeyWithBLOBs
     * @Author lv bin
     * @Date 2017/03/01 14:18
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeyWithBLOBs(SmsLog record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/01 14:18
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(SmsLog record);
}