package cn.udslance.leetcode.startswith5;



/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution560 {
    
    public void test() {
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
    }

    public int subarraySum(int[] nums, int k) {
        int i = 0, j = 0, sum = 0, res = 0;
        while (i < nums.length) {
            if (sum < k) {
                sum += j >= nums.length ? 0 : nums[j];
                if (sum == k) {
                    res++;
                }
                ++j;
            } else if (sum > k) {
                sum -= nums[i];
                if (sum == k) {
                    res++;
                }
                ++i;
            } else {
                sum -= nums[i++];
            }
        }
        return res;
    }
}
