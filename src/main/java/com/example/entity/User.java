package com.example.entity;

import java.io.Serializable;

/**
 * @description:
 * @author chengdongyi
 * @date 2019/7/1 15:13
 */
public class User implements Serializable {

    private static final long serialVersionUID = -802921134293026960L;

    private String name;
    private String pwd;
    private Data data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
