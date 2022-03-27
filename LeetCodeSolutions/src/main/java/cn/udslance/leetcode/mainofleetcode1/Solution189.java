package cn.udslance.leetcode.mainofleetcode1;


/**
 * 旋转数组
 * https://leetcode-cn.com/problems/rotate-array/
 * @author H
 * @create 2021-08-04 19:51
 */
public class Solution189 {

    public void test() {
        rotate(new int[]{1,2,3,4,5,6,7},2);
    }


    public void rotate(int[] nums, int k) {
        if (k == 0 || k == nums.length || nums.length == 1) {
            return;
        }

        int[] res = new int[nums.length];

        k = k % nums.length;
        int step = nums.length - k;

        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[(i + step) % nums.length];
        }

        nums = res.clone();
    }
}
