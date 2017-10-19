package com.shfc.mac.service;

import com.alibaba.fastjson.JSONObject;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.exception.AppException;
import com.shfc.common.result.ResultDO;
import com.shfc.mac.domain.MacInfo;
import com.shfc.mac.dto.MacDetailRemoteDTO;
import com.shfc.mac.dto.MacInfoDTO;
import com.shfc.mac.dto.MacListRemoteDTO;
import com.shfc.mac.enums.MacErrorCode;
import com.shfc.mac.manager.MacInfoManager;
import com.shfc.mac.query.MacQuery;
import com.shfc.mac.remote.MacRemoteService;
import com.shfc.mybatis.pagination.Page;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Package com.shfc.mac.service.MacListServiceImpl
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/14 17:40
 * version V1.0.0
 */
@Service
public class MacListServiceImpl implements MacListService{
    private static final Logger logger = Logger.getLogger(MacListServiceImpl.class);
    @Autowired
    private MacInfoManager macInfoManager;
    @Autowired
    private MacRemoteService macRemoteService;
    @Override
    public ResultDO<Page<MacInfoDTO>> macList(MacQuery query) {
        ResultDO<Page<MacInfoDTO>> resultDO = new ResultDO();
        Page<MacInfoDTO> page = new Page<>();
        Long districtId = query.getDistrictId();//区县ID
        Long blockId = query.getBlockId();//板块ID
        Long residenceId = query.getResidenceId();//小区ID
        Integer pageNumber  = query.getPageNumber();
        Integer pageSize  = query.getPageSize();
        List<MacInfoDTO>  datalist = new ArrayList<>();
        Map<String, String> paramMap = new HashMap<>();
        if(districtId!=null){
            paramMap.put("districtId",String.valueOf(districtId));
        }
        if(blockId!=null){
            paramMap.put("blockId",String.valueOf(blockId));
        }
        if(residenceId!=null){
            paramMap.put("residenceId",String.valueOf(residenceId));
        }
        if(pageNumber!=null){
            paramMap.put("pageNo",String.valueOf(pageNumber));
        }
        if(pageSize!=null){
            paramMap.put("pageSize",String.valueOf(pageSize));
        }
        String result  = macRemoteService.macList(paramMap);
        System.out.println("macList==result=="+result);
        MacListRemoteDTO remoteObject = JSONObject.parseObject(result,MacListRemoteDTO.class);
        if(remoteObject!=null){
            String status = remoteObject.getResStatus();
            if(status.equals("success")){
                List<MacInfoDTO> dataList = remoteObject.getResult();
                page.setData(dataList);
                page.setPageNumber(remoteObject.getPageNo());
                page.setPageSize(remoteObject.getPageSize());
                page.setTotalSize(Long.valueOf(remoteObject.getTotalCount()));
                resultDO.setData(page);
                resultDO.setSuccess(true);
            }else {
                resultDO.setErrCode(MacErrorCode.MAC_REMOTE_ERROR.getCode());
                resultDO.setErrMsg(remoteObject.getResMessage());
                return resultDO;
            }
        }
        return resultDO;
    }

    /**
     * 先根据mac查询本地，本地没有值再远程调用接口
     * @param query
     * @return
     */
    @Override
    public ResultDO<MacInfoDTO> macDetail(MacQuery query) {
        ResultDO<MacInfoDTO> resultDO = new ResultDO<>();
        MacInfoDTO macInfoDTO = new MacInfoDTO();
        String mac =  query.getMac();
        if(ValidateHelper.isEmptyString(mac)){
            resultDO.setErrCode(MacErrorCode.PARAMETER_NOT_NULL.getCode());
            resultDO.setErrMsg(MacErrorCode.PARAMETER_NOT_NULL.getMsg());
            return resultDO;
        }
        MacInfo record = macInfoManager.selectByMac(mac);
        if(record != null){
            BeanUtils.copyProperties(record,macInfoDTO);
            resultDO.setData(macInfoDTO);
            resultDO.setSuccess(true);
            return resultDO;
        }
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("mac",mac);
        String result  = macRemoteService.macDetail(paramMap);
        logger.info("result==="+ result);
        MacDetailRemoteDTO detailRemoteDTO = JSONObject.parseObject(result,MacDetailRemoteDTO.class);

        if(detailRemoteDTO==null){
            resultDO.setErrMsg("远程调用结果异常！");
            return resultDO;
        }
        String status = detailRemoteDTO.getResStatus();
        if(status.equals("02001200000")){
            macInfoDTO = detailRemoteDTO.getResult();
            record = new MacInfo();
            BeanUtils.copyProperties(macInfoDTO,record);
            try {
                macInfoManager.insert(record);
            } catch (AppException e) {
                logger.error("mac详情保存失败！"+e);
            }
            resultDO.setData(macInfoDTO);
            resultDO.setSuccess(true);
            return resultDO;
        }else {
            resultDO.setErrCode(MacErrorCode.MAC_REMOTE_ERROR.getCode());
            resultDO.setErrMsg(detailRemoteDTO.getResMessage());
            return resultDO;
        }
    }
}
