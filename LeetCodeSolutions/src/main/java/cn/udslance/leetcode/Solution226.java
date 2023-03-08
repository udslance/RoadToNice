package cn.udslance.leetcode;
import cn.udslance.beans.TreeNode;

/**
 * @author H
 * @create 2021-06-10 21:54
 */
class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        //特殊情况
        if (root == null) {
            return root;
        }
        invertTreeHelper(root);
        return root;
    }

    public void invertTreeHelper(TreeNode root) {
        //翻转
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //左递归翻转
        if (root.left != null) {
            invertTreeHelper(root.left);
        }
        //右递归翻转
        if (root.right != null) {
            invertTreeHelper(root.right);
        }
    }
}
