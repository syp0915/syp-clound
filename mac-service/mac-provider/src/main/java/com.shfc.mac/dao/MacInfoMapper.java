package com.shfc.mac.dao;

import com.shfc.mac.domain.MacInfo;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.mac.dao.MacInfoMapper.java
 * @Description: 机顶盒mac信息表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author xiehb
 * @date 2017/03/14 17:19
 * version v1.0.0
 */
@Repository
public interface MacInfoMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author xiehb
     * @Date 2017/03/14 17:19
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author xiehb
     * @Date 2017/03/14 17:19
     * @param record
     * @return int
     * @throws []
     */
    int insert(MacInfo record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author xiehb
     * @Date 2017/03/14 17:19
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(MacInfo record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author xiehb
     * @Date 2017/03/14 17:19
     * @param id
     * @return com.shfc.mac.domain.MacInfo
     * @throws []
     */
    MacInfo selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author xiehb
     * @Date 2017/03/14 17:19
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(MacInfo record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author xiehb
     * @Date 2017/03/14 17:19
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(MacInfo record);

    /**
     * 根据mac查询详情
     * @param mac
     * @return
     */
    MacInfo selectByMac(String mac);
}