package cn.udslance.leetcode.startswith0;

/**
 * @author H
 * @create 2021-06-04 10:02
 */
public class Solution027 {
    public static void main(String[] args) {
        Solution027 solution027 = new Solution027();

        int[] ints = {1};

        solution027.removeElement(ints, 1);
    }

    /**
     * 考虑从后往前遍历，把目标元素都换到末尾去
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            //从左边找到一个目标数
            while (left < nums.length && nums[left] != val) {
                left++;
            }
            //从右边找到一个非目标数
            while (right > 0 && nums[right] == val) {
                right--;
            }
            if (left >= right) {
                break;
            }
            //交换
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
        }
        return left;
    }
}
