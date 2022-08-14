package cn.udslance.leetcode.startswith0;


/**
 * @author H
 * @create 2021-07-16 15:55
 */
public class Solution080 {


    public void test() {
        removeDuplicates(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3});
    }

    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        return process(nums, 2);
    }
    int process(int[] nums, int k) {
        int u = 0;
        for (int x : nums) {
            if (u < k || nums[u - k] != x) {
                nums[u++] = x;
            }
        }
        return u;
    }

}
