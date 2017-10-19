package com.shfc.cloud.gateway.manager;

import com.shfc.cloud.gateway.dao.GatewayInterfaceAuthMapper;
import com.shfc.cloud.gateway.domain.GatewayInterfaceAuth;
import com.shfc.cloud.gateway.dto.GatewayAuthDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 类注释
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/3/27 9:52
 * @since 1.0
 */
@Service
public class GatewayAuthManager {
    @Resource
    private GatewayInterfaceAuthMapper gatewayAuthMapper;

    public boolean insert(GatewayAuthDTO gatewayAuthDTO) {
        GatewayInterfaceAuth gatewayAuth=new GatewayInterfaceAuth();
        BeanUtils.copyProperties(gatewayAuthDTO,gatewayAuth);
        gatewayAuth.setEndDate(gatewayAuthDTO.getEndTime());
        gatewayAuth.setStartDate(gatewayAuthDTO.getStartTime());
        return gatewayAuthMapper.insert(gatewayAuth)==1;
    }

    public List<GatewayInterfaceAuth> select(Map map) {
        return gatewayAuthMapper.selectByMerchantId(map);
    }

    public boolean update(GatewayInterfaceAuth gatewayAuth) {
         return gatewayAuthMapper.updateByPrimaryKey(gatewayAuth)==1;
    }

    public boolean delete(GatewayInterfaceAuth gatewayAuth) {
        return gatewayAuthMapper.updateBydel(gatewayAuth)==1;
    }
}
