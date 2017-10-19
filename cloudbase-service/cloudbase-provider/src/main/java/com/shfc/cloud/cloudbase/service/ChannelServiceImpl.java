package com.shfc.cloud.cloudbase.service;

import com.shfc.cloud.cloudbase.domain.SourceChannel;
import com.shfc.cloud.cloudbase.dto.ChannelDTO;
import com.shfc.cloud.cloudbase.dto.ChannelMerchantDTO;
import com.shfc.cloud.cloudbase.manager.ChannelManager;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-28 13:57
 **/
@Service
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private ChannelManager channelManager;
    @Override
    public ResultDO<ChannelDTO> queryChannelByNo(String channelNo) {
        ResultDO<ChannelDTO> resultDO = new ResultDO<ChannelDTO>();
        if (ValidateHelper.isEmpty(channelNo)) {
            resultDO.setErrMsg("请求参数不能为空");
            return resultDO;
        }

        ChannelDTO channelDTO = channelManager.queryChannelNameByNo(channelNo);
        resultDO.setData(channelDTO);
        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public ResultDO<ChannelDTO> queryAllChannelByNo(String channelNo) {
        ResultDO<ChannelDTO> resultDO = new ResultDO<ChannelDTO>();
        if (ValidateHelper.isEmpty(channelNo)) {
            resultDO.setErrMsg("请求参数不能为空");
            return resultDO;
        }

        ChannelDTO channelDTO = channelManager.queryAllChannelNameByNo(channelNo);
        resultDO.setData(channelDTO);
        resultDO.setSuccess(true);
        return resultDO;
    }

    /**
     * 获取所有有效的频道列表
     *
     * @return
     */
    @Override
    public ResultDO<List<ChannelMerchantDTO>> queryAllChannelList() {
        ResultDO<List<ChannelMerchantDTO>> resultDO = new ResultDO<List<ChannelMerchantDTO>>();
        List<ChannelMerchantDTO> channelList = new ArrayList<ChannelMerchantDTO>();

        List<SourceChannel> list = null;
        try {
            list = channelManager.queryAllChannelList();
        } catch (Exception e) {
            e.printStackTrace();
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg("数据库异常");
            return resultDO;
        }
        if (list != null && list.size() > 0){
            for (SourceChannel channel : list) {
                ChannelMerchantDTO channelMerchantDTO = new ChannelMerchantDTO();
                channelMerchantDTO.setChannelNo(channel.getChannelNumber());
                channelMerchantDTO.setMerchantId(channel.getMerchantId());
                channelList.add(channelMerchantDTO);
            }
        }
        resultDO.setSuccess(true);
        resultDO.setErrCode(0);
        resultDO.setErrMsg("成功");
        resultDO.setData(channelList);
        return resultDO;
    }
}
