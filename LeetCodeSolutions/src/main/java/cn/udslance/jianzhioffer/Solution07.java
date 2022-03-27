package cn.udslance.jianzhioffer;

import java.util.LinkedList;

/**
 * @author H
 * @create 2021-05-10 11:04
 */
public class Solution07 {

    public static void main(String[] args) {
        int[] ints = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        Solution07 solution07 = new Solution07();

        System.out.println(solution07.maxSubArray(ints));

    }


    public int maxSubArray(int[] nums) {
        //链表
        // 1. 遍历数组
        // 将遍历到的数字加到尾部，并计算和
        // 如果去掉头部的数字能让和更大，则去掉头部，重新计算
        LinkedList<Integer> integerList = new LinkedList<>();

        integerList.addLast(nums[0]);

        //sum存储的是当前链表和
        int sum = nums[0];

        //存储历史最大值
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            //如果这个节点之前节点的和为负数，则将链表清空
            if (sum < 0) {
                integerList.clear();
                sum = 0;
            }

            integerList.addLast(nums[i]);
            sum += nums[i];

//            //如果现在链表第一个是负数，则说明去掉它，能让结果更大，重新计算sum
//            if (integerList.getFirst() < 0) {
//                sum -= integerList.removeFirst();
//            }

            //检查sum是否比历史最大值还大
            max = Math.max(sum, max);

        }

        return max;
    }
}
