package cn.udslance.leetcode.mainofleetcode2;

/**
 * @author H
 * @create 2021-08-10 19:43
 */
public class Solution213 {

    public int rob(int[] nums) {
        //不偷第一家和不偷最后一家
        if (nums.length == 1) {
            return nums[1];
        }
        //不偷最后一家
        int[] dpA = new int[nums.length];
        dpA[0] = nums[0];
        //不偷第一家
        int[] dpB = new int[nums.length];
        //遇到第一家B不偷
        dpB[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                dpA[i] = Math.max(dpA[0], nums[i]);
                dpB[i] = Math.max(dpB[0], nums[i]);
            } else if (i == nums.length - 1) {
                //遇到最后一家，A不偷
                dpA[i] = dpA[i - 1];
                dpB[i] = Math.max(dpB[i - 1], nums[i] + dpB[i - 2]);
            } else {
                dpA[i] = Math.max(dpA[i - 1], nums[i] + dpA[i - 2]);
                dpB[i] = Math.max(dpB[i - 1], nums[i] + dpB[i - 2]);
            } 
        }

        return Math.max(dpA[nums.length - 1], dpB[nums.length - 1]);
    }
}
