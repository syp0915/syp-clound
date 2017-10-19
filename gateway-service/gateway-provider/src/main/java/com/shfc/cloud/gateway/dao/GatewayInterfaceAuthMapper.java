package com.shfc.cloud.gateway.dao;

import com.shfc.cloud.gateway.domain.GatewayInterfaceAuth;
import com.shfc.mybatis.pagination.Page;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.cloud.gateway.dao.GatewayInterfaceAuthMapper.java
 * @Description: 
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/03/27 15:54
 * version v1.0.0
 */
@Repository
public interface GatewayInterfaceAuthMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/27 15:54
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author lv bin
     * @Date 2017/03/27 15:54
     * @param record
     * @return int
     * @throws []
     */
    int insert(GatewayInterfaceAuth record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/03/27 15:54
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(GatewayInterfaceAuth record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/27 15:54
     * @param id
     * @return com.shfc.cloud.gateway.domain.GatewayInterfaceAuth
     * @throws []
     */
    GatewayInterfaceAuth selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/03/27 15:54
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(GatewayInterfaceAuth record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/27 15:54
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(GatewayInterfaceAuth record);

    /**
     * @Description: 分页获取全部数据库记录
     * @Title selectByPage
     * @Author lv bin
     * @Date 2017/03/27 15:54
     * @return null
     * @throws []
     */
    List<GatewayInterfaceAuth> selectByPage(Page<GatewayInterfaceAuth> page);

    List<GatewayInterfaceAuth> selectByMerchantId(Map map);

    int updateBydel(GatewayInterfaceAuth gatewayAuth);
}