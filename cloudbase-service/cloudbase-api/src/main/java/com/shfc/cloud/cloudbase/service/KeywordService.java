package com.shfc.cloud.cloudbase.service;

import com.shfc.cloud.cloudbase.dto.ChannelDTO;
import com.shfc.cloud.cloudbase.dto.PlotDTO;
import com.shfc.cloud.cloudbase.query.ChannelQuery;
import com.shfc.cloud.cloudbase.query.PlotNameQuery;
import com.shfc.common.result.ResultDO;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-25 13:34
 **/
public interface KeywordService {

    public ResultDO<List<PlotDTO>> queryPlotNameBykeyword(PlotNameQuery query);

    public ResultDO<List<ChannelDTO>> queryChannelBykeyword(ChannelQuery query);
}
