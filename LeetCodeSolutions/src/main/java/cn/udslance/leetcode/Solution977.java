package cn.udslance.leetcode;

/**
 * @title: 有序数组的平方
 * @description: 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * @difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/squares-of-a-sorted-array/">...</a>
 * @author: Udslance
 * @create: 2023-03-08 20:56
 **/
class Solution977 {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int[] resArr = new int[nums.length];
        int right = nums.length - 1;
        int index = nums.length - 1;
        while (left <= right) {
            int iLf = nums[left] * nums[left];
            int iRh = nums[right] * nums[right];
            if (iLf >= iRh) {
                resArr[index--] = iLf;
                left++;
            } else {
                resArr[index--] = iRh;
                right--;
            }
        }
        return resArr;
    }
}
