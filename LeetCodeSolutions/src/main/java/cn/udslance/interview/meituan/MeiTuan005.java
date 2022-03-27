package cn.udslance.interview.meituan;

import java.util.Scanner;

/**
 * @author H
 * @create 2021-09-06 19:17
 */
public class MeiTuan005 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            solution005(in);
        }
    }


    public static void solution005(Scanner in)  {
        // 一天最多可以烤n个蛋糕
        int n = in.nextInt();
        // 已经做好了m个蛋糕
        int m = in.nextInt();
        // 最重蛋糕的重量恰好为a
        int a = in.nextInt();
        // 最轻蛋糕重量恰好为b
        int b = in.nextInt();

        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        //Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int temp = 0;
        for (int i = 0; i < m; i++) {
            temp = in.nextInt();
            max = Math.max(max, temp);
            min = Math.min(min, temp);
            //set.add(temp);

        }

        //能满足最小要求 && 能满足最大要求
        System.out.println(min);
        System.out.println(max);
        if (min < b || max > a) {
            System.out.println("NO");
            return;
        }

        if (max == a && min == b) {
            System.out.println("YES");
            return;
        }

        int rest = n - m;
        //现成的就能满足要求


        if (max == a || min == b) {
            if (rest >= 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            if (rest >= 2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
