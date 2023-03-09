package cn.udslance.leetcode;

import cn.udslance.beans.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: 二叉树的前序遍历
 * @description: 给你二叉树的根节点 root ，返回它节点值的前序遍历。
 * @difficulty: Easy
 * @Link: <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/">link</a>
 * @author: Udslance
 * @create: 2022-11-06 21:03
 **/
class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversalHelper(root, list);
        return list;
    }

    private void preorderTraversalHelper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorderTraversalHelper(root.left, list);
        preorderTraversalHelper(root.right, list);
    }
}
