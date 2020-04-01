/*
 * ExceptionController.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.afangsha.tool.shorturl.web.controller;

import com.afangsha.tool.shorturl.data.common.ShortUrlApiResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author changsu
 *
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    @ResponseBody
    public ShortUrlApiResult handlerException(final HttpServletRequest request, final Exception e) {
        return ShortUrlApiResult.error(200,"");
    }
}
