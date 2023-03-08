package cn.udslance.interview.mi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author H
 * @create 2021-09-01 19:15
 */
public class Mi003 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        String line3 = in.nextLine();
        String[] strings = line1.split(",");
        int m = 0;
        for (int i = 2; i < strings[0].length(); i++) {
            int cur = strings[0].charAt(i) - '0';
            m = m * 10 + cur;
        }

        int n = 0;
        for (int i = 2; i < strings[1].length(); i++) {
            int cur = strings[1].charAt(i) - '0';
            n = n * 10 + cur;
        }

        String[] strings2 = line2.split(",");

        int[] numsA = new int[m + n];
        for (int i = 0; i < m; i++) {
            numsA[i] = Integer.parseInt(strings2[i]);
        }

        String[] strings3 = line3.split(",");

        int[] numsB = new int[n];
        for (int i = 0; i < n; i++) {
            numsB[i] = Integer.parseInt(strings3[i]);
        }

        System.out.println(m);
        System.out.println(n);
        System.out.println(Arrays.toString(numsA));
        System.out.println(Arrays.toString(numsB));

        solution(numsA, numsB, m, n);
    }

    /**
     * 给定两个有序整数数组 A 和 B，将B合并到A中，使得 A 成为一个有序数组。
     *
     * @param numsA ...
     * @param numsB ...
     */
    public static void solution(int[] numsA, int[] numsB, int m, int n) {

        int cur = numsA.length - 1;
        int tailA = m - 1;
        int tailB = n - 1;
        int temp = 0;

        while (cur >= 0 && tailA >= 0 && tailB >= 0) {

            //如果A尾数大于等于B尾数
            if (numsA[tailA] >= numsB[tailB]) {
                //和尾部交换
                temp = numsA[cur];
                numsA[cur--] = numsA[tailA];
                numsA[tailA--] = temp;
            } else {
                //和尾部交换
                temp = numsA[cur];
                numsA[cur--] = numsB[tailB];
                numsB[tailB--] = temp;
            }
        }

        while (tailA != 0) {
            temp = numsA[cur];
            numsA[cur--] = numsA[tailA];
            numsA[tailA--] = temp;
        }

        while (tailB != 0) {
            //和尾部交换
            temp = numsA[cur];
            numsA[cur--] = numsB[tailB];
            numsB[tailB--] = temp;
        }

        StringBuilder sb = new StringBuilder(numsA[0]);
        for (int i = 1; i < numsA.length; i++) {
            sb.append(" ");
            sb.append(numsA[i]);
        }
        System.out.println(sb);
    }

    
    public void test() {
        int[] numsA = new int[]{1, 6, 7, 0, 0, 0};
        int[] numsB = new int[]{2, 4, 6};

        solution(numsA, numsB, 3, 3);
    }
}
