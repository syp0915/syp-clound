package com.shfc.cloud.video.service;

import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.video.dto.DownloadWarDTO;
import com.shfc.cloud.video.dto.ResourceInfoDTO;
import com.shfc.cloud.video.dto.ResourceListDTO;
import com.shfc.cloud.video.dto.WarlistDTO;
import com.shfc.cloud.video.manager.VideoManager;
import com.shfc.cloud.video.query.*;
import com.shfc.common.result.ResultDO;
import com.shfc.mybatis.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package com.shfc.cloud.video.service.VideoServiceImpl
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 15:54
 * version V1.0.0
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoManager videoManager;

    @Override
    public ResultDO uploadWar(UploadWarQuery query) {

        return videoManager.uploadWar(query);
    }

    @Override
    public ResultDO<DownloadWarDTO> downloadWar(DownloadWarQuery query) {

        return videoManager.downloadWar(query);
    }

    @Override
    public ResultDO<Page<WarlistDTO>> warlist(WarlistQuery query) {
        ResultDO<Page<WarlistDTO>> result = new ResultDO<Page<WarlistDTO>>();
        Page<WarlistDTO> page = videoManager.warlist(query, query.getPage());
        result.setData(page);
        result.setSuccess(true);
        return result;
    }

    @Override
    public ResultDO<String> imgZoom(ImgZoomQuery query) {

        return videoManager.imgZoom(query);
    }

    @Override
    public ResultDO<String> videoTranscod(VideoTranscodQuery query) {

        return videoManager.videoTranscod(query);
    }

    @Override
    public ResultDO<Page<ResourceListDTO>> resourceList(ResourceListQuery query) {
        ResultDO<Page<ResourceListDTO>> result = new ResultDO<Page<ResourceListDTO>>();
        Page<ResourceListDTO> page = videoManager.resourceList(query, query.getPage());
        result.setData(page);
        result.setSuccess(true);
        return result;
    }

    @Override
    public ResultDO resourceCheck(ResourceCheckQuery query) {

        return videoManager.resourceCheck(query);
    }

    @Override
    public ResultDO<ResourceInfoDTO> resourceInfo(ResourceInfoQuery query) {

        return videoManager.resourceInfo(query);
    }

    @Override
    public ResultDO<JSONObject> uploadFile(UploadFileQuery query) {

        return videoManager.uploadFile(query);
    }

    @Override
    public ResultDO<Boolean> deleteWar(DeleteWarQuery query) {
        return videoManager.deleteWar(query);
    }

    @Override
    public ResultDO<Integer> queryImageSumSize(String channelNo) {
        return videoManager.queryImageSumSize(channelNo);
    }
}
