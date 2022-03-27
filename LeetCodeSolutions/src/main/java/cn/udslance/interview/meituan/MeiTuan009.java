package cn.udslance.interview.meituan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author H
 * @create 2021-09-07 16:15
 */
public class MeiTuan009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String trim = br.readLine().trim();
        int n = Integer.parseInt(trim);
        String gift = br.readLine().trim();

        solution(gift);
    }

    public static void solution(String gift) {
        int[] pre = new int[gift.length() + 1];
        char[] chars = gift.toCharArray();

        //构造前缀和
        pre[0] = 0;
        int res = 0;
        int min = 0;

        for (int i = 1; i < pre.length; i++) {
            if (chars[i - 1] == 'E') {
                pre[i] = pre[i - 1] + 1;
            } else {
                pre[i] = pre[i - 1] - 1;
            }
            min = Math.min(min, pre[i]);

            res = Math.max(res, pre[i] - min);
        }

        System.out.println(res);
    }
}
