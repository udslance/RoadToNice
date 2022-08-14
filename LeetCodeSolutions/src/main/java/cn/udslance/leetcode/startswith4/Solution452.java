package cn.udslance.leetcode.startswith4;



import java.util.Arrays;
import java.util.Comparator;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution452 {

    public void test() {
        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};

        System.out.println(findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        //最坏情况是每个气球都需要一根箭
        int n = points.length;
        int right = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] < right) {
                --n;
            } else {
                right = points[i][1];
            }
        }

        return n;
    }
}
