package cn.udslance.leetcode.startswith2;



/**
 * @author H
 * @create 2021-08-09 19:29
 */
public class Solution209 {

    public void test() {
        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 1) {
            return nums[0] >= target ? 1 : 0;
        }

        //双指针
        int left = 0, right = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;

        while (left < nums.length && right < nums.length) {
            sum += nums[right];
            if (sum >= target) {
                res = Math.min(res, right - left + 1);
            }

            while (sum >= target) {
                sum -= nums[left++];
                if (sum >= target) {
                    res = Math.min(res, right - left + 1);
                }
            }

            right++;
        }

        if (res == Integer.MAX_VALUE) {
            return 0;
        }

        return res;
    }
}
