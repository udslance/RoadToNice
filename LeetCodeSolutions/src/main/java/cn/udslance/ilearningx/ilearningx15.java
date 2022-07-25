package cn.udslance.ilearningx;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: RoadToNice
 * @description: 给定一个设备编号区间[start, end]，包含4或18的编号都不能使用，如：418、148、718不能使用，108可用。
 * @author: Udslance
 * @create: 2022-07-14 17:25
 **/
public class ilearningx15 {



    // 待实现函数，在此函数中填入答题代码
    private static int proc(int[] arr, int diff) {
        if (diff == 0) {
            return 0;
        }
        int[] dic = new int[102421];
        for (int i : arr) {
            dic[i + 20] = 1;
        }
        int count = 0;

        for (int i : arr) {
            int index = i + 20 - diff;
            if (index >= 0 && index < 102420 && dic[index] == 1) {
                count += 1;
            }
        }

        return count;
    }

}
