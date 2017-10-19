package com.shfc.cloud.video.util;

import com.shfc.common.encrypt.Base64Utils;
import com.shfc.common.result.ResultDO;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;

/**
 * @Package com.shfc.cloud.video.util.ZoomImage
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/23 10:24
 * version V1.0.0
 */
public class ZoomImage {
    /**
     * 按照高度和宽度缩放
     * @param src
     * @param dest
     * @param w
     * @param h
     * @throws Exception
     */
    public static ResultDO zoomImage(String src, String dest, int w, int h) throws Exception {
        ResultDO result = new ResultDO();
        URL url = new URL(src);
        double wr=0,hr=0;
        File destFile = new File(dest);

        BufferedImage bufImg = ImageIO.read(url); //读取图片
        Image Itemp = bufImg.getScaledInstance(w, h, bufImg.SCALE_SMOOTH);//设置缩放目标图片模板
        wr=w*1.0/bufImg.getWidth(); //获取缩放比例
        hr=h*1.0 / bufImg.getHeight();
        AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(wr, hr), null);
        Itemp = ato.filter(bufImg, null);
        try {
            ImageIO.write((BufferedImage) Itemp,dest.substring(dest.lastIndexOf(".")+1), destFile); //写入缩减后的图片
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setErrMsg(ex.getMessage());
            return result;
        }
        result.setSuccess(true);
        return result;
    }

    /*
    * 图片按比率缩放
    * size为文件大小
    */
    public static ResultDO zoomImage(String src,String dest,BigDecimal size) throws Exception {
        ResultDO result = new ResultDO();
        URL url = new URL(src);
        File destFile = new File(dest);

        Double rate = size.doubleValue();
        BufferedImage bufImg = ImageIO.read(url);
        Image Itemp = bufImg.getScaledInstance(bufImg.getWidth(), bufImg.getHeight(), bufImg.SCALE_SMOOTH);
        AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(rate, rate), null);
        Itemp = ato.filter(bufImg, null);
        try {
            ImageIO.write((BufferedImage) Itemp, dest.substring(dest.lastIndexOf(".") + 1), destFile);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setErrMsg(ex.getMessage());
            return result;
        }
        result.setSuccess(true);
        return result;
    }

    /**
     * 图片转化成base64字符串
     * @param imgFile 待处理的图片
     * @return
     */
    public static String GetImageStr(String imgFile){//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try
        {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //对字节数组Base64编码
        return Base64Utils.encrypt(data);//返回Base64编码过的字节数组字符串
    }

    public static void main(String[] args) {
        // 图片源
        final String SRC_FILE = "http://shfc-attachment.oss-cn-shanghai.aliyuncs.com/image/2017/03/16/IMG_1489656342638_96775.jpg";
        // 目标图片
        final String DEST_FILE = "D://2.jpg";
        try {
            BigDecimal size = new BigDecimal("1");
            ZoomImage.zoomImage(SRC_FILE,DEST_FILE,size);
            System.out.println(GetImageStr(DEST_FILE));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
