package com.shfc.cloud.interceptors;

import jodd.JoddDefault;
import jodd.io.StreamUtil;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Package com.shfc.cloud.interceptors.BodyReaderHttpServletRequestWrapper
 * @Description: BodyReaderHttpServletRequestWrapper
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/31 11:30
 * version V1.0.0
 */
public class BodyReaderHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private byte[] body;

    public BodyReaderHttpServletRequestWrapper(HttpServletRequest request)
            throws IOException {
        super(request);
        body = StreamUtil.readBytes(request.getReader(), JoddDefault.encoding);
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream(), JoddDefault.encoding));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body);
        return new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
        };
    }

    public void setBody(byte[] body){
        this.body = body;
    }
}