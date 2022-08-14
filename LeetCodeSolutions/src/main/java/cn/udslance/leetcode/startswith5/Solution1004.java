package cn.udslance.leetcode.startswith5;



/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution1004 {
    
    public void test() {
        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;
        System.out.println(longestOnes(nums, k));
    }

    /**
     * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
     * 返回仅包含 1 的最长（连续）子数组的长度。
     *
     * @param nums ...
     * @param k    ...
     * @return ...
     */
    public int longestOnes(int[] nums, int k) {
        //用左右双指针维护一个滑动窗口，该窗口内最多只能允许有k个0
        //窗口的最大值则为答案
        int left = -1, right = 0;
        int numOf0 = 0;
        int res = 0;
        for (; right < nums.length; right++) {
            //右指针不断右移
            if (nums[right] == 0) {
                numOf0++;
            }
            while (numOf0 > k) {
                if (nums[++left] == 0) {
                    numOf0--;
                }
            }

            res = Math.max(res, right - left);
        }
        return res;
    }

}
