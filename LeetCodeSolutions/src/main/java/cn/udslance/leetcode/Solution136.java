package cn.udslance.leetcode;

/**
 * @author H
 * @create 2021-06-08 15:57
 */
class Solution136 {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }
}
