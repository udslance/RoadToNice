package cn.udslance.leetcode;

import cn.udslance.beans.TreeNode;

import java.util.List;

/**
 * @title: 对称二叉树
 * @description: 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * @difficulty: Easy
 * @Link: <a href="https://leetcode.cn/problems/symmetric-tree/">link</a>
 * @author: Udslance
 * @create: 2022-09-23 22:23
 **/
class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return dfs(root.left, root.right);
        }
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return dfs(left.left, right.right) && dfs(left.right, right.left);
        } else {
            return false;
        }
    }

    private boolean isListSym(List<Integer> list) {
        int start = 0;
        int end = list.size() - 1;
        for (; start < end; start++, end--) {
            if (!list.get(start).equals(list.get(end))) {
                return false;
            }
        }
        return true;
    }
}
