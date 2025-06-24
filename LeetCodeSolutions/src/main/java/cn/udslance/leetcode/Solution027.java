package cn.udslance.leetcode;

/**
 * @author H
 * @create 2021-06-04 10:02
 */
class Solution027 {
    public static void main(String[] args) {
        Solution027 solution027 = new Solution027();
        int[] ints = {2};
        solution027.removeElement(ints, 3);
    }

    /**
     * 考虑从后往前遍历，把目标元素都换到末尾去
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val) {
                while (left < right && nums[right] == val) {
                    right--;
                }
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            left++;
        }
        return left - 1;
    }
}
