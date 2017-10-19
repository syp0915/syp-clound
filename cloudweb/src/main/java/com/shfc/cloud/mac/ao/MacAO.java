package com.shfc.cloud.mac.ao;

import com.shfc.cloud.mac.dto.MacDetailWebDTO;
import com.shfc.cloud.mac.dto.MacWebDTO;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.mac.dto.MacInfoDTO;
import com.shfc.mac.query.MacQuery;
import com.shfc.mac.service.MacListService;
import com.shfc.mybatis.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package com.shfc.cloud.mac.ao.MacAO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/29 13:22
 * version V1.0.0
 */
@Service
public class MacAO {
    @Autowired
    private MacListService macListService;

    /**
     * mac详情
     * @param webDTO
     * @return
     */
    public ResultDO<MacInfoDTO> macDetail(MacDetailWebDTO webDTO){
        MacQuery query = new MacQuery();
        BeanUtils.copyProperties(webDTO,query);
        ResultDO<MacInfoDTO> resultDO = new ResultDO<>();
        Long merchantId = query.getMerchantId();
        String channelNo  = query.getChannelNo();
        String mac = query.getMac();
        if(merchantId==null){
            resultDO.setErrMsg("商户ID不能为空！");
            return resultDO;
        }
        if(channelNo == null){
            resultDO.setErrMsg("频道编号不能为空!");
            return resultDO;
        }
        if(ValidateHelper.isEmptyString(mac)){
            resultDO.setErrMsg("mac不能为空！");
            return resultDO;
        }
        resultDO = macListService.macDetail(query);
        return resultDO;
    }

    /**
     * mac列表
     * @param webDTO
     * @return
     */
    public ResultDO<Page<MacInfoDTO>> macList(MacWebDTO webDTO){
        MacQuery query = new MacQuery();
        BeanUtils.copyProperties(webDTO,query);
        ResultDO<Page<MacInfoDTO>> resultDO = new ResultDO<>();
        Long merchantId = query.getMerchantId();
        String channelNo  = query.getChannelNo();
        if(merchantId==null){
            resultDO.setErrMsg("商户ID不能为空！");
            return resultDO;
        }
        if(channelNo == null){
            resultDO.setErrMsg("频道编号不能为空!");
            return resultDO;
        }
        resultDO = macListService.macList(query);
        return resultDO;
    }
}
