package com.shfc.cloud.cloudbase.dao;

import com.shfc.cloud.cloudbase.domain.BaseDistrict;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.base.dao.BaseDistrictMapper.java
 * @Description: 区域
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author wuky
 * @date 2016/12/28 11:26
 * version v1.0.0
 */
@Repository
public interface BaseDistrictMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author wuky
     * @Date 2016/12/28 11:26
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author wuky
     * @Date 2016/12/28 11:26
     * @param record
     * @return int
     * @throws []
     */
    int insert(BaseDistrict record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author wuky
     * @Date 2016/12/28 11:26
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(BaseDistrict record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author wuky
     * @Date 2016/12/28 11:26
     * @param id
     * @return com.shfc.base.domain.BaseDistrict
     * @throws []
     */
    BaseDistrict selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author wuky
     * @Date 2016/12/28 11:26
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(BaseDistrict record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author wuky
     * @Date 2016/12/28 11:26
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(BaseDistrict record);

    /**
     * @Description: 分页获取全部数据库记录
     * @Title selectByPage
     * @Author wuky
     * @Date 2016/12/28 11:26
     * @return null
     * @throws []
     */
   // List<null> selectByPage(Page<null>page);

    /**
     * @Description: 根据cityId查询板块信息
     * @Title selectByPage
     * @Author wuky
     * @Date 2016/12/28 11:26
     * @return null
     * @throws []
     */
    List<BaseDistrict> selectByCityId(String CityId);

}