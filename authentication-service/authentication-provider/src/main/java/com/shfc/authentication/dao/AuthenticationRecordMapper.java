package com.shfc.authentication.dao;

import com.shfc.authentication.domain.AuthenticationRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.authentication.dao.authenticationRecordMapper.java
 * @Description: 身份认证记录
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016
 * All right reserved.
 * Author xiehb
 * @date 2017/03/09 11:22
 * version v1.0.0
 */
@Repository
public interface AuthenticationRecordMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author xiehb
     * @Date 2017/03/09 11:22
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author xiehb
     * @Date 2017/03/09 11:22
     * @param record
     * @return int
     * @throws []
     */
    int insert(AuthenticationRecord record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author xiehb
     * @Date 2017/03/09 11:22
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(AuthenticationRecord record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author xiehb
     * @Date 2017/03/09 11:22
     * @param id
     * @return com.shfc.authentication.domain.authenticationRecord
     * @throws []
     */
    AuthenticationRecord selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author xiehb
     * @Date 2017/03/09 11:22
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(AuthenticationRecord record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author xiehb
     * @Date 2017/03/09 11:22
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(AuthenticationRecord record);

    /**
     * @Description: 根据姓名身份证验证个人信息
     * @Title authenticate
     * @Author wuky
     * @Date 2017/03/09 11:22
     * @param id
     * @param name
     * @return int
     * @throws []
     */
    AuthenticationRecord authenticate(@Param("name") String name, @Param("id") String id);
}