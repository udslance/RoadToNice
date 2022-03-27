package cn.udslance.interview.midea;

/**
 * @author H
 * @create 2021-09-17 20:15
 */
public class Solution002 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param prices double浮点型一维数组
     * @return double浮点型
     */
    public double maxProfit (double[] prices) {
        // write code here
        double min = prices[0];
        double cur;
        double res = 0;

        for (int i = 1; i < prices.length; i++) {
            cur = prices[i];
            res = Math.max(cur - min, res);
            min = Math.min(min, cur);
        }

        return res;
    }
}
