package cn.udslance.interview.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 美团
 * @author H
 * @create 2021-05-09 11:04
 */
class Main3 {
    private static final Scanner SCANNER = new Scanner(System.in);
    int max = 0;

    public static void main(String[] args) {
        Main3 solution05 = new Main3();
        solution05.test();
    }

    public  void test() {
        // 第一行一个正整数t，代表数据组数。
        int t = SCANNER.nextInt();

        List<int[]> intsList = new ArrayList<>();

        //接下来t行，四个正整数x，a，b，n。
        for (int i = 0; i < t; i++) {
            int[] ints = new int[4];

            for (int j = 0; j < 4; j++) {
                ints[j] = SCANNER.nextInt();
            }
            test2(ints[0], ints[1], ints[2], ints[3], 0);
            System.out.println(max);
            max = 0;
        }
    }



    public  void test2(int x, int a, int b, int n, int get) {
        if (n == 0) {
            max = Math.max(max, get);
            return;
        }

        //记录时间消耗
        --n;

        //如果练习，小美可以获得x点收益，然后状态值下降a（若x<a，则只会下降x点）
        test2(x > a ? x - a : 0, a, b, n, get + x);

        //如果休息，小美的状态值会上升b。
        test2(x + b, a, b, n, get);
    }
}
