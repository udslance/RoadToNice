package cn.udslance.leetcode.mainofleetcode0;

/**
 * @author H
 * @create 2021-07-15 15:34
 */
public class Solution064 {
    public int minPathSum(int[][] grid) {
        //特殊情况
        if (grid.length == 0 || grid == null) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;

        int[][] dp = new int[m][n];
        
        //dp 初始化
        dp[0][0] = grid[0][0];

        //初始化第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        //初始化第一行
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        
        //动态规划，转移方程：dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}
