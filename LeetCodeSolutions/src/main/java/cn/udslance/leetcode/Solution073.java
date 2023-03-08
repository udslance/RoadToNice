package cn.udslance.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author H
 * @create 2021-07-15 16:53
 */
class Solution073 {
    /**
     * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        List<int[]> list = new ArrayList<>();

        //遍历矩阵，看看 0 在哪些行和列，将他们添加到 list 中去
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }
        //遍历 list，将矩阵对应行和列置 0；
        for (int[] ints : list) {
            helper(ints[0], ints[1], matrix);
        }
    }

    public void helper(int i, int j, int[][] matrix) {
        //将该行填充为0
        for (int k = 0; k < matrix[0].length; k++) {
            matrix[i][k] = 0;
        }

        //将该列填充为0
        for (int k = 0; k < matrix.length; k++) {
            matrix[k][j] = 0;
        }
    }
}
