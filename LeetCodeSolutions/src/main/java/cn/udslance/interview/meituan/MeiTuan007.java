package cn.udslance.interview.meituan;



import java.util.Scanner;

/**
 * @author H
 * @create 2021-09-06 19:17
 */
public class MeiTuan007 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();


        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] scores = new int[n];

            for (int j = 0; j < n; j++) {
                scores[j] = in.nextInt();
            }

            System.out.println(solution(scores, n));
        }


    }

    public static int solution(int[] scores, int n) {
        //int[] helper = new int[n + n - 2];
        //System.arraycopy(scores, 0, helper, 0, n);
        //
        //System.arraycopy(scores, 0, helper, n, n - 2);
        int max = 0;

        for (int i = 0; i < n - 2; i++) {
            int dp = scores[i];
            max = Math.max(max, dp);
            for (int j = i + 1; j < i + n; j++) {
                int index = j % n;
                if (dp > 0) {
                    dp += scores[index];
                } else {
                    dp = scores[index];
                }
                max = Math.max(max, dp);
            }
        }

        return max;

    }

    
    public void test() {
        int[] res = new int[]{3, -2, 4, -1};
        System.out.println(solution(res, 4));
    }
}
