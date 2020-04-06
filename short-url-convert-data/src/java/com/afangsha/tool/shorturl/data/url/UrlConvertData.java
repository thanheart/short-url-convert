/*
 * UrlConvertData.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.afangsha.tool.shorturl.data.url;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * @author changsu
 *
 */
@Getter
@Setter
@TableName(value = "urlconvert")
public class UrlConvertData {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String longUrl;
    private String shortUrl;
    private int source;
    private int type;
    private Long hashcode;//建立索引
    private Long userId;
    private Boolean deleted;
    private Timestamp created;
    private Timestamp lastModified;
}
