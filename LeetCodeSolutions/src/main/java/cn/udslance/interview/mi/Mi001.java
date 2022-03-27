package cn.udslance.interview.mi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author H
 * @create 2021-08-26 18:56
 */
public class Mi001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] wait = new int[n];
        for (int i = 0; i < m; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            Arrays.fill(wait, start, end, i + 1);
        }

        int res = 0;

        for (int i = 0; i < wait.length; i++) {
            res = (res + wait[i] * i) % 100000009;
        }

        System.out.println(res);
    }
}
