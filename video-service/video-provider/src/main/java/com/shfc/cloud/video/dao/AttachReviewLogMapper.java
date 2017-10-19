package com.shfc.cloud.video.dao;

import com.shfc.cloud.video.domain.AttachReviewLog;
import com.shfc.cloud.video.dto.ApproverDTO;
import com.shfc.cloud.video.query.ResourceInfoQuery;
import com.shfc.mybatis.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttachReviewLogMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author liaozm
     * @Date 2017/03/25 15:09
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author liaozm
     * @Date 2017/03/25 15:09
     * @param record
     * @return int
     * @throws []
     */
    int insert(AttachReviewLog record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author liaozm
     * @Date 2017/03/25 15:09
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(AttachReviewLog record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author liaozm
     * @Date 2017/03/25 15:09
     * @param id
     * @return com.shfc.cloud.video.domain.AttachReviewLog
     * @throws []
     */
    AttachReviewLog selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author liaozm
     * @Date 2017/03/25 15:09
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(AttachReviewLog record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author liaozm
     * @Date 2017/03/25 15:09
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(AttachReviewLog record);

    /**
     * @Description: 分页获取全部数据库记录
     * @Title selectByPage
     * @Author liaozm
     * @Date 2017/03/25 15:09
     * @return null
     * @throws []
     */
    List<AttachReviewLog> selectByPage(Page<AttachReviewLog> page);

    /**
     *
     * @param query
     * @return
     */
    List<ApproverDTO> selectapproverList(@Param("query") ResourceInfoQuery query);
}