package cn.udslance.leetcode.mainofleetcode3;



import java.util.Arrays;

/**
 * @author H
 * @create 2021-08-23 9:00
 */
public class Solution0101 {

    
    public void test() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);

    }


    public void rotate(int[][] matrix) {


        //行
        int m = matrix.length;
        //列
        int n = matrix[0].length;

        //第一步：沿对角线翻转
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i != j) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }

        //第二步：竖直对称翻转
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }

        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
