package cn.udslance.leetcode;

import cn.udslance.beans.TreeNode;

/**
 * @title: 二叉搜索树的最近公共祖先
 * @description: 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * @difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/">link</a>
 * @author: Udslance
 * @create: 2022-10-08 22:41
 **/
class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
