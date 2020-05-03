/*
 * RedisCache.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.afangsha.tool.shorturl.biz.redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author changsu
 *
 */
@Service
public class RedisCache {

    @Resource(name = "stringRedisTemplate")
    private StringRedisTemplate stringRedisTemplate;


}
