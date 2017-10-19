package com.shfc.cloud.cloudbase.dao;

import com.shfc.cloud.cloudbase.domain.SourceVirtual;
import com.shfc.mybatis.pagination.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.cloud.container.dao.SourceVirtualMapper.java
 * @Description: 资源——虚拟机
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/03/22 15:30
 * version v1.0.0
 */
@Repository
public interface SourceVirtualMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/22 15:30
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author lv bin
     * @Date 2017/03/22 15:30
     * @param record
     * @return int
     * @throws []
     */
    int insert(SourceVirtual record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/03/22 15:30
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(SourceVirtual record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/22 15:30
     * @param id
     * @return com.shfc.cloud.container.domain.SourceVirtual
     * @throws []
     */
    SourceVirtual selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/03/22 15:30
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(SourceVirtual record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/22 15:30
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(SourceVirtual record);

    /**
     * @Description: 分页获取全部数据库记录
     * @Title selectByPage
     * @Author lv bin
     * @Date 2017/03/22 15:30
     * @return null
     * @throws []
     */
    List<SourceVirtual> selectByPage(Page<SourceVirtual> page);

    /**
     * 不分页根据对象查询数据库记录
     * @param sourceVirtual
     * @return
     */
    List<SourceVirtual> selectByDomainList(SourceVirtual sourceVirtual);
}