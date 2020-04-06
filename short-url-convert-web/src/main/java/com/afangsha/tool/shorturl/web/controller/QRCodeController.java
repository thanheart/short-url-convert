/*
 * QRCodeController.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.afangsha.tool.shorturl.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author thanheart
 *
 */
@RestController
public class QRCodeController {

    @GetMapping("/thanheart/afangsha/qrcode")
    public void getQRCode(final HttpServletRequest request,final HttpServletResponse response,
            @RequestParam(value = "shorturl") final String shortUrl){

    }
}
