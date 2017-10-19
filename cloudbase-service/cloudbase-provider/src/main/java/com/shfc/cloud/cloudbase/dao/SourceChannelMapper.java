package com.shfc.cloud.cloudbase.dao;


import com.shfc.cloud.cloudbase.domain.SourceChannel;
import com.shfc.cloud.cloudbase.dto.ChannelDTO;
import com.shfc.mybatis.pagination.Page;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.shfc.baisis.dao.SourceChannelMapper.java
 * @Description: 资源——频道表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author liaozm
 * @date 2017/03/25 16:52
 * version v1.0.0
 */
@Repository
public interface SourceChannelMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author liaozm
     * @Date 2017/03/25 16:52
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author liaozm
     * @Date 2017/03/25 16:52
     * @param record
     * @return int
     * @throws []
     */
    int insert(SourceChannel record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author liaozm
     * @Date 2017/03/25 16:52
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(SourceChannel record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author liaozm
     * @Date 2017/03/25 16:52
     * @param id
     * @return com.shfc.basis.domain.SourceChannel
     * @throws []
     */
    SourceChannel selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author liaozm
     * @Date 2017/03/25 16:52
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(SourceChannel record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author liaozm
     * @Date 2017/03/25 16:52
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(SourceChannel record);

    /**
     * @Description: 分页获取全部数据库记录
     * @Title selectByPage
     * @Author liaozm
     * @Date 2017/03/25 16:52
     * @return null
     * @throws []
     */
    List<SourceChannel> selectByPage(Page<SourceChannel> page);
    /**
     * @Description: 根据关键词获取频道号/名称
     * @Title queryChannelByKeyword
     * @Author wuky
     * @Date 2017/03/25 16:52
     * @return null
     * @throws []
     */
    List<ChannelDTO> queryChannelByKeyword(HashMap<String, Object> params);
    /**
     * @Description: 根据频道号获取频道名称,商户id
     * @Title queryChannelByKeyword
     * @Author wuky
     * @Date 2017/03/25 16:52
     * @return null
     * @throws []
     */
    ChannelDTO queryChannelNameByNo(String channelNo);

    /**
     * @Description: 根据频道号获取频道名称,商户id
     * @Title queryChannelByKeyword
     * @Author wuky
     * @Date 2017/03/25 16:52
     * @return null
     * @throws []
     */
    ChannelDTO queryAllChannelNameByNo(String channelNo);

    /**
     * 查询所有频道列表
     * @return
     */
    List<SourceChannel> queryAllChannelList();
}