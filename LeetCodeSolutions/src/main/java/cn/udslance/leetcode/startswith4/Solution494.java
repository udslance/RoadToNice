package cn.udslance.leetcode.startswith4;



/**
 * @author H
 * @create 2021-08-17 21:39
 */
public class Solution494 {
    private int count = 0;

    
    public void test() {
        System.out.println(findTargetSumWays1(new int[]{1}, 1));
    }


    public int findTargetSumWays1(int[] nums, int target) {
        dfs(nums, 0, target, 0);
        System.out.println(count);
        return count;
    }

    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (Math.abs(target) > Math.abs(sum)) {
            return 0;
        }

        int[][] dp = new int[nums.length][2 * sum + 1];

        //初始化
        dp[0][sum - nums[0]] += 1;
        dp[0][sum + nums[0]] += 1;

        return 0;

    }

    private void dfs(int[] nums,int loc, int target, int path) {
        if (path == nums.length) {
            if (target == 0) {
                ++count;
            }
            return;
        }

        dfs(nums, loc + 1, target - nums[loc], path + 1);
        dfs(nums, loc + 1, target + nums[loc], path + 1);
    }
}
