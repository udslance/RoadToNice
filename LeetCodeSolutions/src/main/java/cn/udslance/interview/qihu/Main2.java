package cn.udslance.interview.qihu;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author H
 * @create 2021-09-25 15:54
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        String[] line2 = br.readLine().trim().split(" ");

        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(line2[i]);
        }

        solution(n, input);
    }

    public static void solution(int n, int[] input) {
        int res = 0;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 1; i < n - 1; i++) {
                while (input[i - 1] <= input[i] && input[i + 1] <= input[i]) {
                    --input[i];
                    res++;
                    flag = true;
                }
            }
        }
        System.out.println(res);
    }

    
    public void test() {
        int n = 8;
        int[] input = {6, 6, 6, 6, 2, 3, 3, 3};
        solution(n, input);
        System.out.println(Arrays.toString(input));
    }
}
