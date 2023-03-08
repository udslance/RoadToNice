package cn.udslance.leetcode;

import cn.udslance.beans.TreeNode;

/**
 * 完全二叉树的节点个数
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 *
 * @author H
 * @create 2021-08-10 22:25
 */
class Solution222 {
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return left+right+1;

    }
}
