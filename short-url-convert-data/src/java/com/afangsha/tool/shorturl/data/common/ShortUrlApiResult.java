/*
 * ShortUrlApiResult.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.afangsha.tool.shorturl.data.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author changsu
 *
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShortUrlApiResult<T> {
    private T resData;

    private boolean success;

    private int code;

    private String msg;


    public static <T> ShortUrlApiResult<T> error(final int errCode, final String errorMsg) {
        final ShortUrlApiResult<T> result = new ShortUrlApiResult<>();
        result.success = false;
        result.code = errCode;
        result.msg = errorMsg;
        return result;
    }

    public static <T> ShortUrlApiResult<T> pack(final T resultData) {
        final ShortUrlApiResult<T> result = new ShortUrlApiResult<>();
        result.success = true;
        result.resData = resultData;
        result.setCode(ResponseMessageEnum.SUCCESS.code);
        return result;
    }

    public static <T> ShortUrlApiResult<T> pack() {
        final ShortUrlApiResult<T> result = new ShortUrlApiResult<>();
        result.success = true;
        result.setCode(ResponseMessageEnum.SUCCESS.code);
        return result;
    }

    public static <T> ShortUrlApiResult<T> pack(int code, T resultData) {
        final ShortUrlApiResult<T> result = new ShortUrlApiResult<>();
        result.success = true;
        result.setCode(code);
        result.resData = resultData;
        return result;
    }
}
