package cn.udslance.leetcode;

/**
 * 旋转数组
 * https://leetcode-cn.com/problems/rotate-array/
 * @author H
 * @create 2021-08-04 19:51
 */
class Solution189 {
    // 首先对整个数组实行翻转，这样子原数组中需要翻转的子数组，就会跑到数组最前面。
    // 这时候，从 kkk 处分隔数组，左右两数组，各自进行翻转即可。
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
