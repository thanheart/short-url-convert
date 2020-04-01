/*
 * BusinessException.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.afangsha.tool.shorturl.biz.exception;

import org.springframework.http.HttpStatus;

/**
 * @author changsu
 *
 */
public class BusinessException extends RuntimeException {
    private Integer code;

    public BusinessException(final String message) {
        this(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    public BusinessException(final Integer code, final String msg) {
        super(msg);
        this.code = code;
    }

    public BusinessException(final String msg, final Throwable cause) {
        super(msg, cause);
    }

}
