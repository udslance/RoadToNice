package cn.udslance.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @title: 斐波那契数
 * @description: 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * @difficulty: Easy
 * @Link: <a href="https://leetcode.cn/problems/fibonacci-number/description/">link</a>
 * @author: Udslance
 * @create: 2023-03-09 22:18
 **/
class Solution509 {
    @Test
    public void test() {
        System.out.println(fib(2));
    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
