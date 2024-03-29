package cn.udslance.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @title: 滑动窗口最大值
 * @description: 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。  返回 滑动窗口中的最大值 。
 * @difficulty: Hard
 * @Link: <a href="https://leetcode.cn/problems/sliding-window-maximum/">link</a>
 * @author: Udslance
 * @create: 2023-03-08 21:06
 **/
class Solution239 {
    @Test
    public void test() {
        int[] resArr = maxSlidingWindow(new int[]{1}, 1);
        System.out.println(Arrays.toString(resArr));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 2) {
            return nums;
        }
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;
    }
}
