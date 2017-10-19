package com.shfc.cloud.gateway.dao;

import com.shfc.cloud.gateway.domain.SourceDataInfo;
import com.shfc.cloud.gateway.domain.SourceDatabase;
import com.shfc.cloud.gateway.dto.SourceDatabaseDTO;
import com.shfc.mybatis.pagination.Page;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.cloud.gateway.dao.SourceDatabaseMapper.java
 * @Description: 资源——数据库
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/03/28 15:52
 * version v1.0.0
 */
@Repository
public interface SourceDatabaseMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/28 15:52
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author lv bin
     * @Date 2017/03/28 15:52
     * @param record
     * @return int
     * @throws []
     */
    int insert(SourceDatabase record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/03/28 15:52
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(SourceDatabase record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/28 15:52
     * @param id
     * @return com.shfc.cloud.gateway.domain.SourceDatabase
     * @throws []
     */
    SourceDatabase selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/03/28 15:52
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(SourceDatabase record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/28 15:52
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(SourceDatabase record);

    /**
     * @Description: 分页获取全部数据库记录
     * @Title selectByPage
     * @Author lv bin
     * @Date 2017/03/28 15:52
     * @return null
     * @throws []
     */
    List<SourceDatabase> selectByPage(Page<SourceDatabase> page);

    SourceDataInfo selectByMerchantId(SourceDataInfo sourceDataInfo);
}