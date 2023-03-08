package cn.udslance.leetcode;

import cn.udslance.beans.TreeNode;

import java.util.*;

/**
 * @title: 二叉树的锯齿形层序遍历
 * @description: 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * @difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/">...</a>
 * @author: Udslance
 * @create: 2022-09-23 22:50
 **/
class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 使用一个queue来实现
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        // 0：从左到右；1：从右到左
        int orientation = 0;
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            int levelSize = linkedList.size();
            List<Integer> levelList = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode tmp;
                if (orientation == 0) {
                    tmp = linkedList.removeFirst();
                    if (tmp.left != null) {
                        linkedList.add(tmp.left);
                    }
                    if (tmp.right != null) {
                        linkedList.add(tmp.right);
                    }
                } else {
                    tmp = linkedList.removeLast();
                    if (tmp.right != null) {
                        linkedList.addFirst(tmp.right);
                    }
                    if (tmp.left != null) {
                        linkedList.addFirst(tmp.left);
                    }
                }
                levelList.add(tmp.val);
            }
            res.add(levelList);
            orientation = orientation == 0 ? 1 : 0;
        }
        return res;
    }
}
