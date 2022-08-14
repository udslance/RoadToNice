package cn.udslance.leetcode.startswith0;

import cn.udslance.beans.TreeNode;

/**
 * @author H
 * @create 2021-07-21 21:07
 */
public class Solution099 {
    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        in_order(root);

        int tmp = firstNode.val;

        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }

    private void in_order(TreeNode root){
        if (root == null) {
            return;
        }

        in_order(root.left);

        if (firstNode == null && preNode.val > root.val) {
            firstNode = preNode;
        }

        if (firstNode != null && preNode.val > root.val) {
            secondNode = root;
        }

        preNode = root;

        in_order(root.right);
    }

}
