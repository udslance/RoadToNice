package cn.udslance.leetcode;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
class Solution518 {
    
    public void test() {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(change(5, coins));

    }

    private Integer res = 0;

    /**
     * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
     * <p>
     * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
     * <p>
     * 假设每一种面额的硬币有无限个。
     *
     * @param amount ...
     * @param coins  ...
     * @return ...
     */
    public int change(int amount, int[] coins) {
        dfs(amount, coins, 0);
        return res;
    }

    private void dfs(int amount, int[] coins, int start) {
        if (amount == 0) {
            res++;
            return;
        }

        for (int i = start; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                dfs(amount - coins[i], coins, i);
            }
        }
    }
}
