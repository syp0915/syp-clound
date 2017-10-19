package com.shfc.sms.dao;

import com.shfc.mybatis.pagination.Page;
import com.shfc.sms.domain.SmsBatchRecord;
import com.shfc.sms.dto.SmsRecordResultDTO;
import com.shfc.sms.query.SmsRecordQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.sms.dao.SmsBatchRecordMapper.java
 * @Description: 短信批量发送记录
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author xiehb
 * @date 2017/03/03 16:58
 * version v1.0.0
 */
@Repository
public interface SmsBatchRecordMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author xiehb
     * @Date 2017/03/03 16:58
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author xiehb
     * @Date 2017/03/03 16:58
     * @param record
     * @return int
     * @throws []
     */
    int insert(SmsBatchRecord record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author xiehb
     * @Date 2017/03/03 16:58
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(SmsBatchRecord record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author xiehb
     * @Date 2017/03/03 16:58
     * @param id
     * @return com.shfc.sms.domain.SmsBatchRecord
     * @throws []
     */
    SmsBatchRecord selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author xiehb
     * @Date 2017/03/03 16:58
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(SmsBatchRecord record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author xiehb
     * @Date 2017/03/03 16:58
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(SmsBatchRecord record);

    /**
     * 批量发送短信记录查询
     * @param query
     * @return
     */
    List<SmsRecordResultDTO> smsBatchRecordList(@Param("query") SmsRecordQuery query, Page page);
}