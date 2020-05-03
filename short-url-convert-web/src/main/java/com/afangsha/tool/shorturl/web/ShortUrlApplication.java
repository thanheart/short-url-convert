/*
 * ShortUrlApplication.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.afangsha.tool.shorturl.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author changsu
 *
 */
@SpringBootApplication(
        scanBasePackages = {
                "com.afangsha.tool.shorturl.common",
                "com.afangsha.tool.shorturl.biz",
                "com.afangsha.tool.shorturl.web"
        }
)
@EnableAsync
@MapperScan("com.afangsha.tool.shorturl.db.mysql")
public class ShortUrlApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(
            final SpringApplicationBuilder application) {
        return application.sources(ShortUrlApplication.class);
    }

    public static void main(final String[] args) {
        SpringApplication.run(ShortUrlApplication.class, args);
    }
}
