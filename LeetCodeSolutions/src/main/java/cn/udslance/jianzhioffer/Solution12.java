package cn.udslance.jianzhioffer;



/**
 * @author H
 * @create 2021-05-18 10:31
 */
public class Solution12 {
    public int maxProfit1(int[] prices) {

        int max = 0;

        for (int i = prices.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {

                max = Math.max(max, prices[i] - prices[j]);
            }
        }

        return max;
    }

    
    public void test2() {
        int[] ints = {7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit2(ints));

    }

    public int maxProfit2(int[] prices) {

        int[] dp = new int[prices.length];

        dp[0] = 0;

        //用来记录前i天股票的最小值
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(prices[i] - min, dp[i - 1]);

            min = Math.min(prices[i], min);
        }

        return dp[prices.length - 1];
    }
}
