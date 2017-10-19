package com.shfc.cloud.gateway.manager;

import com.shfc.cloud.gateway.dao.GatewayIpWhiteMapper;
import com.shfc.cloud.gateway.domain.GatewayIpWhite;
import com.shfc.cloud.gateway.dto.WhiteListDTO;
import com.shfc.mybatis.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类注释
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/3/27 9:51
 * @since 1.0
 */
@Service
public class WhiteListManager {
    @Resource
    private GatewayIpWhiteMapper gatewayIpWhiteMapper;

    public boolean insert(WhiteListDTO whiteListDTO) {
        GatewayIpWhite gatewayIpWhite=new GatewayIpWhite();
        BeanUtils.copyProperties(whiteListDTO,gatewayIpWhite);
        return gatewayIpWhiteMapper.insert(gatewayIpWhite)==1;
    }

    public Page<GatewayIpWhite> select(WhiteListDTO whiteListDTO,Page page) {
         gatewayIpWhiteMapper.selectByPage(whiteListDTO ,page);
         return page;
    }

    public List<GatewayIpWhite> selectByMerchantId(long merchantId) {
        return  gatewayIpWhiteMapper.selectByMerchantId(merchantId );
    }
    public boolean update(GatewayIpWhite gatewayIpWhite) {
        return gatewayIpWhiteMapper.updateByIp(gatewayIpWhite)==1;
    }
}
