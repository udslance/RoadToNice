package cn.udslance.leetcode.startswith2;



/**
 * @author H
 * @create 2021-08-08 23:05
 */
public class Solution200 {

    
    public void test() {

    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int res = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length  || j >= grid[0].length || grid[i][j] == '0' || grid[i][j] == '2') {
            // board[i][j] == '#' 说明已经搜索过了.
            return;
        }

        grid[i][j] = '2';
        // 上
        dfs(grid, i - 1, j);
        // 下
        dfs(grid, i + 1, j);
        // 左
        dfs(grid, i, j - 1);
        // 右
        dfs(grid, i, j + 1);

    }
}
