package cn.udslance.interview.unknow;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * vivo 面试 1
 * @author H
 * @create 2021-06-17 20:05
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> idList = new ArrayList<>();

        // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
        while (in.hasNextInt()) {
            int a = in.nextInt();
            idList.add(a);
        }

        Main2 main2 = new Main2();

        int res = main2.method(idList);

        System.out.println(res);
    }

    public int method(List<Integer> idList) {

        int count = 0;



        for (Integer integer : idList) {
            String tempS = integer + "";

            char[] chars = tempS.toCharArray();

            if (integer % 7 == 0) {
                count++;
            } else {
                for (char aChar : chars) {
                    if (aChar - '7' == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
