package cn.udslance.interview.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author H
 * @create 2021-09-06 19:17
 */
public class MeiTuan006 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();

        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = in.nextInt();
        }

        System.out.println(solution(scores, n, x));
    }

    public static int solution(int[] scores, int n, int x) {
        Arrays.sort(scores);
        int start = n - x;
        if (scores[start] == 0) {
            while (start < scores.length && scores[start] == 0) {
                start++;
                x--;
            }
            return x;
        }

        while (start - 1 >= 0 && scores[start] == scores[start - 1]) {
            start--;
            x++;
        }

        return x;

    }

    public static void quickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int key = a[left];
        int i = left;
        int j = right;
        while (i < j) {
            //j向左移，直到遇到比key大的值
            while (a[j] <= key && i < j) {
                j--;
            }
            //i向右移，直到遇到比key小的值
            while (a[i] >= key && i < j) {
                i++;
            }
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        a[left] = a[i];
        a[i] = key;
        quickSort(a, left, i - 1);
        quickSort(a, i + 1, right);
    }
}
