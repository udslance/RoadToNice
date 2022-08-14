package cn.udslance.leetcode.startswith3;

/**
 * @author H
 * @create 2021-08-22 17:49
 */
public class Solution309 {
    public int maxProfit(int[] prices) {
        //天数
        int n = prices.length;
        int[][] dp = new int[n][3];
        //状态码：
        //0 表示当天在股市没有钱，钱在手上
        //1 表示钱在股市里，且当天不准备卖出
        //2 表示当天卖出，钱在当天回到手上

        //初始条件
        dp[0][0] = 0;
        dp[0][1] = -1 * prices[0];
        dp[0][2] = 0;

        for (int i = 1; i < n; i++) {
            //0 表示当天在股市没有钱：可能有两种情况
            //昨天在股市就没有钱
            //昨天在股市没有钱，是因为昨天卖出去了
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);

            //1 表示钱在股市里，且不准备取出来
            //钱一直就在股市里
            //今天刚买入的，这里需要注意只有昨天钱在手上（冷冻期），今天才能买，即昨天是0不是2
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);

            //2 表示当天卖出，则前一天钱一定在股市里
            dp[i][2] = dp[i - 1][1] + prices[i];
        }

        return Math.max(dp[n-1][0],dp[n-1][2]);
    }
}
