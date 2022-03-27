package cn.udslance.interview.oppo;


/**
 * @author H
 * @create 2021-09-26 16:41
 */
public class Main2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 按传输的文件数量和个数限制，计算出有多少种选择方式
     * @param data int整型二维数组 * 其中第一个数组包含三个整数 n，k，m（1≤n≤2e5,0≤k≤1e9,1≤m≤n) ，其中第二个数组按创建天数给出每天的文件数a(0≤a≤1e9)
     * @return int整型
     */
    public int dpAlg (int[][] data) {
        // write code here
        int n = data[0][0];
        int k = data[0][1];
        int m = data[0][2];

        int[] pre = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            pre[i] = data[1][i - 1] + pre[i - 1];
        }

        int res = 0;
        for (int i = m; i < n + 1; i++) {
            if (pre[i] - pre[i - m] <= k) {
                res++;
            }
        }

        return res;
    }


}
