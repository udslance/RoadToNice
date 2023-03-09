package cn.udslance.leetcode;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

/**
 * @title: 单词搜索
 * @description: 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * @difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/word-search/">link</a>
 * @author: Udslance
 * @create: 2022-10-16 12:08
 **/
class Solution079 {

    private static final Logger LOGGER = Logger.getLogger("");

    @Test
    public void testUrAnswer() {
        long startTime = System.currentTimeMillis();

        // do something!
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";

        String res = "";
        LOGGER.info("运行结果：" + exist(board, word));
        // end
        long endTime = System.currentTimeMillis();
        LOGGER.info("程序运行时间：" + (endTime - startTime) + " ms");
    }

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        char startChar = chars[0];
        // 首先要找到起点
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == startChar) {
                    boolean[][] use = new boolean[board.length][board[0].length];
                    if (dfs(board,use ,i, j, chars, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,boolean[][] use, int i, int j, char[] chars, int index) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != chars[index] || use[i][j]) {
            return false;
        }
        if (index == chars.length - 1) {
            return true;
        }
        // 标记为已使用
        use[i][j] = true;
        boolean b =  dfs(board, use, i + 1, j, chars, index + 1) ||
                dfs(board, use, i, j + 1, chars, index + 1) ||
                dfs(board, use, i - 1, j, chars, index + 1) ||
                dfs(board, use, i, j - 1, chars, index + 1);
        // 回溯
        use[i][j] = false;
        return b;
    }
}
