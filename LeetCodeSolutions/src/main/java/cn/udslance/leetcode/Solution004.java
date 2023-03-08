package cn.udslance.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @title: 寻找两个正序数组的中位数
 * @description: 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * @difficulty: Hard
 * @Link: <a href="https://leetcode.cn/problems/median-of-two-sorted-arrays/">...</a>
 * @author: Udslance
 * @create: 2023-03-05 10:59
 **/
class Solution004 {

    @Test
    public void test() {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 偶数个数字，取nums[n/2]和nums[n/2+1]的平均值
        // 奇数个数字，取nums[n/2]
        int size1 = nums1.length;
        int size2 = nums2.length;
        int total = size1 + size2;
        int target = total / 2;
        if (total % 2 == 0) {
            target -= 1;
        }
        // 思路：双指针
        int poke1 = 0;
        int poke2 = 0;
        int cal1 = 0;
        while (poke1 + poke2 <= target) {
            int cur1 = poke1 < size1 ? nums1[poke1] : Integer.MAX_VALUE;
            int cur2 = poke2 < size2 ? nums2[poke2] : Integer.MAX_VALUE;
            if (cur1 <= cur2) {
                cal1 = cur1;
                poke1++;
            } else {
                cal1 = cur2;
                poke2++;
            }
        }
        if (total % 2 == 1) {
            return cal1;
        }else {
            int cur1 = poke1 < size1 ? nums1[poke1] : Integer.MAX_VALUE;
            int cur2 = poke2 < size2 ? nums2[poke2] : Integer.MAX_VALUE;
            int cal2 = Math.min(cur1, cur2);
            return (double) (cal1 + cal2) / 2;
        }
    }
}
