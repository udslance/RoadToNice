package cn.udslance.leetcode;

import cn.udslance.beans.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: 路径总和 II
 * @description: Medium
 * @difficulty: 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * @Link: <a href="https://leetcode.cn/problems/path-sum-ii/">link</a>
 * @author: Udslance
 * @create: 2022-10-16 17:19
 **/
class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(res, path, root, targetSum, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> path, TreeNode node, int target, int curSum) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        curSum += node.val;
        if (node.left == null && node.right == null) {
            if (curSum == target) {
                res.add(new ArrayList<>(path));
            }
        }
        dfs(res, path, node.left, target, curSum);
        dfs(res, path, node.right, target, curSum);
        path.remove(path.size() - 1);
    }
}
