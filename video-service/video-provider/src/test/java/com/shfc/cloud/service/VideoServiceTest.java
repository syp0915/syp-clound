package com.shfc.cloud.service;

import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.JunitBaseTest;
import com.shfc.cloud.video.constant.AttachConstant;
import com.shfc.cloud.video.constant.AttachStatusConstant;
import com.shfc.cloud.video.constant.EnvironmentConstant;
import com.shfc.cloud.video.dto.ResourceInfoDTO;
import com.shfc.cloud.video.dto.ResourceListDTO;
import com.shfc.cloud.video.query.*;
import com.shfc.cloud.video.service.VideoService;
import com.shfc.common.result.ResultDO;
import com.shfc.mybatis.pagination.Page;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

/**
 * @Package com.shfc.cloud.service.VideoServiceTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/28 10:22
 * version V1.0.0
 */
public class VideoServiceTest extends JunitBaseTest {

    @Autowired
    private VideoService videoService;

    @Test
    public void testWarlist(){
        WarlistQuery query = new WarlistQuery();
        query.setMerchantId(100029L);
        query.setChannelNo("997");
        query.setEnvironment(EnvironmentConstant.Test.getCode()+"");
        Page page = new Page();
        page.setPageNumber(1);
        page.setPageSize(20);
        query.setPage(page);
        ResultDO result = videoService.warlist(query);
        System.out.println(result.isSuccess()+"---------"+result.getErrMsg());
    }

    @Test
    public void testUploadWar(){
        UploadWarQuery query = new UploadWarQuery();
        query.setMerchantId(1L);
        query.setChannelNo("997");
        query.setEnvironment(EnvironmentConstant.Test);
        query.setWarName("test11.war");
        query.setWarVersion("1.0");
        File warContent = new File("D:\\trade-module.rar");
//        query.setWarContent(warContent);
        ResultDO result = videoService.uploadWar(query);
        System.out.println(result.isSuccess()+"---------"+result.getErrMsg());
    }

    @Test
    public void testDownloadWar(){
        DownloadWarQuery query = new DownloadWarQuery();
        query.setMerchantId(1L);
        query.setChannelNo("997");
        query.setWarId(5L);
        ResultDO result = videoService.downloadWar(query);
        System.out.println(result.isSuccess()+"---------"+result.getErrMsg());
    }

    @Test
    public void testImgZoom(){
        ImgZoomQuery query = new ImgZoomQuery();
        query.setMerchantId(1L);
        query.setChannelNo("997");
        query.setHeight(500);
        query.setWidth(500);
        query.setImageUrl("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2592175618,2686141055&fm=23&gp=0.jpg");
        ResultDO<String> result = videoService.imgZoom(query);
        System.out.println(result.isSuccess()+"---------"+result.getErrMsg()+"CCCC"+result.getData());
        System.out.println("11111");
    }

    @Test
    public void tesetUploadFile() {
        UploadFileQuery query = new UploadFileQuery();
        query.setMerchantId(1L);
        query.setChannelNo("997");
        File file = new File("D:\\trade-module.rar");
        query.setFileName("trade-module.rar");
        query.setType(AttachConstant.War);
        ResultDO<JSONObject> result = videoService.uploadFile(query);
        System.out.println(result.isSuccess()+"---------"+result.getErrMsg()+"CCCC"+result.getData());
    }

    @Test
    public void tesetResourceInfo(){
        ResourceInfoQuery query = new ResourceInfoQuery();
        query.setMerchantId(1L);
        query.setChannelNo("997");
        query.setFileId(3L);
        ResultDO<ResourceInfoDTO> result = videoService.resourceInfo(query);
        System.out.println(result.isSuccess()+"---------"+result.getErrMsg()+"CCCC"+result.getData().getImgTypeName());
    }

    @Test
    public void tesetResourceList(){
        ResourceListQuery query = new ResourceListQuery();
        query.setMerchantId(888888L);
        query.setType(AttachConstant.Image);
        query.setStatus(AttachStatusConstant.FirstReview);
        ResultDO<Page<ResourceListDTO>> result = videoService.resourceList(query);
        System.out.println(result.isSuccess()+"---------"+result.getErrMsg()+"CCCC"+result.getData().getTotalSize());
    }

    @Test
    public void tesetResourceList2(){
        ResourceListQuery query = new ResourceListQuery();
        query.setMerchantId(888888L);
        query.setType(AttachConstant.Image);
        ResultDO<Page<ResourceListDTO>> result = videoService.resourceList(query);
        System.out.println(result.isSuccess()+"---------"+result.getErrMsg()+"CCCC"+result.getData().getTotalSize());
    }

    @Test
    public void tesetResourceList3(){
        ResourceListQuery query = new ResourceListQuery();
        query.setMerchantId(1888888L);
        query.setType(AttachConstant.Image);
        ResultDO<Page<ResourceListDTO>> result = videoService.resourceList(query);
        System.out.println(result.isSuccess()+"---------"+result.getErrMsg()+"CCCC"+result.getData().getTotalSize());
    }

    public static void main(String[] args) {
        String imageUrl = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2592175618,2686141055&fm=23&gp=0.jpg";
        System.out.println(imageUrl.substring(imageUrl.lastIndexOf("."),imageUrl.length()));
    }
}
