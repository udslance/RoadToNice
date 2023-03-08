package cn.udslance.interview.meituan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author H
 * @create 2021-09-10 10:31
 */
public class MeiTuan011 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] l1 = bufferedReader.readLine().trim().split(" ");
        int n = Integer.parseInt(l1[0]);
        int m = Integer.parseInt(l1[1]);
        int k = Integer.parseInt(l1[2]);

        String[] l2 = bufferedReader.readLine().trim().split(" ");
        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(l2[i]);
        }

        solution(input, m, k);
    }

    /**
     *
     * @param input ...
     * @param m 规定了窗口大小
     * @param k 规定了窗口内的最小值
     */
    public static void solution(int[] input, int m, int k) {
        //初始化窗口
        int l = -1;
        int res = 0;
        for (int r = 0; r < input.length; r++) {
            if (input[r] >= k) {
                if (r - l == m) {
                    res++;
                    l++;
                }
            } else {
                l = r;
            }
        }

        System.out.println(res);
    }
}
