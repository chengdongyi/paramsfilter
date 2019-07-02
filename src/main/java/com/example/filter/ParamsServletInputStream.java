package com.example.filter;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author chengdongyi
 * @description: 请求参数输入流
 * @date 2019/7/1 10:46
 */
public class ParamsServletInputStream extends ServletInputStream {

    private ByteArrayInputStream bis;

    public ParamsServletInputStream(ByteArrayInputStream bis) {
        this.bis = bis;
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void setReadListener(ReadListener readListener) {

    }

    @Override
    public int read() throws IOException {
        return bis.read();
    }

}
