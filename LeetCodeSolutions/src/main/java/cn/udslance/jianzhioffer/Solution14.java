package cn.udslance.jianzhioffer;



/**
 * @author H
 * @create 2021-05-21 10:31
 */
public class Solution14 {


    
    public void test() {
        int[] ints1 = {2,5,1,2,5};
        int[] ints2 = {10,5,2,1,5,2};

        System.out.println(maxUncrossedLines(ints1, ints2));

    }



    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            int num1 = nums1[i - 1];
            for (int j = 1; j <= n; j++) {
                int num2 = nums2[j - 1];
                if (num1 == num2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
