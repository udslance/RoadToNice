package cn.udslance.leetcode.mainofleetcode5;



/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution516 {
    public int longestPalindromeSubseq(String s) {
        //动态规划
        int length = s.length();
        int[][] dp = new int[length][length];

        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }

        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][length - 1];
    }

    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
