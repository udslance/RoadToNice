package cn.udslance.leetcode;

import cn.udslance.beans.TreeNode;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: 二叉树的中序遍历
 * @description: 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * @difficulty: Easy
 * @Link: <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/">link</a>
 * @author: Udslance
 * @create: 2022-09-06 22:57
 **/
class Solution094 {

    private static final Logger LOGGER = Logger.getLogger("");

    @Test
    public void testUrAnswer() {
        long startTime = System.currentTimeMillis();

        // do something!

        String res = "";
        LOGGER.debug("运行结果：" + res);
        // end
        long endTime = System.currentTimeMillis();
        LOGGER.info("程序运行时间：" + (endTime - startTime) + " ms");
    }

    private List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        res.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right);
        }
        return res;
    }

}
