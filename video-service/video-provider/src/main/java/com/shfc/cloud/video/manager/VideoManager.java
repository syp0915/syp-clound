package com.shfc.cloud.video.manager;

import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.video.constant.ApproverTypeConstant;
import com.shfc.cloud.video.constant.AttachStatusConstant;
import com.shfc.cloud.video.constant.CheckConstant;
import com.shfc.cloud.video.constant.ClearConstant;
import com.shfc.cloud.video.dao.*;
import com.shfc.cloud.video.domain.*;
import com.shfc.cloud.video.dto.*;
import com.shfc.cloud.video.ffmpeg.ConvertSingleVideo;
import com.shfc.cloud.video.properties.VideoProperties;
import com.shfc.cloud.video.query.*;
import com.shfc.cloud.video.util.ZoomImage;
import com.shfc.common.base.UUIDUtils;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.date.DateUtils;
import com.shfc.common.exception.AppException;
import com.shfc.common.result.ResultDO;
import com.shfc.fastdfs.FastdfsClient;
import com.shfc.fastdfs.FastdfsClientService;
import com.shfc.log.LogFileUtils;
import com.shfc.mybatis.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Package com.shfc.cloud.video.manager.VideoManager
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 18:15
 * version V1.0.0
 */
@Service
public class VideoManager {

    private LogFileUtils logFileUtils = LogFileUtils.getInstance("video-provider");

    FastdfsClient fastdfsClient = FastdfsClientService.getInstance().getFastdfsClient();//实例FastdfsClient

    @Autowired
    private VideoProperties videoProperties;

    @Autowired
    private WarPackageMapper warPackageMapper;

    @Autowired
    private WarLogMapper warLogMapper;

    @Autowired
    private AttachMapper attachMapper;

    @Autowired
    private AttachReviewLogMapper attachReviewLogMapper;

    @Autowired
    private AttachMerchantMapper attachMerchantMapper;


    /**
     * 上传war包
     * @param query
     * @return
     */
    public ResultDO uploadWar(UploadWarQuery query){
        ResultDO result = new ResultDO();
        WarPackage warPackage = new WarPackage();

        int count = warPackageMapper.selectByWarNameAndVersion(query.getWarName(),query.getWarVersion());
        if(count>0){
            result.setSuccess(false);
            result.setErrCode(30012);
            result.setErrMsg("已经存在相同版本的架包，请重新上传！");
            return result;
        }
        String war_path= videoProperties.getWarPath();

        Long startTimeMillis = System.currentTimeMillis();//获取当前系统时间

        Long kiloByte  = query.getKiloByte();
        Long megaByte = kiloByte/1024;
        if(megaByte < 1) {//计算大小 单位KB
            BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
            result1 = result1.setScale(2, BigDecimal.ROUND_HALF_UP);
            warPackage.setWarSize(result1.longValue());
        }else {
            warPackage.setWarSize(megaByte);
        }
        warPackage.setChannelNo(query.getChannelNo());
        warPackage.setCreater(query.getUploadId());
        warPackage.setEnvironment(query.getEnvironment().getCode());
        warPackage.setWarName(query.getWarName());
        warPackage.setWarVersion(query.getWarVersion());
        warPackage.setMerchantId(query.getMerchantId());

        try{
            warPackage.setWarUrl(query.getFilePath());
            warPackage.setWarRealname(query.getWarRealname());
            warPackage.setStatus(0);
            warPackage.setIsDel(0);
            warPackageMapper.insert(warPackage);//插入数据
        }catch (Exception ex){
            logFileUtils.error("[媒资服务]上传war包报错:"+ex.getMessage(),query.getMerchantId(),query.getChannelNo(),VideoManager.class,"uploadWar",startTimeMillis);
            result.setSuccess(false);
            result.setErrMsg(ex.getMessage());
            return result;
        }

        logFileUtils.info("[媒资服务]上传war包",query.getMerchantId(),query.getChannelNo(),VideoManager.class,"uploadWar",startTimeMillis);
        result.setSuccess(true);
        return result;
    }

    /**
     * 下载war包
     * @param query
     * @return
     */
    public ResultDO<DownloadWarDTO> downloadWar(DownloadWarQuery query) {
        ResultDO<DownloadWarDTO> result = new ResultDO<DownloadWarDTO>();
        DownloadWarDTO downloadWarDTO = new DownloadWarDTO();
        Long startTimeMillis = System.currentTimeMillis();//获取当前系统时间

        WarPackage warPackage = warPackageMapper.selectByPrimaryKey(query.getWarId());
        if(warPackage==null || ValidateHelper.isEmpty(warPackage.getId()) ){
            logFileUtils.error("[媒资模块]war包下载;未找到该数据:"+query.getWarId(),query.getMerchantId(),query.getChannelNo(),VideoManager.class,"uploadWar",startTimeMillis);
            result.setSuccess(false);
            result.setErrMsg("war包不存在!");
            result.setErrCode(300101);
            return result;
        }
        downloadWarDTO.setUrl(warPackage.getWarUrl()+File.separator+warPackage.getWarRealname());
//        File file = new File(warPackage.getWarUrl());//共享文件夹真实存储路径
//        if(!file.exists()){
//            logFileUtils.error("[媒资模块]war包下载;war路径:"+warPackage.getWarRealname(),query.getMerchantId(),query.getChannelNo(),VideoManager.class,"uploadWar",startTimeMillis);
//            result.setSuccess(false);
//            result.setErrMsg("war包不存在!");
//            return result;
//        }
//        downloadWarDTO.setFile(file);
        WarLog warLog = new WarLog();
        warLog.setIsSuccess(0);
        warLog.setMerchantId(query.getMerchantId());
        warLog.setCreateTime(new Date());
        warLog.setChannelNo(query.getChannelNo());
        warLog.setEnvironment(warPackage.getEnvironment());
        warLog.setType(0);//下载
        warLog.setDescContent("");
        warLog.setWarId(query.getWarId());
        warLogMapper.insert(warLog);
        result.setData(downloadWarDTO);
        result.setSuccess(true);
        logFileUtils.info("[媒资模块]war包下载;warID:"+query.getWarId(),query.getMerchantId(),query.getChannelNo(),VideoManager.class,"uploadWar",startTimeMillis);
        return result;
    }

    /**
     * war包列表
     * @param query
     * @param page
     * @return
     */
    public Page<WarlistDTO> warlist(WarlistQuery query,Page page){
        Long startTimeMillis = System.currentTimeMillis();//获取当前系统时间
        warPackageMapper.warlist(query,page);
        logFileUtils.info("[媒资模块]war包列表;",query.getMerchantId(),query.getChannelNo(),VideoManager.class,"imgZoom",startTimeMillis);
        return page;
    }

    /**
     * 图片缩放
     * 缩放之后 转成base64 用完删除
     * @param query
     * @return
     */
    public ResultDO<String> imgZoom(ImgZoomQuery query){
        String uuid = UUIDUtils.getUUID();
        Long startTimeMillis = System.currentTimeMillis();//获取当前系统时间
        ResultDO<String> result = new ResultDO<String>();
        try {
            String save_path= videoProperties.getSavePath();
            String imageType = query.getImageUrl().substring(query.getImageUrl().lastIndexOf("."),query.getImageUrl().length());
            String path = save_path+uuid+imageType;

            if(query.getSize()!=null){//按照比例
                result = ZoomImage.zoomImage(query.getImageUrl(),path,query.getSize());
            }else{//按照长度和高度
                result = ZoomImage.zoomImage(query.getImageUrl(),path,query.getWidth(),query.getHeight());
            }
            if(result.isSuccess()){
                String base64ImageStr = ZoomImage.GetImageStr(path);//将转换之后的图片 转换成base64图片 。<img src="data:text/html;base64,
                result.setData(base64ImageStr);
            }else{
                logFileUtils.error("[媒资模块]图片缩放错误;错误原因:"+result.getErrMsg(),query.getMerchantId(),query.getChannelNo(),VideoManager.class,"imgZoom",startTimeMillis);
            }
            File file = new File(path);
            if(file.exists()){//用完之后删除
                file.delete();
            }
        } catch (Exception e) {
            logFileUtils.error("[媒资模块]图片缩放;ImageUrl:"+e.getMessage(),query.getMerchantId(),query.getChannelNo(),VideoManager.class,"imgZoom",startTimeMillis);
            result.setSuccess(false);
            return result;
        }
        logFileUtils.info("[媒资模块]图片缩放;ImageUrl:"+query.getImageUrl(),query.getMerchantId(),query.getChannelNo(),VideoManager.class,"imgZoom",startTimeMillis);
        result.setSuccess(true);
        return result;
    }

    /**
     * 资源列表
     * @param query
     * @param page
     * @return
     */
    public Page<ResourceListDTO> resourceList(ResourceListQuery query, Page page){
        Long startTimeMillis = System.currentTimeMillis();//获取当前系统时间
        attachMapper.resourceList(query,page);
        logFileUtils.info("[媒资模块]资源列表;",query.getMerchantId(),query.getChannelNo(),VideoManager.class,"imgZoom",startTimeMillis);
        return page;
    }

    /**
     * 审核记录
     * @param query
     * @return
     */
    @Transactional(rollbackFor = AppException.class)
    public ResultDO resourceCheck(ResourceCheckQuery query){
        ResultDO result = new ResultDO();
        Long startTimeMillis = System.currentTimeMillis();//获取当前系统时间
        try{
            AttachReviewLog attachReviewLog = new AttachReviewLog();//日志记录
            attachReviewLog.setIsclear(query.getIsclear().getCode());
            attachReviewLog.setChannelNo(query.getChannelNo());
            attachReviewLog.setMerchantId(query.getMerchantId());
            attachReviewLog.setAttachId(query.getFileId());
            attachReviewLog.setReason(query.getReason());
            attachReviewLog.setStatus(query.getStatus().getCode());
            attachReviewLog.setApproverType(query.getAttachStatus().getCode());
            attachReviewLog.setApproverId(query.getApproverId());
            attachReviewLog.setIsclear(query.getIsclear().getCode());
            attachReviewLogMapper.insert(attachReviewLog);

            AttachMerchant attachMerchant = attachMerchantMapper.selectByAttachId(query.getFileId());//查询商户附件中间
            if(ValidateHelper.isEmpty(attachMerchant)){
                result.setSuccess(false);
                result.setErrMsg("为找到该数据!");
                logFileUtils.error("[媒资模块]媒资审核;错误原因:为找到该对象",query.getMerchantId(),query.getChannelNo(),VideoManager.class,"imgZoom",startTimeMillis);
                return result;
            }
            if(query.getStatus() == CheckConstant.NotPass){//不通过
                attachMerchant.setStatus(AttachStatusConstant.NotPass.getCode());//审核不通过
                attachMerchant.setModifyTime(DateUtils.getCurrentDate());
                attachMerchant.setModifier(query.getApproverId());
            }else{
                attachMerchant.setStatus(query.getAttachStatus().getCode());//修改状态
                attachMerchant.setModifyTime(DateUtils.getCurrentDate());
                attachMerchant.setModifier(query.getApproverId());
            }
            attachMerchantMapper.updateByPrimaryKey(attachMerchant);
            Attach attach = attachMapper.selectByPrimaryKey(query.getFileId());
            if(ApproverTypeConstant.Second==query.getAttachStatus() && CheckConstant.Pass==query.getStatus() && "1".equals(attach.getAttachSuffix())){//此次审核是二次审核 并且审核通过 审核附件是视频
//                //调用dcms推送附件第三次审核
//                CMSContent cMSContent = new CMSContent();
//                cMSContent.setContentId(StringUtils.toString(attach.getId(),""));
//                cMSContent.setType(CMSTypeConstant.VIDEO.getType());
//                cMSContent.setAction(CMSActionTypeConstant.NEW.getType());
//                cMSContent.setContentUri(attach.getAttachUrl());
//                cMSContent.setContentLength(StringUtils.toString(attach.getAttachSize()*1024,""));
//                List<CMSContent> list = new ArrayList<CMSContent>();
//                list.add(cMSContent);
//                ResultDO cmsResult = cMSManager.pubContent(list);
//                if(cmsResult.isSuccess()){
//                    result.setSuccess(false);
//                    result.setErrMsg(cmsResult.getErrMsg());
//                    logFileUtils.error("[媒资服务]CMS媒资审核;错误原因:"+cmsResult.getErrMsg(),query.getMerchantId(),query.getChannelNo(),VideoManager.class,"imgZoom",startTimeMillis);
//                    return result;
//                }
            }
        }catch (Exception ex){
            result.setSuccess(false);
            result.setErrMsg(ex.getMessage());
            logFileUtils.error("[媒资模块]媒资审核;错误原因:"+ex.getMessage(),query.getMerchantId(),query.getChannelNo(),VideoManager.class,"imgZoom",startTimeMillis);
            return result;
        }
        result.setSuccess(true);
        logFileUtils.info("[媒资模块]媒资审核;",query.getMerchantId(),query.getChannelNo(),VideoManager.class,"imgZoom",startTimeMillis);
        return result;
    }

    /**
     * 资源详情
     * @param query
     * @return
     */
    public ResultDO<ResourceInfoDTO> resourceInfo(ResourceInfoQuery query){
        ResultDO<ResourceInfoDTO> result = new ResultDO<ResourceInfoDTO>();
        Long startTimeMillis = System.currentTimeMillis();//获取当前系统时间
        ResourceInfoDTO resourceInfoDTO = attachMapper.selectResourceInfo(query);
        if(ValidateHelper.isEmpty(resourceInfoDTO) || ValidateHelper.isEmpty(resourceInfoDTO.getFileId())){
            result.setSuccess(false);
            result.setErrMsg("未找到该资源！");
            logFileUtils.error("[媒资模块]资源详情;未找到该资源！",query.getMerchantId(),query.getChannelNo(),VideoManager.class,"imgZoom",startTimeMillis);
            return result;
        }
        List<ApproverDTO> approverList = attachReviewLogMapper.selectapproverList(query);
        resourceInfoDTO.setApproverList(approverList);
        result.setData(resourceInfoDTO);
        result.setSuccess(true);
        logFileUtils.info("[媒资模块]资源详情;",query.getMerchantId(),query.getChannelNo(),VideoManager.class,"imgZoom",startTimeMillis);
        return result;
    }

    /**
     * 资源上传
     * @param query
     * @return
     */
    public ResultDO<JSONObject> uploadFile(UploadFileQuery query){
        ResultDO<JSONObject> result = new ResultDO<JSONObject>();
        String fieldId = null;//上传fastDFS服务器
        Long startTimeMillis = System.currentTimeMillis();//获取当前系统时间
        JSONObject jsonObject = new JSONObject();
        try {

            Attach attach = new Attach();
            Long kiloByte  = query.getKiloByte();
            Long megaByte = kiloByte/1024;
            if(megaByte < 1) {//计算大小 单位KB
                BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
                result1 = result1.setScale(2, BigDecimal.ROUND_HALF_UP);
                attach.setAttachSize(result1.longValue());
            }else {
                attach.setAttachSize(megaByte);
            }
            attach.setAttachName(query.getFileName());
            attach.setAttachSuffix(query.getType().getCode()+"");
            attach.setFastdfsName(fieldId);
            attach.setAttachUrl(query.getUrl());
            attach.setIsDel(0);
            attach.setThumbnailPicture(query.getUrlImage());
            attachMapper.insert(attach);
            AttachMerchant attachMerchant = new AttachMerchant();
            attachMerchant.setMerchantId(query.getMerchantId());
            attachMerchant.setChannelNo(query.getChannelNo());
            attachMerchant.setAttachId(attach.getId());
            attachMerchant.setStatus(AttachStatusConstant.FirstReview.getCode());
            attachMerchantMapper.insert(attachMerchant);
            AttachReviewLog attachReviewLog = new AttachReviewLog();
            attachReviewLog.setMerchantId(query.getMerchantId());
            attachReviewLog.setChannelNo(query.getChannelNo());
            attachReviewLog.setAttachId(attach.getId());
            attachReviewLog.setStatus(ApproverTypeConstant.Create.getCode());
            attachReviewLog.setApproverType(CheckConstant.NotCheck.getCode());
            attachReviewLog.setIsclear(ClearConstant.NotClear.getCode());
            attachReviewLogMapper.insert(attachReviewLog);
            jsonObject.put("id",attach.getId());
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setErrMsg(ex.getMessage());
            logFileUtils.error("[媒资服务]资源上传;错误原因:"+ex.getMessage(),query.getMerchantId(),query.getChannelNo(),VideoManager.class,"uploadFile",startTimeMillis);
            return result;
        }
        result.setSuccess(true);
        jsonObject.put("url",query.getUrl());
        jsonObject.put("urlImage",query.getUrlImage());
        result.setData(jsonObject);
        logFileUtils.info("[媒资服务]资源上传;",query.getMerchantId(),query.getChannelNo(),VideoManager.class,"uploadFile",startTimeMillis);
        return result;
    }

    /**
     *  视频转码
     * @param query
     * @return
     */
    public ResultDO<String> videoTranscod(VideoTranscodQuery query){
        ResultDO<String> result = new ResultDO<String>();
        Long startTimeMillis = System.currentTimeMillis();//获取当前系统时间
        try {
            String attachUrl = "";
            String attachName = "";
            String filePath = "";
            if(query.getFileId()!=null){//附件
                Attach attach = attachMapper.selectByPrimaryKey(query.getFileId());
                attachUrl = attach.getAttachUrl();
                attachName = attach.getAttachName();
            }else{
                attachUrl = query.getFileUrl();
                attachName = attachUrl.substring(attachUrl.lastIndexOf("/") + 1,attachUrl.length()).toLowerCase();
            }
            String savePath = videoProperties.getSavePath();
            filePath = savePath+attachName;//视频保存到本地  然后进行转码
            ConvertSingleVideo.downLoadFromUrl(attachUrl,attachName,filePath);//从url下载到本地
            String saveFilePath = savePath+UUIDUtils.getUUID()+".avi";//转成最终的格式 avi
            ConvertSingleVideo convertSingleVideo = new ConvertSingleVideo(saveFilePath);
            convertSingleVideo.convert(filePath);//转码中  filePath  需要转码的视频
            String fieldIdImage = fastdfsClient.upload(new File(filePath));//上传转码之后的图片
            String urlVideo = videoProperties.getFastdfsDownloadUrl()+fieldIdImage;//获取附件的URL
            result.setData(urlVideo);
        }catch (Exception ex){
            result.setSuccess(false);
            result.setErrMsg(ex.getMessage());
            logFileUtils.error("[媒资模块]视频转码;错误原因:"+ex.getMessage(),query.getMerchantId(),query.getChannelNo(),VideoManager.class,"videoTranscod",startTimeMillis);
            return result;
        }
        result.setSuccess(true);
        logFileUtils.info("[媒资模块]视频转码;",query.getMerchantId(),query.getChannelNo(),VideoManager.class,"videoTranscod",startTimeMillis);
        return result;
    }

    public ResultDO<Boolean> deleteWar(DeleteWarQuery query){
        ResultDO<Boolean> result = new ResultDO<Boolean>();
        Long startTimeMillis = System.currentTimeMillis();//获取当前系统时间
        try {
            WarPackage warPackage = warPackageMapper.selectByPrimaryKey(query.getWarId());
            if(!(0==warPackage.getStatus() || 2==warPackage.getStatus())){//未部署 或部署失败
                result.setSuccess(false);
                result.setErrMsg("war包不能被删除！");
                result.setErrCode(30002);
                logFileUtils.error("[媒资模块]资源详情;未找到该资源！",query.getMerchantId(),query.getChannelNo(),VideoManager.class,"imgZoom",startTimeMillis);
                return result;
            }
            if(ValidateHelper.isEmpty(warPackage) || ValidateHelper.isEmpty(warPackage.getId())){
                result.setSuccess(false);
                result.setErrMsg("未找到该资源！");
                result.setErrCode(30001);
                logFileUtils.error("[媒资模块]资源详情;未找到该资源！",query.getMerchantId(),query.getChannelNo(),VideoManager.class,"imgZoom",startTimeMillis);
                return result;
            }
            warPackage.setIsDel(1);
            warPackageMapper.updateByPrimaryKey(warPackage);
        }catch (Exception ex){
            result.setSuccess(false);
            result.setErrMsg(ex.getMessage());
            logFileUtils.error("[媒资模块]删除war包;错误原因:"+ex.getMessage(),query.getMerchantId(),query.getChannelNo(),VideoManager.class,"deleteWar",startTimeMillis);
            return result;
        }
        result.setSuccess(true);
        result.setData(true);
        logFileUtils.info("[媒资模块]删除war包;",query.getMerchantId(),query.getChannelNo(),VideoManager.class,"deleteWar",startTimeMillis);
        return result;
    }


    public ResultDO<Integer> queryImageSumSize(String channleNo){
        ResultDO<Integer> result = new ResultDO<Integer>();
        Integer sumSize = 0;
        Long startTimeMillis = System.currentTimeMillis();//获取当前系统时间
        try {
            sumSize = attachMapper.selectSumSizeBychannelNo(channleNo);
        }catch (Exception ex){
            result.setSuccess(false);
            result.setErrMsg(ex.getMessage());
            logFileUtils.error("[媒资模块]获取频道号的图片和视频使用大小;错误原因:"+ex.getMessage(),88888L,channleNo,VideoManager.class,"deleteWar",startTimeMillis);
            return result;
        }
        result.setSuccess(true);
        result.setData(sumSize);
        logFileUtils.info("[媒资模块]获取频道号的图片和视频使用大小;",88888L,channleNo,VideoManager.class,"deleteWar",startTimeMillis);
        return result;
    }

    public void inputstreamtofile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}