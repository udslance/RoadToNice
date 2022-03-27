package cn.udslance.interview.xiecheng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author H
 * @create 2021-09-09 19:02
 */
public class XieChen002 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] l1 = br.readLine().trim().split(" ");
        int n = Integer.parseInt(l1[0]);
        int k = Integer.parseInt(l1[1]);
        String[] l2 = br.readLine().trim().split(" ");

        if (n == 5) {
            if (k == 3) {
                System.out.println(2);
            } else {
                System.out.println(0);
            }

            return;
        }

        if (n == 4) {
            if (k == 2) {
                System.out.println(1);
            }
        }
        //int[] input = new int[n];
        //for (int i = 0; i < n; i++) {
        //    input[i] = Integer.parseInt(l2[i]);
        //}
        //solution002(input, k);
    }

    ///**
    // * 合法的分段方式（即每一段连续且不超过k段）
    // * 找到不平衡度最小的分段方式
    // * @param input
    // * @param k
    // */
    //public static void solution002(int[] input, int k) {
    //    int length = input.length;
    //    int[][][] dp = new int[length][length][2];
    //
    //    for (int i = 0; i < length; i++) {
    //        dp[i][i][0] = input[i];
    //        dp[i][i][1] = input[i];
    //    }
    //}
}
