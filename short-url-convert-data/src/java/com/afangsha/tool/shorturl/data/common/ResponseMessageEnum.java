/*
 * ResponseMessageEnum.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.afangsha.tool.shorturl.data.common;

/**
 * @author changsu
 *
 */
public enum  ResponseMessageEnum {
    SUCCESS(200, "成功"),

    /**
     * 10000-10100 为短链接异常
     */
    SHORT_URL_CREAT_ERROR(10000,"短链接生成异常"),
    URL_NOT_SHORT(10001,"不是短链接"),
    URL_NOT_EXISTS(10002,"短链接不存在"),
    URL_IN_VALIDATE(10003,"次链接无效"),

    /**
     *  90000-90100 为通用错误码
     */
    PARAM_ERROR(90000, "参数错误"),
    INTERNAL_SERVER_ERROR(90001, "系统异常");

    public int code;

    public String message;

    private ResponseMessageEnum(final int code, final String desc) {
        this.code = code;
        this.message = desc;
    }
}
