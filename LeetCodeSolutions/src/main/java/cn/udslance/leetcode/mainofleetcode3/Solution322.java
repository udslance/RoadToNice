package cn.udslance.leetcode.mainofleetcode3;



/**
 * 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * 链接：https://leetcode-cn.com/problems/coin-change
 *
 * @author H
 * @create 2021-08-12 19:42
 */
public class Solution322 {
    
    public void test() {
        int[] ints = new int[]{1,2,5};

        System.out.println(coinChange(ints, 11));
    }


    public int coinChange(int[] coins, int amount) {
        // 自底向上的动态规划
        if(coins.length == 0){
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] memo = new int[amount+1];
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && memo[i - coin] < min) {
                    min = memo[i - coin] + 1;
                }
            }

            memo[i] = min;
        }

        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];

    }
}
