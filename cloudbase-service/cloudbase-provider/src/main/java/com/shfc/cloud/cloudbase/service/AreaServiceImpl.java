package com.shfc.cloud.cloudbase.service;

import com.fc.common.redis.RedisUtil;
import com.shfc.cloud.cloudbase.domain.BaseBlock;
import com.shfc.cloud.cloudbase.domain.BaseDistrict;
import com.shfc.cloud.cloudbase.dto.BlockInfoDTO;
import com.shfc.cloud.cloudbase.dto.RegionInfoDTO;
import com.shfc.cloud.cloudbase.manager.AreaManager;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import org.apache.log4j.Logger;
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
 * @create 2016-12-30 09:30
 **/
@Service
public class AreaServiceImpl implements AreaService {
    public static final Logger LOGGER = Logger.getLogger(AreaServiceImpl.class);

    @Autowired
    private AreaManager areaManager;
    @Override
    public ResultDO<List<RegionInfoDTO>> getRegionBlockInfo(String cityId) {
        ResultDO<List<RegionInfoDTO>> resultDO=new ResultDO<List<RegionInfoDTO>>();
        if (ValidateHelper.isEmpty(cityId)) {
            resultDO.setErrMsg("请求参数不能为空");
            return resultDO;
        }
        Object object= RedisUtil.get(cityId);
        if(object!=null){
            List<RegionInfoDTO> list=(List<RegionInfoDTO>)object;
            resultDO.setData(list);
            resultDO.setSuccess(true);
            return resultDO;
        }

        List<RegionInfoDTO> list = new ArrayList<RegionInfoDTO>();
        //查询区域
        List<BaseDistrict> districts = areaManager.selectByCityId(cityId);

        for (BaseDistrict baseDistrict : districts) {
            RegionInfoDTO regionInfoDTO = new RegionInfoDTO();
            regionInfoDTO.setRegionId(String.valueOf(baseDistrict.getId()));
            regionInfoDTO.setRegionName(baseDistrict.getDistrictName());
            List<BlockInfoDTO> blockList = new ArrayList<BlockInfoDTO>();
            // 查询区县下的街道、镇
            List<BaseBlock> blocks = areaManager.selectByDistrictId(baseDistrict.getId());
                for (BaseBlock baseBlock : blocks) {
                    BlockInfoDTO blockInfoDTO = new BlockInfoDTO();
                    blockInfoDTO.setBlockId(String.valueOf(baseBlock.getId()));
                    blockInfoDTO.setBlockName(baseBlock.getBlockName());
                    blockList.add(blockInfoDTO);
                }
            regionInfoDTO.setBlockList(blockList);
            list.add(regionInfoDTO);
        }
        resultDO.setData(list);

        if(!ValidateHelper.isEmpty(resultDO.getData())){
            RedisUtil.set(cityId, resultDO.getData(), 3600);
        }

        resultDO.setSuccess(true);
        return resultDO;
    }
}
