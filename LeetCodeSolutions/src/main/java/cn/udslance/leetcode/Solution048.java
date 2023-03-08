package cn.udslance.leetcode;

import java.util.Arrays;

/**
 * @author H
 * @create 2021-07-07 22:36
 */
class Solution048 {

    
    public void test() {
        int[][] matrix = {{1,2},{3,4}};

        rotate(matrix);

        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }


    public void rotate(int[][] matrix) {

        int temp1 = matrix[0][0];

        int temp2 = matrix[0][1];


        for (int i = 0; i < 4; i++) {
            matrix[0][1] = temp1;

            temp1 = matrix[1][1];

            matrix[1][1] = temp2;

            temp2 = matrix[1][0];
        }

    }
}
