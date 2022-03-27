package cn.udslance.interview.huawei;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 逃出生天
 * @author H
 * @create 2021-08-25 18:45
 */
public class HWSolution04 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);

        int n = 3;
        int m = 3;
        int[][] input = {{2,3,2}, {5,1,1}, {4,5,5}};


        if (m + n > input[m - 1][n - 1] + 2) {
            System.out.println(-1);

        } else {
            dfs(input, 0, 0, 0);
            int res = step == Integer.MAX_VALUE ? -1 : step;
            System.out.println(res);
        }

    }


    static int step = Integer.MAX_VALUE;

    public static void dfs(int[][] input, int i, int j, int cur) {


        if (i == input.length - 1 && j == input[0].length - 1) {
            step = Math.min(step, cur);
        }

        if (input[input.length - 1][input[0].length - 1] == 0) {
            return;
        }

        //上下左右都走不通
        //下
        if (i + 1 < input.length && input[i + 1][j] > 0) {
            refresh(input);
            dfs(input, i + 1, j, cur + 1);
            unfresh(input);

        }
        //右
        if (j + 1 < input[0].length && input[i][j + 1] > 0) {
            refresh(input);
            dfs(input, i, j + 1, cur + 1);
            unfresh(input);
        }
        //左
        if (j - 1 >= 0 && input[i][j - 1] > 0) {
            refresh(input);
            dfs(input, i, j - 1, cur + 1);
            unfresh(input);
        }
        //上
        if (i - 1 >= 0 && input[i - 1][j] > 0) {
            refresh(input);
            dfs(input, i - 1, j, cur + 1);
            unfresh(input);
        }

    }

    public static void refresh(int[][] input) {
        for (int[] ints : input) {
            for (int i = 0; i < ints.length; i++) {
                ints[i]--;
            }
        }
    }

    public static void unfresh(int[][] input) {
        for (int[] ints : input) {
            for (int i = 0; i < ints.length; i++) {
                ints[i]++;
            }
        }
    }
}
