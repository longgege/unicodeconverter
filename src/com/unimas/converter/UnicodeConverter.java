package com.unimas.converter;

import sun.java2d.Surface;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 微信斜体字unicode转换
 * source: I love you three thousand times!
 * target: 𝑰 𝙡𝙤𝙫𝙚 𝙮𝙤𝙪 𝙩𝙝𝙧𝙚𝙚 𝙩𝙝𝙤𝙪𝙨𝙖𝙣𝙙 𝙩𝙞𝙢𝙚𝙨!
 * @author Lgg
 * @date 2019/8/23
 * see http://k.sina.com.cn/article_1595443924_5f188ad402700lqml.html 原理
 * see https://unicode-table.com/cn Unicode 字符百科
 */
public class UnicodeConverter {

    /**
     * 数学Sans-Serif Bold Italic Small A,120406
     */
    public static final int SMALL_A_CODE = 0x1D656;

    /**
     * 数学Sans-Serif Bold Italic Capital A,119912
     */
    public static final int BIG_A_CODE = 0x1D468;


    /**
     * 将字母字符转换为对应的unicode，其余字符原样输出
     *
     * @param source
     * @return
     */
    public static String converter(String source) {
        StringBuffer result = new StringBuffer();
        char[] sourceChar = source.toCharArray();
        // A与a的字符编码距离
        int lowerLetterDiff = 32;

        for (int i = 0; i < sourceChar.length; i++) {
            int diffCount = sourceChar[i] - 'A';
            // 除字母外其他字符，原样输出
            boolean isNotLetter = diffCount < 0 || diffCount > 58;
            if (isNotLetter) {
                result.append(sourceChar[i]);
                continue;
            }

            // 小写字母处理
            boolean isLowerLetter = diffCount >= lowerLetterDiff;
            if (isLowerLetter) {
                result.append(Character.toChars(diffCount - lowerLetterDiff + SMALL_A_CODE));
                continue;
            }

            // 大写字母处理
            result.append(Character.toChars(diffCount + BIG_A_CODE));
        }
        return result.toString();
    }


}
