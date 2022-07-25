package cn.udslance.ilearningx;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @program: RoadToNice
 * @description: 给定一个设备编号区间[start, end]，包含4或18的编号都不能使用，如：418、148、718不能使用，108可用。
 * @author: Udslance
 * @create: 2022-07-14 17:25
 **/
public class ilearningx07 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int start = cin.nextInt();
        int end = cin.nextInt();
        cin.close();

        String str = "123418";

        StringBuilder stringBuilder = new StringBuilder(str);





        System.out.println(getNormalDeviceNum(start, end));
    }

    // 待实现函数，在此函数中填入答题代码
    private static int getNormalDeviceNum(int start, int end) {
        //思路一：将数字转为字符串，依次检查是否为4或18
        return 0;
    }

}
