package com.shfc.cloud.monitor.dao;

import com.shfc.cloud.monitor.domain.CacheRecord;
import com.shfc.mybatis.pagination.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.cache.dao.CacheRecordMapper.java
 * @Description: 
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/03/31 14:34
 * version v1.0.0
 */
@Repository
public interface CacheRecordMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/31 14:34
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author lv bin
     * @Date 2017/03/31 14:34
     * @param record
     * @return int
     * @throws []
     */
    int insert(CacheRecord record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/03/31 14:34
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(CacheRecord record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/31 14:34
     * @param id
     * @return com.shfc.cache.domain.CacheRecord
     * @throws []
     */
    CacheRecord selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/03/31 14:34
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(CacheRecord record);

    /**
     * @Title updateByPrimaryKeyWithBLOBs
     * @Author lv bin
     * @Date 2017/03/31 14:34
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeyWithBLOBs(CacheRecord record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/31 14:34
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(CacheRecord record);

    /**
     * @Description: 分页获取全部数据库记录
     * @Title selectByPage
     * @Author lv bin
     * @Date 2017/03/31 14:34
     * @return null
     * @throws []
     */
    List<CacheRecord> selectByPage(Page<CacheRecord> page);
}