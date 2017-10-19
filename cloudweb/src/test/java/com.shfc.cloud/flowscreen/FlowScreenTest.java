package com.shfc.cloud.flowscreen;

import com.alibaba.fastjson.JSON;
import com.shfc.common.http.ApacheHttpCilent;
import com.shfc.common.math.RandomUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Package com.shfc.cloud.flowscreen.FlowScreenTest
 * @Description: FlowScreenTest
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/28 13:49
 * version V1.0.0
 */
public class FlowScreenTest {
    private static String byteArrayToHex(byte[] byteArray) {

        char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F' };
        char[] resultCharArray = new char[byteArray.length * 2];
        int index = 0;
        for (byte b : byteArray) {
            resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b & 0xf];
        }
        return new String(resultCharArray);
    }
    public static String encrypt(String value) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] inputByteArray = value.getBytes();
            messageDigest.update(inputByteArray);
            byte[] resultByteArray = messageDigest.digest();
            return byteArrayToHex(resultByteArray);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
//        {"requestSeq":1490364293650907370,"appId":"05001","version":"V1.0.0","tvboxId":"98bc576855c5","url":"http://10.27.97.219:9999/path/page.html?par"}
        // appId=05001&version=V1.0.0&signType=01
        // &params=%7B%22requestSeq%22%3A1490364293650907370%2C%22appId%22%3A%2205001%22%2C%22version%22%3A%22V1.0.0%22%2C%22tvboxId%22%3A%2298bc576855c5%22%2C%22url%22%3A%22http%3A%2F%2F10.27.97.219%3A9999%2Fpath%2Fpage.html%3Fpar%22%7D
        // &signCode=99FFDDED75D17C01DA7F34F6D40CF0A0

        Map<String, Object> paramMap = new LinkedHashMap<>();
        String str = System.currentTimeMillis() + RandomUtils.generateNumberString(5);
        paramMap.put("requestSeq", Long.valueOf(str));
        paramMap.put("appId", "05001");
        paramMap.put("version", "V1.0.0");
        paramMap.put("tvboxId", "98bc576855c5");
        paramMap.put("url", "http://10.27.97.219:9999/path/page.html?par");

        String data = JSON.toJSONString(paramMap);
        String params = data.concat("123456");
        String md5 = encrypt(params);

        Map<String, String> requestMap = new LinkedHashMap<String, String>();
        requestMap.put("appId", "05001");
        requestMap.put("version", "V1.0.0");
        requestMap.put("signType", "01");
        requestMap.put("params", data);
        requestMap.put("signCode", md5);
        
        String url = "http://192.168.201.50:8080/ocntvbox/piaoping/V1.0.0";
        String result  = ApacheHttpCilent.doPost(url, requestMap);
        System.out.println(result);
    }


}
