package cn.udslance.leetcode.startswith3;

/**
 * @author H
 * @create 2021-08-22 20:21
 */
public class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        int up = 1;
        int down = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }

        return nums.length == 0 ? 0 : Math.max(down, up);
    }
}
