package cn.udslance.leetcode.startswith2;

/**
 * @author H
 * @create 2021-08-16 21:29
 */
public class Solution279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i;

            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }

        return dp[n];
    }
}
