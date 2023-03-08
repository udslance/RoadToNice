package cn.udslance.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 * @author H
 * @create 2021-08-04 20:20
 */
class Solution198 {

    @Test
    public void test() {
        int[] nums = {2,7,9,3,1};

        System.out.println(rob(nums));
    }


    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int sum, int start) {
        if (start >= nums.length) {
            return 0;
        }
        sum = sum + nums[start];
        sum += Math.max(dfs(nums,sum , start + 2), dfs(nums, sum, start + 3));
        return sum;
    }
}
