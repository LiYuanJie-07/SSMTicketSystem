package com.gdou.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * 公共返回类
 */
public class Msg {
    //状态码 100失败 200成功
    private Integer code;

    //提示信息
    private String msg;

    //返回的数据
    private Map<String,Object> data = new HashMap<String,Object>();

    //成功方法
    public static Msg success(String msg){
        Msg result = new Msg();
        result.setCode(200);
        result.setMsg(msg);
        return result;
    }

    //失败方法
    public static Msg fail(String msg){
        Msg result = new Msg();
        result.setCode(100);
        result.setMsg(msg);
        return result;
    }

    //返回数据方法
    public Msg add(String key,Object value){
        this.getData().put(key, value);
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }


}
