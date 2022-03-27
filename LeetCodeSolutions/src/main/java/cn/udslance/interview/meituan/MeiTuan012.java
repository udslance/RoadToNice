package cn.udslance.interview.meituan;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author H
 * @create 2021-09-10 10:31
 */
public class MeiTuan012 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //一行一个只由数字组成的不含前导零的字符串
        String line1 = bufferedReader.readLine().trim();
        //输出一行一个整数代表有多少这个字符串的子串代表的数字能被 22 整除。
        //能被22整除就一定能被11整除，
        for (int i = 1; i < 51; i++) {
            System.out.println(22 * i);

        }
    }



    public static void solution012(String input) {
        if (input.length() < 2) {
            System.out.println(0);
        }

        char[] chars = input.toCharArray();
        int[][] dp = new int[chars.length][chars.length];
        //滑动窗口法
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < dp[0].length; j++) {
                int tmp = Integer.parseInt(input.substring(i, j+1));
                if (tmp % 22 == 0) {
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j - 1]) + 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j - 1]);
                }
            }
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));

        }

        System.out.println(dp[0][chars.length - 1]);
    }

    
    public void test() {
        solution012("12221");

    }
}
