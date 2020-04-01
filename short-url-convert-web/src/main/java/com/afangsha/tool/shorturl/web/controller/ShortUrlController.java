/*
 * ShortUrlController.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.afangsha.tool.shorturl.web.controller;

import com.afangsha.tool.shorturl.biz.service.ShortUrlService;
import com.afangsha.tool.shorturl.data.common.ShortUrlApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author changsu
 *
 */
@RestController
public class ShortUrlController {

    @Autowired
    private ShortUrlService shortUrlService;

    @PostMapping("/thanheart/afangsha/shorturl")
    public ShortUrlApiResult createShortUrl(final HttpServletRequest request,
            @RequestParam(value = "longurl") final String longUrl) {
        final String shortUrl = shortUrlService.convertToShortUrl(longUrl);
        return ShortUrlApiResult.pack(shortUrl);
    }

    @GetMapping()
    public ShortUrlApiResult getLongUrl(final HttpServletRequest request,
            @RequestParam(value = "shorturl")final String shortUrl){
        final String longUrl = shortUrlService.convertToLongUrl(shortUrl);
        return ShortUrlApiResult.pack(longUrl);
    }
}
