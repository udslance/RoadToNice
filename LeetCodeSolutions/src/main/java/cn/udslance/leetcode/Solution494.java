package cn.udslance.leetcode;

/**
 * @author H
 * @create 2021-08-17 21:39
 */
class Solution494 {
    public void test() {
        System.out.println(findTargetSumWays(new int[]{1}, 1));
    }

    private int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, 0, target, 0);
        System.out.println(count);
        return count;
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
