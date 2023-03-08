package cn.udslance.jianzhioffer;

import java.util.Scanner;

/**
 * @author H
 * @create 2021-05-09 10:23
 */
class Solution04 {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {




        System.out.println(test());

    }

    public static int test() {
        //木桩数量n
        int n = SCANNER.nextInt();

        //家具宽度m，只有连续m个木桩都能搬过去才能成功将家具搬过去
        int m = SCANNER.nextInt();

        //体力限制h，只能越过高度不高于h的围栏
        int h = SCANNER.nextInt();

        //围栏
        int[] ints = new int[n];

        //读取围栏高度
        for (int i = 0; i < n; i++) {
            ints[i] = SCANNER.nextInt();
        }




        for (int i = 0; i < n; i++) {
            boolean flag = false;
            if(ints[i] <= h){
                //找到第一个满足高度的木桩
                for (int j = 1; j < m; j++) {
                    //验证是否后续的 m - 1 个木桩都满足要求
                    if(ints[i + j] > h){
                        flag = false;
                        break;
                    }
                    flag = true;
                }

                if (flag) {
                    return i + 1;
                }
            }
        }

        return -1;
    }
}
