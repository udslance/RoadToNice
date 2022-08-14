package cn.udslance.leetcode.startswith0;


/**
 * @author H
 * @create 2021-07-13 15:42
 */
public class Solution055 {
    
    public void test() {
        int[] nums = {3,2,1,0,4};


        System.out.println(canJump(nums));
    }


    public boolean canJump(int[] nums) {
        int length = nums.length;

        int start = 0;

        int end = 1;

        int step = 0;


        while (end < length) {

            if (step > length) {
                return false;
            }

            int max = 0;
            for (int i = start; i < end; i++) {
                max = Math.max(i + nums[i], max);
            }

            start = end;

            end = max + 1;

            step++;
        }

        return true;


    }
}
