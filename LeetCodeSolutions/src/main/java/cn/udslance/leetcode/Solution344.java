package cn.udslance.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @title: 反转字符串
 * @description: 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * @difficulty: Easy
 * @Link: <a href="https://leetcode.cn/problems/reverse-string/">link</a>
 * @author: Udslance
 * @create: 2023-03-05 21:26
 **/
class Solution344 {
    @Test
    public void test() {
        reverseString(new char[]{'h','e','l','l','o'});
    }

    public void reverseString(char[] s) {
        if (s.length <= 1) {
            return;
        }
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
        System.out.println(Arrays.toString(s));
    }
}
