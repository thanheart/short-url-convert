/*
 * BinarySystemUtils.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.afangsha.tool.shorturl.biz.util;

/**
 * @author changsu
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 进制转换
 */
public class BinarySystemUtils {

    /**
     * 10 进制转 62 进制
     * @param number
     * @return
     */

    private static Character[] tenNumber = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private static Character[] lowerLetter = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };
    private static Character[] upperLetter = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };
    private static List<Character> SixtyTwoBinaryCode = new ArrayList<Character>();
    private static long SixtyTwo = 62;

    static {
        SixtyTwoBinaryCode.addAll(Arrays.asList(tenNumber));
        SixtyTwoBinaryCode.addAll(Arrays.asList(lowerLetter));
        SixtyTwoBinaryCode.addAll(Arrays.asList(upperLetter));
    }

    public static String convertTenToSixtyTwoBinary(final long number) {
        final List<Character> sixtyTwoBinChar = new ArrayList<Character>();
//        number%SixtyTwo
        return "";
    }
}
