package cn.udslance.leetcode;

import cn.udslance.beans.TreeNode;

/**
 * @title: 二叉搜索树中的中序后继
 * @description:
 * @difficulty:
 * @Link: <a href="">link</a>
 * @author: Udslance
 * @create: 2022-10-08 23:01
 **/
class Solution285 {
    public static TreeNode getSuccessorNode(TreeNode node) {
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            TreeNode parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private static TreeNode getLeftMost(TreeNode node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
