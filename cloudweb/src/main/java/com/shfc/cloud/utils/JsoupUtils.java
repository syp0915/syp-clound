package com.shfc.cloud.utils;

import com.shfc.common.base.ValidateHelper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpProtocolParams;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;

/**
 * @Package com.shfc.cloud.utils.JsoupUtils
 * @Description: Jsoup http request and html parse
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/22 13:29
 * version V1.0.0
 */
public class JsoupUtils {

    /**
     * 超时时间
     */
    public final static int TIME_OUT_MILLIS = 6000;

    /**
     * 读取目录
     * @param url
     * @return
     * @throws IOException
     */
    public static String[] doGetRequestAppLog(String url) throws IOException {
        Document doc = Jsoup.connect(url).timeout(TIME_OUT_MILLIS).get();
        LinkedList<String> linkedList = null;
        Elements listDiv = doc.body().getElementsByTag("pre");
        if (listDiv != null && listDiv.size() > 0) {
            Element element = listDiv.get(0);
            String text = element.text();
            // 换行符号替换成 $
            String str = text.replace("\r\n", "$");
            String regex = "\\s{2,}";
            // 去除两个以上的空格 替换成*
            String str1 = str.replaceAll(regex, "*");

            // array[0] == "../"  array[1] 开始包含三部分 第一部分 目录名 第二部分 最后修改时间  第三部分 大小用*分隔
            String[] array = str1.split("\\$");

            return array;
        }

        return null;
    }

    /**
     * 下载文件
     * @param filePath
     * @return
     * @throws Exception
     */
    public static InputStream download(String filePath) throws Exception {
        InputStream inputStream = null;
        URL url = new URL(filePath);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        if (conn.getResponseCode() == 200) {
            inputStream = conn.getInputStream();
        }

        return inputStream;
    }

    public static void main(String[] args) throws Exception {
        doGetRequestAppLog("http://192.168.201.78/");
//        doGetRequestAppLog("http://192.168.201.78/merchant_1/channel_999/");
//        String urlStr = "http://192.168.201.78/merchant_1/channel_999/test.zip";
        String urlStr = "http://192.168.201.78/merchant_1/channel_999/test_2.txt ";
        InputStream inputStream = download(urlStr);
        FileOutputStream outputStream = new FileOutputStream(new File("d:/t.txt"));

        byte[] b = new byte[2048];
        int length;
        while ((length = inputStream.read(b)) > 0) {
            outputStream.write(b, 0, length);
        }
        // 这里主要关闭。
        outputStream.close();
        inputStream.close();
    }
}
