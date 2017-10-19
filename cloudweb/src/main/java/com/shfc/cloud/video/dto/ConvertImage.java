package com.shfc.cloud.video.dto;

import com.shfc.common.base.Logger;

import java.io.File;

/**
 * @Package com.shfc.cloud.video.ffmpeg.ConvertImage
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/25 11:10
 * version V1.0.0
 */
public class ConvertImage {

    /**
     * 对视频进行缩略图片
     * @param INPUT_PATH
     * @param IMG_PATH
     * @return
     */
    public static boolean processImg(String INPUT_PATH,String IMG_PATH) {
        Logger.info(ConvertImage.class,"IMG_PATH="+IMG_PATH);
        if(new File(IMG_PATH).exists()) return true;
        Ffmpeg.processImg(INPUT_PATH,IMG_PATH);
        try {
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        boolean isok = ConvertImage.processImg("D:\\3.mp4","D:\\1121xx.jpg");
        System.out.println(isok);
    }
}
