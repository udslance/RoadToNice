package cn.udslance.leetcode.mainofleetcode0;

import cn.udslance.beans.TreeNode;


/**
 * @author H
 * @create 2021-07-21 20:37
 */
public class Solution098 {

    
    public void test() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);

        t5.left = t1;
        t5.right = t4;

        t4.left = t3;
        t4.right = t6;

        System.out.println(isValidBST(t5));
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root);

    }

    public boolean dfs(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) {

            return true;
        }


        if (root.left != null) {
            dfs(root.left);
        }

        if (root.right != null) {
            dfs(root.right);
        }

        return (root.left != null && root.val > root.left.val) && (root.right != null && root.val < root.right.val);
    }
}
