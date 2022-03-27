package cn.udslance.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * @author H
 * @create 2021-05-10 9:28
 */
public class Solution05 {

    public static void main(String[] args) {

        Solution05 solution05 = new Solution05();

        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};

        System.out.println(solution05.majorityElement2(nums));

    }

    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> integerIntegerMap = new HashMap<>();

        for (int num : nums) {
            if (integerIntegerMap.containsKey(num)) {
                //如果map中已经有了这个数字，则出现次数加 1
                Integer value = integerIntegerMap.get(num);
                integerIntegerMap.put(num, value + 1);
            } else {
                //map中并没有这个数字，则将它放进去
                integerIntegerMap.put(num, 1);
            }

            //将数字放入之后，查看该数字出现的次数是否已超过数组长度的一半
            if (integerIntegerMap.get(num) > nums.length / 2) {
                return num;
            }
        }

        return -1;
    }

    public int majorityElement2(int[] nums) {
        int votes = 0;
        int x = 0;

        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }

            if (x == num) {
                votes++;
            } else {
                votes--;
            }
        }

        return x;
    }
}
