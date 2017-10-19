package com.shfc.cloud.video.ao;

import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.common.ao.BaseAO;
import com.shfc.cloud.constant.ErrorConstant;
import com.shfc.cloud.video.constant.*;
import com.shfc.cloud.video.dto.*;
import com.shfc.cloud.video.query.*;
import com.shfc.cloud.video.service.VideoService;
import com.shfc.common.base.Logger;
import com.shfc.common.base.UUIDUtils;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.date.DateUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.fastdfs.FastdfsClient;
import com.shfc.fastdfs.FastdfsClientService;
import com.shfc.mybatis.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * @Package com.shfc.cloud.video.ao.ResourceAO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/16 15:34
 * version V1.0.0
 */
@Service
public class VideoAO extends BaseAO {

    @Autowired
    private VideoService videoService;

    @Value("${fastdfs.download.url}")
    private String fastdfsDownloadUrl;

    @Value("${save_path}")
    private String savePath;

    @Value("${ffmpeg_path}")
    private String ffmpegPath;

    @Value("${war.path}")
    private String warPath;

    FastdfsClient fastdfsClient = FastdfsClientService.getInstance().getFastdfsClient();//实例FastdfsClient


    public ResultDO uploadWar(UploadWarDTO uploadWarDTO,String fileName){
        ResultDO result = new ResultDO();
        result = checkCommonData(uploadWarDTO.getMerchantId(),uploadWarDTO.getChannelNo());
        if(!result.isSuccess()){
            return result;
        }
        if(ValidateHelper.isEmpty(uploadWarDTO.getEnvironment())){
            result.setErrCode(ErrorConstant.NULL_ENVIROMENT.getCode());
            result.setErrMsg(ErrorConstant.NULL_ENVIROMENT.getMsg());
            result.setSuccess(false);
            return result;
        }
        if(ValidateHelper.isEmpty(uploadWarDTO.getWarName())){
            result.setErrCode(ErrorConstant.NULL_ENVIROMENT.getCode());
            result.setErrMsg(ErrorConstant.NULL_ENVIROMENT.getMsg());
            result.setSuccess(false);
            return result;
        }
        if(ValidateHelper.isEmpty(uploadWarDTO.getWarVersion())){
            result.setErrCode(ErrorConstant.NULL_ENVIROMENT.getCode());
            result.setErrMsg(ErrorConstant.NULL_ENVIROMENT.getMsg());
            result.setSuccess(false);
            return result;
        }
        if(ValidateHelper.isEmpty(uploadWarDTO.getUploadId())){
            result.setErrCode(ErrorConstant.NULL_ENVIROMENT.getCode());
            result.setErrMsg(ErrorConstant.NULL_ENVIROMENT.getMsg());
            result.setSuccess(false);
            return result;
        }
        EnvironmentConstant environmentName = EnvironmentConstant.getConstantByValue(uploadWarDTO.getEnvironment());
        if(ValidateHelper.isEmpty(environmentName)){
            result.setErrCode(ErrorConstant.ERROR_ENVIROMENT.getCode());
            result.setErrMsg(ErrorConstant.ERROR_ENVIROMENT.getMsg());
            result.setSuccess(false);
            return result;
        }

        UploadWarQuery query = new UploadWarQuery();
        query.setMerchantId(uploadWarDTO.getMerchantId());
        query.setChannelNo(uploadWarDTO.getChannelNo());
        query.setUploadId(uploadWarDTO.getUploadId());
        query.setWarName(uploadWarDTO.getWarName());
        query.setWarVersion(uploadWarDTO.getWarVersion());
        query.setEnvironment(environmentName);

        String uuid = UUIDUtils.getUUID();
        String war_path = warPath;
        try {

            String marchartPath = war_path+File.separator+query.getMerchantId();
            File file = new File(marchartPath);
            if(!file.exists()){
                file.mkdir();
            }
            String channelPath = marchartPath + File.separator+query.getChannelNo();
            file = new File(channelPath);
            if(!file.exists()){
                file.mkdir();
            }
            String warVersionPath = channelPath + File.separator +query.getWarVersion();
            file = new File(warVersionPath);
            if(!file.exists()){
                file.mkdir();
            }

            String filePath = warVersionPath +File.separator+uuid + ".war";//组装新的路径
            File outFile = new File(filePath);
            inputstreamtofile(uploadWarDTO.getWarContent(),outFile);
            query.setFilePath(warVersionPath);
            query.setWarRealname(uuid + ".war");
            query.setKiloByte(outFile.length());
        }catch (Exception e) {
            result.setErrCode(ErrorConstant.ERROR_NULL_REASON.getCode());
            result.setErrMsg(e.getMessage());
            result.setSuccess(false);
            return result;
        }
        result = videoService.uploadWar(query);

//        String url = "";
//        try {
//            File file = new File(savePath+File.separator+fileName);
//            inputstreamtofile(uploadWarDTO.getWarContent(),file);
//            query.setKiloByte(file.length());
//            String fieldId = fastdfsClient.upload(file);//上传war包
//            url = fastdfsDownloadUrl+"/"+fieldId;//获取附件的URL
//            if(file.exists()){
//                file.delete();//删除了
//            }
//        }catch (Exception e) {
//            result.setErrCode(ErrorConstant.ERROR_NULL_REASON.getCode());
//            result.setErrMsg(e.getMessage());
//            result.setSuccess(false);
//            return result;
//        }
//        query.setFilePath(url);

        return result;
    }

    public void inputstreamtofile(InputStream ins, File file) throws IOException {
        OutputStream os = new FileOutputStream(file);
        try {
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (Exception e) {
            Logger.error(VideoAO.class,e.getMessage());
            //e.printStackTrace();
        }finally {
            os.close();
            ins.close();
        }
    }


    public ResultDO<DownloadWarDTO> downloadWar(Long warId,String channelNo,Long currentMerchantId){
        ResultDO<DownloadWarDTO> result = new ResultDO<DownloadWarDTO>();
        result = checkCommonData(currentMerchantId,channelNo);
        if(!result.isSuccess()){
            return result;
        }
        if(ValidateHelper.isEmpty(warId)){
            result.setErrCode(ErrorConstant.NULL_WARID.getCode());
            result.setErrMsg(ErrorConstant.NULL_WARID.getMsg());
            result.setSuccess(false);
            return result;
        }
        DownloadWarQuery query = new DownloadWarQuery();
        query.setWarId(warId);
        query.setChannelNo(channelNo);
        query.setMerchantId(currentMerchantId);
        result = videoService.downloadWar(query);
        return result;
    }

    /**
     * war包列表
     * @param warlistDTO
     * @return
     */
    public ResultDO<Page<WarlistDTO>> warlist(WarlistDTO warlistDTO) {
        ResultDO<Page<WarlistDTO>> result = new ResultDO<Page<WarlistDTO>>();
        result = checkCommonQueryData(warlistDTO.getMerchantId(),warlistDTO.getChannelNo());
        if(!result.isSuccess()){
            return result;
        }
        if( ValidateHelper.isEmpty(warlistDTO.getEnvironment())){
            result.setErrCode(ErrorConstant.NULL_ENVIROMENT.getCode());
            result.setErrMsg(ErrorConstant.NULL_ENVIROMENT.getMsg());
            result.setSuccess(false);
            return result;
        }
        if( ValidateHelper.isEmpty(warlistDTO.getChannelNo())){
            result.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            result.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            result.setSuccess(false);
            return result;
        }
        WarlistQuery query = new WarlistQuery();
        query.setMerchantId(warlistDTO.getMerchantId());
        query.setChannelNo(warlistDTO.getChannelNo());
        query.setEnvironment(warlistDTO.getEnvironment());

        Page page = new Page();
        page.setPageNumber(warlistDTO.getPageNumber());
        page.setPageSize(warlistDTO.getPageSize());
        query.setPage(page);
        result = videoService.warlist(query);
        return result;
    }

    /**
     * 图片缩放功能
     * @param imgZoomDTO
     * @return
     */
    public ResultDO<String> imgZoom(ImgZoomDTO imgZoomDTO){
        ResultDO<String> result = new ResultDO<String>();
        ImgZoomQuery query = new ImgZoomQuery();
        result = checkCommonData(imgZoomDTO.getMerchantId(),imgZoomDTO.getChannelNo());
        if(!result.isSuccess()){
            return result;
        }
        if(ValidateHelper.isEmpty(imgZoomDTO.getImageUrl())){//参数错误
            result.setErrCode(ErrorConstant.NULL_IMAGEURL.getCode());
            result.setErrMsg(ErrorConstant.NULL_IMAGEURL.getMsg());
            result.setSuccess(false);
            return result;
        }

        if(ValidateHelper.isEmpty(imgZoomDTO.getSize()) && (ValidateHelper.isEmpty(imgZoomDTO.getHeight())||
                ValidateHelper.isEmpty(imgZoomDTO.getWidth()))){//高度和比例选其一
            result.setErrCode(ErrorConstant.ERROR_SIZE_HEIGHT.getCode());
            result.setErrMsg(ErrorConstant.ERROR_SIZE_HEIGHT.getMsg());
            result.setSuccess(false);
            return result;
        }
        query.setMerchantId(imgZoomDTO.getMerchantId());
        query.setChannelNo(imgZoomDTO.getChannelNo());
        query.setImageUrl(imgZoomDTO.getImageUrl());
        query.setHeight(imgZoomDTO.getHeight());
        query.setWidth(imgZoomDTO.getWidth());
        query.setSize(imgZoomDTO.getSize());
        result = videoService.imgZoom(query);
        return result;
    }

    /**
     * 资源审批功能
     * @param resourceCheckDTO
     * @return
     */
    public ResultDO resourceCheck(ResourceCheckDTO resourceCheckDTO){
        ResultDO result = new ResultDO();
        result = checkCommonData(resourceCheckDTO.getMerchantId(),resourceCheckDTO.getChannelNo());
        if(!result.isSuccess()){
            return result;
        }
        if(ValidateHelper.isEmpty(resourceCheckDTO.getApproverId())){//审批人必填
            result.setErrCode(ErrorConstant.ERROR_APPROVERID.getCode());
            result.setErrMsg(ErrorConstant.ERROR_APPROVERID.getMsg());
            result.setSuccess(false);
            return result;
        }
        if(ValidateHelper.isEmpty(resourceCheckDTO.getStatus())){//审批人必填
            result.setErrCode(ErrorConstant.ERROR_CHECK_STAUS.getCode());
            result.setErrMsg(ErrorConstant.ERROR_CHECK_STAUS.getMsg());
            result.setSuccess(false);
            return result;
        }
        if(ValidateHelper.isEmpty(resourceCheckDTO.getIsclear())) {//参数必填
            result.setErrCode(ErrorConstant.NULL_ISCLEAR.getCode());
            result.setErrMsg(ErrorConstant.NULL_ISCLEAR.getMsg());
            result.setSuccess(false);
            return result;
        }
        CheckConstant status = CheckConstant.getConstantByValue(resourceCheckDTO.getStatus());
        ClearConstant isclear = ClearConstant.getConstantByValue(resourceCheckDTO.getIsclear());
        ApproverTypeConstant attachStatus = ApproverTypeConstant.getConstantByValue(resourceCheckDTO.getAttachStatus());
        if(ValidateHelper.isEmpty(status) || ValidateHelper.isEmpty(attachStatus) || ValidateHelper.isEmpty(isclear)){//状态不对
            result.setErrCode(ErrorConstant.ERROR_STATUS.getCode());
            result.setErrMsg(ErrorConstant.ERROR_STATUS.getMsg());
            result.setSuccess(false);
            return result;
        }
        if(status==CheckConstant.NotPass&&ValidateHelper.isEmpty(resourceCheckDTO.getReason())){//当状态是不通过 理由必填
            result.setErrCode(ErrorConstant.ERROR_NULL_REASON.getCode());
            result.setErrMsg(ErrorConstant.ERROR_NULL_REASON.getMsg());
            result.setSuccess(false);
            return result;
        }
        ResourceCheckQuery query = new ResourceCheckQuery();
        query.setMerchantId(resourceCheckDTO.getMerchantId());
        query.setChannelNo(resourceCheckDTO.getChannelNo());
        query.setApproverId(resourceCheckDTO.getApproverId());
        query.setFileId(resourceCheckDTO.getFileId());
        query.setIsclear(isclear);
        query.setStatus(status);
        query.setReason(resourceCheckDTO.getReason());
        query.setAttachStatus(attachStatus);
        result = videoService.resourceCheck(query);
        return result;
    }

    /***
     * 附件上传
     * @return
     */
    public ResultDO<JSONObject> uploadFile(UploadFileDTO uploadFileDTO, String fileName){
        ResultDO<JSONObject> result = new ResultDO<JSONObject>();
        UploadFileQuery query = new UploadFileQuery();
        result = checkCommonData(uploadFileDTO.getMerchantId(),uploadFileDTO.getChannelNo());
        if(!result.isSuccess()){
            return result;
        }
        if(ValidateHelper.isEmpty(uploadFileDTO.getType())){//附件类型必填
            result.setErrCode(ErrorConstant.NULL_FILE_TYPE.getCode());
            result.setErrMsg(ErrorConstant.NULL_FILE_TYPE.getMsg());
            result.setSuccess(false);
            return result;
        }
        AttachConstant attachConstant = AttachConstant.getConstantByValue(uploadFileDTO.getType());
        if(ValidateHelper.isEmpty(attachConstant)){//附件类型错误
            result.setErrCode(ErrorConstant.ERROR_FILE_TYPE.getCode());
            result.setErrMsg(ErrorConstant.ERROR_FILE_TYPE.getMsg());
            result.setSuccess(false);
            return result;
        }
        query.setMerchantId(uploadFileDTO.getMerchantId());
        query.setChannelNo(uploadFileDTO.getChannelNo());
        query.setFileName(fileName);
        query.setType(attachConstant);

        String url = "";

        try {

            File file = new File(savePath+File.separator+query.getFileName());
            Logger.info(this.getClass(),savePath+File.separator+query.getFileName());
            inputstreamtofile(uploadFileDTO.getFile(),file);
            String urlImage = "";
            if(query.getType() == AttachConstant.Video){//如果是视频 进行缩略图片获取

                File fileSavePath = file;

                String fileImagePath = savePath+File.separator+UUIDUtils.getUUID()+".jpg";

                ConvertImage.processImg(savePath+File.separator+file.getName(),fileImagePath);

                Thread.sleep(3000);

                //对视频进行缩略图片获取
                File fileImage = new File(fileImagePath);
                String fieldIdImage = fastdfsClient.upload(fileImage);//上传缩略图片
                urlImage = fastdfsDownloadUrl+File.separator+fieldIdImage;//获取附件的URL
                //fileImage.delete();//清除图片
            }
            String fieldId = fastdfsClient.upload(file);//上传视频
            url = fastdfsDownloadUrl+File.separator+fieldId;//获取附件的URL
            query.setUrl(url);
            query.setKiloByte(file.length());
            query.setUrlImage(urlImage);
            if(file.exists()){
                file.delete();//删除了
            }
        } catch (Exception e) {
            result.setErrCode(ErrorConstant.ERROR_NULL_REASON.getCode());
            result.setErrMsg(e.getMessage());
            result.setSuccess(false);
            return result;
        }
        result = videoService.uploadFile(query);
        return result;
    }

    /***
     * 附件上传
     * @return
     */
    public ResultDO<String> uploadFileToGD(UploadFileDTO uploadFileDTO,String fileName){
        ResultDO<String> result = new ResultDO<String>();
        String url = "";
        try {
            File file = new File(savePath+File.separator+fileName);
            inputstreamtofile(uploadFileDTO.getFile(),file);
            String fieldId = fastdfsClient.upload(file);//上传视频
            url = fastdfsDownloadUrl+"/"+fieldId;//获取附件的URL
            if(file.exists()){
                file.delete();//删除了
            }
        }catch (Exception e) {
            result.setErrCode(ErrorConstant.ERROR_NULL_REASON.getCode());
            result.setErrMsg(e.getMessage());
            result.setSuccess(false);
            return result;
        }
        result.setSuccess(true);
        result.setData(url);
        return result;
    }

    /**
     * 资源详情
     * @param resourceInfoWebDTO
     * @return
     */
    public ResultDO<ResourceInfoDTOToWeb> resourceInfo(ResourceInfoWebDTO resourceInfoWebDTO){
        ResultDO<ResourceInfoDTOToWeb> result = new ResultDO<ResourceInfoDTOToWeb>();
        ResourceInfoDTOToWeb resourceInfoDTOToWeb = new ResourceInfoDTOToWeb();
        result = checkCommonQueryData(resourceInfoWebDTO.getMerchantId(),resourceInfoWebDTO.getChannelNo());
        if(!result.isSuccess()){
            return result;
        }
        if(ValidateHelper.isEmpty(resourceInfoWebDTO.getFileId())){
            result.setErrCode(ErrorConstant.NULL_FIELDID.getCode());
            result.setErrMsg(ErrorConstant.NULL_FIELDID.getMsg());
            result.setSuccess(false);
            return result;
        }
        ResourceInfoQuery query = new ResourceInfoQuery();
        query.setMerchantId(resourceInfoWebDTO.getMerchantId());
        query.setChannelNo(resourceInfoWebDTO.getChannelNo());
        query.setFileId(resourceInfoWebDTO.getFileId());
        ResultDO<ResourceInfoDTO> result_Account = new ResultDO<ResourceInfoDTO>();
        result_Account = videoService.resourceInfo(query);
        if(result_Account.isSuccess()){
            ResourceInfoDTO resourceInfoDTO = result_Account.getData();
            result.setSuccess(true);
            resourceInfoDTOToWeb.setFileId(resourceInfoDTO.getFileId());
            resourceInfoDTOToWeb.setChannelNo(resourceInfoDTO.getChannelNo());
            resourceInfoDTOToWeb.setChannelName(resourceInfoDTO.getChannelName());
            resourceInfoDTOToWeb.setChannelType(resourceInfoDTO.getChannelType());
            resourceInfoDTOToWeb.setChannelTypeName(resourceInfoDTO.getChannelTypeName());
            resourceInfoDTOToWeb.setFileName(resourceInfoDTO.getFileName());
            resourceInfoDTOToWeb.setImgUrl(resourceInfoDTO.getImgUrl());
            resourceInfoDTOToWeb.setImgType(resourceInfoDTO.getImgType());
            resourceInfoDTOToWeb.setImgTypeName(resourceInfoDTO.getImgTypeName());
            resourceInfoDTOToWeb.setImgSize(resourceInfoDTO.getImgSize());
            resourceInfoDTOToWeb.setApproverTime(DateUtils.date2String(resourceInfoDTO.getApproverTime()));
            resourceInfoDTOToWeb.setCreateTime(DateUtils.date2String(resourceInfoDTO.getCreateTime()));
            resourceInfoDTOToWeb.setStatus(resourceInfoDTO.getStatus());
            resourceInfoDTOToWeb.setStatusName(AttachStatusConstant.getNameByValue(resourceInfoDTO.getStatus()));
            resourceInfoDTOToWeb.setDesc(resourceInfoDTO.getDesc());
            resourceInfoDTOToWeb.setSize(resourceInfoDTO.getSize());
            resourceInfoDTOToWeb.setApproverList(resourceInfoDTO.getApproverList());
            result.setData(resourceInfoDTOToWeb);
        }else{
            result.setSuccess(false);
            result.setErrCode(result_Account.getErrCode());
            result.setErrMsg(result_Account.getErrMsg());
        }
        return result;
    }

    /**
     * 资源列表
     * @param resourceListDTO
     * @return
     */
    public ResultDO<Page<ResourceListDTO>> resourceList(ResourceListToWebDTO resourceListDTO){
        ResultDO<Page<ResourceListDTO>> result = new ResultDO<Page<ResourceListDTO>>();
        ResourceListQuery query = new ResourceListQuery();
        result = checkCommonQueryData(resourceListDTO.getMerchantId(),resourceListDTO.getChannelNo());
        if(!result.isSuccess()){
            return result;
        }
        if(ValidateHelper.isEmpty(resourceListDTO.getType())){
            result.setErrCode(ErrorConstant.NULL_FILE_TYPE.getCode());
            result.setErrMsg(ErrorConstant.NULL_FILE_TYPE.getMsg());
            result.setSuccess(false);
            return result;
        }
        if(ValidateHelper.isEmpty(resourceListDTO.getPageSize())){
            result.setErrCode(ErrorConstant.NULL_VIDEO_PAGESIZE.getCode());
            result.setErrMsg(ErrorConstant.NULL_VIDEO_PAGESIZE.getMsg());
            result.setSuccess(false);
            return result;
        }
        if(ValidateHelper.isEmpty(resourceListDTO.getPageNumber())){
            result.setErrCode(ErrorConstant.NULL_VIDEO_PAGENUMBER.getCode());
            result.setErrMsg(ErrorConstant.NULL_VIDEO_PAGENUMBER.getMsg());
            result.setSuccess(false);
            return result;
        }
        AttachConstant type =AttachConstant.getConstantByValue(resourceListDTO.getType());
        if(!ValidateHelper.isEmpty(resourceListDTO.getStatus())){
            AttachStatusConstant status = AttachStatusConstant.getConstantByValue(resourceListDTO.getStatus());
            if(!ValidateHelper.isEmpty(status)){
                query.setStatus(status);
            }
        }
        if(ValidateHelper.isEmpty(type)){
            result.setErrCode(ErrorConstant.ERROR_STATUS.getCode());
            result.setErrMsg(ErrorConstant.ERROR_STATUS.getMsg());
            result.setSuccess(false);
            return result;
        }
        query.setMerchantId(resourceListDTO.getMerchantId());
        query.setChannelNo(resourceListDTO.getChannelNo());
        query.setStartDate(resourceListDTO.getStartDate());
        query.setEndDate(resourceListDTO.getEndDate());
        query.setType(type);

        Page page = new Page();
        page.setPageNumber(resourceListDTO.getPageNumber());
        page.setPageSize(resourceListDTO.getPageSize());
        query.setPage(page);
        result = videoService.resourceList(query);
        return result;
    }

    public ResultDO<Boolean> deleteWar(DeleteWarQuery query){
        ResultDO<Boolean> result = new ResultDO<Boolean>();
        if(ValidateHelper.isEmpty(query.getWarId())){
            result.setErrCode(ErrorConstant.NULL_VIDEO_PAGENUMBER.getCode());
            result.setErrMsg(ErrorConstant.NULL_VIDEO_PAGENUMBER.getMsg());
            result.setSuccess(false);
            return result;
        }
        result = videoService.deleteWar(query);
        return result;
    }
}
