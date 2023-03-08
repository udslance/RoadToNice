package cn.udslance.leetcode;

/**
 * @title: 丑数 II
 * @description: 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * @difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/ugly-number-ii/description/?orderBy=most_votes">...</a>
 * @author: Udslance
 * @create: 2023-02-19 12:19
 **/
class Solution264 {
    public int nthUglyNumber(int n) {
        int[] uglyArr = new int[n + 1];
        uglyArr[1] = 1;
        for (int i2 = 1, i3 = 1, i5 = 1, curX = 2; curX < n + 1; curX++) {
            int a = uglyArr[i2] * 2;
            int b = uglyArr[i3] * 3;
            int c = uglyArr[i5] * 5;

            int curMin = Math.min(a, Math.min(b, c));
            if (curMin == a) {
                i2++;
            }
            if (curMin == b) {
                i3++;
            }
            if (curMin == c) {
                i5++;
            }
            uglyArr[curX] = curMin;
        }
        return uglyArr[n];
    }
}
