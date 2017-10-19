package com.shfc.mail.dao;

import com.shfc.mail.domain.EmailRecord;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.mail.dao.EmailRecordMapper.java
 * @Description: email发送记录
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017
 * All right reserved.
 * Author lv bin
 * @date 2017/03/14 17:07
 * version v1.0.0
 */
@Repository
public interface EmailRecordMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/14 17:07
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author lv bin
     * @Date 2017/03/14 17:07
     * @param record
     * @return int
     * @throws []
     */
    int insert(EmailRecord record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/03/14 17:07
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(EmailRecord record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/14 17:07
     * @param id
     * @return com.shfc.mail.domain.EmailRecord
     * @throws []
     */
    EmailRecord selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/03/14 17:07
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(EmailRecord record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/14 17:07
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(EmailRecord record);
}