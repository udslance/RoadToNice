package cn.udslance.leetcode;

import cn.udslance.beans.TreeNode;

/**
 * @title: 将有序数组转换为二叉搜索树
 * @description: 给你一个整数数组nums，其中元素已经按升序排列，请你将其转换为一棵高度平衡二叉搜索树。
 * @difficulty: Easy
 * @Link: <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/">...</a>
 * @author: Udslance
 * @create: 2022-09-25 23:16
 **/
class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return help(nums, 0, nums.length - 1);
    }

    private TreeNode help(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode midNode = new TreeNode(nums[mid]);
        midNode.left = help(nums, start, mid - 1);
        midNode.right = help(nums, mid + 1, end);
        return midNode;
    }
}
