package cn.udslance.leetcode.startswith0;

/**
 * @author H
 * @create 2021-06-14 17:01
 */
public class Solution005 {
    public static void main(String[] args) {
        Solution005 solution005 = new Solution005();

        System.out.println(solution005.longestPalindrome("bcbb"));

    }

    public String longestPalindrome(String s) {
        // 特殊情况
        if (s.length() < 2) {
            return s;
        }

        //构建表格dp[i][j]表示s[i]->s[j]之间是否为回文串
        int length = s.length();
        boolean[][] dp = new boolean[length][length];

        //初始化表格
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;
        int begin = 0;

        //动态规划
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                {
                    if (s.charAt(i) != s.charAt(j)) {
                        dp[i][j] = false;
                    } else {
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }

                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
