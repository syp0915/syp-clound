package com.shfc.cloud.flowscreen.ao;

import com.shfc.cloud.constant.CloudConstant;
import com.shfc.cloud.flowscreen.dto.FlowscreenDTO;
import com.shfc.cloud.utils.HttpSessionUtils;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.flowscreen.domain.FlowscreenRecord;
import com.shfc.flowscreen.service.FlowscreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package com.shfc.apistore.flowscreen.ao
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/3/30 上午9:43
 * version V1.0.0
 */
@Service
public class FlowscreenAO {
    @Autowired
    private FlowscreenService flowscreenService;

    public ResultDO<Object> flowscreenReq(FlowscreenDTO flowscreenDTO){
        Long merchantId = HttpSessionUtils.getObject(CloudConstant.CURRENT_MERCHANT_ID);
        if (ValidateHelper.isEmpty(flowscreenDTO.getChannelNo())||ValidateHelper.isEmpty(flowscreenDTO.getMac())
                ||ValidateHelper.isEmpty(flowscreenDTO.getUrl())) {
            ResultDO<Object> resultDO = new ResultDO<>();
            resultDO.setErrMsg("请求参数不正确");
            return resultDO;
        }
        FlowscreenRecord flowscreenRecord = new FlowscreenRecord();
        flowscreenRecord.setMerchantId(merchantId);
        flowscreenRecord.setChannelNo(flowscreenDTO.getChannelNo());
        flowscreenRecord.setUrl(flowscreenDTO.getUrl());
        flowscreenRecord.setMac(flowscreenDTO.getMac());
        return flowscreenService.flowscreenReq(flowscreenRecord);
    }

}
