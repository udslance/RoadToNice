package cn.udslance.leetcode;

/**
 * @author H
 * @create 2021-08-17 21:28
 */
class Solution912 {
    
    public void test() {
        sortArray(new int[]{5, 2, 3, 1});


    }

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left, r = right;
        int pivot = nums[left];
        while (true) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            if (l >= r) {
                break;
            }
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
        int tmp = nums[l];
        nums[l] = pivot;
        nums[left] = tmp;
        quickSort(nums, left, l - 1);
        quickSort(nums, l + 1, right);
    }
}
