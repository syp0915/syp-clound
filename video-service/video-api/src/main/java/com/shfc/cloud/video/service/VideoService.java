package com.shfc.cloud.video.service;

import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.video.dto.DownloadWarDTO;
import com.shfc.cloud.video.dto.ResourceInfoDTO;
import com.shfc.cloud.video.dto.ResourceListDTO;
import com.shfc.cloud.video.dto.WarlistDTO;
import com.shfc.cloud.video.query.*;
import com.shfc.common.result.ResultDO;
import com.shfc.mybatis.pagination.Page;

/**
 * @Package com.shfc.cloud.video.service.VideoService
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/18 15:31
 * version V1.0.0
 */
public interface VideoService {

    /**
     * 上传war包
     * @param query
     * @return
     */
    ResultDO uploadWar(UploadWarQuery query);

    /**
     * war包附件下载
     * @param query
     * @return
     */
    ResultDO<DownloadWarDTO> downloadWar(DownloadWarQuery query);

    /**
     * war包列表
     * @param query
     * @return
     */
    ResultDO<Page<WarlistDTO>> warlist(WarlistQuery query);

    /**
     * 图片缩放
     * @param query 缩放之后的图片URL
     * @return
     */
    ResultDO<String> imgZoom(ImgZoomQuery query);

    /**
     * 视频转码功能
     * @param query 视频访问url
     * @return
     */
    ResultDO<String> videoTranscod(VideoTranscodQuery query);

    /**
     * 资源列表 分页
     * @param query
     * @return
     */
    ResultDO<Page<ResourceListDTO>> resourceList(ResourceListQuery query);

    /**
     * 资源审批功能
     * @param query
     * @return
     */
    ResultDO resourceCheck(ResourceCheckQuery query);

    /**
     * 资源详情
     * @param query
     * @return
     */
    ResultDO<ResourceInfoDTO> resourceInfo(ResourceInfoQuery query);

    /**
     * 资源上传
     * @param query
     * @return 文件访问url
     */
    ResultDO<JSONObject> uploadFile(UploadFileQuery query);

    /**
     * 删除war包 假删除
     * @param query
     * @return
     */
    ResultDO<Boolean> deleteWar(DeleteWarQuery query);

    /**
     * 获取图片和视频审批通过的总大小情况
     * @param channelNo
     * @return
     */
    ResultDO<Integer> queryImageSumSize(String channelNo);
}
