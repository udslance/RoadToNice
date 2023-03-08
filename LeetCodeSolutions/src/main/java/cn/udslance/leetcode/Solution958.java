package cn.udslance.leetcode;

import cn.udslance.beans.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @title: 二叉树的完全性检验
 * @description: 给定一个二叉树的root，确定它是否是一个完全二叉树。
 * @difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/check-completeness-of-a-binary-tree/">...</a>
 * @author: Udslance
 * @create: 2022-10-06 20:18
 **/
class Solution958 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode l = cur.left;
            TreeNode r = cur.right;
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }
}
