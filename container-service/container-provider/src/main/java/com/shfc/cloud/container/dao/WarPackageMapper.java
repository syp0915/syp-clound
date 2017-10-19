package com.shfc.cloud.container.dao;

import com.shfc.cloud.container.domain.WarPackage;
import com.shfc.cloud.container.dto.WarRollbackDTO;
import com.shfc.mybatis.pagination.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.cloud.container.dao.WarPackageMapper.java
 * @Description: war包表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/03/22 16:13
 * version v1.0.0
 */
@Repository
public interface WarPackageMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/22 16:13
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author lv bin
     * @Date 2017/03/22 16:13
     * @param record
     * @return int
     * @throws []
     */
    int insert(WarPackage record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/03/22 16:13
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(WarPackage record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/22 16:13
     * @param id
     * @return com.shfc.cloud.container.domain.WarPackage
     * @throws []
     */
    WarPackage selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/03/22 16:13
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(WarPackage record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/22 16:13
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(WarPackage record);

    /**
     * @Description: 分页获取全部数据库记录
     * @Title selectByPage
     * @Author lv bin
     * @Date 2017/03/22 16:13
     * @return null
     * @throws []
     */
    List<WarPackage> selectByPage(Page<WarPackage> page);


    /**
     * 修改war包状态。把其他状态打回
     * @param record
     * @return
     */
    int updateStatusByWar(WarPackage record);

    WarPackage selectByWarNameAndVersion(WarRollbackDTO reqDto);
}