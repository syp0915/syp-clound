package com.shfc.cloud.video.properties;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Package com.shfc.cloud.video.properties.VideoProperties
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/21 11:10
 * version V1.0.0
 */
@Service
public class VideoProperties {

    @Value("${war.path}")
    private String warPath;

    @Value("${fastdfs.download.url}")
    private String fastdfsDownloadUrl;

    @Value("${save_path}")
    private String savePath;

    @Value("${ffmpeg_path}")
    private String ffmpegPath;

    public String getWarPath() {
        return warPath;
    }

    public void setWarPath(String warPath) {
        this.warPath = warPath;
    }

    public String getFastdfsDownloadUrl() {
        return fastdfsDownloadUrl;
    }

    public void setFastdfsDownloadUrl(String fastdfsDownloadUrl) {
        this.fastdfsDownloadUrl = fastdfsDownloadUrl;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getFfmpegPath() {
        return ffmpegPath;
    }

    public void setFfmpegPath(String ffmpegPath) {
        this.ffmpegPath = ffmpegPath;
    }
}
