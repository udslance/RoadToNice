package cn.udslance.jianzhioffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author H
 * @create 2021-05-09 10:04
 */
class Solution03 {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

    }

    public int grid() {
        //读取第一行三个数n,m,k，表示行数,列数以及五元组个数。
        int n = SCANNER.nextInt();

        int m = SCANNER.nextInt();

        int k = SCANNER.nextInt();

        // 接下来有k个五元组，需要读取k次
        List<int[]> list = new ArrayList<>();

        //将五元组都存放在list当中
        for (int i = 0; i < k; i++) {
            int[] ints = new int[5];

            for (int j = 0; j < 5; j++) {
                ints[j] = SCANNER.nextInt();

            }
            list.add(ints);
        }

        return 0;


    }
}
