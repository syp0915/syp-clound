package com.shfc.cloud.video.dao;

import com.shfc.cloud.video.domain.Attach;
import com.shfc.cloud.video.dto.ResourceInfoDTO;
import com.shfc.cloud.video.dto.ResourceListDTO;
import com.shfc.cloud.video.query.ResourceInfoQuery;
import com.shfc.cloud.video.query.ResourceListQuery;
import com.shfc.mybatis.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttachMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author liaozm
     * @Date 2017/03/25 13:41
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author liaozm
     * @Date 2017/03/25 13:41
     * @param record
     * @return int
     * @throws []
     */
    int insert(Attach record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author liaozm
     * @Date 2017/03/25 13:41
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(Attach record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author liaozm
     * @Date 2017/03/25 13:41
     * @param id
     * @return com.shfc.cloud.video.domain.Attach
     * @throws []
     */
    Attach selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author liaozm
     * @Date 2017/03/25 13:41
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(Attach record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author liaozm
     * @Date 2017/03/25 13:41
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(Attach record);

    /**
     * 根据查询资源包列表
     * @param query
     * @param page
     * @return
     */
    List<ResourceListDTO> resourceList(@Param("query") ResourceListQuery query, Page page);


    /**
     * 查询资源详情
     * @param query
     * @return
     */
    ResourceInfoDTO selectResourceInfo(ResourceInfoQuery query);

    /**
     * @Description: 分页获取全部数据库记录
     * @Title selectByPage
     * @Author liaozm
     * @Date 2017/03/25 13:41
     * @return null
     * @throws []
     */
    List<Attach> selectByPage(Page<Attach> page);

    /**
     * 根据频道号查看此频道空间占用多少
     * @param channleNo
     * @return
     */
    Integer selectSumSizeBychannelNo(String channleNo);
}