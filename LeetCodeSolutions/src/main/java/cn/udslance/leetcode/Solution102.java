package cn.udslance.leetcode;

import cn.udslance.beans.TreeNode;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Title: 二叉树的层序遍历
 * @Difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/">link</a>
 * @author H
 *
 */
class Solution102 {
    private  static final Logger logger = Logger.getLogger("");
    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        long endTime = System.currentTimeMillis();
        logger.info("程序运行时间：" + (endTime - startTime) + " ms");
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode tmp = root;
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < curSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
