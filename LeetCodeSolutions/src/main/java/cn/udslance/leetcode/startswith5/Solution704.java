package cn.udslance.leetcode.startswith5;



/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution704 {
    
    public void test() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(nums, 2));
    }


    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int resIndex = -1;
        int left = 0, right = nums.length - 1, mid = 0;

        while (left < right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nums[left] == target ? left : -1;
    }
}
