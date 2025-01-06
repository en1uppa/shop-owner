package com.example.common;

import lombok.Data;


/**
 * 通用返回给前端的结果，服务端响应的数据最终都会封装成此对象
 * @param <T>
 */
@Data
public class R<T> {
    private int code;
    private String msg;
    private T data;
    public static <T> R<T> success(T data)
    {
        R<T> r = new R<>();
        r.setCode(200);
        r.setData(data);
        r.msg="响应成功";
        return r;
    }
    public static <T> R<T> error(String msg){
        R<T> r = new R<>();
        r.setCode(500);
        r.msg="错误信息!";
        return r;
    }
}
