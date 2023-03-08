package cn.udslance.leetcode;

import java.util.Stack;

/**
 * @author H
 * @create 2021-08-12 20:34
 */
class Solution739 {


    public void test() {
        System.out.println(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));
    }


    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length == 0){
            return temperatures;
        }
        Stack<Integer> helper = new Stack<>();
        int[] res = new int[temperatures.length];
        helper.push(0);
        for (int i = 1; i < temperatures.length;) {
            if (helper.isEmpty() || temperatures[i] <= temperatures[helper.peek()]) {
                helper.push(i);
                i++;
            }else {
                int loc = helper.pop();
                res[loc] = i - loc;
            }
        }
        return res;
    }

    public int[] dailyTemperatures0(int[] temperatures) {
        int[] resArr = new int[temperatures.length];
        for (int i = 0; i < resArr.length; i++) {
            int j = i + 1;
            for (; j < resArr.length && temperatures[j] <= temperatures[i]; j++) {
            }
            if (j < resArr.length) {
                resArr[i] = j - i;
            }
        }
        return resArr;
    }

    public int[] dailyTemperatures1(int[] temperatures) {
        int length = temperatures.length;
        int[] resArr = new int[length];

        // 从后向前遍历
        for (int i = length - 2; i >= 0; i--) {
            // a. 下一位比自己大
            if (temperatures[i] < temperatures[i + 1]) {
                resArr[i] = 1;
            } else if (temperatures[i] == temperatures[i + 1]) {
                // b. 下一位跟自己相等
                resArr[i] = resArr[i + 1] == 0 ? 0 : resArr[i + 1] + 1;
            } else {
                // c. 下一位小于自己
                int j = i + 1;
                for (; j < length && temperatures[j] <= temperatures[i]; j++) {
                }
                if (j < length) {
                    resArr[i] = j - i;
                }
            }
        }
        return resArr;
    }
}
