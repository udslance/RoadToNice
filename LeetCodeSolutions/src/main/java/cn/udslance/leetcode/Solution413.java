package cn.udslance.leetcode;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
class Solution413 {
    
    public void test() {

    }

    public int numberOfArithmeticSlices(int[] nums) {

        if (nums.length < 3) {
            return 0;
        }
        int[] dp = new int[nums.length];

        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        int res = 0;
        for (int i : dp) {
            res += i;
        }

        return res;
    }
}
