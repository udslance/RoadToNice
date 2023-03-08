package cn.udslance.interview.qihu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author H
 * @create 2021-09-25 15:54
 */
public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        String[] line2 = br.readLine().trim().split(" ");

        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(line2[i]);
        }

        solution(n,input);
    }

    public static void solution(int n, int[] input){
        int res = 0;

        for (int i = 0; i < n; i++) {
            int temp = 0;
            if (i == 0 || input[i] > input[i - 1]) {
                //向两边探寻
                int l = i - 1;
                int r = i + 1;
                while (l >= 0 && input[l] < input[l + 1]){
                    --l;
                }
                while (r < n && input[r] < input[r - 1]){
                    ++r;
                }

                res = Math.max(res, r - l - 1);
            }
        }

        System.out.println(res);
    }

    
    public void test() {
        int n = 5;
        int[] input = {5, 1, 2, 1, 5};
        solution(n,input);
    }
}
