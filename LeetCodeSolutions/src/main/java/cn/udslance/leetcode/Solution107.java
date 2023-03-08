package cn.udslance.leetcode;

import cn.udslance.beans.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author H
 * @create 2021-07-22 20:47
 */
class Solution107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        if (root != null) {
            treeNodeQueue.add(root);
        }
        while (treeNodeQueue.size() != 0) {
            List<Integer> list = new ArrayList<>();
            int count = treeNodeQueue.size();
            for (int i = 0; i < count; i++) {
                TreeNode temp = treeNodeQueue.poll();
                list.add(temp.val);
                if (temp.left != null) {
                    treeNodeQueue.add(temp.left);
                }
                if (temp.right != null) {
                    treeNodeQueue.add(temp.right);
                }
            }
            res.addFirst(list);
        }
        return res;
    }
}
