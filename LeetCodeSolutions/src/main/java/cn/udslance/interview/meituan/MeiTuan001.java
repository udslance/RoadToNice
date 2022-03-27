package cn.udslance.interview.meituan;



import java.util.Arrays;
import java.util.Scanner;

/**
 * @author H
 * @create 2021-08-26 20:03
 */
public class MeiTuan001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //输入第一行仅包含三个正整数n,x,y，分别表示参赛的人数和晋级淘汰人数区间。(1<=n<=50000,1<=x,y<=n)
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int[] grades = new int[n];
        //输入第二行包含n个整数，中间用空格隔开，表示从1号选手到n号选手的成绩。(1<=|a_i|<=1000)
        for (int i = 0; i < n; i++) {
            grades[i] = in.nextInt();
        }

        System.out.println(solution1(grades, x, y));
    }


    public void test() {
        int[] grades = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(solution1(grades, 2, 3));
    }

    public static int solution1(int[] grades, int x, int y) {
        Arrays.sort(grades);

        for (int i = 0; i < grades.length; i++) {
            int cur = grades[i];
            while (i + 1 < grades.length && grades[i] == grades[i + 1]) {
                i++;
            }
            //cur可以让i + 1人淘汰，可以让 length - i人晋级
            int out = i + 1;
            int in = grades.length - out;
            if (in >= x && in <= y && out >= x && out <= y) {
                return cur;
            }
        }
        return -1;
    }
}
