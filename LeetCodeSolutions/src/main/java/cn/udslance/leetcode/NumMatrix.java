package cn.udslance.leetcode;

/**
 * @title: 二维区域和检索 - 矩阵不可变
 * @description: 给定一个二维矩阵 matrix，以下类型的多个请求：
 * @difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/range-sum-query-2d-immutable/description/?orderBy=most_votes">link</a>
 * @author: Udslance
 * @create: 2023-02-19 19:55
 **/
class NumMatrix {
    private int[][] mMatrix;

    private int[][] dpMat;

    private int width;

    private int height;

    public NumMatrix(int[][] matrix) {
        mMatrix = matrix;
        width = matrix[0].length;
        height = matrix.length;
        dpMat = new int[height + 1][width + 1];
        initData();
    }

    private void initData() {
        initDpMat();
    }

    private void initDpMat() {
        for (int i = 0; i < mMatrix.length; i++) {
            for (int j = 0; j < mMatrix[0].length; j++) {
                dpMat[i+1][j+1] = dpMat[i][j+1] + dpMat[i+1][j] - dpMat[i][j] + mMatrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int a = dpMat[row1][col1];
        int b = dpMat[row1][col2 + 1];
        int c = dpMat[row2 + 1][col1];
        int d = dpMat[row2 + 1][col2 + 1];
        return d - b - c + a;
    }
}
