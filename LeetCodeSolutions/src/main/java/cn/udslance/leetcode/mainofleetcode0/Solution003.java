package cn.udslance.leetcode.mainofleetcode0;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution003 {
    public int lengthOfLongestSubstring(String s) {
        //用来存放当前两个指针间的字符以及字符位置
        HashMap<Character, Integer> dric = new HashMap<>();
        int pokeLeft = -1;
        int pokeRight = 0;
        int res = 0;
        for (; pokeRight < s.length(); pokeRight++) {
            char curChar = s.charAt(pokeRight);
            if (dric.containsKey(curChar) && dric.get(curChar) > pokeLeft) {
                //如果当前字典里已有当前字符：1. 将左指针移到上次该字符出现的位置（只允许右移） 2. 更新最新位置
                pokeLeft = dric.get(curChar);
            }
            //如果字典里没有当前字符，就加进去
            dric.put(curChar, pokeRight);
            res = Math.max(res, pokeRight - pokeLeft);
        }
        return res;
    }

    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        System.out.println(lengthOfLongestSubstring("abba"));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
