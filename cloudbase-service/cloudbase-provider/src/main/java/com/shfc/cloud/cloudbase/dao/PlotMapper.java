package com.shfc.cloud.cloudbase.dao;

import com.shfc.cloud.cloudbase.domain.Plot;
import com.shfc.cloud.cloudbase.dto.PlotDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface PlotMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Plot record);

    int insertSelective(Plot record);

    Plot selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Plot record);

    int updateByPrimaryKey(Plot record);

    List<PlotDTO> queryPlotNameBykeyWord(HashMap<String, Object> params);
}