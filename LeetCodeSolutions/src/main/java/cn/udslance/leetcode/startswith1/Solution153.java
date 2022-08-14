package cn.udslance.leetcode.startswith1;


/**
 * @author H
 * @create 2021-08-01 20:29
 */
public class Solution153 {
    public void test() {
        System.out.println(findMin(new int[]{11, 13, 15, 17}));
    }
    public int findMin(int[] nums) {
        //通过二分查找寻找顶点
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
