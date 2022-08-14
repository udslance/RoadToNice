package cn.udslance.leetcode.startswith0;



import java.util.Arrays;

/**
 * @author H
 * @create 2021-07-13 17:11
 */
public class Solution059 {
    
    public void test() {
        int[][] res = generateMatrix(4);

        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int num = 1;

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        while (num <= n * n) {
            //从左到右
            for (int i = left; i <= right && num <= n * n; i++) {
                res[top][i] = num++;
            }
            top++;

            //从上到下
            for (int i = top; i <= bottom && num <= n * n; i++) {
                res[i][right] = num++;
            }
            right--;

            //从右到左
            for (int i = right; i >= left && num <= n * n; i--) {
                res[bottom][i] = num++;
            }
            bottom--;

            //从下到上
            for (int i = bottom; i >= top && num <= n * n; i--) {
                res[i][left] = num++;
            }
            left++;

        }

        return res;
    }
}
