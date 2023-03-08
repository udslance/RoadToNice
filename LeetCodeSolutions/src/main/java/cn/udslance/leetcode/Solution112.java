package cn.udslance.leetcode;

import cn.udslance.beans.TreeNode;

/**
 * @title: 路径总和
 * @description: 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum。
 * @difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/path-sum/">...</a>
 * @author: Udslance
 * @create: 2022-10-17 23:09
 **/
class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                return true;
            }
        }
        boolean b = hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
        targetSum += root.val;
        return b;
    }
}
