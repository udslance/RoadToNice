package cn.udslance.leetcode;

/**
 * @title: 搜索二维矩阵 II
 * @description: 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。
 * @difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/search-a-2d-matrix-ii/description/">link</a>
 * @author: Udslance
 * @create: 2023-02-19 11:47
 **/
class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 从右上角看是一颗二叉搜索树
        int width = matrix[0].length;
        int hight = matrix.length;
        for (int i = 0, j = width - 1; i < hight && j >= 0;) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
