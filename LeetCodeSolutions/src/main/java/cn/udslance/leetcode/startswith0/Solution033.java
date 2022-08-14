package cn.udslance.leetcode.startswith0;


/**
 * @author H
 * @create 2021-06-28 22:45
 */
public class Solution033 {

    
    public void test() {
        System.out.println(search(new int[]{3, 1}, 3));
    }

    public int search(int[] nums, int target) {
        // 如果中间的数小于最右边的数，则右半段是有序的，若中间数大于最右边数，则左半段是有序的，
        // 我们只要在有序的半段里用首尾两个数组来判断目标值是否在这一区域内，这样就可以确定保留哪半边了
        int left = 0;
        int right = nums.length - 1;
        int mid = right / 2;
        if (nums[mid] < nums[right]) {
            //如果中间的数小于最右边的数，则右半段是有序的
            if (target < nums[mid] || target > nums[right]) {
                //如果目标值超出有序段范围
                //说明在左边
                right = mid;
            } else {
                //说明在右边
                left = mid;
            }
        } else {
            //若中间数大于最右边数，则左半段是有序的
            if (target > nums[mid] || target < nums[left]) {
                //如果目标值超出有序段范围
                //说明在右边
                left = mid;

            } else {
                right = mid;
            }
        }

        for (int i = left; i <= right; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
