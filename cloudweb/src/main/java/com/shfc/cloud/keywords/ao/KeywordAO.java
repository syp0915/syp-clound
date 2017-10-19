package com.shfc.cloud.keywords.ao;

import com.shfc.cloud.cloudbase.dto.ChannelDTO;
import com.shfc.cloud.cloudbase.dto.PlotDTO;
import com.shfc.cloud.cloudbase.query.ChannelQuery;
import com.shfc.cloud.cloudbase.query.PlotNameQuery;
import com.shfc.cloud.cloudbase.service.KeywordService;
import com.shfc.cloud.keywords.dto.ChannelNameDTO;
import com.shfc.cloud.keywords.dto.PlotNameDTO;
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
 * @create 2017-03-17 13:46
 **/
@Service
public class KeywordAO {
    @Autowired
    private KeywordService keywordService;

    public ResultDO<List<PlotDTO>> queryPlotNameBykeyword(PlotNameDTO dto){
        ResultDO<List<PlotDTO>> resultDO=new ResultDO<List<PlotDTO>>();

        if(ValidateHelper.isEmpty(dto.getKeyword())){
            resultDO.setErrMsg("请求参数关键词不能为空");
            return resultDO;
        }

        PlotNameQuery query=new PlotNameQuery();
        query.setKeyword(dto.getKeyword());
        query.setNum(dto.getNum());
        if(!ValidateHelper.isEmpty(dto.getDistrictId())){
           query.setDistrictId(dto.getDistrictId());
        }

        if(!ValidateHelper.isEmpty(dto.getBlockId())){
            query.setBlockId(dto.getBlockId());
        }

        ResultDO<List<PlotDTO>> result=keywordService.queryPlotNameBykeyword(query);
        if(!result.isSuccess()){
          resultDO.setErrMsg(result.getErrMsg());
            return resultDO;
        }

        resultDO.setData(result.getData());
        resultDO.setSuccess(true);
        return resultDO;

    }


    public ResultDO<List<ChannelDTO>> queryChannelBykeyword(ChannelNameDTO dto){
        ResultDO<List<ChannelDTO>> resultDO=new ResultDO<List<ChannelDTO>>();

        if(ValidateHelper.isEmpty(dto.getKeyword())){
            resultDO.setErrMsg("请求参数关键词不能为空");
            return resultDO;
        }

        ChannelQuery query=new ChannelQuery();
        query.setKeyword(dto.getKeyword());
        query.setNum(dto.getNum());

        ResultDO<List<ChannelDTO>> result=keywordService.queryChannelBykeyword(query);
        if(!result.isSuccess()){
            resultDO.setErrMsg(result.getErrMsg());
            return resultDO;
        }

        resultDO.setData(result.getData());
        resultDO.setSuccess(true);
        return resultDO;

    }


}
