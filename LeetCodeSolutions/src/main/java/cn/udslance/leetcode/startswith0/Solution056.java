package cn.udslance.leetcode.startswith0;




import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author H
 * @create 2021-07-13 16:09
 */
public class Solution056 {

    @Test
    public void test() {
        int[][] intervals = {{1, 4}, {2, 3}, {8, 10}, {15, 18}};

        int[][] res = merge(intervals);

        for (int[] re : res) {
            System.out.println(Arrays.toString(re));

        }
        
    }

    public int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序
        quickSort(intervals, 0, intervals.length - 1);
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

    private void quickSort(int[][] arrs, int left, int right) {
        if (left >= right) {
            return;
        }
        int ml = left;
        int mr = right;
        int[] ruleArr = arrs[left];
        int ruleVal = arrs[left][0];
        while (ml < mr) {
            while (ml < mr && arrs[mr][0] >= ruleVal) {
                mr--;
            }
            while (ml < mr && arrs[ml][0] <= ruleVal) {
                ml++;
            }
            if (ml >= mr) {
                break;
            }
            swap(arrs, ml, mr);
        }
        arrs[left] = arrs[ml];
        arrs[ml] = ruleArr;

        quickSort(arrs, left, ml - 1);
        quickSort(arrs, ml + 1, right);
    }

    private static void swap(int[][] arrs, int i, int j) {
        int[] temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }
}
