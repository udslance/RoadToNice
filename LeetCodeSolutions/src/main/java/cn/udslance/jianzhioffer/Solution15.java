package cn.udslance.jianzhioffer;

import java.util.Arrays;

/**
 * @author H
 * @create 2021-05-24 16:45
 */
class Solution15 {

    
    public void test() {
        System.out.println(strangePrinter("abab"));
    }

    public int strangePrinter(String s) {
        //二维数组初始化
        //dp[i][j]代表的是字符串在区间[i,j]中需要最少的打印次数
        int[][] dp = new int[s.length()][s.length()];

        //对角线全为 1
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }

        for (int i = 0, x = 1; i + x < dp.length; i++) {
            int j = i + x;

            if (s.charAt(i) == s.charAt(j)) {
                //如果 i 所指字符等于 j 所指字符，则从左边取值
                dp[i][j] = dp[i][j - 1];
            } else {
                //如果 i 所指字符不等于 j 所指字符，则需要通过枚举找最小值
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int tmp = dp[i][k] + dp[k + 1][j];
                    min = Math.min(min, tmp);
                }
                dp[i][j] = min;
            }

            //如果这条斜线全部完成了规划，就需要右移。
            if (j == dp.length - 1) {
                i = -1;
                x++;
            }
        }

        return dp[0][dp.length - 1];


    }


    
    public void test1() {
        int[] ints = {4, 5, 1, 6, 2, 7, 3, 8};

        System.out.println(Arrays.toString(ints));

        quickSort(ints, 0, ints.length - 1);

        System.out.println(Arrays.toString(ints));

    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;

        int r = right;

        int pivot = arr[(l + r) / 2];

        int temp;

        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }

            while (arr[r] > pivot) {
                r--;
            }

            if (l >= r) {
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot) {
                r--;
            }

            if (arr[r] == pivot) {
                l++;
            }
        }

        if (l == r) {
            l++;
            r--;
        }

        if (left < r) {
            quickSort(arr, left, r);
        }

        if (right > l) {
            quickSort(arr, l, right);
        }

    }
}
