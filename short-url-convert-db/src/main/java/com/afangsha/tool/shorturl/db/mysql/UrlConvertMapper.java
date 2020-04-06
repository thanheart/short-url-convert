/*
 * UrlConvertMapper.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.afangsha.tool.shorturl.db.mysql;

import com.afangsha.tool.shorturl.data.url.UrlConvertData;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author changsu
 *
 */
public interface UrlConvertMapper extends BaseMapper<UrlConvertData> {

    UrlConvertData getUrlDataById(@Param("id") long id);

    UrlConvertData getUrlDataByHashCode(@Param("hashcode") long hashCode);
}
