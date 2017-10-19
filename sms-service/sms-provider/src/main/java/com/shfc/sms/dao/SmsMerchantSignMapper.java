package com.shfc.sms.dao;

import com.shfc.mybatis.pagination.Page;
import com.shfc.sms.domain.SmsMerchantSign;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Package: com.shfc.sms.dao.SmsMerchantSignMapper.java
 * @Description: 商户签名
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author lv bin
 * @date 2017/03/01 14:18
 * version v1.0.0
 */
@Repository
public interface SmsMerchantSignMapper {
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
    int insert(SmsMerchantSign record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/03/01 14:18
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(SmsMerchantSign record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/01 14:18
     * @param id
     * @return com.shfc.sms.domain.SmsMerchantSign
     * @throws []
     */
    SmsMerchantSign selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/03/01 14:18
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(SmsMerchantSign record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/03/01 14:18
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(SmsMerchantSign record);

    /**
     * @Description: 根据签名Id获取记录
     * @Title selectByPrimaryKey
     * @Author wuky
     * @Date 2017/03/01 14:18
     * @param id
     * @return com.shfc.sms.domain.SmsMerchantSign
     * @throws []
     */
    SmsMerchantSign querySignBySignId(Long id);

    /**
     * @Description: 根据签名查询数据库记录
     * @Title getSign
     * @Author zhoumin
     * @Date 2017/03/07 下午 02:24
     * @throws []
     */
    SmsMerchantSign getSign(Map<String,Object> map);

    /**
     * 根据主键ID和商户ID查询签名记录
     * @Author xiehb
     * @param map
     * @return
     */
    SmsMerchantSign getSignById(Map<String,Object> map);
    /**
     * @Description: 查询审核状态是审核中的签名
     * @Title querySign
     * @Author zhoumin
     * @Date 2017/03/08 下午 05:24
     * @throws []
     */
    List<SmsMerchantSign> querySign(Page<SmsMerchantSign> page);

    /**
     * @Description: 根据商户ID查询数据库记录
     * @Title querySignByMerchantId
     * @Author zhoumin
     * @Date 2017/03/09 下午 04:04
     * @throws []
     */
    List<SmsMerchantSign> querySignByMerchantId(Long merchantId);
}