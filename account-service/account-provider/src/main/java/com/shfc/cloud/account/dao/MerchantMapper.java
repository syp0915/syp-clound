package com.shfc.cloud.account.dao;

import com.shfc.cloud.account.domain.Merchant;
import com.shfc.cloud.account.dto.MerchantDTO;
import com.shfc.cloud.account.dto.MerchantInfoDTO;
import com.shfc.cloud.account.query.UserInfoQuery;
import com.shfc.cloud.account.query.UserListQuery;
import com.shfc.mybatis.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantMapper {
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
    int insert(Merchant record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author liaozm
     * @Date 2017/03/25 15:30
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(Merchant record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author liaozm
     * @Date 2017/03/25 15:30
     * @param id
     * @return com.shfc.cloud.account.domain.Merchant
     * @throws []
     */
    Merchant selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author liaozm
     * @Date 2017/03/25 15:30
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(Merchant record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author liaozm
     * @Date 2017/03/25 15:30
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(Merchant record);

    /**
     * @Description: 分页获取全部数据库记录
     * @Title selectByPage
     * @Author liaozm
     * @Date 2017/03/25 15:30
     * @return null
     * @throws []
     */
    List<Merchant> selectByPage(Page<Merchant> page);

    /**
     * 查询商户相亲
     * @param query
     * @return
     */
    MerchantInfoDTO selectMerchant(@Param("query") UserInfoQuery query);

    /**
     * 商户列表
     * @param query
     * @param page
     * @return
     */
    List<MerchantDTO> selectMerchantList(@Param("query") UserListQuery query, Page page);
}