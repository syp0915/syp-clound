package com.shfc.cloud.http;

import com.shfc.common.http.ApacheHttpCilent;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Package com.shfc.cloud.http.HttpRequestTest
 * @Description: HttpRequestTest
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/31 9:18
 * version V1.0.0
 */
public class HttpRequestTest extends HttpRequestBase{

    @Test
    public void testDir() throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("apiKey", "a6b9e216b8be4a37bd9e9aee92ef5bb8");
        params.put("timestamp", String.valueOf(System.currentTimeMillis()));
        params.put("reqJson", "{'merchantId':10,'filePath':'test/'}");
        params.put("signature", "HyaMv8dwUAbDknEEfZMcg4J724d1p/EWJgDqPGUzfG7i8Wn99Jm+o1YzeOSt8wgPZT5HRQp");

        String url = DOMAIN_URL + "/cloud/appLog/dir/v1.0.0";

        System.out.println(ApacheHttpCilent.doPost(url, params));
    }
}
