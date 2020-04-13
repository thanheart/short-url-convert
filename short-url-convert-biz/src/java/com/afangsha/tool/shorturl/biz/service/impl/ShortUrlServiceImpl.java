/*
 * ShortUrlServiceImpl.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.afangsha.tool.shorturl.biz.service.impl;

import com.afangsha.tool.shorturl.data.common.ResponseMessageEnum;
import com.afangsha.tool.shorturl.biz.exception.ShortUrlException;
import com.afangsha.tool.shorturl.biz.service.ShortUrlService;
import com.afangsha.tool.shorturl.biz.util.BinarySystemUtils;
import com.afangsha.tool.shorturl.biz.util.HashCreateUtils;
import com.afangsha.tool.shorturl.data.url.UrlConvertData;
import com.afangsha.tool.shorturl.db.mysql.UrlConvertMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author changsu
 *
 */
@Service
public class ShortUrlServiceImpl implements ShortUrlService {
    private static String HTTP = "http";
    private static String Http = "http://";
    private static String Https = "https://";
    private static String ShortUrlPrefix = "afs.ink/a/";
    private static String ConflictAddValue = "#";
    private static int MaxTryCount = 10;
    private static String Empty = "";

    @Autowired
    private UrlConvertMapper urlConvertMapper;

    @Override
    public String convertToShortUrl(final String longUrl) {
        final String trueUrl = longUrl.startsWith(HTTP) ? longUrl : Https + longUrl;
        //验证URL 是否可以访问 todo
        final UrlConvertData urlConvertData = new UrlConvertData();
        urlConvertData.setLongUrl(trueUrl);
        String hashStr = new String(trueUrl);
        for (int count = 0; count < MaxTryCount; ++count, hashStr += ConflictAddValue) {
            long hashCode = HashCreateUtils.murmurHashGenerator(hashStr);
            if (hashCode < 0) {
                hashCode *= (-1);
            }
            urlConvertData.setHashcode(hashCode);
            urlConvertData.setShortUrl(
                    ShortUrlPrefix + BinarySystemUtils.convertTenToSixtyTwoBinary(hashCode));
            try {
                urlConvertMapper.insert(urlConvertData);
                return urlConvertData.getShortUrl();
            } catch (final Exception e) {
                //add log todo
                final UrlConvertData reqConvertData = new UrlConvertData();
                reqConvertData.setHashcode(hashCode);
                final UrlConvertData selectConvertData = urlConvertMapper.selectOne(reqConvertData);
                if (selectConvertData.getLongUrl().equals(trueUrl)) {
                    return selectConvertData.getShortUrl();
                }
                continue;
            }
        }
        throw new ShortUrlException(ResponseMessageEnum.SHORT_URL_CREAT_ERROR);
        //抛出异常
    }

    @Override
    public String convertToLongUrl(final String shortUrl) {
        if (!shortUrl.startsWith(ShortUrlPrefix)) {
            throw new ShortUrlException(ResponseMessageEnum.URL_NOT_SHORT);
        }
        final String number = shortUrl.replace(ShortUrlPrefix, Empty);
        final long hashCode = Long.valueOf(BinarySystemUtils.convertSixtyTwoToTenBinary(number));
        final UrlConvertData reqConvertData = new UrlConvertData();
        reqConvertData.setHashcode(hashCode);
        final UrlConvertData urlConvertData = urlConvertMapper.selectOne(reqConvertData);
        if (urlConvertData.getShortUrl().equals(shortUrl)) {
            return urlConvertData.getLongUrl();
        }
        throw new ShortUrlException(ResponseMessageEnum.URL_NOT_EXISTS);
    }

    private boolean urlIsValidate(final String urlStr){
        if(urlStr==null || urlStr.isEmpty()){
            return false;
        }
        URL url = new URL(urlStr);
        HttpURLConnection connection = url.openConnection();

    }
}
