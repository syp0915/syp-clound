package com.shfc.cloud.gateway.dao;

import com.shfc.cloud.gateway.domain.SensitiveWord;
import com.shfc.mybatis.pagination.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.cloud.gateway.dao.SensitiveWordMapper.java
 * @Description: 
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/03/23 16:35
 * version v1.0.0
 */
@Repository
public interface SensitiveWordMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/23 16:35
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author lv bin
     * @Date 2017/03/23 16:35
     * @param record
     * @return int
     * @throws []
     */
    int insert(SensitiveWord record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/03/23 16:35
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(SensitiveWord record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/23 16:35
     * @param id
     * @return com.shfc.cloud.gateway.domain.SensitiveWord
     * @throws []
     */
    SensitiveWord selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/03/23 16:35
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(SensitiveWord record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/23 16:35
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(SensitiveWord record);

    /**
     * @Description: 分页获取全部数据库记录
     * @Title selectByPage
     * @Author lv bin
     * @Date 2017/03/23 16:35
     * @return null
     * @throws []
     */
    List<SensitiveWord> selectByPage(Page<SensitiveWord> page);

    List<SensitiveWord> selectByName(String sensitiveWord);
}