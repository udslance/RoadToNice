package cn.udslance.leetcode;

/**
 * @title: 整数拆分
 * @description: 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。  返回 你可以获得的最大乘积 。
 * @difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/integer-break/description/">link</a>
 * @author: Udslance
 * @create: 2023-02-26 20:56
 **/
class Solution343 {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int res = 1;
        while(n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}
