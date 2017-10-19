package com.shfc.cloud.account.dao;

import com.shfc.cloud.account.domain.ServiceLeftSource;
import com.shfc.cloud.account.dto.DeductDTO;
import com.shfc.mybatis.pagination.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceLeftSourceMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author liaozm
     * @Date 2017/03/25 15:30
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author liaozm
     * @Date 2017/03/25 15:30
     * @param record
     * @return int
     * @throws []
     */
    int insert(ServiceLeftSource record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author liaozm
     * @Date 2017/03/25 15:30
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(ServiceLeftSource record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author liaozm
     * @Date 2017/03/25 15:30
     * @param id
     * @return com.shfc.cloud.account.domain.ServiceLeftSource
     * @throws []
     */
    ServiceLeftSource selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author liaozm
     * @Date 2017/03/25 15:30
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(ServiceLeftSource record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author liaozm
     * @Date 2017/03/25 15:30
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(ServiceLeftSource record);

    /**
     * @Description: 分页获取全部数据库记录
     * @Title selectByPage
     * @Author liaozm
     * @Date 2017/03/25 15:30
     * @return null
     * @throws []
     */
    List<ServiceLeftSource> selectByPage(Page<ServiceLeftSource> page);

    /**
     * 根据类型ID 查询具体资源
     * @param deductDTO
     * @return
     */
    ServiceLeftSource selectByTypeId(DeductDTO deductDTO);
}