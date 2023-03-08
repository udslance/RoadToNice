package cn.udslance.leetcode;

import cn.udslance.beans.TreeNode;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
class Solution538 {

    public void test() {

    }

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        midOrder(root);
        return root;

    }

    private void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        midOrder(root.right);

        sum += root.val;
        root.val = sum;

        midOrder(root.left);
    }
}
