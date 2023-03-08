package cn.udslance.leetcode;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

/**
 * @title: 买卖股票的最佳时机
 * @description: 买卖股票的最佳时机
 * @difficulty: Easy
 * @Link: <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/">...</a>
 * @author: Udslance
 * @create: 2022-11-02 21:59
 **/
class Solution121 {

    private static final Logger LOGGER = Logger.getLogger("");

    @Test
    public void testUrAnswer() {
        long startTime = System.currentTimeMillis();

        // do something!
        int[] prices = new int[]{7,1,5,3,6,4};

        String res = "" + maxProfit(prices);
        LOGGER.info("运行结果：" + res);
        // end
        long endTime = System.currentTimeMillis();
        LOGGER.info("程序运行时间：" + (endTime - startTime) + " ms");
    }



    public int maxProfit(int[] prices) {
        // dp[i]表示当天卖出股票能获得的最大利润
        if (prices.length <= 1) {
            return 0;
        }
        int pre = Math.max(prices[1] - prices[0], 0);
        int res = Math.max(0, pre);
        for (int i = 2; i < prices.length; i++) {
            if (pre <= 0) {
                pre = Math.max(prices[i] - prices[i - 1], 0);
            } else {
                pre = (prices[i] - prices[i - 1]) + pre;
            }
            res = Math.max(res, pre);
        }
        return res;
    }
}
