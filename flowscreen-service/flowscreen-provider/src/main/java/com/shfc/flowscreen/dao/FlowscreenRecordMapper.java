package com.shfc.flowscreen.dao;

import com.shfc.flowscreen.domain.FlowscreenRecord;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.flowscreen.dao.FlowscreenRecordMapper
 * @Description: FlowscreenRecordMapper
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/03/29 10:17
 * version v1.0.0
 */
@Repository
public interface FlowscreenRecordMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/29 10:17
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author lv bin
     * @Date 2017/03/29 10:17
     * @param record
     * @return int
     * @throws []
     */
    int insert(FlowscreenRecord record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/03/29 10:17
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(FlowscreenRecord record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/29 10:17
     * @param id
     * @return com.fc.realtor.domain.FlowscreenRecord
     * @throws []
     */
    FlowscreenRecord selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/03/29 10:17
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(FlowscreenRecord record);

    /**
     * @Title updateByPrimaryKeyWithBLOBs
     * @Author lv bin
     * @Date 2017/03/29 10:17
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeyWithBLOBs(FlowscreenRecord record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/29 10:17
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(FlowscreenRecord record);

}