package com.lyanba.entry;

/**
 * @className: ResultCode
 * @description: 返回值状态码
 * @author: LyanbA
 * @since: 2021/10/10 20:47
 * @todo:
 */
public enum ResultCode {
    SUCCESS(200),
    FAILED(500);

    private Integer code;

    ResultCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
