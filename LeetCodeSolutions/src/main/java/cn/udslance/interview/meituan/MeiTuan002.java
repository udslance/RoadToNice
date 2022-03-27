package cn.udslance.interview.meituan;



import java.util.Arrays;
import java.util.Scanner;

/**
 * @author H
 * @create 2021-08-26 20:03
 */
public class MeiTuan002 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //输入第一行仅包含一个正整数n，表示任意序列的长度。(1<=n<=20000)
        int n = in.nextInt();
        int[] input = new int[n];
        //输入第二行包含n个整数，中间用空格隔开，表示从1号选手到n号选手的成绩。(1<=|a_i|<=1000)
        for (int i = 0; i < n; i++) {
            input[i] = in.nextInt();
        }

        System.out.println(solution1(input));
    }



    public static int solution1(int[] input) {
        Arrays.sort(input);

        int res = 0;

        for (int i = 0; i < input.length; i++) {
            int cur = Math.abs(input[i] - (i + 1));
            res += cur;
        }

        return res;
    }


    public void test() {
        int[] input = new int[]{-1, 2, 3, 10, 100};
        System.out.println(solution1(input));
    }
}
