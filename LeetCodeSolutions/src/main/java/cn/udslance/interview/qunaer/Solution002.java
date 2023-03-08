package cn.udslance.interview.qunaer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
class Solution002 {
    public int solution(int[] arr) {
        //首先对数组进行排序
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            //从后往前，往list里面加
            list.add(arr[i]);
            int cal = cal(list);
            //如果有下降趋势，就终止
            if (cal <= max) {
                break;
            } else {
                max = cal;
            }
        }

        return max;
    }

    /**
     * 提供一个求和的方法
     * @param list ...
     * @return ...
     */
    private int cal(List<Integer> list) {
        int sum = 0;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int time = size - i;
            sum += list.get(i) * time;
        }
        return sum;
    }
    
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        int[] arr = {-1, 1, 4, -9, -8};
        System.out.println(solution(arr));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
