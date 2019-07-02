package com.example.entity;

import java.io.Serializable;

/**
 * @description:
 * @author chengdongyi
 * @date 2019/7/1 15:14
 */
public class Data implements Serializable {

    private static final long serialVersionUID = 2138983526814316910L;

    private String mobile;
    private String address;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
