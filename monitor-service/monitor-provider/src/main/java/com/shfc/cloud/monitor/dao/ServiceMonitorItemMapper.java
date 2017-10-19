package com.shfc.cloud.monitor.dao;

import com.shfc.cloud.monitor.domain.ServiceMonitorItem;
import com.shfc.mybatis.pagination.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.cloud.monitor.dao.ServiceMonitorItemMapper.java
 * @Description: 
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/03/23 14:43
 * version v1.0.0
 */
@Repository
public interface ServiceMonitorItemMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/23 14:43
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author lv bin
     * @Date 2017/03/23 14:43
     * @param record
     * @return int
     * @throws []
     */
    int insert(ServiceMonitorItem record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/03/23 14:43
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(ServiceMonitorItem record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/23 14:43
     * @param id
     * @return com.shfc.cloud.monitor.domain.ServiceMonitorItem
     * @throws []
     */
    ServiceMonitorItem selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/03/23 14:43
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(ServiceMonitorItem record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/23 14:43
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(ServiceMonitorItem record);

    /**
     * @Description: 分页获取全部数据库记录
     * @Title selectByPage
     * @Author lv bin
     * @Date 2017/03/23 14:43
     * @return null
     * @throws []
     */
    List<ServiceMonitorItem> selectByPage(Page<ServiceMonitorItem> page);

    /**
     * 不分页根据对象查询数据库记录
     * @param serviceMonitorItem
     * @return
     */
    List<ServiceMonitorItem> selectByDomainList(ServiceMonitorItem serviceMonitorItem);

}