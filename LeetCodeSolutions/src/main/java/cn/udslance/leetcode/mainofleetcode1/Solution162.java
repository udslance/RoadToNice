package cn.udslance.leetcode.mainofleetcode1;


/**
 * 寻找峰值
 * https://leetcode-cn.com/problems/find-peak-element/
 * @author H
 * @create 2021-08-03 19:24
 */
public class Solution162 {


    public void test() {
        int[] nums = {3,1,2};
        System.out.println(findPeakElement(nums));

    }

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean a = mid == 0 && nums[mid] > nums[mid + 1];
            boolean b = mid == nums.length - 1 && nums[mid] > nums[mid - 1];

            if (a || b) {
                //目标在两端
                return mid;
            }

            if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == nums.length ||nums[mid] < nums[mid + 1])) {
                //目标在右
                left = mid + 1;
            } else if ((mid == 0 || nums[mid - 1] > nums[mid]) &&(mid == nums.length || nums[mid] > nums[mid + 1])) {
                //目标在左
                right = mid;
            }else if ((mid == 0 || nums[mid - 1] > nums[mid]) &&(mid == nums.length || nums[mid] < nums[mid + 1])) {
                //目标在两边，任意找一边
                right = mid;
            } else {
                //目标在此
                return mid;
            }
        }

        return left;
    }
}
