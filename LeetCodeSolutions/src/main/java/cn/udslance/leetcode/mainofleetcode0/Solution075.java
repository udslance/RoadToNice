package cn.udslance.leetcode.mainofleetcode0;



import java.util.Arrays;

/**
 * @author H
 * @create 2021-07-15 17:14
 */
public class Solution075 {


    public void test() {
        int[] ints = new int[]{1, 3, 2, 4, 9, 5};
        sortColors(ints);
        System.out.println(Arrays.toString(ints));

    }

    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int left, int right) {
        int l = left, r = right;
        int pivot = nums[(l + r) / 2];
        int temp = 0;

        while (l < r) {
            while (nums[l] < pivot) {
                l++;
            }

            while (nums[r] > pivot) {
                r--;
            }

            if (l >= r) {
                break;
            }

            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;

            if (nums[l] == pivot) {
                r--;
            }

            if (nums[r] == pivot) {
                l++;
            }
        }

        if (l == r) {
            l++;
            r--;
        }

        if (left < r) {
            quickSort(nums, left, r);
        }
        if(right > l){
            quickSort(nums,l,right);
        }
    }
}
