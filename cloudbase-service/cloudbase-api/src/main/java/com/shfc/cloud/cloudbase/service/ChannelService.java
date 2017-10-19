package com.shfc.cloud.cloudbase.service;

import com.shfc.cloud.cloudbase.dto.ChannelDTO;
import com.shfc.cloud.cloudbase.dto.ChannelMerchantDTO;
import com.shfc.common.result.ResultDO;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 频道服务
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-28 13:55
 **/
public interface ChannelService {

    /**
     * @Description: 根据频道号查询频道信息
     * @Title queryPlotByKeyword
     * @Author  wuky
     * @Date 2017/1/3 17:17
     * @param  channelNo
     * @return ResultDO<PlotAddressDTO>
     * @throws
     */
    ResultDO<ChannelDTO> queryChannelByNo(String channelNo);

    /**
     * @Description: 根据频道号查询频道信息
     * @Title queryPlotByKeyword
     * @Author  wuky
     * @Date 2017/1/3 17:17
     * @param  channelNo
     * @return ResultDO<PlotAddressDTO>
     * @throws
     */
    ResultDO<ChannelDTO> queryAllChannelByNo(String channelNo);

    /**
     * 获取所有有效的频道列表
     * @return
     */
    ResultDO<List<ChannelMerchantDTO>> queryAllChannelList();

}
