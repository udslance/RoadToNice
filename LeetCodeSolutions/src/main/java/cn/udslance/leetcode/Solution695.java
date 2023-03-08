package cn.udslance.leetcode;

/**
 * 岛屿的最大面积
 * https://leetcode-cn.com/problems/max-area-of-island/
 * @author H
 * @create 2021-08-16 20:47
 */
class Solution695 {
    private Integer maxSize = 0;

    public void test() {
        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(maxAreaOfIsland(grid));

    }

    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxSize = Math.max(maxSize, dfs(grid, i, j, 1));
                }
            }
        }
        return maxSize;
    }

    public int dfs(int[][] grid, int i, int j, int size) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 2 || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 2;
        //上
        return 1
            + dfs(grid, i - 1, j, size + 1)
            + dfs(grid, i + 1, j, size + 1)
            + dfs(grid, i, j - 1, size + 1)
            +dfs(grid, i, j + 1, size + 1);
    }
}
