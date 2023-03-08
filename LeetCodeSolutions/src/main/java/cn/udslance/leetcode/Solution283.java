package cn.udslance.leetcode;

import java.util.Arrays;

/**
 * @author H
 * @create 2021-06-13 15:55
 */
class Solution283 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 0, 4, 5, 0, 6, 7, 0, 8};

        Solution283 solution283 = new Solution283();

        solution283.moveZeroes2(nums);

        System.out.println(Arrays.toString(nums));

    }

    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length && nums[i] != 0) {
                i++;
            }
            //找到第一个0
            int not0Index = i + 1;
            while (not0Index < nums.length && nums[not0Index] == 0) {
                not0Index++;
            }
            if (i >= nums.length || not0Index >= nums.length) {
                return;
            }
            //交换
            nums[i] = nums[not0Index];
            nums[not0Index] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        if(nums==null) {
            return;
        }
        //两个指针a和b
        int b = 0;
        for(int a=0;a<nums.length;a++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            //这里
            // 1. nums[a]!=0，nums[b]!=0
            //  (1) a == b：发生一次无影响的交换
            //  (2) a != b：发生一次有意义的交换
            // 2. nums[a] == 0：a 往后面走，去找非 0 的数
            // 一旦发生了一次有 0 参与的交换，b 指针便会落后于 a 指针，之后 b 指针将总会指向 0
            if(nums[a]!=0) {
                int tmp = nums[a];
                nums[a] = nums[b];
                nums[b++] = tmp;
            }
        }
    }
}
