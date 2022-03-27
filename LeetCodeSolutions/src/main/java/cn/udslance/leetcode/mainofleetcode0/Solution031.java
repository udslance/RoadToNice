package cn.udslance.leetcode.mainofleetcode0;



import java.util.Arrays;

/**
 * @author H
 * @create 2021-06-27 22:35
 */
public class Solution031 {


    public void test() {
        nextPermutation(new int[]{1,3,2});
    }

    public void nextPermutation(int[] nums) {

        int length = nums.length;

        boolean flag = false;

        int j = length - 1;


        //从后向前查找第一个相邻升序的元素对 (i,j)，满足 A[i] < A[j]。此时 [j,end) 必然是降序
        for (; j >= 1; j--) {

            //j右，i左
            int i = j - 1;
            

            if (nums[j] > nums[i]) {
                //在 [j,end) 从后向前查找第一个满足 A[i] < A[k] 的 k。
                // A[i]、A[k]分别就是上文所说的「小数」、「大数」

                for (int k = length - 1; k >= j; k--) {
                    if (nums[k] > nums[i]) {
                        //将 A[i] 与 A[k] 交换
                        int temp = nums[k];

                        nums[k] = nums[i];

                        nums[i] = temp;

                        flag = true;

                        break;
                    }
                }
            }

            if (flag) {
                break;
            }

        }

        Arrays.sort(nums, j, length);


        System.out.println(Arrays.toString(nums));
    }
}
