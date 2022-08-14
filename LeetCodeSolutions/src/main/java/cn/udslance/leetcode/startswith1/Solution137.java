package cn.udslance.leetcode.startswith1;

/**
 * @author H
 * @create 2021-06-08 15:57
 */
public class Solution137 {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
        }

        for (int num : nums) {
            if ((sum - num) % 3 == 0) {
                return num;
            }
        }
        return 0;
    }
}
