package cn.udslance.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 被围绕的区域
 * <a href="https://leetcode-cn.com/problems/surrounded-regions/">...</a>
 * @author H
 * @create 2021-07-25 21:18
 */
class Solution130 {

    
    public void test() {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','O','O','X'},{'X','O','X','X'}};

        solve(board);
    }

    public void solve(char[][] board) {
        // 先通过缺口找到所有"没有被围住的o，将其标记为#，然后再将剩余的o改为x"
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        //存放边界上的“缺口”
        List<int[]> exits = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从边缘o开始搜索
                boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isEdge && board[i][j] == 'O') {
                    exits.add(new int[]{i, j});
                    board[i][j] = '#';
                    visited[i][0] = true;
                }
            }
        }

        while (!exits.isEmpty()) {
            int count = exits.size();
            for (int k = 0; k < count; k++) {
                //获取出口坐标
                int[] temp = exits.remove(0);
                int i = temp[0];
                int j = temp[1];
                //下方
                if (i + 1 < m && board[i + 1][j] == 'O' && !visited[i + 1][j]) {
                    exits.add(new int[]{i + 1, j});
                    board[i + 1][j] = '#';
                    visited[i + 1][j] = true;
                }
                //上方
                if (i - 1 >= 0 && board[i - 1][j] == 'O' && !visited[i - 1][j]) {
                    exits.add(new int[]{i - 1, j});
                    board[i - 1][j] = '#';
                    visited[i - 1][j] = true;
                }
                //左方
                if (j - 1 >= 0 && board[i][j - 1] == 'O' && !visited[i][j - 1]) {
                    exits.add(new int[]{i, j - 1});
                    board[i][j - 1] = '#';
                    visited[i][j - 1] = true;
                }
                //右方
                if (j + 1 < n && board[i][j + 1] == 'O' && !visited[i][j + 1]) {
                    exits.add(new int[]{i, j + 1});
                    board[i][j + 1] = '#';
                    visited[i][j + 1] = true;
                }
            }

        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
