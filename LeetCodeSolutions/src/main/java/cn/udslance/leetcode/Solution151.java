package cn.udslance.leetcode;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

/**
 * @title: 反转字符串中的单词
 * @description: 给你一个字符串 s ，请你反转字符串中单词的顺序。
 * @difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/reverse-words-in-a-string/">link</a>
 * @author: Udslance
 * @create: 2022-11-06 21:39
 **/
class Solution151 {

    private static final Logger LOGGER = Logger.getLogger("");

    @Test
    public void testUrAnswer() {
        long startTime = System.currentTimeMillis();

        // do something!
        String str = "F R  I   E    N     D      S      ";

        String res = reverseWords(str);
        LOGGER.info("运行结果：" + res);
        // end
        long endTime = System.currentTimeMillis();
        LOGGER.info("程序运行时间：" + (endTime - startTime) + " ms");
    }


    public String reverseWords(String s) {
        s = s.trim();
        int j = s.length() - 1;
        int i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            // 搜索首个空格
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            // 添加单词
            res.append(s.substring(i + 1, j + 1)).append(" ");
            // 跳过单词间空格
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            // j指向下个单词的尾字符
            j = i;
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}
