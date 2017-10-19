package com.shfc.mac.manager;

import com.shfc.common.exception.AppException;
import com.shfc.mac.dao.MacInfoMapper;
import com.shfc.mac.domain.MacInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Package com.shfc.mac.manager.MacInfoManager
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/28 20:39
 * version V1.0.0
 */
@Service
public class MacInfoManager {
    @Autowired
    private MacInfoMapper macInfoMapper;

    /**
     * 根据mac名称查询
     * @param mac
     * @return
     */
    public MacInfo selectByMac(String mac){
        return macInfoMapper.selectByMac(mac);
    }

    /**
     * mac 本地保存
     * @param record
     * @throws AppException
     */
    @Transactional(rollbackFor = AppException.class)
    public void insert(MacInfo record) throws AppException{
        macInfoMapper.insert(record);
    }
}
