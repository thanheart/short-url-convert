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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private static List<Character> SixtyTwoBinaryCodeList = new ArrayList<Character>();
    private static Map<Character, Integer> SixtyTwoBinaryCodeMap = new HashMap<>();
    private static int SixtyTwo = 62;
    private static int Ten = 10;

    static {
        SixtyTwoBinaryCodeList.addAll(Arrays.asList(tenNumber));
        SixtyTwoBinaryCodeList.addAll(Arrays.asList(lowerLetter));
        SixtyTwoBinaryCodeList.addAll(Arrays.asList(upperLetter));
        for (int index = 0; index < SixtyTwoBinaryCodeList.size(); ++index) {
            SixtyTwoBinaryCodeMap.put(SixtyTwoBinaryCodeList.get(index), index);
        }
    }

    /**
     * 10 进制 转 62 进制
     * @param number
     * @return
     */
    public static String convertTenToSixtyTwoBinary(final long number) {
        return binarySystemConvert(String.valueOf(number), Ten, SixtyTwo);
    }

    /**
     * 62 进制转 10 进制
     * @param number
     * @return
     */
    public static String convertSixtyTwoToTenBinary(final String number) {
        return binarySystemConvert(number, SixtyTwo, Ten);
    }

    /**
     * sourceBinary 进制转换为 targetBinary 进制
     * @param number
     * @param sourceBinary
     * @param targetBinary
     * @return
     */
    private static String binarySystemConvert(final String number, final int sourceBinary,
            final int targetBinary) {
        final char[] numberChars = number.toCharArray();
        long tenBinSum = 0;
        //转换为 10 进制
        if (sourceBinary == 10) {
            tenBinSum = Long.valueOf(number);
        } else {
            for (int index = 1; index < numberChars.length; ++index) {
                char numberChar = numberChars[numberChars.length - index];
                int num = convertToNumber(numberChar);
                tenBinSum += num * Math.pow(sourceBinary, index - 1);
            }
        }
        //转换为 targetBin 进制
        if (targetBinary == 10) {
            return String.valueOf(tenBinSum);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (; tenBinSum != 0; tenBinSum /= targetBinary) {
            int tenNum = (int) (tenBinSum % targetBinary);
            stringBuffer.append(SixtyTwoBinaryCodeList.get(tenNum));
        }
        return stringBuffer.reverse().toString();
    }

    private static int convertToNumber(final char code) {
        return SixtyTwoBinaryCodeMap.get(code);
    }
}
