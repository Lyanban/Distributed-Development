package com.lyanba.entry;

import lombok.Getter;

/**
 * @className: ResultJson
 * @description: 返回值封装类
 * @author: LyanbA
 * @since: 2021/10/10 20:41
 * @todo:
 */
@Getter
public class ResultJson<T> {
    private Integer code;
    private String message;
    private T obj;

    private ResultJson(Integer code, String message, T obj) {
        this.code = code;
        this.message = message;
        this.obj = obj;
    }

    public static <T> ResultJson<T> getInstance(ResultCode resultCode, T obj, String message) {
        return new ResultJson<>(resultCode.getCode(), message, obj);
    }

    public static <T> ResultJson<T> success(String message, T obj) {
        return getInstance(ResultCode.SUCCESS, obj, message);
    }
    public static <T> ResultJson<T> success(T obj) {
        return getInstance(ResultCode.SUCCESS, obj, null);
    }

    public static <T> ResultJson<T> failed(T obj, String message) {
        return getInstance(ResultCode.FAILED, obj, message);
    }

    public static <T> ResultJson<T> failed(String message) {
        return getInstance(ResultCode.FAILED, null, message);
    }
}
