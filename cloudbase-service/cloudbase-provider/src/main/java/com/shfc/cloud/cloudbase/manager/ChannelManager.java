package com.shfc.cloud.cloudbase.manager;

import com.shfc.cloud.cloudbase.dao.SourceChannelMapper;
import com.shfc.cloud.cloudbase.domain.SourceChannel;
import com.shfc.cloud.cloudbase.dto.ChannelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-28 13:58
 **/
@Service
public class ChannelManager {
    @Autowired(required = false)
    private SourceChannelMapper sourceChannelMapper;

    public ChannelDTO queryChannelNameByNo(String channelNo){
        return sourceChannelMapper.queryChannelNameByNo(channelNo);
    }

    public ChannelDTO queryAllChannelNameByNo(String channelNo){
        return sourceChannelMapper.queryAllChannelNameByNo(channelNo);
    }

    public List<SourceChannel> queryAllChannelList(){
        return sourceChannelMapper.queryAllChannelList();
    }

}
