package com.shfc.mac.Utils;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Colin Yan on 2017/1/23.
 */
public class InvokeBase {

    public static String post(String url, Map<String, String> map) throws IOException {

        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> e : map.entrySet()) {
            nvps.add(new BasicNameValuePair(e.getKey(), e.getValue()));
        }

        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
        HttpResponse response = httpclient.execute(httpPost);
        System.out.println("url:" + url);
        System.out.println("status code:" + response.getStatusLine());
        String result = IOUtils.toString(response.getEntity().getContent(), "utf-8");
        httpclient.getConnectionManager().shutdown();
        return result;
    }

    public String sign(String appId, String version, String signType, String params, String appSecret) {
        String sourceStr = "appId=" + appId + "&version=" + version
                + "&signType=" + signType + "&params=" + params + "&appSecret="
                + appSecret;

        return Md5Utils.getMd5Code(sourceStr, "utf-8");
    }
}
