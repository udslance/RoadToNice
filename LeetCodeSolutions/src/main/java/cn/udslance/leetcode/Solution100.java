package cn.udslance.leetcode;

import cn.udslance.beans.TreeNode;

/**
 * @title: 相同的数
 * @description: 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * @difficulty: E
 * @Link: <a href="https://leetcode.cn/problems/same-tree/">...</a>
 * @author: Udslance
 * @create: 2022-09-08 23:04
 **/
class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}
