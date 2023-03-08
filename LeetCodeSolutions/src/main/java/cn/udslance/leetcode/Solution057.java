package cn.udslance.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author H
 * @create 2021-07-13 16:44
 */
class Solution057 {

    public void test() {
        int[][] intervals = {{1, 4}, {2, 3}, {8, 10}, {15, 18}};

        int[][] res = insert(intervals, new int[]{3, 6});

        for (int[] re : res) {
            System.out.println(Arrays.toString(re));

        }

    }
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> list = new ArrayList<>();

        boolean insert = false;

        if (intervals[0][0] > newInterval[0]) {
            list.add(newInterval);
            insert = true;
        } else {
            list.add(intervals[0]);
        }

        for (int i = 1; i < intervals.length;) {
            int[] temp1 = list.get(list.size() - 1);

            int[] temp2;
            if ((intervals[i][0] > newInterval[0] || i == intervals.length - 1) && !insert) {
                temp2 = newInterval;
                insert = true;
            } else {
                temp2 = intervals[i];
                i++;
            }


            if (temp1[1] >= temp2[1]) {
                continue;
            }else if(temp1[1] >= temp2[0]){
                list.remove(list.size() - 1);
                list.add(new int[]{temp1[0], temp2[1]});
            } else {
                list.add(temp2);
            }
        }

        int[][] res = new int[list.size()][];


        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
