package cn.udslance.leetcode;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

/**
 * @Title: 字符串转换整数 (atoi)
 * @Difficulty: middle
 * @Link: <a href="https://leetcode.cn/problems/string-to-integer-atoi/">link</a>
 * @author H
 * @create 2021-08-23 9:21
 *
 */
class Solution008 {
    static Logger logger = Logger.getLogger("");

    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        int res = myAtoi("4193 with words");
        logger.info("结果：" + res);
        long endTime = System.currentTimeMillis();
        logger.info("程序运行时间：" + (endTime - startTime) + " ms");
    }

    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0){
            return 0;
        }
        int res = 0;
        // 去除前导空格

        // 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。
        // 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
        int isPositive = 1;
        int start = 0;
        if (s.charAt(0) == '-') {
            isPositive = -1;
            start = 1;
        } else if (s.charAt(0) == '+') {
            start = 1;
        }
        //读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) < 48 || s.charAt(i) > 57) {
                break;
            }
            int cur = s.charAt(i) - '0';
            if (res * isPositive > 214748364 || (res * isPositive == 214748364 && cur > 7)) {
                return Integer.MAX_VALUE;
            } else if (res * isPositive < -214748364 || (res * isPositive == -214748364 && cur > 7)) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + cur;
        }

        return res * isPositive;
    }



}
