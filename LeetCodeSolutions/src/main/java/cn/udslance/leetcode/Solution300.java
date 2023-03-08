package cn.udslance.leetcode;

import java.util.Arrays;

/**
 * @author H
 * @create 2021-08-12 19:25
 */
class Solution300 {
    
    public void test() {
        int[] nums = new int[]{0,1,0,3,2,3};
        System.out.println(lengthOfLIS(nums));

    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
