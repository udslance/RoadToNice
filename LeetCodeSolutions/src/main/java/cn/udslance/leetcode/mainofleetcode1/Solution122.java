package cn.udslance.leetcode.mainofleetcode1;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution122 {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 0：持有现金
        // 1：持有股票
        // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            // 这两行调换顺序也是可以的
            //dp[i - 1][0]：昨天不买，今天也不买
            //dp[i - 1][1] + prices[i]：昨天买了，今天卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            //dp[i - 1][1]：昨天买了，今天不卖出
            //dp[i - 1][0] - prices[i]：昨天没买，今天买
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}
