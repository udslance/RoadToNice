package cn.udslance.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 * @author H
 * @create 2021-08-23 9:21
 */
class Solution001 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        System.out.println(Arrays.toString(twoSum(new int[]{3,3}, 6)));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
