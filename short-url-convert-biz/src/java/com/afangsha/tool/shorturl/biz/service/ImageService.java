/*
 * ImageService.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.afangsha.tool.shorturl.biz.service;

/**
 * @author changsu
 *
 */

import org.springframework.web.multipart.MultipartFile;

/**
 * 用于图片上传
 */
public interface ImageService {

    /**
     * 上传图片到文件服务器 or oss
     * @param projectImgFile
     * @return
     */
    String uploadImg( final MultipartFile projectImgFile);
}
