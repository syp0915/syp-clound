package com.shfc.sms.dao;

import com.shfc.mybatis.pagination.Page;
import com.shfc.sms.domain.SmsMerchantTemplate;
import com.shfc.sms.dto.TemplateResultDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.shfc.sms.dao.SmsMerchantTemplateMapper.java
 * @Description: 商户短信模板
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author lv bin
 * @date 2017/03/01 14:18
 * version v1.0.0
 */
@Repository
public interface SmsMerchantTemplateMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/01 14:18
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author lv bin
     * @Date 2017/03/01 14:18
     * @param record
     * @return int
     * @throws []
     */
    int insert(SmsMerchantTemplate record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/03/01 14:18
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(SmsMerchantTemplate record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/01 14:18
     * @param id
     * @return com.shfc.sms.domain.SmsMerchantTemplate
     * @throws []
     */
    SmsMerchantTemplate selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/03/01 14:18
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(SmsMerchantTemplate record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/01 14:18
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(SmsMerchantTemplate record);

    /**
     * @Description: 根据模板Id来更新对应数据库字段
     * @Title updateBychannelTplId
     * @Author wuky
     * @Date 2017/03/01 14:18
     * @param record
     * @return int
     * @throws []
     */
    int updateBychannelTplId(SmsMerchantTemplate record);

    /**
     * 根据通道模板ID查询本地记录
     * add by xiehb
     */
    SmsMerchantTemplate selectByChannelTplId(Long channelTplId);

    /**
     * @Description: 根据查询条件取数据库记录
     * @Title selectByTplId
     * @Author wuky
     * @Date 2017/03/01 14:18
     * @param params
     * @return com.shfc.sms.domain.SmsMerchantTemplate
     * @throws []
     */
    List<TemplateResultDTO> queryTplByTplId(HashMap<String,Object> params);

    /**
     * @Description: 查询审核状态是未审核的模板
     * @Title queryTpl
     * @Author wuky
     * @Date 2017/03/01 14:18
     * @param page
     * @return List<SmsMerchantTemplate>
     * @throws []
     */
    List<SmsMerchantTemplate> queryTpl(Page<SmsMerchantTemplate> page);

}