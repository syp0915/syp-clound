package com.shfc.cloud.cloudbase.service;

import com.shfc.cloud.cloudbase.dto.ChannelDTO;
import com.shfc.cloud.cloudbase.dto.PlotDTO;
import com.shfc.cloud.cloudbase.manager.KeywordManager;
import com.shfc.cloud.cloudbase.query.ChannelQuery;
import com.shfc.cloud.cloudbase.query.PlotNameQuery;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 关键词联想
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-25 13:54
 **/
@Service
public class KeywordServiceImpl implements KeywordService {
    @Autowired(required = false)
    private KeywordManager keywordManager;
    @Override
    public ResultDO<List<PlotDTO>> queryPlotNameBykeyword(PlotNameQuery query) {
        ResultDO<List<PlotDTO>> resultDO=new ResultDO<List<PlotDTO>>();

        if(ValidateHelper.isEmpty(query.getKeyword())){
            resultDO.setErrMsg("关键词不能为空");
            return resultDO;
        }

        List<PlotDTO> list=keywordManager.queryPlotNameBykeyWord(query);
        resultDO.setData(list);
        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public ResultDO<List<ChannelDTO>> queryChannelBykeyword(ChannelQuery query) {
        ResultDO<List<ChannelDTO>> resultDO=new ResultDO<List<ChannelDTO>>();

        if(ValidateHelper.isEmpty(query.getKeyword())){
            resultDO.setErrMsg("关键词不能为空");
            return resultDO;
        }
        List<ChannelDTO> list=keywordManager.queryChannelBykeyWord(query);
        resultDO.setData(list);
        resultDO.setSuccess(true);
        return resultDO;
    }
}
