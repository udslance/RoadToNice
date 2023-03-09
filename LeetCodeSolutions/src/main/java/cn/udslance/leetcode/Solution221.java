package cn.udslance.leetcode;

/**
 * @title: 最大正方形
 * @description: 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * @difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/maximal-square/description/?orderBy=most_votes">link</a>
 * @author: Udslance
 * @create: 2023-02-18 11:24
 **/
class Solution221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }

        int col = matrix[0].length;
        int row = matrix.length;
        int[][] dp = new int[row + 1][col + 1];
        int maxRes = Integer.MIN_VALUE;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(dp[i][j + 1], Math.min(dp[i][j], dp[i + 1][j])) + 1;
                    maxRes = Math.max(maxRes, dp[i + 1][j + 1]);
                }
            }
        }

        return maxRes * maxRes;
    }
}
