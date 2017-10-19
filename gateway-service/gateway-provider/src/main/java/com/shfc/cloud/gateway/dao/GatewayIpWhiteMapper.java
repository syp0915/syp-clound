package com.shfc.cloud.gateway.dao;

import com.shfc.cloud.gateway.domain.GatewayIpWhite;
import com.shfc.cloud.gateway.dto.WhiteListDTO;
import com.shfc.mybatis.pagination.Page;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.cloud.gateway.dao.GatewayIpWhiteMapper.java
 * @Description: 
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/03/27 09:41
 * version v1.0.0
 */
@Repository
public interface GatewayIpWhiteMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/27 09:41
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author lv bin
     * @Date 2017/03/27 09:41
     * @param record
     * @return int
     * @throws []
     */
    int insert(GatewayIpWhite record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/03/27 09:41
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(GatewayIpWhite record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/27 09:41
     * @param id
     * @return com.shfc.cloud.gateway.domain.GatewayIpWhite
     * @throws []
     */
    GatewayIpWhite selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/03/27 09:41
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(GatewayIpWhite record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/27 09:41
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(GatewayIpWhite record);

    /**
     * @Description: 分页获取全部数据库记录
     * @Title selectByPage
     * @Author lv bin
     * @Date 2017/03/27 09:41
     * @return null
     * @throws []
     */
    List<GatewayIpWhite> selectByPage(@Param("whiteListDTO")WhiteListDTO whiteListDTO, Page  page);

    List<GatewayIpWhite> selectByMerchantId(long merchantId);

    int updateByIp(GatewayIpWhite gatewayIpWhite);
}