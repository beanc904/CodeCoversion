package com.beanc.exchange;

public class ToOriginal {
    //ChatGPT生成
    // 二进制减一操作的方法
    private static String binarySubtractOne(String binaryString) {
        char[] binaryArray = binaryString.toCharArray();

        // 从右到左遍历二进制数组
        for (int i = binaryArray.length - 1; i >= 0; i--) {
            if (binaryArray[i] == '1') {
                // 如果当前位是1，则变为0，并结束循环
                binaryArray[i] = '0';
                break;
            } else {
                // 如果当前位是0，则变为1，继续循环
                binaryArray[i] = '1';
            }
        }

        // 将字符数组转换为字符串并返回
        return new String(binaryArray);
    }//ChatGPT引用结束

    //以下为实现代码

    public static String CTO(String ComplementCode) {
        //（原码转化为反码）同时也是反码转原码
        StringBuilder string = new StringBuilder();

        for (char bit : ComplementCode.toCharArray()) {
            if (bit == '0') {
                string.append('1');
            } else {
                string.append('0');
            }
        }

        char[] chars = string.toString().toCharArray();
        if (chars[0] == '0') {
            chars[0] = '1';
        } else {
            chars[0] = '0';
        }

        return new String(chars);
    }

    public static String TTO(String TwosComplementCode) {
        //补码转原码
        char[] chars = TwosComplementCode.toCharArray();

        if (chars[0] == '1') {
            chars[0] = '0';
            String result = binarySubtractOne(new String(chars));
            char[] chars1 = result.toCharArray();
            chars1[0] = '1';//char1是反码
            return CTO(new String(chars1));
        } else {
            return TwosComplementCode;
        }
    }

    public static String STO(String OffsetCode) {
        //偏移码转原码
        char[] chars = OffsetCode.toCharArray();

        if (chars[0] == '0') {
            chars[0] = '1';
        } else {
            chars[0] = '0';
        }//此时的chars是补码

        return TTO(new String(chars));
    }

}
