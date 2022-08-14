package cn.udslance.leetcode.startswith0;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author H
 * @create 2021-07-13 16:09
 */
public class Solution056 {

    
    public void test() {
        int[][] intervals = {{1, 4}, {2, 3}, {8, 10}, {15, 18}};

        int[][] res = merge(intervals);

        for (int[] re : res) {
            System.out.println(Arrays.toString(re));

        }
        
    }


    public int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        List<int[]> list = new ArrayList<>();


        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] temp1 = list.get(list.size() - 1);

            int[] temp2 = intervals[i];

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
