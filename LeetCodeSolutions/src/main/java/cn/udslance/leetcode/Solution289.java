package cn.udslance.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 生命游戏
 * <a href="https://leetcode-cn.com/problems/game-of-life/">...</a>
 * @author H
 * @create 2021-08-23 9:21
 */
class Solution289 {
    public void gameOfLife(int[][] board) {
        List<int[]> deadList = new ArrayList<>(9);
        List<int[]> aliveList = new ArrayList<>(9);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int alive = 0;
                //周围八个细胞
                //上
                if (i - 1 >= 0 && board[i - 1][j] == 1) {
                    ++alive;
                }
                //下
                if (i + 1 < board.length && board[i + 1][j] == 1) {
                    ++alive;
                }
                //左
                if (j - 1 >= 0 && board[i][j - 1] == 1) {
                    ++alive;
                }
                //右
                if (j + 1 < board[0].length && board[i][j + 1] == 1) {
                    ++alive;
                }
                //左上
                if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 1) {
                    ++alive;
                }
                //右上
                if (i - 1 >= 0 && j + 1 < board[0].length && board[i - 1][j + 1] == 1) {
                    ++alive;
                }
                //左下
                if (i + 1 < board.length && j - 1 >= 0 && board[i + 1][j - 1] == 1) {
                    ++alive;
                }
                //右下
                if (i + 1 < board.length && j + 1 < board[0].length && board[i + 1][j + 1] == 1) {
                    ++alive;
                }

                if (board[i][j] == 1 && (alive < 2 || alive > 3)) {
                    // 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
                    // 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
                    deadList.add(new int[]{i, j});
                }else if (board[i][j] == 0 && alive == 3) {
                    // 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
                    aliveList.add(new int[]{i, j});
                }
            }
        }
        for (int[] ints : deadList) {
            board[ints[0]][ints[1]] = 0;
        }
        for (int[] ints : aliveList) {
            board[ints[0]][ints[1]] = 1;
        }
    }
}
