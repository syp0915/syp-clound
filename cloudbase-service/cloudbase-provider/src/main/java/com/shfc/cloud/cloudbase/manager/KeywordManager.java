package com.shfc.cloud.cloudbase.manager;

import com.shfc.cloud.cloudbase.dao.PlotMapper;
import com.shfc.cloud.cloudbase.dao.SourceChannelMapper;
import com.shfc.cloud.cloudbase.dto.ChannelDTO;
import com.shfc.cloud.cloudbase.dto.PlotDTO;
import com.shfc.cloud.cloudbase.query.ChannelQuery;
import com.shfc.cloud.cloudbase.query.PlotNameQuery;
import com.shfc.common.base.ValidateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-25 14:18
 **/
@Service
public class KeywordManager {

    @Autowired(required = false)
    private PlotMapper plotMapper;

    @Autowired(required = false)
    private SourceChannelMapper sourceChannelMapper;

    public List<PlotDTO> queryPlotNameBykeyWord(PlotNameQuery query){
        HashMap<String,Object> params=new HashMap<String,Object>();
        params.put("keyword",query.getKeyword());
        if(query.getNum()!=null&&query.getNum()!=0){
            params.put("num",query.getNum());
        }
        if(!ValidateHelper.isEmpty(query.getDistrictId())){
            params.put("districtId",Integer.parseInt(query.getDistrictId()));
        }
        if(!ValidateHelper.isEmpty(query.getBlockId())){
            params.put("blockId",Integer.parseInt(query.getBlockId()));
        }

        return plotMapper.queryPlotNameBykeyWord(params);
    }


    public List<ChannelDTO> queryChannelBykeyWord(ChannelQuery query){
        HashMap<String,Object> params=new HashMap<String,Object>();
        params.put("keyword",query.getKeyword());
        if(query.getNum()!=null&&query.getNum()!=0){
            params.put("num",query.getNum());
        }

        return sourceChannelMapper.queryChannelByKeyword(params);
    }


}
