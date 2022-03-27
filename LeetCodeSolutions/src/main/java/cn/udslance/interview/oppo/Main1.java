package cn.udslance.interview.oppo;



import java.util.Arrays;

/**
 * @author H
 * @create 2021-09-26 16:41
 */
public class Main1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算出给定二维数组的最短路径
     * @param data int整型二维数组
     * @return int整型
     */
    public int findShortestPath (int[][] data) {
        // write code here
        int n = data.length;
        int[][] dp = new int[n + 1][n + 1];

        //初始化第一行和第一列
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }

        Arrays.fill(dp[0], Integer.MAX_VALUE);

        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = data[i - 1][j - 1] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n][n];
    }

    
    public void test() {
        int[][] data = {{2,3,1,4},{4,6,3,1},{4,3,1,2},{2,4,1,3}};

        System.out.println(findShortestPath(data));

    }
}
