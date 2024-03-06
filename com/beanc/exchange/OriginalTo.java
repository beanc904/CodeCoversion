package com.beanc.exchange;

public class OriginalTo {
    //ChatGPT生成
    // 二进制加一操作的方法
    private static String binaryAddOne(String binaryString) {
        char[] binaryArray = binaryString.toCharArray();

        // 从右到左遍历二进制数组
        for (int i = binaryArray.length - 1; i >= 0; i--) {
            if (binaryArray[i] == '0') {
                // 如果当前位是0，则将其变为1，并结束循环
                binaryArray[i] = '1';
                break;
            } else {
                // 如果当前位是1，则变为0，继续循环
                binaryArray[i] = '0';
            }
        }

        // 将字符数组转换为字符串并返回
        return new String(binaryArray);
    }//ChatGPT引用结束

    //以下为实现代码

    public static String OTC(String OriginalCode) {
        //原码转化为反码
        StringBuilder string = new StringBuilder();

        for (char bit : OriginalCode.toCharArray()) {
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

    public static String OTT(String OriginalCode) {
        //原码转补码
        char[] chars = OTC(OriginalCode).toCharArray();
        if (chars[0] == '1') {
            chars[0] = '0';
            String result = binaryAddOne(new String(chars));
            char[] chars1 = result.toCharArray();
            chars1[0] = '1';
            return new String(chars1);
        } else {
            return OriginalCode;
        }
    }

    public static String OTS(String OriginalCode) {
        //原码转偏移码
        char[] chars = OTT(OriginalCode).toCharArray();

        if (chars[0] == '0') {
            chars[0] = '1';
        } else {
            chars[0] = '0';
        }

        return new String(chars);
    }
}
