/*
 * ShortUrlException.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.afangsha.tool.shorturl.biz.exception;

import com.afangsha.tool.shorturl.data.common.ResponseMessageEnum;

/**
 * @author changsu
 *
 */
public class ShortUrlException extends BusinessException {

    public ShortUrlException(final String message) {
        super(message);
    }

    public ShortUrlException(final Integer code, final String msg) {
        super(code, msg);
    }

    public ShortUrlException(final String msg, final Throwable cause) {
        super(msg, cause);
    }

    public ShortUrlException(final ResponseMessageEnum messageEnum) {
        super(messageEnum.code, messageEnum.message);
    }
}
