package cn.udslance.leetcode;

/**
 * 寻找峰值
 * <a href="https://leetcode-cn.com/problems/find-peak-element/">...</a>
 * @author H
 * @create 2021-08-03 19:24
 */
class Solution162 {


    public void test() {
        int[] nums = {3,1,2};
        System.out.println(findPeakElement(nums));

    }

    public int findPeakElement(int[] nums) {
        int length = nums.length;
        // 特殊情况1：数组只有一个数
        if (length < 2) {
            return 0;
        }
        // 特殊情况2：左端满足要求
        if (nums[0] > nums[1]) {
            return 0;
        }
        // 特殊情况3：右端满足要求
        if (nums[length - 1] > nums[length - 2]) {
            return length - 1;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                // 判断mid满不满足
                return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                // 说明mid ～ right之间有峰值
                left = mid;
            } else {
                // 说明mid ～ right之间有峰值
                right = mid;
            }
        }
        return left;
    }
}
