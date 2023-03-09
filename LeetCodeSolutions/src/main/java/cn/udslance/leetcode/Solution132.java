package cn.udslance.leetcode;

import java.util.Arrays;

/**
 * @title: 分割回文串 II
 * @description: 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。返回符合要求的 最少分割次数 。
 * @difficulty: Hard
 * @Link: <a href="https://leetcode.cn/problems/palindrome-partitioning-ii/">link</a>
 * @author: Udslance
 * @create: 2022-11-05 21:21
 **/
class Solution132 {
    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int len = s.length();
        int dp[] = new int[len];
        Arrays.fill(dp, len - 1);
        for (int i = 0; i < len; i++) {
            // 注意偶数长度与奇数长度回文串的特点
            // 奇数回文串以1个字符为中心
            minCutHelper(s, i, i, dp);
            // 偶数回文串以2个字符为中心
            minCutHelper(s, i, i + 1, dp);
        }
        return dp[len - 1];
    }

    private void minCutHelper(String s, int i, int j, int[] dp) {
        int len = s.length();
        while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
            dp[j] = Math.min(dp[j], (i == 0 ? -1 : dp[i - 1]) + 1);
            i--;
            j++;
        }
    }
}
