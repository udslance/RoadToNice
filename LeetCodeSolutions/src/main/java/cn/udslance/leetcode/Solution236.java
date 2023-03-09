package cn.udslance.leetcode;

import cn.udslance.beans.TreeNode;

/**
 * @title: 二叉树的最近公共祖先
 * @description: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * @difficulty: Medium
 * @Link:
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/?orderBy=most_votes">link</a>
 * @author: Udslance
 * @create: 2023-02-18 16:27
 **/
class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) {
            return null; // 1.
        }
        if(left == null) {
            return right; // 3.
        }
        if(right == null) {
            return left; // 4.
        }
        return root; // 2. if(left != null and right != null)
    }
}
