package com.unimas;

import com.unimas.converter.UnicodeConverter;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 微信斜体字unicode转换测试
 * @author Lgg
 * @date 2019/8/26
 */
public class Test {

    public static void main(String[] args) {

        try (Scanner inputString = new Scanner(System.in, StandardCharsets.UTF_8.name());) {
            // 接收输入
            // "Talk is cheap,Show me the code!";
            String source = inputString.nextLine();
            // 转换并打印
            System.out.println(UnicodeConverter.converter(source));
        }

//        System.out.println('a'-'A'-6+119912);
//        System.out.println(String.valueOf(Character.toChars(0x1D661)));
//        System.out.println(Integer.parseInt("1D661",16));
//        System.out.println(Integer.toHexString(120406).toUpperCase());
//        for (int i = 119912; i <= 119937; i++) {
//            System.out.print(String.valueOf(Character.toChars(i)));
//        }
//        System.out.println('I'-'A');
//        System.out.println(Character.toChars(119912));
    }
}
