package com.shfc.cloud.video.dto;

import java.io.File;
import java.io.Serializable;

/**
 * @Package com.shfc.cloud.video.dto.DownloadWarDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 14:06
 * version V1.0.0
 */
public class DownloadWarDTO implements Serializable {
    private File file;//war包附件
    private String url;//war包URL路径

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
