package cn.udslance.leetcode;

import cn.udslance.beans.TreeNode;

/**
 * @title: 平衡二叉树
 * @description: 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * @difficulty: Easy
 * @Link: <a href="https://leetcode.cn/problems/balanced-binary-tree/">link</a>
 * @author: Udslance
 * @create: 2022-10-06 20:40
 **/
class Solution110 {
    public boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }

    private result process(TreeNode root) {
        if (root == null) {
            return new result(true, 0);
        }
        result leftData = process(root.left);
        result rightData = process(root.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced
                && Math.abs(leftData.height - rightData.height) < 2;
        return new result(isBalanced, height);
    }

    private class result{
        boolean isBalanced;
        int height;

        public result(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
