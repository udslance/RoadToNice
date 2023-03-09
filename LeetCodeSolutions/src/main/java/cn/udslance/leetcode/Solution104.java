package cn.udslance.leetcode;

import cn.udslance.beans.TreeNode;

/**
 * @title: 二叉树的最大深度
 * @description: 给定一个二叉树，找出其最大深度。
 * @difficulty: Easy
 * @Link: <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/">link</a>
 * @author: Udslance
 * @create: 2022-09-25 22:38
 **/
class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return res;
    }

    private int res = 0;

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        res = Math.max(res, depth);
        if (root.left != null) {
            dfs(root.left, depth + 1);
        }
        if (root.right != null) {
            dfs(root.right, depth + 1);
        }
    }
}
