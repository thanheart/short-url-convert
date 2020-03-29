/*
 * ShortUrlService.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.afangsha.tool.shorturl.biz.service;

/**
 * @author changsu
 *
 */
public interface ShortUrlService {

    /**
     * 长链接转短链接
     * @param longUrl
     * @return
     */
    String convertToShortUrl(final String longUrl);

    /**
     * 短链接转长链接
     * @param shortUrl
     * @return
     */
    String convertToLongUrl(final String shortUrl);
}
