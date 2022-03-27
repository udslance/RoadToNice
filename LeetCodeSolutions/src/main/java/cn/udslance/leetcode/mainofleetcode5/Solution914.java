package cn.udslance.leetcode.mainofleetcode5;



/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution914 {
    
    public void test() {

    }

    public boolean checkPossibility(int[] nums) {
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (i == 1 || nums[i] >= nums[i - 2]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }

                if (count++ > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
