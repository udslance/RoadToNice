package cn.udslance.leetcode;

import cn.udslance.beans.TreeNode;

/**
 * @title: 二叉树的最小深度
 * @description: 给定一个二叉树，找出其最小深度。
 * @difficulty: Easy
 * @Link: <a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree/">...</a>
 * @author: Udslance
 * @create: 2022-10-17 22:59
 **/
class Solution111 {
    private int mindepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        process(root, 1);
        return mindepth;
    }

    private void process(TreeNode node, int curDepth) {
        if ((node.left == null && node.right == null) || curDepth >= mindepth) {
            mindepth = Math.min(curDepth, mindepth);
            return;
        }
        if (node.left != null) {
            process(node.left, curDepth + 1);
        }
        if (node.right != null) {
            process(node.right, curDepth + 1);
        }
    }
}
