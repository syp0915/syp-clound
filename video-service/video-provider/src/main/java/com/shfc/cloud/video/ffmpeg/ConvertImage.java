package com.shfc.cloud.video.ffmpeg;

import java.io.File;
import java.util.List;

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

    public static String ffmpeg_home = "";

    /**
     * 对视频进行缩略图片
     * @param INPUT_PATH
     * @param IMG_PATH
     * @return
     */
    public static boolean processImg(String INPUT_PATH,String IMG_PATH) {
        System.out.println("IMG_PATH="+IMG_PATH);
        if(new File(IMG_PATH).exists()) return true;
        List<String> commend = new java.util.ArrayList<String>();
        commend.add(ffmpeg_home);
        commend.add("-i");
        commend.add(INPUT_PATH);
        commend.add("-y");
        commend.add("-f");
        commend.add("image2");
        commend.add("-ss");
        commend.add("10");
        commend.add("-t");
        commend.add("0.001");
        commend.add("-s");
        commend.add("200x150");
        commend.add(IMG_PATH);
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commend);
            builder.start();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        ConvertImage.ffmpeg_home = "D:\\ffmpeg\\bin\\ffmpeg.exe";
        boolean isok = ConvertImage.processImg("D:\\upload\\rmvb\\111.rmvb","D:\\upload\\rmvb\\1121.jpg");
        System.out.println(isok);
    }
}
